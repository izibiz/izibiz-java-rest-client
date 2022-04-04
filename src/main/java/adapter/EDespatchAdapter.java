package adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import response.EDespatchResponse;
import response.EInvoiceResponse;

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
    EDespatchResponse eDespatchResponseList;

    public EDespatchResponse listEArchiveInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL ;
        String response = httpClient().send(token, url, "GET");
        eDespatchResponseList = new Gson().fromJson(response, EDespatchResponse.class);//java generic method
        return eDespatchResponseList;
    }

}
