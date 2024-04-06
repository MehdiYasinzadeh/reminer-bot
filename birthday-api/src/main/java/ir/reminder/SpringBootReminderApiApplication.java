package ir.reminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
@EnableScheduling
public class SpringBootReminderApiApplication {
    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(SpringBootReminderApiApplication.class, args);

    }
}
