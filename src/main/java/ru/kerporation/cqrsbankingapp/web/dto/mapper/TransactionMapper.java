package ru.kerporation.cqrsbankingapp.web.dto.mapper;


import org.mapstruct.Mapper;
import ru.kerporation.cqrsbankingapp.domain.model.Transaction;
import ru.kerporation.cqrsbankingapp.web.dto.TransactionDto;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = CardMapper.class, injectionStrategy = CONSTRUCTOR)
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}
