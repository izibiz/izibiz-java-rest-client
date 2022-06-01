package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import response.ContentEDeclaration;
import response.ECreditNoteResponse;
import response.EDeclarationResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class EDeclarationAdapter extends DocumentAdapter<EDeclarationResponse> {
    public String URL = BASE_URL + "/" + VERSION + "/edeclarations" ;
    Adapter adapter = new Adapter();
    EDeclarationResponse eDeclarationResponseList;
    EDeclarationResponse eDeclarationResponseList2;
    EDeclarationResponse eDeclarationResponse;

    public EDeclarationResponse listEDeclaration(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return list(token, URL, EDeclarationResponse.class);
    }
    public EDeclarationResponse listByCreationDateEDeclaration(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        return list(token, url, EDeclarationResponse.class);
    }

    public String viewPDFEDeclaration(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "pdf", "PDF", "EDeclaration","" );
    }
    public String viewHTMLEDeclaration(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "html", "HTML", "EDeclaration","" );
    }
    public String viewXMLEDeclaration(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "ubl", "XML", "EDeclaration","" );
    }
    public String statusEDeclaration(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        return listStatus(token, url);
    }
    public String downloadXMLEDeclaration(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/ubl", "EDeclaration/XML/Downloads/");
    }
    public String downloadHTMLEDeclaration(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/html", "EDeclaration/HTML/Downloads/");
    }
    public String downloadPDFEDeclaration(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/pdf", "EDeclaration/PDF/Downloads/");
    }
}
