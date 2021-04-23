package com.logigear.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.models.Login;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class DataProviderHelper {

    @DataProvider(name = "logins")
    public static Object[] getLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Login> login = objectMapper.readValue(Common.readFile("login-data.json"), new TypeReference<List<Login>>() {});
        return login.toArray();
    }

}
