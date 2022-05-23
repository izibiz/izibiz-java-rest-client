package EStorageSamples;

import adapter.AuthAdapter;
import adapter.ESmmAdapter;
import adapter.EStorageAdapter;
import model.LoginRequest;
import org.junit.jupiter.api.*;
import response.ESmmResponse;
import response.EStorageResponse;

import java.io.IOException;
import java.net.URISyntaxException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EStorageSample {
    static EStorageAdapter adapter;
    static EStorageResponse EStorage;
    static EStorageResponse EStorageList;
    static EStorageResponse EStorageList2;
    static adapter.AuthAdapter AuthAdapter;

    static String Token ;
    public static String list;

    @BeforeAll
    public static void init() {
        //     AuthSample authSample= new AuthSample();
        adapter = new EStorageAdapter();
        AuthAdapter = new AuthAdapter();
        //     Token = AuthSample.response;
    }
    @Test
    @Order(1)
    public void login() throws URISyntaxException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        LoginRequest body = new LoginRequest("izibiz-dev","izi321");
        Token = AuthAdapter.login(body);

        Assertions.assertNotNull(Token);
        System.out.println(Token);

    }
}
