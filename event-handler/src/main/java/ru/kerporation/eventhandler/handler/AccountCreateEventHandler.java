package ru.kerporation.eventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import ru.kerporation.common.domain.model.Account;
import ru.kerporation.common.events.AccountCreateEvent;
import ru.kerporation.eventhandler.service.account.AccountService;

@Component("ACCOUNT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {

    private final AccountService accountService;
    private final Gson gson;

    @Override
    public void handle(final JsonObject object,
                       final Acknowledgment acknowledgment) {
        final AccountCreateEvent event = gson.fromJson(object, AccountCreateEvent.class);
        final Account account = gson.fromJson((String) event.getPayload(), Account.class);
        accountService.create(account);
        acknowledgment.acknowledge();
    }
}