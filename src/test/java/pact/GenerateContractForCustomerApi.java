package pact;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static pact.PactConfiguration.*;

public class GenerateContractForCustomerApi {

    private String url = "http://localhost:8080/customers/3";

    @Rule
    public PactProviderRule rule = new PactProviderRule(PACT_PROVIDER, MOCK_HOST, MOCK_HOST_PORT, this);

    @Pact(provider = PACT_PROVIDER, consumer = PACT_CONSUMER)
    public PactFragment createFragment(PactDslWithProvider pactDslWithProvider) {
        return pactDslWithProvider
                .uponReceiving("Get Customer")
                .path("/customers/3")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(getHeaders())
                .body(expectedResults())
                .toFragment();
    }

    private PactDslJsonBody expectedResults() {
        PactDslJsonBody response = new PactDslJsonBody();
        response.stringType("name")
                .integerType("customerID")
                .integerType("age");
        return response;
    }

    @Test
    @PactVerification(PACT_PROVIDER)
    public void runTest() throws IOException {
        RestTemplate restClient = new RestTemplate();
        restClient.getForObject(url, String.class);
    }
}
