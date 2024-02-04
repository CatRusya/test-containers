package org.example.testcontainers.web.mapper;

import java.util.List;

public interface Mappable<E, D> {
    E toEntity(D d);

    D toDto(E e);

    List<D> toDto(List<E> e);
}
