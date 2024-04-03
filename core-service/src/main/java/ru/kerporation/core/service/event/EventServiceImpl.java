package ru.kerporation.core.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.common.events.AbstractEvent;
import ru.kerporation.common.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public void create(final AbstractEvent event) {
        repository.save(event);
    }
}