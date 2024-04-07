package ru.kerporation.eventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import ru.kerporation.common.domain.model.Client;
import ru.kerporation.common.events.ClientCreateEvent;
import ru.kerporation.eventhandler.service.client.ClientService;

@Component("CLIENT_CREATE")
@RequiredArgsConstructor
public class ClientCreateEventHandler implements EventHandler {

    private final ClientService clientService;
    private final Gson gson;

    @Override
    public void handle(final JsonObject object,
                       final Acknowledgment acknowledgment) {
        final ClientCreateEvent event = gson.fromJson(object, ClientCreateEvent.class);
        final Client client = gson.fromJson((String) event.getPayload(), Client.class);
        clientService.create(client);
        acknowledgment.acknowledge();
    }
}