package transformer;

public class MyTransformer {

        public String transformContent(String body){
            String upperCase = body.toUpperCase();
            return upperCase;
        }
}