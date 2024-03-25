package ru.kerporation.cqrsbankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kerporation.cqrsbankingapp.events.AbstractEvent;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}
