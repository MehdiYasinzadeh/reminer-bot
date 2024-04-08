package ir.reminder.telegram;


import ir.reminder.handler.ResponseHandler;
import ir.reminder.utility.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

@Component
@Configuration
public class PizzaBot extends AbilityBot {

    private final ResponseHandler responseHandler;

    public PizzaBot(ResponseHandler responseHandler, @Value("${bot_token:default}") String botToken, @Value("${bot_name:default}") String botName) {
        super(botToken, botName);
        this.responseHandler = responseHandler;
        responseHandler.senderInit(silent, db);
    }

    public Ability startBot() {
        return Ability
                .builder()
                .name("start")
                .info(Constants.START_DESCRIPTION)
                .locality(USER)
                .privacy(PUBLIC)
                .action(ctx -> responseHandler.replyToStart(ctx.chatId(), ctx.user().getUserName()))
                .build();
    }

//    public Reply replyToButtons() {
//        BiConsumer<BaseAbilityBot, Update> action = (abilityBot, upd) -> responseHandler.replyToButtons(getChatId(upd), upd.getMessage());
//        return Reply.of(action, Flag.TEXT,upd -> responseHandler.userIsActive(getChatId(upd)));
//    }

    @Override
    public long creatorId() {
        return 1L;
    }

    public void sendMessage(Long chatId) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        String fooResourceUrl
                = "https://api.codebazan.ir/hadis";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        sendMessage.setText(response.getBody());
        sender.execute(sendMessage);
    }
}
