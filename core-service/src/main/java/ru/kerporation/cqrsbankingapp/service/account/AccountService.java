package ru.kerporation.cqrsbankingapp.service.account;

import ru.kerporation.cqrsbankingapp.domain.model.Account;
import ru.kerporation.cqrsbankingapp.service.CommandService;
import ru.kerporation.cqrsbankingapp.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {

}