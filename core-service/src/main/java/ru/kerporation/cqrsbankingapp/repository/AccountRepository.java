package ru.kerporation.cqrsbankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kerporation.cqrsbankingapp.domain.model.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
