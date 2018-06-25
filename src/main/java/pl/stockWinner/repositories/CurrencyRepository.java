package pl.stockWinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stockWinner.models.entity.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findAll();

    Optional<Currency> findByName(String name);

    List<Currency> findAllByName(String name);
}
