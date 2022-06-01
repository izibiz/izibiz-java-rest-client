package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import response.ContentECheck;
import response.ECheckResponse;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;


public class DocumentAdapter<Response> extends Adapter{

    public <Response> Response list(String token, String url, Class<Response> responseType) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response = httpClient().send(token, url);
        return new Gson().fromJson(response,responseType);
    }
    public String listStatus(String token, String url) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String response = httpClient().send(token, url);
        return response;
    }
    public String view(String token, String URL, List<Long> idList, String urlType, String fileType, String productType, String inboxOutboxEmpty) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

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
        String response = httpClient().downloadFile(token, URL, body, filePath);

        return response;
    }
}
