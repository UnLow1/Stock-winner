package pl.stockWinner.controllers;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.stockWinner.models.converters.SharesConverter;
import pl.stockWinner.models.converters.SharesPersonalConverter;
import pl.stockWinner.models.dto.SharesDTO;
import pl.stockWinner.models.entity.SharesEntity;
import pl.stockWinner.models.entity.SharesPersonalEntity;
import pl.stockWinner.models.entity.UserEntity;
import pl.stockWinner.repositories.SharesPersonalRepository;
import pl.stockWinner.repositories.SharesRepository;
import pl.stockWinner.repositories.UserDataRepository;
import pl.stockWinner.services.SharesPersonalService;

@RestController
@RequestMapping(path = "/api/shares")
@Transactional
public class SharesController {

    @Autowired
    private SharesRepository sharesRepository;

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private SharesPersonalRepository sharesPersonalRepository;

    @Autowired
    private SharesConverter sharesConverter;

    @Autowired
    private SharesPersonalConverter sharesPersonalConverter;

    @Autowired
    private SharesPersonalService sharesPersonalService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> addShares(@RequestBody SharesDTO sharesDTO) {
        SharesEntity sharesEntity = sharesConverter.convertFromDto(sharesDTO);
        sharesRepository.save(sharesEntity);

        UserEntity userEntity = getUserEntity();

        SharesPersonalEntity sharesPersonalEntity = sharesPersonalService.create(sharesDTO, sharesEntity, userEntity);

        sharesPersonalRepository.save(sharesPersonalEntity);
        return ResponseEntity
                .ok(sharesPersonalConverter.convertFromEntity(sharesPersonalEntity));
    }

    @GetMapping
    @Transactional
    public ResponseEntity<?> getShares() {
//        return ResponseEntity.ok(articleInfoConverter
//                .convertFromEntities(Lists.newArrayList(
//                        articlePersonalInfoRepository.findAllByUserEntity(getUserEntity())
//                )));

        return ResponseEntity.ok(sharesPersonalConverter.convertFromEntities(
                Lists.newArrayList(sharesPersonalRepository.findAllByUserEntity(getUserEntity()))
        ));
    }


    public UserEntity getUserEntity() {
        String userMail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDataRepository.findFirstByUserMail(userMail);
    }
}
