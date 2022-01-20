package com.hevo.feignclient;

import java.util.logging.Logger;

import com.hevo.feignclient.UserRecordClientImpl;
import com.hevo.feignclient.client.UserRecordClient;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        public UserRecordClientImpl userRecordClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(UserRecordClient.class))
                .logLevel(Logger.Level.FULL)
                .target(UserRecordClient.class, "https://reqres.in/api/users");

        try {
            userRecordClient.getUserRecords();
            userRecordClient.getUser();
            userRecordClient.createUser();
            // userRecordClient.updateUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
