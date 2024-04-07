package ru.kerporation.eventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import ru.kerporation.common.domain.model.Card;
import ru.kerporation.common.events.CardCreateEvent;
import ru.kerporation.eventhandler.service.card.CardService;

@Component("CARD_CREATE")
@RequiredArgsConstructor
public class CardCreateEventHandler implements EventHandler {

    private final CardService cardService;
    private final Gson gson;

    @Override
    public void handle(final JsonObject object,
                       final Acknowledgment acknowledgment) {
        final CardCreateEvent event = gson.fromJson(object, CardCreateEvent.class);
        final Card card = gson.fromJson((String) event.getPayload(), Card.class);
        cardService.create(card);
        acknowledgment.acknowledge();
    }
}