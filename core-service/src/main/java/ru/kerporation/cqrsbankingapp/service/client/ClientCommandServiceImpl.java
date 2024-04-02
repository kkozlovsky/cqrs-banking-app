package ru.kerporation.cqrsbankingapp.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kerporation.cqrsbankingapp.domain.model.Client;
import ru.kerporation.cqrsbankingapp.events.ClientCreateEvent;
import ru.kerporation.cqrsbankingapp.service.event.EventService;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientCommandServiceImpl implements ClientCommandService {

    private final EventService eventService;

    @Override
    public void create(final Client object) {
        final ClientCreateEvent event = new ClientCreateEvent(object);
        eventService.create(event);
    }

}
