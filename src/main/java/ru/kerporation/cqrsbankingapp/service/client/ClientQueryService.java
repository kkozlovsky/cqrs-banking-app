package ru.kerporation.cqrsbankingapp.service.client;


import ru.kerporation.cqrsbankingapp.domain.model.Client;
import ru.kerporation.cqrsbankingapp.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    Client getByUsername(final String username);

    boolean existsByUsername(final String username);

}
