package sample.auth;


import adapter.AuthAdapter;
import adapter.EInvoicesInboxAdapter;
import model.LoginRequest;
import model.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class EInvoicesInboxSample {
    static EInvoicesInboxAdapter adapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
   //     AuthSample authSample= new AuthSample();
        adapter = new EInvoicesInboxAdapter();
   //     Token = AuthSample.response;
    }

    @Test
    public void canList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        AuthSample.init();
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthSample.adapter.login(body);

        System.out.println(adapter.listEInvoices(Token));

    }
}