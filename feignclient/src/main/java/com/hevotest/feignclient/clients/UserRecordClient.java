package com.hevotest.feignclient.clients;

import com.hevotest.feignclient.models.UserRecord;

import com.hevotest.feignclient.models.Datum;
import com.hevotest.feignclient.models.Support;
import com.hevotest.feignclient.models.UserRecord;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface UserRecordClient {

    @RequestLine("GET /users/{page}")
    UserRecord findByPage(@Param("page") Integer page);

    @RequestLine("GET /users")
    UserRecord findAll();

    @RequestLine("POST /users")
    @Headers("Content-Type: application/json")
    void create(UserRecord userRecord);
}