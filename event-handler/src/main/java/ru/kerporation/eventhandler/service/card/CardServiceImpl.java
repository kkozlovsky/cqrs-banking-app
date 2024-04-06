package ru.kerporation.eventhandler.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.common.domain.model.Card;
import ru.kerporation.common.repository.CardRepository;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    @Override
    public Card create(final Card card) {
        //TODO set date cvv and number
        return repository.save(card);
    }
}