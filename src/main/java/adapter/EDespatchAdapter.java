package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import response.EDespatchResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;



public class EDespatchAdapter extends Adapter {
    public String URL = BASE_URL + "/" + VERSION + "/earchives/" ;
    Adapter adapter = new Adapter();
    EDespatchResponse eDespatchResponse;

    public EDespatchResponse listEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{


        System.out.println(URL);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .setHeader("Authorization","Bearer " + token)
                .GET()
                .build();

        JsonNode responseData = (JsonNode) httpClient().send(request);

        System.out.println(responseData);
        String response = responseData.toString();
        //  eInvoiceResponse = mapper().readValue(response,EInvoiceResponse.class);
        eDespatchResponse = new Gson().fromJson(response,EDespatchResponse.class);

        System.out.println(eDespatchResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }


        return eDespatchResponse;
    }
}
