package ru.kerporation.cqrsbankingapp.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.cqrsbankingapp.domain.model.Card;
import ru.kerporation.cqrsbankingapp.domain.model.Client;
import ru.kerporation.cqrsbankingapp.service.client.ClientService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardQueryService queryService;
    private final CardCommandService commandService;
    private final ClientService clientService;

    @Override
    public void create(final Card object) {
        commandService.create(object);
    }

    @Override
    public Card getById(final UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void createByClientId(final UUID clientId) {
        final Client client = clientService.getById(clientId);
        final Card card = new Card(client.getAccount());
        commandService.create(card);
    }

    @Override
    public boolean existsByNumberAndDate(final String number,
                                         final String date) {
        return queryService.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(final String number,
                                         final String date,
                                         final String cvv) {
        return queryService.getByNumberAndDateAndCvv(number, date, cvv);
    }

}
