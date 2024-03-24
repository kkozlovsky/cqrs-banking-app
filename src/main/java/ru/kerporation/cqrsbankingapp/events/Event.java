package ru.kerporation.cqrsbankingapp.events;

import ru.kerporation.cqrsbankingapp.domain.aggregate.Aggregate;

public interface Event {

    void apply(final Aggregate aggregate);
}