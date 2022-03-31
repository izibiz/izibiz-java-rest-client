package sample.auth;

import adapter.EDespatchAdapter;
import adapter.EInvoiceAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import response.EDespatchResponse;
import response.EInvoiceResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class EDespatchesListSample {
    static EDespatchAdapter adapter;
    static EDespatchResponse EDespatch;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EDespatchAdapter();
        //     Token = AuthSample.response;
    }

    @Test
    public void canList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        AuthSample.init();
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthSample.adapter.login(body);
        EDespatch = adapter.listEArchiveInvoices(Token);

        System.out.println(EDespatch.getContent()[0]);

    }
}
