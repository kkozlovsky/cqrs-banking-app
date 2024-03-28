package ru.kerporation.cqrsbankingapp.service.transaction;


import ru.kerporation.cqrsbankingapp.domain.model.Transaction;
import ru.kerporation.cqrsbankingapp.service.CommandService;
import ru.kerporation.cqrsbankingapp.service.QueryService;

public interface TransactionService extends CommandService<Transaction>, QueryService<Transaction> {
}
