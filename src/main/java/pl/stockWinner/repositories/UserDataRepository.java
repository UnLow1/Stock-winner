package pl.stockWinner.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.stockWinner.models.entity.UserEntity;

public interface UserDataRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findFirstByUserMail(String userMail);
}