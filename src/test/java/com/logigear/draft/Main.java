package com.logigear.draft;

import com.github.javafaker.Faker;
import com.logigear.helpers.Constant;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.regexify("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{1,3}"));
    }

}
