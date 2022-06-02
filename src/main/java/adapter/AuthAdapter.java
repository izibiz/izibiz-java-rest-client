package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.LoginRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class AuthAdapter extends Adapter{
    public static final String URL = BASE_URL + "/" + VERSION + "/auth/token";

    public String login(LoginRequest body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        String bodyJson = mapper().writeValueAsString(body);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(bodyJson))
                .build();

        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonNode bodyObj = mapper.readTree(resp.body()).get("data");

        if(null == bodyObj) {
            bodyObj = mapper.readTree(resp.body()).get("error");
        }

        String response = bodyObj.get("accessToken").asText();
        System.out.println(response);
        if(null == response) {
            response = bodyObj.asText();
        }

        return response;
    }
}
