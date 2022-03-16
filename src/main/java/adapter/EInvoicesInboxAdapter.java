package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import model.LoginRequest;////

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.List;

public class EInvoicesInboxAdapter extends Adapter {
    public static final String URL = BASE_URL + "/" + VERSION + "/einvoices/inbox" ;

    public String listEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{




        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode bodyObj = (JsonNode) httpClient().send(request);
        System.out.println(bodyObj);
        String response = bodyObj.asText();
        if(null == response) {
            response = bodyObj.asText();
        }


        return response;
    }
}
