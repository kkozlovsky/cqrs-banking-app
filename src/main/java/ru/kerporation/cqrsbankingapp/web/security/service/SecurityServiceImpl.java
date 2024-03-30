package ru.kerporation.cqrsbankingapp.web.security.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.kerporation.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import ru.kerporation.cqrsbankingapp.domain.model.Card;
import ru.kerporation.cqrsbankingapp.domain.model.Client;
import ru.kerporation.cqrsbankingapp.domain.model.Transaction;
import ru.kerporation.cqrsbankingapp.service.card.CardService;
import ru.kerporation.cqrsbankingapp.service.client.ClientService;
import ru.kerporation.cqrsbankingapp.service.transaction.TransactionService;
import ru.kerporation.cqrsbankingapp.web.security.SecurityUser;

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