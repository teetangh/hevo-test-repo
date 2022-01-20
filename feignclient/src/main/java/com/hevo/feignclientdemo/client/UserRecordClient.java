package com.hevo.feignclientdemo.client;

import com.hevo.feignclientdemo.dto.UserRecord;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

// import feign client annotation


@FeignClient(name = "user-record-client", url = "https://reqres.in/api/users")
public interface UserRecordClient {

    @RequestLine("GET /users?page={page}&per_page={per_page}")
    UserRecord getUserRecord(@Param("page") int page, @Param("per_page") int per_page);

    @RequestLine("GET /users/{id}")
    UserRecord getUser(@Param("id") int id);

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    UserRecord createUser(UserRecord user);

    @RequestLine("PUT")
    @Headers("Content-Type: application/json")
    UserRecord updateUser(UserRecord user);

}
