package pl.stockWinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stockWinner.models.entity.Currency;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findAll();

}
