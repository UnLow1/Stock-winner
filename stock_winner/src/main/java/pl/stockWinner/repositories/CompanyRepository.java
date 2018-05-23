package pl.stockWinner.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.stockWinner.models.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> getById(Long id);

    @Query("select c from Company  c")
    List<Company> getCompanies(Pageable pageable);
}
