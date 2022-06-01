package adapter;

import com.google.gson.Gson;
import model.DownloadRequest;
import response.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class EExchangeAdapter extends DocumentAdapter<EExchangeResponse> {

    public String URL = BASE_URL + "/" + VERSION + "/exchanges" ;
    Adapter adapter = new Adapter();
    EExchangeResponse eExchangeResponseList;
    EExchangeResponse eExchangeResponseList2;
    EExchangeResponse eExchangeResponse;

    public EExchangeResponse listEExchange(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return list(token, URL, EExchangeResponse.class);
    }
    public EExchangeResponse listByCreationDateEExchange(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=desc";
        return list(token, url, EExchangeResponse.class);
    }

    public String viewPDFEExchange(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "pdf", "PDF", "EExchange" ,"" );
    }
    public String viewHTMLEExchange(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "html", "HTML", "EExchange","" );
    }
    public String viewXMLEExchange(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return view(token, URL, idList, "ubl", "XML", "EExchange","" );
    }
    public String statusEExchange(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        return listStatus(token, url);
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
