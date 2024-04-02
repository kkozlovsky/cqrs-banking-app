package ru.kerporation.cqrsbankingapp.service.card;

import ru.kerporation.cqrsbankingapp.domain.model.Card;
import ru.kerporation.cqrsbankingapp.service.CommandService;
import ru.kerporation.cqrsbankingapp.service.QueryService;

import java.util.UUID;

public interface CardService extends CommandService<Card>, QueryService<Card> {

    void createByClientId(final UUID clientId);

    boolean existsByNumberAndDate(final String number,
                                  final String date);

    Card getByNumberAndDateAndCvv(final String number,
                                  final String date,
                                  final String cvv);

}
