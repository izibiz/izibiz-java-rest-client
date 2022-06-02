package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DocumentAdapter<Response> extends Adapter{

    public <Response> Response list(String token, String url, Class<Response> responseType) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response = httpClient().send(token, url);
        return new Gson().fromJson(response,responseType);
    }
    public String listStatus(String token, String url) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return httpClient().send(token, url);
    }
    public String statusInquiry(String token, String URL, List<Long> idList, String inboxOutboxEmpty) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response="";
        for (Long id:idList) {
            String url = URL +inboxOutboxEmpty +"/" + id;
            response = httpClient().send(token, url);
        }
        return response;
    }

    public String viewDocument(String token, String URL, List<Long> idList, String urlType, String fileType, String productType, String inboxOutboxEmpty) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response="";
        for (Long id:idList) {
            File file = new File(PATH + productType+"/"+ fileType +"/"+ id+"."+ fileType.toLowerCase());
            String url = URL +"/"+inboxOutboxEmpty+ "/"+ id + "/preview/"+ urlType;
            response = httpClient().previewFile(token, url, file);
        }
        return response;
    }

    public String downloadDocument(String token, DownloadRequest[] body, String URL, String path) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        String filePath = System.getProperty("user.home")+"/Desktop/İzibiz/Kayit/" + path;
        return httpClient().downloadFile(token, URL, body, filePath);
    }

    public <Response> Response listSeries(String token, String url, Class<Response> responseType) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        String response = httpClient().sendSeries(token, url);
        return new Gson().fromJson(response,responseType);

    }
}