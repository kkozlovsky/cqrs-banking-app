package ru.kerporation.core.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kerporation.common.domain.model.Card;
import ru.kerporation.core.service.card.CardService;
import ru.kerporation.core.web.dto.CardDto;
import ru.kerporation.core.web.dto.TransactionDto;
import ru.kerporation.core.web.dto.mapper.CardMapper;
import ru.kerporation.core.web.dto.mapper.TransactionMapper;
import ru.kerporation.core.web.security.SecurityUser;
import ru.kerporation.core.web.security.service.SecurityService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
@Validated
public class CardController {

    private final CardService cardService;
    private final SecurityService securityService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        final SecurityUser user = securityService.getUserFromRequest();
        cardService.createByClientId(user.getId());
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public CardDto getById(@PathVariable final UUID id) {
        final Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public List<TransactionDto> getTransactionsById(@PathVariable final UUID id) {
        final Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }

}