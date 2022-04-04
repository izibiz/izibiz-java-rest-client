package http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EdonusumHttpClient {
    private ObjectMapper mapper = new ObjectMapper();
    private HttpClient client = HttpClient.newHttpClient();

    public String send(String token, String url, String requestType) throws IOException, InterruptedException {
        JsonNode bodyObj=null;
        String response="";

        if(requestType=="GET"){
            try{
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(url))
                        .setHeader("Authorization","Bearer " + token)
                        .GET()
                        .build();

                HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());

                bodyObj = mapper.readTree(resp.body()).get("data");

                if(null == bodyObj) {
                    bodyObj = mapper.readTree(resp.body()).get("error");
                }

                response = bodyObj.toString();

                if(StringUtils.isEmpty(response)) {
                    response = bodyObj.asText();
                }
            } catch (URISyntaxException e){
                e.printStackTrace();
            }
        }

        return response;
    }

    public String sendFile(String token, String url, File file) throws  IOException, InterruptedException {

        HttpResponse<byte[]> resp = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .setHeader("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            resp = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
            byte[] responseData = resp.body();
            FileOutputStream pdfFile = new FileOutputStream(file);
            pdfFile.write(responseData);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return resp.body().toString();
    }

}
