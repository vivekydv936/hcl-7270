# Spring Bean Initialization - Quick Notes

These notes use the classes in `src/main/java/org/example` as the example.

## 1. What is a Spring bean?

A **bean** is an object created and managed by Spring. Spring can:

- create the object,
- resolve and inject its dependencies,
- manage its lifecycle, and
- return the same singleton instance when the bean is requested.

In this project, both classes are beans because they use `@Component`:

```java
@Component
public class OrderService { ... }

@Component
public class PaymentService { ... }
```

`AppConfig` enables component scanning:

```java
@Configuration
@ComponentScan
public class AppConfig { }
```

This tells Spring to find `@Component` classes in the package and register them as beans.

## 2. Bean initialization: what happens first?

The application creates the Spring container here:

```java
ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
```

While this line runs, Spring generally:

1. reads `AppConfig`,
2. scans for components,
3. creates singleton beans eagerly by default, and
4. injects their dependencies.

Only after the context has been created does this line run:

```java
OrderService order = context.getBean(OrderService.class);
```

`getBean` retrieves a bean from the container. It does not normally create a new object when the singleton was already initialized.

## 3. Eager initialization (`@Eager` idea)

Spring's default behavior for singleton beans is **eager initialization**. In simple terms:

> Create the bean when the application context starts.

There is no standard `@Eager` annotation needed for this default behavior. A normal component is eager unless it is marked lazy.

For example:

```java
@Component
public class PaymentService {
    public PaymentService(OrderService orderService) {
        System.out.println("Payment bean created");
    }
}
```

The constructor message can appear during `new AnnotationConfigApplicationContext(...)`, before `getBean(...)` is called.

### When eager initialization is useful

- Failures are discovered during startup.
- Important services are ready immediately.
- There is no first-request creation delay.

### Possible downside

The application spends startup time and memory creating beans that may never be used.

## 4. Lazy initialization (`@Lazy`)

`@Lazy` means:

> Do not create the target bean until it is actually needed.

It can be placed on a class:

```java
@Component
@Lazy
public class PaymentService {
    // Created when PaymentService is first requested or used.
}
```

It can also be placed on a dependency injection point. This is what the example does:

```java
public OrderService(@Lazy PaymentService paymentService) {
    this.paymentService = paymentService;
    System.out.println("order bean created");
}
```

This says that `OrderService` can be created without immediately creating the real `PaymentService` object.

### Important detail about this example

`@Lazy` on the constructor parameter makes the **dependency lookup lazy**. It does not necessarily stop Spring from creating `PaymentService` eagerly if `PaymentService` is also discovered as a normal singleton bean elsewhere during context startup.

To make the `PaymentService` bean itself lazy, use `@Lazy` on the class as well:

```java
@Component
@Lazy
public class PaymentService {
    // ...
}
```

The commented `@Lazy` above `OrderService` is a different choice: it delays creation of `OrderService` itself. Usually, put `@Lazy` on the bean or injection point that you specifically want to delay.

## 5. What is a proxy?

A **proxy** is a small stand-in object created by Spring. It looks like the requested dependency to `OrderService`, but it does not immediately create the real `PaymentService`.

Think of it like a receptionist:

- `OrderService` receives the receptionist (proxy).
- The receptionist remembers how to obtain `PaymentService`.
- When `OrderService` calls `paymentService.pay()`, the receptionist asks Spring for the real service.
- The call is then forwarded to the real object.

In this code:

```java
public void Placeorder() {
    paymentService.pay();
    System.out.println("order placed");
}
```

`paymentService` may initially be a Spring-generated proxy. The first call to `pay()` triggers resolution of the actual `PaymentService` if it has not already been created.

A proxy is not the real service; it is a controlled reference to the real service.

## 6. Why is `@Lazy` useful here?

The two services depend on each other:

```text
OrderService -> PaymentService
PaymentService -> OrderService
```

This is a circular dependency. Without lazy resolution, Spring may try to construct both objects before either constructor can finish:

```text
Create OrderService
  -> needs PaymentService
       -> needs OrderService
            -> cycle
```

The lazy parameter gives Spring a proxy instead of requiring the real `PaymentService` immediately:

```text
Create OrderService
  -> inject PaymentService proxy
Create PaymentService
  -> inject existing OrderService
```

That breaks the construction cycle. In real applications, it is usually better to redesign the classes to remove the circular dependency, but `@Lazy` is a useful tool when the relationship is intentional or difficult to change.

## 7. Startup flow for `Main`

```java
ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

OrderService order = context.getBean(OrderService.class);
System.out.println("payment service not started yet");
order.Placeorder();
```

A likely flow is:

1. Spring scans `OrderService` and `PaymentService`.
2. Spring creates `OrderService` and injects a lazy `PaymentService` reference.
3. Spring creates `PaymentService` if it is still an eager singleton selected during context startup.
4. `getBean(OrderService.class)` returns the managed `OrderService`.
5. `Placeorder()` calls `paymentService.pay()`.
6. Spring uses the proxy to resolve or forward to the real payment service.
7. The console prints `payment done`, then `order placed`, then `order details`.

Therefore, this message can be misleading:

```java
System.out.println("payment service not started yet");
```

It only says that the line was printed before `Placeorder()`. It does not prove that the `PaymentService` constructor has not already run. The constructor messages are the reliable clue for this small example.

## 8. Quick comparison

| Concept | Simple meaning | Usual timing |
|---|---|---|
| Eager singleton | Create the bean as the context starts | Application startup |
| `@Lazy` bean | Delay creating the bean | First request/use |
| `@Lazy` dependency | Inject a lazy reference/proxy | Real dependency is resolved when needed |
| Proxy | Spring-created stand-in that forwards calls | Before or during first use |
| `getBean(...)` | Ask Spring for its managed object | When this line executes |

## Remember

- `@Component` makes a class discoverable as a bean.
- `@ComponentScan` tells Spring where to search.
- Singleton beans are eager by default.
- `@Lazy` delays creation or dependency resolution.
- A proxy is a stand-in, not the actual target object.
- `@Lazy` can help break circular dependencies.
- Use constructor logs and a clear test to verify when a bean is actually created.
