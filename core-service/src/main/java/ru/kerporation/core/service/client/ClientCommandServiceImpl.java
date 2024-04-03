package ru.kerporation.core.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kerporation.common.domain.model.Client;
import ru.kerporation.common.events.ClientCreateEvent;
import ru.kerporation.core.service.event.EventService;

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
