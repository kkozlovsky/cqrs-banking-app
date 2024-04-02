package ru.kerporation.cqrsbankingapp.events;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kerporation.cqrsbankingapp.domain.aggregate.Aggregate;
import ru.kerporation.cqrsbankingapp.domain.model.Card;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CardCreateEvent extends AbstractEvent {

    public CardCreateEvent(final Card payload) {
        super(null, EventType.CARD_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {
        //TODO implement
    }

}