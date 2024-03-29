package ru.kerporation.cqrsbankingapp.web.dto.mapper;

import org.mapstruct.Mapper;
import ru.kerporation.cqrsbankingapp.domain.model.Card;
import ru.kerporation.cqrsbankingapp.web.dto.CardDto;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
