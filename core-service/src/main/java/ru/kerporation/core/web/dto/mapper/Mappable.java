package ru.kerporation.core.web.dto.mapper;

import java.util.List;

public interface Mappable<E, D> {

    E fromDto(final D dto);

    D toDto(final E entity);

    List<D> toDto(final List<E> entities);

}
