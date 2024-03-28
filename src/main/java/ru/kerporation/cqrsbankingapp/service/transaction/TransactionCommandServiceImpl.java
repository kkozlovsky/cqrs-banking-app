package ru.kerporation.cqrsbankingapp.service.transaction;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kerporation.cqrsbankingapp.domain.model.Transaction;
import ru.kerporation.cqrsbankingapp.events.TransactionCreateEvent;
import ru.kerporation.cqrsbankingapp.service.event.EventService;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final EventService eventService;

    @Override
    public void create(final Transaction object) {
        final TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}
