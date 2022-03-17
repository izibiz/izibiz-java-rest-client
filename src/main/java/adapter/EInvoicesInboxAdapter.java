package adapter;

import com.fasterxml.jackson.databind.JsonNode;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import model.LoginRequest;////
import response.EInvoiceResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

public class EInvoicesInboxAdapter extends Adapter {
    public static String URL = BASE_URL + "/" + VERSION + "/einvoices/inbox?dateType=DELIVERY&status=New&startDate=" ;
    Adapter adapter = new Adapter();
    EInvoiceResponse eInvoiceResponse;

    public EInvoiceResponse listEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        URL = URL + adapter.startDate + "&endDate=" + adapter.endDate + "&page=1&pageSize=20&sort=desc&sortProperty=supplierName";

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
        eInvoiceResponse = new Gson().fromJson(response,EInvoiceResponse.class);

        System.out.println(eInvoiceResponse.contents[0]);

        if(null == response) {
            response = responseData.asText();
        }


        return eInvoiceResponse;
    }
}
