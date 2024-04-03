package ru.kerporation.core.service.event;

import ru.kerporation.common.events.AbstractEvent;

public interface EventService {
    void create(final AbstractEvent event);
}
