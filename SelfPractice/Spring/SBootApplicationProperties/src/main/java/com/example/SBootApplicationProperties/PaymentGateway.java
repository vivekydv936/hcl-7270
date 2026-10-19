package com.example.SBootApplicationProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

      private final PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }
    public int getRetryCount(){
        return paymentProperties.getRetryCount();
    }
    public boolean getIsEnabled(){
        return paymentProperties.isEnabled();
    }
    public  int getTimeout(){
        return paymentProperties.getTimeOut();
    }

    public  void display(){
        System.out.println(getRetryCount());
        System.out.println(getIsEnabled());
        System.out.println(getTimeout());
        System.out.println(getType());
    }


//    @Value

//    @Value("${PaymentGateway.type:Razorpay}")
//    private String type;
//    @Value("${PaymentGateway.retryCount}")
//    private int retryCount;

//    injecting values via app.properties file using value and default pass
//    public PaymentGateway(@Value("${PaymentGateway.type:Razorpay}") String type,
//                          @Value("${PaymentGateway.retryCount}")int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }


}
