package ru.kerporation.cqrsbankingapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.kerporation.cqrsbankingapp.domain.model.Card;
import ru.kerporation.cqrsbankingapp.service.card.CardService;
import ru.kerporation.cqrsbankingapp.web.dto.CardDto;
import ru.kerporation.cqrsbankingapp.web.dto.TransactionDto;
import ru.kerporation.cqrsbankingapp.web.dto.mapper.CardMapper;
import ru.kerporation.cqrsbankingapp.web.dto.mapper.TransactionMapper;
import ru.kerporation.cqrsbankingapp.web.security.SecurityUser;
import ru.kerporation.cqrsbankingapp.web.security.service.SecurityService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
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