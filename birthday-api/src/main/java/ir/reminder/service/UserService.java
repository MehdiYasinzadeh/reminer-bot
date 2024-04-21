package ir.reminder.service;

import ir.reminder.entity.UserInfoRequest;
import ir.reminder.entity.UserLoginRequest;

public interface UserService {

    void save(UserInfoRequest userInfoRequest) throws Exception;

    boolean authenticateUser(UserLoginRequest userLoginRequest);

}
