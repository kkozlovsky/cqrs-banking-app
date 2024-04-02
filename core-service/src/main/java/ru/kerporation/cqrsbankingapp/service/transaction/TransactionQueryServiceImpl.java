package ru.kerporation.cqrsbankingapp.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import ru.kerporation.cqrsbankingapp.domain.model.Transaction;
import ru.kerporation.cqrsbankingapp.repository.TransactionRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository repository;

    @Override
    public Transaction getById(final UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

}
