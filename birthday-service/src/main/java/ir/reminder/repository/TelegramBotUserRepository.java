package ir.reminder.repository;

import ir.reminder.entity.TelegramBotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramBotUserRepository extends JpaRepository<TelegramBotUser, Long> {
    TelegramBotUser findByChatId(Long chatId);
    Boolean existsTelegramBotUserByChatId(Long chatId);
}
