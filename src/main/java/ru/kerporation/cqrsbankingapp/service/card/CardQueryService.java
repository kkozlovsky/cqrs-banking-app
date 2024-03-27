package ru.kerporation.cqrsbankingapp.service.card;

import ru.kerporation.cqrsbankingapp.domain.model.Card;
import ru.kerporation.cqrsbankingapp.service.QueryService;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(final String number,
                                  final String date);

    Card getByNumberAndDateAndCvv(final String number,
                                  final String date,
                                  final String cvv);

}
