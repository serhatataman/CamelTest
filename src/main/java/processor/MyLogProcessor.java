package processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyLogProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {

        System.out.println("The String is that: " + exchange.getIn().getBody(String.class));
    }
}