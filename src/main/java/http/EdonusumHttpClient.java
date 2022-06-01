package http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.DownloadRequest;
import org.apache.commons.lang3.StringUtils;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class EdonusumHttpClient {
    private ObjectMapper mapper = new ObjectMapper();
    private HttpClient client = HttpClient.newHttpClient();

    public String send(String token, String url, DownloadRequest[]... body) throws IOException, InterruptedException {
        JsonNode bodyObj=null;
        String response="";

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
        return response;
    }// downloadFile
    public String downloadFile(String token, String url, DownloadRequest[] body, String path) throws IOException, InterruptedException {
        JsonNode bodyObj=null;
        String response="";
        try{
            ObjectMapper mapper = new ObjectMapper();
            HttpClient client = HttpClient.newHttpClient();
            String bodyJson = mapper.writeValueAsString(body);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .setHeader("Authorization","Bearer " + token)
                    .setHeader("Content-Type","application/json ")
                    .POST(HttpRequest.BodyPublishers.ofString(bodyJson))
                    .build();
            HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode bodyObj1 = mapper.readTree(resp.body()).get("error");
            bodyObj = mapper.readTree(resp.body()).get("data");

            if(null == bodyObj) {
                bodyObj = mapper.readTree(resp.body()).get("error");
            }
            response = bodyObj.get("content").asText();

            String fileName = bodyObj.get("filename").asText();
            byte[] decodedBytes = Base64.getDecoder().decode(response);
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path+fileName), 4096)) {
                out.write(decodedBytes);
            }

            if(StringUtils.isEmpty(response)) {
                response = bodyObj.asText();
            }
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
        return response;

    }
    public String previewFile(String token, String url, File file) throws  IOException, InterruptedException {//previewFile

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
