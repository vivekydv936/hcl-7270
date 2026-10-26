package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.example.configuration.WebConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();  // to actualy listen port

        String contextpath =""; // context path
        String basedoc =new File("src/main/WebApp").getAbsolutePath();  //  context path folder
        Context ctx = tomcat.addContext(contextpath,basedoc);




        // ioc container up
        AnnotationConfigWebApplicationContext springcontext = new AnnotationConfigWebApplicationContext();
        springcontext.register(WebConfig.class);


        // Dispatch server
        DispatcherServlet dispatcherServlet =new DispatcherServlet(springcontext);
        tomcat.addServlet( ctx ,"dispatcherServlet",dispatcherServlet);
        ctx.addServletMappingDecoded("/","dispatcherServlet");
        tomcat.start();
        System.out.println("tomcat started ");
        tomcat.getServer().await();// to kepp server running


    }
}
