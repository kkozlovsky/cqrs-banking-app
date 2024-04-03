package ru.kerporation.core.service.transaction;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kerporation.common.domain.model.Transaction;
import ru.kerporation.common.events.TransactionCreateEvent;
import ru.kerporation.core.service.event.EventService;

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
