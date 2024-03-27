package ru.kerporation.cqrsbankingapp.service.event;

import ru.kerporation.cqrsbankingapp.events.AbstractEvent;

public interface EventService {
    void create(final AbstractEvent event);
}
