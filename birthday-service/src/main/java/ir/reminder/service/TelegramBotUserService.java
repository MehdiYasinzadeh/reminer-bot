package ir.reminder.service;


import ir.reminder.entity.TelegramBotUser;
import ir.reminder.repository.TelegramBotUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramBotUserService {

    private final TelegramBotUserRepository repository;

    public TelegramBotUserService(TelegramBotUserRepository repository) {
        this.repository = repository;
    }

    public TelegramBotUser save(TelegramBotUser botUser) {
        return repository.save(botUser);
    }

    public TelegramBotUser getByChatId(Long chatId) {
        return repository.findByChatId(chatId);
    }

    public List<TelegramBotUser> getAll() {
        return repository.findAll();
    }

    public boolean isExist(Long chatId) {
        return repository.existsTelegramBotUserByChatId(chatId);
    }
}
