import kong.unirest.JsonNode;
import org.json.JSONObject;
import org.junit.Test;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class GetCustomersTest {
    @Test
    public void whenICallGetCustomers_thenReturns200AndHardcodedCustomer() {
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/customers").asJson();
        JSONObject returnedCustomer = response
                .getBody()
                .getArray()
                .getJSONObject(0);

        assertThat(response.getStatus(), is(equalTo(200)));
        assertThat(returnedCustomer.get("id"), is(equalTo("df5b5b2e-86a5-40da-a555-0f18a8bdce93")));
    }
}
