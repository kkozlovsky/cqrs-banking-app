package ru.kerporation.eventhandler.service.transaction;

import ru.kerporation.common.domain.model.Transaction;

public interface TransactionService {

    Transaction create(final Transaction transaction);
}