package ru.kerporation.cqrsbankingapp.domain.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.SneakyThrows;

@Converter
public class ObjectConverter implements AttributeConverter<Object, String> {

    @Override
    @SneakyThrows
    public String convertToDatabaseColumn(final Object object) {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Override
    public Object convertToEntityAttribute(final String json) {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(json, Object.class);
    }
}