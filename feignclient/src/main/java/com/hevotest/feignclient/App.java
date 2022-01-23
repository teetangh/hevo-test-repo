package com.hevotest.feignclient;

import com.hevotest.feignclient.*;
import com.hevotest.feignclient.models.*;
import com.hevotest.feignclient.clients.*;

// import static org.hamcrest.CoreMatchers.containsString;
// import static org.hamcrest.CoreMatchers.is;

public class App {

    

    public static void main(String[] args) {
        System.out.println("Hello World!");

        UserRecordControllerFeignClientBuilder feignClientBuilder = new UserRecordControllerFeignClientBuilder();
        UserRecordClient userRecordClient = feignClientBuilder.getUserRecordClient();
    }
}
