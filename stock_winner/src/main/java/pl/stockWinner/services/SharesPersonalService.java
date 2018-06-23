package pl.stockWinner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stockWinner.models.converters.SharesPersonalConverter;
import pl.stockWinner.models.dto.SharesDTO;
import pl.stockWinner.models.entity.SharesEntity;
import pl.stockWinner.models.entity.SharesPersonalEntity;
import pl.stockWinner.models.entity.UserEntity;

@Service
public class SharesPersonalService {

    @Autowired
    SharesPersonalConverter sharesPersonalConverter;

    public SharesPersonalEntity create(SharesDTO sharesDTO, SharesEntity sharesEntity, UserEntity userEntity) {
        SharesPersonalEntity sharesPersonalEntity = sharesPersonalConverter.convertFromDto(sharesDTO);
        sharesPersonalEntity.setSharesEntity(sharesEntity);
        sharesPersonalEntity.setUserEntity(userEntity);
        return sharesPersonalEntity;
    }
}
