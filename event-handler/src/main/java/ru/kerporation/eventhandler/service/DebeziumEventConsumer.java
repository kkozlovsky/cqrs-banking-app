package ru.kerporation.eventhandler.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import ru.kerporation.eventhandler.handler.EventHandler;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DebeziumEventConsumer implements CDCEventConsumer {

    private final Map<String, EventHandler> factories;

    @Override
    @KafkaListener(topics = "events")
    public void process(final String payload, final Acknowledgment acknowledgment) {
        try {
            log.info("Received message: {}", payload);
            final JsonObject json = JsonParser.parseString(payload).getAsJsonObject().get("payload").getAsJsonObject();
            final String type = json.get("type").getAsString();
            factories.get(type).handle(json, acknowledgment);
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}