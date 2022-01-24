package com.hevodemo.feignclient;

import com.hevodemo.feignclient.UserRecordControllerFeignClientBuilder;
import com.hevodemo.feignclient.clients.UserRecordClient;
import com.hevodemo.feignclient.models.*;

// import static org.hamcrest.CoreMatchers.containsString;
// import static org.hamcrest.CoreMatchers.is;

public class App {

    static UserRecordClient userRecordClient ;

    public static  void getAllUserRecords(UserRecordClient userRecordClient) {
        UserRecord userRecord = userRecordClient.findAll();
        System.out.println(userRecord);
    }

    public static void getUserRecordByPage(UserRecordClient userRecordClient,Integer page) {
        UserRecord userRecord = userRecordClient.findByPage(page);
        System.out.println(userRecord);
    }

    // With Pagination
    public static void getUserRecordByPageAndPaginate(UserRecordClient userRecordClient) {

        Integer page = 1;
        UserRecord userRecord;
        do {
            userRecord = userRecordClient.findByPage(page);
            System.out.println(userRecord);
            page++;
        } while (userRecord.getData().size() > 0);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        UserRecordControllerFeignClientBuilder feignClientBuilder = new UserRecordControllerFeignClientBuilder();
        userRecordClient = feignClientBuilder.getUserRecordClient();

//        getAllUserRecords(userRecordClient);
//        getUserRecordByPage(userRecordClient,1);

        getUserRecordByPageAndPaginate(userRecordClient);
    }
}