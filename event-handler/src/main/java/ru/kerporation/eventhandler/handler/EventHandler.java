package ru.kerporation.eventhandler.handler;

import com.google.gson.JsonObject;
import org.springframework.kafka.support.Acknowledgment;

public interface EventHandler {

    void handle(final JsonObject object,
                final Acknowledgment acknowledgment);

}