package ru.kerporation.core.web.security.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.kerporation.common.domain.exception.ResourceNotFoundException;
import ru.kerporation.common.domain.model.Card;
import ru.kerporation.common.domain.model.Client;
import ru.kerporation.common.domain.model.Transaction;
import ru.kerporation.core.service.card.CardService;
import ru.kerporation.core.service.client.ClientService;
import ru.kerporation.core.service.transaction.TransactionService;
import ru.kerporation.core.web.security.SecurityUser;

import java.util.UUID;

@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final ClientService clientService;
    private final CardService cardService;
    private final TransactionService transactionService;

    @Override
    public SecurityUser getUserFromRequest() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return (SecurityUser) authentication.getPrincipal();
    }

    @Override
    public boolean canAccessClient(final UUID clientId) {
        final SecurityUser user = getUserFromRequest();
        final UUID id = user.getId();
        return clientId.equals(id);
    }

    @Override
    public boolean canAccessCard(final UUID cardId) {
        final SecurityUser user = getUserFromRequest();
        final UUID id = user.getId();
        final Client client = clientService.getById(id);
        return client.getCards().stream().anyMatch(card -> card.getId().equals(cardId));
    }

    @Override
    public boolean canAccessCard(final Card card) {
        try {
            final Card foundCard = cardService.getByNumberAndDateAndCvv(card.getNumber(), card.getDate(), card.getCvv());
            return canAccessCard(foundCard.getId());
        } catch (final ResourceNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean canAccessTransaction(final UUID transactionId) {
        final SecurityUser user = getUserFromRequest();
        final UUID id = user.getId();
        final Client client = clientService.getById(id);
        final Transaction transaction = transactionService.getById(transactionId);
        return client.getCards().contains(transaction.getFrom()) || client.getCards().contains(transaction.getTo());
    }

}