package ir.reminder.service;

import ir.reminder.entity.UserInfo;
import ir.reminder.entity.UserInfoRequest;
import ir.reminder.entity.UserLoginRequest;
import ir.reminder.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginRepository loginRepository;

    public UserServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void save(UserInfoRequest userInfoRequest) throws Exception {
        String message = "به پروسه ی ثبت نام خوش امدید";
        System.out.println(message);
        try {
            if (loginRepository.existsByNationalCode(userInfoRequest.getNationalCode())){
                String dbMessage = "this user is exist" ;
                System.out.println(dbMessage);
            }
            UserInfo userInfo = new UserInfo();
            userInfo.setNationalCode(userInfoRequest.getNationalCode());
            userInfo.setEmail(userInfoRequest.getEmail());
            userInfo.setPassword(userInfoRequest.getPassword());
            userInfo.setGender(userInfoRequest.getGender());
            userInfo.setFirstName(userInfoRequest.getFirstName());
            userInfo.setLastName(userInfoRequest.getLastName());
            userInfo.setAge(userInfoRequest.getAge());
            loginRepository.save(userInfo);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public boolean authenticateUser(UserLoginRequest userLoginRequest) {
        UserInfo userInfo = loginRepository.findByEmail(userLoginRequest.getEmail());
        if (userInfo != null && userInfo.getPassword().equals(userLoginRequest.getPassword())) {
            return true;
        }
        return false;
    }
}
