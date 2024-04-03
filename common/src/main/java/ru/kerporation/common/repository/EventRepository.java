package ru.kerporation.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kerporation.common.events.AbstractEvent;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}
