package com.hevodemo.feignclient;

import com.hevodemo.feignclient.*;
import com.hevodemo.feignclient.clients.*;
import com.hevodemo.feignclient.models.*;

// import static org.hamcrest.CoreMatchers.containsString;
// import static org.hamcrest.CoreMatchers.is;

public class App {

    

    public static void main(String[] args) {
        System.out.println("Hello World!");

        UserRecordControllerFeignClientBuilder feignClientBuilder = new UserRecordControllerFeignClientBuilder();
        UserRecordClient userRecordClient = feignClientBuilder.getUserRecordClient();
    }
}
