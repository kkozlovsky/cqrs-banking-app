package ru.kerporation.core.web.dto.mapper;


import org.mapstruct.Mapper;
import ru.kerporation.common.domain.model.Account;
import ru.kerporation.core.web.dto.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
