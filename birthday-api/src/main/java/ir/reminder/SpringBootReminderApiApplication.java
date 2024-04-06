package ir.reminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootReminderApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootReminderApiApplication.class, args);
//            System.getProperties().put("proxySet", "true");
//            System.getProperties().put("socksProxyHost", "127.0.0.1");
//            System.getProperties().put("socksProxyPort", "2050");

    }
}
