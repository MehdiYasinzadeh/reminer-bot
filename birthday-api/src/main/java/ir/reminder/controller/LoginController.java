package ir.reminder.controller;


import ir.reminder.entity.UserInfoRequest;
import ir.reminder.entity.UserInfoResponse;
import ir.reminder.entity.UserLoginRequest;
import ir.reminder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class LoginController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserInfoRequest userInfoRequest) {

        try {
            userService.save(userInfoRequest);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("ثبت نام با موفقیت انجام شد ");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("این کاربر قبلا ثبت نام کرده است ");

        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest userLoginRequest) {
        if (userService.authenticateUser(userLoginRequest)) {
            return ResponseEntity.ok("ورود با موفقیت انجام شد");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("نام کاربری یا رمز عبور صحیح نمی باشد");
        }
    }

}
