package ru.kerporation.core.service.client;


import ru.kerporation.common.domain.model.Client;
import ru.kerporation.core.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    Client getByUsername(final String username);

    boolean existsByUsername(final String username);

}
