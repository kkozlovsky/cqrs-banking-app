package ru.kerporation.core.web.dto.mapper;

import org.mapstruct.Mapper;
import ru.kerporation.common.domain.model.Card;
import ru.kerporation.core.web.dto.CardDto;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
