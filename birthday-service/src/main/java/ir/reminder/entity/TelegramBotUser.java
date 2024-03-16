package ir.reminder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TelegramBotUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long chatId;
    private String username;

    public Long getId() {
        return id;
    }

    public TelegramBotUser setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getChatId() {
        return chatId;
    }

    public TelegramBotUser setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public TelegramBotUser setUsername(String username) {
        this.username = username;
        return this;
    }
}
