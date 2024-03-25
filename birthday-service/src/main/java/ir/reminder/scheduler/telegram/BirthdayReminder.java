package ir.reminder.scheduler.telegram;

import ir.reminder.entity.TelegramBotUser;
import ir.reminder.service.TelegramBotUserService;
import ir.reminder.telegram.PizzaBot;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class BirthdayReminder {
    private final TelegramBotUserService botUserService;
    private final PizzaBot pizzaBot;

    public BirthdayReminder(TelegramBotUserService botUserService, PizzaBot pizzaBot) {
        this.botUserService = botUserService;
        this.pizzaBot = pizzaBot;
    }

    @Scheduled(cron = "0 0 18 ? * *", zone = "Asia/Tehran")
    public void scheduleFixedDelayTask() {
        List<TelegramBotUser> telegramUsers = botUserService.getAll();
        if (!telegramUsers.isEmpty()) {
            telegramUsers.forEach(telegramBotUser -> {
                try {
                    pizzaBot.sendMessage(telegramBotUser.getChatId());
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
