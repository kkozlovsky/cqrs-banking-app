package ru.kerporation.core.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.common.domain.exception.ResourceNotFoundException;
import ru.kerporation.common.domain.model.Card;
import ru.kerporation.common.repository.CardRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository repository;

    @Override
    public Card getById(final UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByNumberAndDate(final String number,
                                         final String date) {
        return repository.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(final String number,
                                         final String date,
                                         final String cvv) {
        return repository.findByNumberAndDateAndCvv(number, date, cvv).orElseThrow(ResourceNotFoundException::new);
    }

}
