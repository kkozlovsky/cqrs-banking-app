package ru.kerporation.core.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kerporation.common.domain.model.Transaction;
import ru.kerporation.core.service.card.CardService;
import ru.kerporation.core.service.transaction.TransactionService;
import ru.kerporation.core.web.dto.OnCreate;
import ru.kerporation.core.web.dto.TransactionDto;
import ru.kerporation.core.web.dto.mapper.TransactionMapper;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
@Validated
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    @PreAuthorize("ssi.canAccessCard(#dto.from)")
    public void create(@RequestBody @Validated(OnCreate.class) final TransactionDto dto) {
        if (!cardService.existsByNumberAndDate(dto.getTo().getNumber(), dto.getTo().getDate())) {
            throw new IllegalStateException("Card does not exists.");
        }
        final Transaction transaction = transactionMapper.fromDto(dto);
        transactionService.create(transaction);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    public TransactionDto getById(@PathVariable final UUID id) {
        final Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }
}