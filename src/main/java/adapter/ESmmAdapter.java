package adapter;

import model.DownloadRequest;
import response.ESmmResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ESmmAdapter extends DocumentAdapter<ESmmResponse> {
    public String URL = BASE_URL + "/" + VERSION + "/esmms" ;

    public ESmmResponse listESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return list(token, URL, ESmmResponse.class);
    }
    public ESmmResponse listByCreationDateESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        return list(token, url, ESmmResponse.class);
    }

    public String viewPDFESmm(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "ESmm","" );
    }
    public String viewHTMLESmm(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "ESmm","" );
    }
    public String viewXMLESmm(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "ESmm","" );
    }
    public String statusESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        return listStatus(token, url);
    }
    public String downloadXMLESmm(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/ubl", "ESmm/XML/Downloads/");
    }
    public String downloadHTMLESmm(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/html", "ESmm/HTML/Downloads/");
    }
    public String downloadPDFESmm(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/pdf", "ESmm/PDF/Downloads/");
    }
}
