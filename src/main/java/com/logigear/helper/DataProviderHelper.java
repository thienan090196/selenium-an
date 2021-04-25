package com.logigear.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logigear.models.Login;
import com.logigear.models.Register;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class DataProviderHelper {

    @DataProvider(name = "valid-login")
    public static Object[] getValidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Login> logins = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "login-data/valid-login.json"), new TypeReference<List<Login>>() {});
        return logins.toArray();
    }

    @DataProvider(name = "invalid-logins")
    public static Object[] getInvalidLoginsData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Login> login = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "login-data/invalid-logins.json"), new TypeReference<List<Login>>() {});
        return login.toArray();
    }

    @DataProvider(name = "valid-register")
    public static Object[] getValidRegisterData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Register> registers = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "register-data/valid-register.json"), new TypeReference<List<Register>>() {});
        return registers.toArray();
    }

    @DataProvider(name = "invalid-registers")
    public static Object[] getInvalidRegistersData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Register> registers = objectMapper.readValue(Common.readFile(Constant.TEST_DATA_FOLDER_PATH + "register-data/invalid-registers.json"), new TypeReference<List<Register>>() {});
        return registers.toArray();
    }

}
