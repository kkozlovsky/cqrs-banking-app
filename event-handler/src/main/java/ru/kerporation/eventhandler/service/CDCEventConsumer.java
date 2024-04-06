package ru.kerporation.eventhandler.service;

import org.springframework.kafka.support.Acknowledgment;

public interface CDCEventConsumer {

    void process(final String payload,
                 final Acknowledgment acknowledgment);

}