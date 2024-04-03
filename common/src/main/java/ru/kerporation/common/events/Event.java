package ru.kerporation.common.events;


import ru.kerporation.common.domain.aggregate.Aggregate;

public interface Event {

    void apply(final Aggregate aggregate);
}