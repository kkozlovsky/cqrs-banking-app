package ru.kerporation.core.service.card;

import ru.kerporation.common.domain.model.Card;
import ru.kerporation.core.service.CommandService;
import ru.kerporation.core.service.QueryService;

import java.util.UUID;

public interface CardService extends CommandService<Card>, QueryService<Card> {

    void createByClientId(final UUID clientId);

    boolean existsByNumberAndDate(final String number,
                                  final String date);

    Card getByNumberAndDateAndCvv(final String number,
                                  final String date,
                                  final String cvv);

}
