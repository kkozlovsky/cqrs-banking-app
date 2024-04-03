package ru.kerporation.core.service.client;

import ru.kerporation.common.domain.model.Client;
import ru.kerporation.core.service.CommandService;
import ru.kerporation.core.service.QueryService;

public interface ClientService extends CommandService<Client>, QueryService<Client> {

    Client getByUsername(final String username);

    boolean existsByUsername(final String username);

}
