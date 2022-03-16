package adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import http.EdonusumHttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adapter {
    public static final String BASE_URL = "https://apidev.izibiz.com.tr";
    public static final String VERSION = "v1";

    private EdonusumHttpClient edonusumHttpClient;
    private ObjectMapper mapper;
    private Map<String, List<String>> headers;

    public Adapter() {
        edonusumHttpClient = new EdonusumHttpClient();
        headers = new HashMap<>();
        mapper = new ObjectMapper();
    }

    public ObjectMapper mapper() {
        return this.mapper;
    }

    public EdonusumHttpClient httpClient() {
        return this.edonusumHttpClient;
    }

    public Map<String, List<String>> headersMap() {
        return this.headers;
    }
}
