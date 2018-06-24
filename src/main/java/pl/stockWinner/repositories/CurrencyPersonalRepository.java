package pl.stockWinner.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stockWinner.models.entity.CurrencyPersonalEntity;

@Repository
public interface CurrencyPersonalRepository extends CrudRepository<CurrencyPersonalEntity, Long> {

    //    Optional<SharesPersonalEntity> findByIdAndUserEntity(long id, UserEntity userEntity);
//
//    Optional<SharesPersonalEntity> findByArticleEntityAndUserEntity(SharesEntity articleEntity, UserEntity userEntity);
//
//    Iterable<SharesPersonalEntity> findAllByArticleEntity(SharesEntity sharesEntity);
//
//    Iterable<SharesPersonalEntity> findAllByUserEntity(UserEntity userEntity);

}
