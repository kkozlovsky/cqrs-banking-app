package ru.kerporation.cqrsbankingapp.service.client;

import ru.kerporation.cqrsbankingapp.domain.model.Client;
import ru.kerporation.cqrsbankingapp.service.CommandService;
import ru.kerporation.cqrsbankingapp.service.QueryService;

public interface ClientService extends CommandService<Client>, QueryService<Client> {

    Client getByUsername(final String username);

    boolean existsByUsername(final String username);

}
