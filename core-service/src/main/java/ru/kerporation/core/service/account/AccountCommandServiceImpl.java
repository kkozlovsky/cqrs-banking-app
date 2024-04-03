package ru.kerporation.core.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.common.domain.model.Account;
import ru.kerporation.common.events.AccountCreateEvent;
import ru.kerporation.core.service.event.EventService;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(final Account object) {
        final AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
}