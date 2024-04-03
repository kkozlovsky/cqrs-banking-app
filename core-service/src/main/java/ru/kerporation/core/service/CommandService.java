package ru.kerporation.core.service;

public interface CommandService<T> {
    void create(final T object);
}