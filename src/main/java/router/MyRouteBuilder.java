package router;

import org.apache.camel.builder.RouteBuilder;
import processor.MyLogProcessor;
import transformer.MyTransformer;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:/tmp/input?move=./done")
                .process(new MyLogProcessor())
                .bean(new MyTransformer(), "transformContent")
                .process(new MyLogProcessor())
                .to("file:/tmp/output");

    }
}