package http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EdonusumHttpClient {
    private ObjectMapper mapper = new ObjectMapper();
    private HttpClient client = HttpClient.newHttpClient();

    public Object send(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonNode bodyObj = mapper.readTree(resp.body()).get("data");

        if(null == bodyObj) {
            bodyObj = mapper.readTree(resp.body()).get("error");
        }

        return bodyObj;
    }

}
