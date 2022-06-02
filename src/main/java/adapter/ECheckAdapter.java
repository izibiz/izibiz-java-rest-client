package adapter;

import model.DownloadRequest;
import response.DataSeries;
import response.ECheckResponse;
import response.SeriesResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ECheckAdapter extends DocumentAdapter<ECheckResponse> {

    public String URL = BASE_URL + "/" + VERSION + "/echecks" ;

    public ECheckResponse listECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

       return list(token, URL, ECheckResponse.class);
    }
    public ECheckResponse listByCreationDateECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"?page=0&pageSize=20&sortProperty=createDate&sort=desc";
        return list(token, url, ECheckResponse.class);
    }

    public String viewPDFECheck(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "pdf", "PDF", "ECheck","" );
    }
    public String viewHTMLECheck(String token,  List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "html", "HTML", "ECheck","" );
    }
    public String viewXMLECheck(String token, List<Long> idList) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {

        return viewDocument(token, URL, idList, "ubl", "XML", "ECheck","" );
    }
    public String statusECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url = URL +"/lookup-statuses";
        return listStatus(token, url);
    }
    public String downloadXMLECheck(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/ubl", "ECheck/XML/Downloads/");
    }
    public String downloadHTMLECheck(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/html", "ECheck/HTML/Downloads/");
    }
    public String downloadPDFECheck(String token, DownloadRequest[] body) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        return downloadDocument(token, body, URL+"/download/pdf", "ECheck/PDF/Downloads/");
    }
    public SeriesResponse listSeriesECheck(String token) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{

        String url=URL +"/series";
        return listSeries(token, url, SeriesResponse.class);
    }
}
