package pl.stockWinner.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.stockWinner.models.converters.UserConverter;
import pl.stockWinner.models.dto.AuthenticationDto;
import pl.stockWinner.models.dto.AuthenticationResponseDto;
import pl.stockWinner.models.dto.ErrorInfoDto;
import pl.stockWinner.models.dto.UserDto;
import pl.stockWinner.models.entity.UserEntity;
import pl.stockWinner.repositories.UserDataRepository;
import pl.stockWinner.utils.TokenUtils;

import javax.naming.AuthenticationException;
import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController()
@RequestMapping(path = "${jwt.route.authentication}")
public class AuthenticationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private UserConverter userConverter;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationDto authenticationDto) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDto.getMail(),
                        authenticationDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenUtils.generateToken(authenticationDto.getMail());

        return ResponseEntity.ok(new AuthenticationResponseDto(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Valid @RequestBody UserDto userDto) throws URISyntaxException {
        UserEntity userEntity = userConverter.convertFromDto(userDto);
        userDataRepository.save(userEntity);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> noSuchElementException(ConstraintViolationException ex) {
        return new ResponseEntity<>(new ErrorInfoDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
