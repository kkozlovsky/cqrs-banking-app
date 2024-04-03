package ru.kerporation.core.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kerporation.common.domain.model.Card;
import ru.kerporation.common.events.CardCreateEvent;
import ru.kerporation.core.service.event.EventService;

@Service
@RequiredArgsConstructor
@Transactional
public class CardCommandServiceImpl implements CardCommandService {

    private final EventService eventService;

    @Override
    public void create(final Card object) {
        final CardCreateEvent event = new CardCreateEvent(object);
        eventService.create(event);
    }

}
