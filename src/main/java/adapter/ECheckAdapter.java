package adapter;

import com.google.gson.Gson;
import response.ContentECheck;

import response.ECheckResponse;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ECheckAdapter extends Adapter {
    public String URL = BASE_URL + "/" + VERSION + "/echecks" ;
    Adapter adapter = new Adapter();
    ECheckResponse eCheckResponseList;
    ECheckResponse eCheckResponseList2;
    ECheckResponse eCheckResponse;

    public ECheckResponse listECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL;
        String response = httpClient().send(token, url);
        eCheckResponseList = new Gson().fromJson(response, ECheckResponse.class);//java generic method
        return eCheckResponseList;
    }
    public ECheckResponse listByCreationDateECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=desc";
        String response = httpClient().send(token, url);
        eCheckResponseList = new Gson().fromJson(response, ECheckResponse.class);//java generic method
        return eCheckResponseList;
    }

    public String ViewPDFECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentECheck content:eCheckResponseList.contents) {
            File file = new File(PATH + "ECheck/PDF", content.id+".pdf");
            String url = URL + "/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentECheck content:eCheckResponseList.contents) {
            File file = new File(PATH + "ECheck/HTML", content.id+".html");
            String url = URL + "/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentECheck content:eCheckResponseList.contents) {
            File file = new File(PATH + "ECheck/XML", content.id+".xml");
            String url = URL + "/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }
    public String statusECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        String response = httpClient().send(token, url);
        return response;
    }
}
