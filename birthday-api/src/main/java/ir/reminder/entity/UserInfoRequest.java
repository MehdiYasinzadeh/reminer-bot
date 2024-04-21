package ir.reminder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public class UserInfoRequest {

    @NotNull(message = "NAME_NOT_NULL")
    @Schema(example = "نام تستی", description = "نام")
    private String firstName;

    @NotNull(message = "LAST_NAME_NOT_NULL")
    @Schema(example = "فامیلی", description = "نام خانوادگی")
    private String lastName;


    @Pattern(regexp = "^(([0-9]*)|(([0-9]*)\\.([0-9]*)))$", message = "NATIONAL_CODE_ONLY_ACC_NUM")
    @Pattern(regexp = "\\d{10}$", message = "NATIONAL_CODE_LENGTH_INVALID")
    @Schema(example = "0021000000", description = "شماره ملی")
    @NotNull(message = "NATIONAL_CODE_NOT_NULL")
    private String nationalCode;


    @Schema(example = "MALE", description = "جنسیت کاربر")
    @NotNull(message = "GENDER_IS_INVALID")
    private String gender;

    @NotNull(message = "EMAIL_NOT_NULL")
    @Schema(example = "a@gmail.com", description = "آدرس ایمیل")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "EMAIL_NOT_VALID")
    private String email;

    private String age;

    @Min(value = 6, message = "PASSWORD_LENGTH_INVALID")
    @Max(value = 10, message = "PASSWORD_LENGTH_INVALID")
    @Schema(description = "رمز عبور")
    private String password;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UserInfo toUserInfo(UserInfoRequest requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setFirstName(requestDTO.getFirstName());
        userInfo.setLastName(requestDTO.getLastName());
        userInfo.setGender(requestDTO.getGender());
        userInfo.setNationalCode(requestDTO.getNationalCode());
        userInfo.setEmail(requestDTO.getEmail());
        userInfo.setPassword(requestDTO.getPassword());
        userInfo.setAge(requestDTO.getAge());
        return userInfo;
    }

}
