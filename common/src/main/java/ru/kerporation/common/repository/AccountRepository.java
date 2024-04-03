package ru.kerporation.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kerporation.common.domain.model.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
