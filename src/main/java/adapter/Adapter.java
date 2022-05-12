package adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import http.EdonusumHttpClient;
import model.DownloadRequest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adapter {
    public static final String BASE_URL = "https://apidev.izibiz.com.tr";
    public static final String VERSION = "v1";
    public static final String ID = "114318159";
    public static final String PATH = System.getProperty("user.home")+"/Desktop/İzibiz/Kayit/";

    private EdonusumHttpClient edonusumHttpClient;
    private ObjectMapper mapper;
    private Map<String, List<String>> headers;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String endDate = LocalDate.now().format(formatter);
    public String startDate = LocalDate.now().plusYears(-2).format(formatter);

    public Adapter() {
        edonusumHttpClient = new EdonusumHttpClient();
        headers = new HashMap<>();
        mapper = new ObjectMapper();
    }

    public String downloadDocument(String token, DownloadRequest[] body, String URL, String path) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException{
        String filePath = System.getProperty("user.home")+"/Desktop/İzibiz/Kayit/" + path;
        String response = httpClient().sendDownload(token, URL, body, filePath);
        return response;
    }
    public ObjectMapper mapper() {
        return this.mapper;
    }

    public EdonusumHttpClient httpClient() {
        return this.edonusumHttpClient;
    }
}
