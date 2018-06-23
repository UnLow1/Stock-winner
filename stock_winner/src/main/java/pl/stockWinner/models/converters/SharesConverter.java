package pl.stockWinner.models.converters;

import org.springframework.stereotype.Component;
import pl.stockWinner.models.dto.SharesDTO;
import pl.stockWinner.models.entity.SharesEntity;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class SharesConverter implements BaseConverter<SharesEntity, SharesDTO> {

    @Override
    public SharesDTO convertFromEntity(SharesEntity entity) {
        return new SharesDTO()
                .setTicker(entity.getTicker())
                .setVolume(entity.getVolume())
                .setPrice(entity.getVolume())
                .setDate(entity.getDate());
    }

    @Override
    public SharesEntity convertFromDto(SharesDTO dto) {
        return new SharesEntity()
                .setTicker(dto.getTicker())
                .setVolume(dto.getVolume())
                .setPrice(dto.getPrice())
                .setDate(dto.getDate());
    }

    @Override
    public Collection<SharesDTO> convertFromEntities(Collection<SharesEntity> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }

    @Override
    public Collection<SharesEntity> convertFromDtos(Collection<SharesDTO> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }
}
