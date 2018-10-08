package router;

import org.apache.camel.builder.RouteBuilder;
import processor.MyLogProcessor;
import transformer.MyTransformer;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        /*
        * There is a text file in input file. Take it and process it.
        * In process, take the string which in text file and write it to terminal.
        * In Bean(where we do data transformation), take the data as String and transform it to UpperCase
        * Finally, COPY file to output directory.
        * */
        from("file:/tmp/input?move=./done")
                .process(new MyLogProcessor())
                .bean(new MyTransformer(), "transformContent")
                .process(new MyLogProcessor())
                .to("file:/tmp/output");

    }
}