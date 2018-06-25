package pl.stockWinner.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stockWinner.models.entity.CurrencyPersonalEntity;
import pl.stockWinner.models.entity.UserEntity;

import java.util.List;

@Repository
public interface CurrencyPersonalRepository extends CrudRepository<CurrencyPersonalEntity, Long> {

    //    Optional<SharesPersonalEntity> findByIdAndUserEntity(long id, UserEntity userEntity);
//
//    Optional<SharesPersonalEntity> findByArticleEntityAndUserEntity(SharesEntity articleEntity, UserEntity userEntity);
//
//    Iterable<SharesPersonalEntity> findAllByArticleEntity(SharesEntity sharesEntity);
//
    List<CurrencyPersonalEntity> findAllByUserEntity(UserEntity userEntity);

}
