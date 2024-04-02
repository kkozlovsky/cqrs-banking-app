package ru.kerporation.cqrsbankingapp.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import ru.kerporation.cqrsbankingapp.domain.model.Account;
import ru.kerporation.cqrsbankingapp.repository.AccountRepository;

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