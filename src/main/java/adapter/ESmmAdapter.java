package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import response.ContentESmm;
import response.EInvoiceResponse;
import response.ESmmResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ESmmAdapter extends DocumentAdapter<ESmmResponse> {
    public String URL = BASE_URL + "/" + VERSION + "/esmms" ;
    Adapter adapter = new Adapter();
    ESmmResponse eSmmResponseList;
    ESmmResponse eSmmResponseList_outbox;
    ESmmResponse eSmmResponse;

    public ESmmResponse listESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return list(token, URL, ESmmResponse.class);
    }
    public ESmmResponse listByCreationDateESmm(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=asc";
        String response = httpClient().send(token, url);
        eSmmResponseList = new Gson().fromJson(response, ESmmResponse.class);
        return eSmmResponseList;
    }

    public String viewPDFESmm(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "pdf", "PDF", "ESmm","" );
    }
    public String viewHTMLESmm(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "html", "HTML", "ESmm","" );
    }
    public String viewXMLESmm(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "ubl", "XML", "ESmm","" );
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
