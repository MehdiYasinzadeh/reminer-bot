package ir.reminder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserLoginRequest {
    @NotNull(message = "EMAIL_NOT_NULL")
    @Schema(example = "a@gmail.com", description = "آدرس ایمیل")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "EMAIL_NOT_VALID")
    private String email;

    @Min(value = 6, message = "PASSWORD_LENGTH_INVALID")
    @Max(value = 10, message = "PASSWORD_LENGTH_INVALID")
    @Schema(description = "رمز عبور")
    private String password;

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
}
