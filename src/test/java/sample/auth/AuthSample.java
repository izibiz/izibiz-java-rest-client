package sample.auth;

import adapter.AuthAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AuthSample {
    static AuthAdapter adapter;

    @BeforeAll
    public static void init() {
        adapter = new AuthAdapter();
    }

    @Test
    public String canLogin_returnsToken() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        String response = adapter.login(body);

        Assertions.assertNotNull(response);

        System.out.println(response);

        return response;
    }
}
