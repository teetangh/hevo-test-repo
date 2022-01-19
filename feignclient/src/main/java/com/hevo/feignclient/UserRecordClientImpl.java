package com.hevo.feignclient;

public class UserRecordClientImpl implements UserRecordClient {

    @Override
    public void getUserRecords() throws Exception {
        UserRecord userRecord = userRecordClient.getUserRecord(1, 10);
        System.out.println(userRecord);
    }

    @Override
    public void getUser() throws Exception {
        User user = userRecordClient.getUser(1);
        System.out.println(user);
    }

    @Override
    public void createUser() throws Exception {
        User user = new User();
        user.setEmail("teetangh@gmail.com");
        user.setFirstName("Tae");
        user.setLastName("Tangh");
        user.setAvatar("https://avatars0.githubusercontent.com/u/1234?v=3");
        userRecordClient.createUser(user);
    }

    @Override
    public void updateUser() throws Exception {
        User user = userRecordClient.getUser(1);
        user.setEmail("teetangh@yahoo.co.in");
        user.setFirstName("Tae");
        user.setLastName("Tangh");
        user.setAvatar("https://avatars0.githubusercontent.com/u/1234?v=3");
        userRecordClient.updateUser(user);
    }

}
