package com.hevodemo.feignclient;

import com.hevodemo.feignclient.UserRecordControllerFeignClientBuilder;
import com.hevodemo.feignclient.clients.UserRecordClient;
import com.hevodemo.feignclient.models.*;

import java.util.Arrays;
import java.util.List;

public class App {

    static UserRecordClient userRecordClient;

    // GET all UserRecords
    public static void getAllUserRecords(UserRecordClient userRecordClient) {
        UserRecord userRecord = userRecordClient.findAll();
        System.out.println(userRecord);
    }

    // GET UserRecord by id
    public static void getUserRecordByPage(UserRecordClient userRecordClient, Integer page) {
        UserRecord userRecord = userRecordClient.findByPage(page);
        System.out.println(userRecord);
    }

    // GET UserRecord by id and paginate
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

    // POST
    public static void postUserRecord(UserRecordClient userRecordClient) {
        Datum datum1 = new Datum();
        datum1.setId(1);
        datum1.setFirstName("samplefirstname");
        datum1.setLastName("samplelastname");
        datum1.setEmail("abc@gmail.com");
        datum1.setAvatar(
                "https://media.istockphoto.com/photos/headshot-portrait-of-smiling-ethnic-businessman-in-office-picture-id1300512215?b=1&k=20&m=1300512215&s=170667a&w=0&h=LsZL_-vvAHB2A2sNLHu9Vpoib_3aLLkRamveVW3AGeQ=");

        Datum datum2 = new Datum();
        datum2.setId(2);
        datum2.setFirstName("samplefirstname");
        datum2.setLastName("samplelastname");
        datum2.setEmail("xyz@gmail.com");
        datum2.setAvatar(
                "https://expertphotography.b-cdn.net/wp-content/uploads/2020/08/social-media-profile-photos-3.jpg");

        // Put datum in a list
        List<Datum> data = Arrays.asList(datum1, datum2);

        Support support = new Support();
        support.setText("sampletext");
        support.setUrl("https://www.google.com");

        UserRecord userRecord = new UserRecord();
        userRecord.setData(data);
        userRecord.setSupport(support);
        userRecord.setPage(3);
        userRecord.setPerPage(2);
        userRecord.setTotal(2);
        userRecord.setTotalPages(1);

        UserRecord resultUserRecord = userRecordClient.create(userRecord);
        System.out.println(resultUserRecord);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        UserRecordControllerFeignClientBuilder feignClientBuilder = new UserRecordControllerFeignClientBuilder();
        userRecordClient = feignClientBuilder.getUserRecordClient();

        System.out.println("GETTING ALL USERRECORDS");
        getAllUserRecords(userRecordClient);

        System.out.println("GETTING USERRECORD BY PAGE");
        getUserRecordByPage(userRecordClient, 1);

        System.out.println("GETTING USERRECORD BY PAGE AND PAGINATE");
        getUserRecordByPageAndPaginate(userRecordClient);

        System.out.println("POSTING USERRECORD");
        postUserRecord(userRecordClient);
    }
}