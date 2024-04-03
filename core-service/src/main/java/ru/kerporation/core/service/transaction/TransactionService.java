package ru.kerporation.core.service.transaction;


import ru.kerporation.common.domain.model.Transaction;
import ru.kerporation.core.service.CommandService;
import ru.kerporation.core.service.QueryService;

public interface TransactionService extends CommandService<Transaction>, QueryService<Transaction> {
}
