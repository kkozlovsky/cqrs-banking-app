package ru.kerporation.cqrsbankingapp.web.dto.mapper;


import org.mapstruct.Mapper;
import ru.kerporation.cqrsbankingapp.domain.model.Client;
import ru.kerporation.cqrsbankingapp.web.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
