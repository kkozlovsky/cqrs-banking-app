package ru.kerporation.core.web.dto.mapper;


import org.mapstruct.Mapper;
import ru.kerporation.common.domain.model.Client;
import ru.kerporation.core.web.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
