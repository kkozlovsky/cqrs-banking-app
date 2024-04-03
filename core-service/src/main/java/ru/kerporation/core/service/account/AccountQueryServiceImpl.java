package ru.kerporation.core.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.common.domain.exception.ResourceNotFoundException;
import ru.kerporation.common.domain.model.Account;
import ru.kerporation.common.repository.AccountRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository repository;

    @Override
    public Account getById(final UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}