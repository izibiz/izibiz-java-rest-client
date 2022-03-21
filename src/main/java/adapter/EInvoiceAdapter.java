package adapter;

import com.fasterxml.jackson.databind.JsonNode;

import com.google.gson.Gson;
import response.EInvoiceResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class EInvoiceAdapter extends Adapter {
    public static String URL = BASE_URL + "/" + VERSION + "/einvoices/" ;
    Adapter adapter = new Adapter();
    EInvoiceResponse eInvoiceResponse;

    public EInvoiceResponse listEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        URL = URL +"inbox?dateType=DELIVERY&status=New&startDate="+ adapter.startDate + "&endDate=" + adapter.endDate + "&page=1&pageSize=20&sort=desc&sortProperty=supplierName";

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

    public EInvoiceResponse pendingApprovalEinvoices(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "outbox?page=0&sortProperty=customerName&sort=asc";

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

    public EInvoiceResponse approvalExpiredEInvoices(String token)throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "inbox?status=ResponseTimeExpired&page=0&pageSize=100&sortProperty=createDate&sort=asc";

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

    public EInvoiceResponse UndeliverableAnswerEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "inbox?status=ResponseUnDelivered&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&pageSize=100&sortProperty=createDate&sort=asc";
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

    public EInvoiceResponse RejectedEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "inbox?status=Rejected&dateType=DELIVERY&startDate="+ adapter.startDate + "&endDate="+ adapter.endDate+ "&page=0&pageSize=100&sortProperty=createDate&sort=asc";
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

 /*   public EInvoiceResponse StatusInquiryEInvoices(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        URL = URL + "inbox/"+ ID;
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

        return eInvoiceResponse;*

    }*/





}
