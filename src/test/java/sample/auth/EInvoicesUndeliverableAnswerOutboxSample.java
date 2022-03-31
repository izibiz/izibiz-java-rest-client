package sample.auth;


import adapter.EInvoiceAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import response.EInvoiceResponse;

import java.io.IOException;
import java.net.URISyntaxException;


public class EInvoicesUndeliverableAnswerOutboxSample {

    static EInvoiceAdapter adapter;
    static EInvoiceResponse EInvoice;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EInvoiceAdapter();
        //     Token = AuthSample.response;
    }

    @Test
    public void undeliverableAnswerList() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        AuthSample.init();
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthSample.adapter.login(body);
        EInvoice = adapter.UndeliverableAnswerEInvoices_Outbox(Token);

        System.out.println(EInvoice.getContent()[0]);

    }
}
