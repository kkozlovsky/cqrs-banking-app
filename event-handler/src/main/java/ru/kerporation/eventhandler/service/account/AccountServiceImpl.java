package ru.kerporation.eventhandler.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.common.domain.model.Account;
import ru.kerporation.common.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public Account create(final Account account) {
        account.setBalance(BigDecimal.ZERO);
        account.setNumber(UUID.randomUUID().toString());
        return repository.save(account);
    }
}