package com.hevodemo.feignclient.clients;

import com.hevodemo.feignclient.models.Datum;
import com.hevodemo.feignclient.models.Support;
import com.hevodemo.feignclient.models.UserRecord;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface UserRecordClient {

    @RequestLine("GET /users?page={page}")
    UserRecord findByPage(@Param("page") Integer page);

    @RequestLine("GET /users")
    UserRecord findAll();

    @RequestLine("POST /users")
    @Headers("Content-Type: application/json")
    UserRecord create(UserRecord userRecord);
}