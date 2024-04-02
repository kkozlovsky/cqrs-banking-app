package ru.kerporation.cqrsbankingapp.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.cqrsbankingapp.domain.model.Account;
import ru.kerporation.cqrsbankingapp.events.AccountCreateEvent;
import ru.kerporation.cqrsbankingapp.service.event.EventService;

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