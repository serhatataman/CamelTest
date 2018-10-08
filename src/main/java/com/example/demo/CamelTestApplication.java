package com.example.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import router.MyRouteBuilder;

@SpringBootApplication
public class CamelTestApplication {

    public static void main(String[] args) {

        MyRouteBuilder router = new MyRouteBuilder();
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(router);
            context.start();

            Thread.sleep(5000);

            context.stop();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
