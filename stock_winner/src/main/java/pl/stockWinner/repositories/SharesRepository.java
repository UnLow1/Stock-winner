package pl.stockWinner.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stockWinner.models.entity.SharesEntity;

import java.util.Optional;

@Repository
public interface SharesRepository extends CrudRepository<SharesEntity, Long> {

    //Optional<SharesEntity> findByUrl(String url);

}
