# Java Collections Framework Practice

Each Java file is a standalone runnable example demonstrating common operations for one concrete collection implementation.

## Files
- `ArrayListDemo.java` — indexed list operations, add/update/remove/search/iterate/sort
- `LinkedListDemo.java` — list operations plus deque/queue operations
- `HashSetDemo.java` — unique elements, add/remove/search/iterate
- `LinkedHashSetDemo.java` — unique elements while preserving insertion order
- `TreeSetDemo.java` — unique sorted elements, first/last, range operations
- `PriorityQueueDemo.java` — priority-based queue operations
- `ArrayDequeDemo.java` — queue and stack operations
- `HashMapDemo.java` — key/value operations, iteration, update, removal
- `LinkedHashMapDemo.java` — map operations while preserving insertion order
- `TreeMapDemo.java` — sorted keys, first/last entries, range operations
- `HashtableDemo.java` — legacy synchronized map operations

## Run a file
Open a terminal in this folder and run, for example:

```bash
javac ArrayListDemo.java
java ArrayListDemo
```

Use the same two commands for any other demo, replacing `ArrayListDemo` with its class name.

## Notes
- The Java Collections Framework's `List`, `Set`, `Queue`, and `Map` are interfaces; you create objects from implementations such as `ArrayList`, `HashSet`, `PriorityQueue`, and `HashMap`.
- `Map` is part of the Collections Framework, but it does **not** extend `Collection`.
- `HashSet` and `HashMap` do not guarantee iteration order.
- `LinkedHashSet` and `LinkedHashMap` preserve insertion order.
- `TreeSet` sorts elements; `TreeMap` sorts keys.
- `PriorityQueue` retrieves elements according to priority (natural order here), not insertion order.
- `ArrayDeque` can be used as a queue or stack and does not allow `null`.
- `Hashtable` is a legacy class; modern code usually prefers `HashMap` unless synchronized behavior is specifically needed.
- These examples use ordinary non-null values to keep behavior clear.
