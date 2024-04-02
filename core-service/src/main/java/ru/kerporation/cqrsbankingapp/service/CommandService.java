package ru.kerporation.cqrsbankingapp.service;

public interface CommandService<T> {
    void create(final T object);
}