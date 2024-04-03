package ru.kerporation.common.events;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kerporation.common.domain.aggregate.Aggregate;
import ru.kerporation.common.domain.model.Transaction;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionCreateEvent extends AbstractEvent {

    public TransactionCreateEvent(final Transaction payload) {
        super(null, EventType.TRANSACTION_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {
        //TODO implement
    }
}