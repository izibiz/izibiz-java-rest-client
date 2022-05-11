package adapter;

import com.google.gson.Gson;
import response.Content;
import response.ContentESmm;
import response.EInvoiceResponse;
import response.ESmmResponse;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ESmmAdapter extends Adapter {
    public String URL = BASE_URL + "/" + VERSION + "/esmms" ;
    Adapter adapter = new Adapter();
    ESmmResponse eSmmResponseList;
    ESmmResponse eSmmResponseList_outbox;
    ESmmResponse eSmmResponse;

    public ESmmResponse listESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL;
        String response = httpClient().send(token, url);
        eSmmResponseList = new Gson().fromJson(response, ESmmResponse.class);//java generic method
        return eSmmResponseList;
    }
    public ESmmResponse listByCreationDateESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eSmmResponseList = new Gson().fromJson(response, ESmmResponse.class);//java generic method
        return eSmmResponseList;
    }

    public String ViewPDFESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentESmm content:eSmmResponseList.contents) {
            File file = new File(PATH + "Esmm/PDF", content.id+".pdf");
            String url = URL + "/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentESmm content:eSmmResponseList.contents) {
            File file = new File(PATH + "Esmm/HTML", content.id+".html");
            String url = URL + "/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentESmm content:eSmmResponseList.contents) {
            File file = new File(PATH + "Esmm/XML", content.id+".xml");
            String url = URL + "/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }
    public String statusESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }
}
