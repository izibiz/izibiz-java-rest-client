package adapter;

import com.google.gson.Gson;
import response.ContentEDeclaration;
import response.ContentEExchange;
import response.EDeclarationResponse;
import response.EExchangeResponse;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class EDeclarationAdapter extends Adapter {
    public String URL = BASE_URL + "/" + VERSION + "/edeclarations" ;
    Adapter adapter = new Adapter();
    EDeclarationResponse eDeclarationResponseList;
    EDeclarationResponse eDeclarationResponseList2;
    EDeclarationResponse eDeclarationResponse;

    public EDeclarationResponse listEDeclaration(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL;
        String response = httpClient().send(token, url, "GET");
        eDeclarationResponseList = new Gson().fromJson(response, EDeclarationResponse.class);//java generic method
        return eDeclarationResponseList;
    }
    public EDeclarationResponse listByCreationDateEDeclaration(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url, "GET");
        eDeclarationResponseList = new Gson().fromJson(response, EDeclarationResponse.class);//java generic method
        return eDeclarationResponseList;
    }

    public String ViewPDFEDeclaration(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDeclaration content:eDeclarationResponseList.contents) {
            File file = new File(PATH + "EDeclaration/PDF", content.id+".pdf");
            String url = URL + "/"+ content.id + "/preview/pdf";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewHTMLEDeclaration(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDeclaration content:eDeclarationResponseList.contents) {
            File file = new File(PATH + "EDeclaration/HTML", content.id+".html");
            String url = URL + "/"+ content.id + "/preview/html";
            response = httpClient().sendFile(token, url, file);
        }

        return response;

    }
    public String ViewXMLEDeclaration(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        String response="";
        for (ContentEDeclaration content:eDeclarationResponseList.contents) {
            File file = new File(PATH + "EDeclaration/XML", content.id+".xml");
            String url = URL + "/"+ content.id + "/preview/ubl";
            response = httpClient().sendFile(token, url, file);
        }

        return response;
    }
    public String statusEDeclaration(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        String response = httpClient().send(token, url, "GET");
        return response;
    }
}
