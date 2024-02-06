package ir.reminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootReminderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootReminderApplication.class, args);
//            System.getProperties().put("proxySet", "true");
//            System.getProperties().put("socksProxyHost", "127.0.0.1");
//            System.getProperties().put("socksProxyPort", "2050");

    }
}
