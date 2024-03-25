package ru.kerporation.cqrsbankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kerporation.cqrsbankingapp.domain.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByUsername(final String username);

    boolean existsByUsername(final String username);
}
