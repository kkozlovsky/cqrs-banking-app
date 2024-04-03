package ru.kerporation.core.web.security.service;

import ru.kerporation.common.domain.model.Card;
import ru.kerporation.core.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(final UUID clientId);

    boolean canAccessCard(final UUID cardId);

    boolean canAccessCard(final Card card);

    boolean canAccessTransaction(final UUID transactionId);

}