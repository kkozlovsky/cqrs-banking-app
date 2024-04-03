package ru.kerporation.core.service.card;

import ru.kerporation.common.domain.model.Card;
import ru.kerporation.core.service.QueryService;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(final String number,
                                  final String date);

    Card getByNumberAndDateAndCvv(final String number,
                                  final String date,
                                  final String cvv);

}
