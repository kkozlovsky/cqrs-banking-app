package ru.kerporation.cqrsbankingapp.events;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kerporation.cqrsbankingapp.domain.aggregate.Aggregate;
import ru.kerporation.cqrsbankingapp.domain.model.Account;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountCreateEvent extends AbstractEvent {

    public AccountCreateEvent(final Account payload) {
        super(null, EventType.ACCOUNT_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {
        // TODO implement
    }
}