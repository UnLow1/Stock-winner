package pl.stockWinner.models.converters;

import org.springframework.stereotype.Component;
import pl.stockWinner.models.dto.SharesDTO;
import pl.stockWinner.models.entity.SharesEntity;
import pl.stockWinner.models.entity.SharesPersonalEntity;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class SharesPersonalConverter implements BaseConverter<SharesPersonalEntity, SharesDTO> {
    @Override
    public SharesDTO convertFromEntity(SharesPersonalEntity entity) {
        return new SharesDTO()
                .setId(entity.getId())
                .setTicker(entity.getSharesEntity().getTicker())
                .setVolume(entity.getSharesEntity().getVolume())
                .setPrice(entity.getSharesEntity().getPrice())
                .setDate(entity.getSharesEntity().getDate());
    }

    @Override
    public SharesPersonalEntity convertFromDto(SharesDTO sharesDTO) {
        SharesPersonalEntity sharesPersonalEntity = new SharesPersonalEntity();
        sharesPersonalEntity.setSharesEntity(new SharesEntity());
        sharesPersonalEntity
                .getSharesEntity()
                .setTicker(sharesDTO.getTicker())
                .setVolume(sharesDTO.getVolume())
                .setPrice(sharesDTO.getPrice())
                .setDate(sharesDTO.getDate());

        return sharesPersonalEntity;
    }

    @Override
    public Collection<SharesDTO> convertFromEntities(Collection<SharesPersonalEntity> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }

    @Override
    public Collection<SharesPersonalEntity> convertFromDtos(Collection<SharesDTO> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }
}
