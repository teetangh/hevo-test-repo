package com.hevo.feignclient;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface UserRecordClient {

    @RequestLine("GET /users?page={page}&per_page={per_page}")
    UserRecord getUserRecord(@Param("page") int page, @Param("per_page") int per_page);

    @RequestLine("GET /users/{id}")
    User getUser(@Param("id") int id);

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    User createUser(User user);

    @RequestLine("PUT")
    @Headers("Content-Type: application/json")
    User updateUser(User user);

}
