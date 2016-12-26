package pact;

import java.util.HashMap;

public class PactConfiguration {
    public final static String MOCK_HOST = "localhost";
    public final static int MOCK_HOST_PORT = 8080;

    public static final String PACT_PROVIDER = "CustomerAPI_Provide";
    public static final String PACT_CONSUMER = "customerAPI_consumer";

    public static HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        return headers;
    }


}
