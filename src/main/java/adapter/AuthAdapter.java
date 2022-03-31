package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import model.LoginRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.List;

public class AuthAdapter extends Adapter{
    public static final String URL = BASE_URL + "/" + VERSION + "/auth/token";

    public String login(LoginRequest body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String bodyJson = mapper().writeValueAsString(body);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Content-Type", "application/json") //enum
                .POST(HttpRequest.BodyPublishers.ofString(bodyJson))
                .build();

        JsonNode bodyObj = (JsonNode) httpClient().send(request);

        String response = bodyObj.get("accessToken").asText();
        System.out.println(response);
        if(null == response) {
            response = bodyObj.asText();
        }

        return response;
    }
}
