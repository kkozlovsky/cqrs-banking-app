package ru.kerporation.cqrsbankingapp.web.dto.mapper;


import org.mapstruct.Mapper;
import ru.kerporation.cqrsbankingapp.domain.model.Account;
import ru.kerporation.cqrsbankingapp.web.dto.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
