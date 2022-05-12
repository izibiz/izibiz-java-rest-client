package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import model.LoginRequest;
import response.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class EExchangeAdapter extends Adapter {

    public String URL = BASE_URL + "/" + VERSION + "/exchanges" ;
    Adapter adapter = new Adapter();
    EExchangeResponse eExchangeResponseList;
    EExchangeResponse eExchangeResponseList2;
    EExchangeResponse eExchangeResponse;

    public EExchangeResponse listEExchange(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL;
        String response = httpClient().send(token, url);
        eExchangeResponseList = new Gson().fromJson(response, EExchangeResponse.class);//java generic method
        return eExchangeResponseList;
    }
    public EExchangeResponse listByCreationDateEExchange(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=desc";
        String response = httpClient().send(token, url);
        eExchangeResponseList = new Gson().fromJson(response, EExchangeResponse.class);//java generic method
        return eExchangeResponseList;
    }

    public String ViewPDFEExchange(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEExchange content:eExchangeResponseList.contents) {
            File file = new File(PATH + "EExchange/PDF", content.id+".pdf");
            String url = URL + "/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEExchange(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEExchange content:eExchangeResponseList.contents) {
            File file = new File(PATH + "EExchange/HTML", content.id+".html");
            String url = URL + "/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEExchange(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEExchange content:eExchangeResponseList.contents) {
            File file = new File(PATH + "EExchange/XML", content.id+".xml");
            String url = URL + "/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }
    public String statusEExchange(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }

    public String downloadXMLEExchange(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/ubl", "EExchange/XML/Downloads/");
    }
    public String downloadHTMLEExchange(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/html", "EExchange/HTML/Downloads/");
    }
    public String downloadPDFEExchange(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/pdf", "EExchange/PDF/Downloads/");
    }
}
