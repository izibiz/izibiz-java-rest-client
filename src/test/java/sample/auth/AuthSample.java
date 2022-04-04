package sample.auth;

import adapter.AuthAdapter;

import model.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class AuthSample {
    public static AuthAdapter adapter;
    public static String response;

    @BeforeAll
    public static void init() {
        adapter = new AuthAdapter();
    }

    @Test
    public void login() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        response = adapter.login(body);

        Assertions.assertNotNull(response);
        System.out.println(response);

    }
}
