package ru.kerporation.cqrsbankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kerporation.cqrsbankingapp.domain.model.Card;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    boolean existsByNumberAndDate(final String number,
                                  final String date);

    Optional<Card> findByNumberAndDateAndCvv(final String number,
                                             final String date,
                                             final String cvv);
}
