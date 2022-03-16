import adapter.AuthAdapter;

import java.io.IOException;
import java.net.URISyntaxException;

public class RestClient {
    private AuthAdapter authAdapter;
    // ...

    public RestClient() {
        authAdapter = new AuthAdapter();
        //TODO: declarations
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        RestClient client = new RestClient();
    }

    public AuthAdapter auth() {
        return this.authAdapter;
    }
}
