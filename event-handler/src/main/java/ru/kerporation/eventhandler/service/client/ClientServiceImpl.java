package ru.kerporation.eventhandler.service.client;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.common.domain.model.Account;
import ru.kerporation.common.domain.model.Client;
import ru.kerporation.common.repository.ClientRepository;
import ru.kerporation.eventhandler.service.account.AccountService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final AccountService accountService;

    @Override
    @Transactional
    public Client create(final Client client) {
        Account account = new Account();
        account = accountService.create(account);
        client.setAccount(account);
        return repository.save(client);
    }
}