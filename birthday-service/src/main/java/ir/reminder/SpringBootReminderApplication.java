package ir.reminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
@EnableScheduling
public class SpringBootReminderApplication {
    public static void main(String[] args) throws TelegramApiException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootReminderApplication.class, args);
//            System.getProperties().put("proxySet", "true");
//            System.getProperties().put("socksProxyHost", "127.0.0.1");
//            System.getProperties().put("socksProxyPort", "2050");

    }
}
