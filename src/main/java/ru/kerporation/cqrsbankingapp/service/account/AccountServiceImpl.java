package ru.kerporation.cqrsbankingapp.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.cqrsbankingapp.domain.model.Account;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountQueryService queryService;
    private final AccountCommandService commandService;

    @Override
    public Account getById(final UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void create(final Account object) {
        commandService.create(object);
    }
}
