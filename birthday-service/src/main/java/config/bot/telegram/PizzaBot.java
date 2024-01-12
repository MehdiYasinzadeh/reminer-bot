package config.bot.telegram;

import org.apache.http.client.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;

@Component
public class PizzaBot extends AbilityBot {
    private final ResponseHandler responseHandler;
    @Autowired
    public PizzaBot(Environment env) {
        super(env.getProperty("botToken"), "baeldungbot");
        responseHandler = new ResponseHandler(silent, db);
    }
    @Override
    public long creatorId() {
        return 1L;
    }
}
