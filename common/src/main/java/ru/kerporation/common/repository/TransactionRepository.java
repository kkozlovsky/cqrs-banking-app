package ru.kerporation.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kerporation.common.domain.model.Transaction;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
