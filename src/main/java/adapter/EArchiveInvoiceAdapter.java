package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import response.EArchiveInvoiceResponse;
import response.EInvoiceResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class EArchiveInvoiceAdapter extends Adapter {

    public String URL = BASE_URL + "/" + VERSION + "/earchives/" ;
    Adapter adapter = new Adapter();
    response.EArchiveInvoiceResponse EArchiveInvoiceResponse;

    public EArchiveInvoiceResponse listEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{


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
        EArchiveInvoiceResponse = new Gson().fromJson(response,EArchiveInvoiceResponse.class);

        System.out.println(EArchiveInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }


        return EArchiveInvoiceResponse;
    }
}
