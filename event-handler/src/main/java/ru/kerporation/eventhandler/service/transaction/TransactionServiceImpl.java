package ru.kerporation.eventhandler.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kerporation.common.domain.model.Transaction;
import ru.kerporation.common.repository.TransactionRepository;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Override
    public Transaction create(final Transaction transaction) {
        //TODO change balance of card accounts
        return repository.save(transaction);
    }
}