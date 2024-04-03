package ru.kerporation.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kerporation.common.domain.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByUsername(final String username);

    boolean existsByUsername(final String username);
}
