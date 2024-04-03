package ru.kerporation.core.service.account;

import ru.kerporation.common.domain.model.Account;
import ru.kerporation.core.service.CommandService;
import ru.kerporation.core.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {

}