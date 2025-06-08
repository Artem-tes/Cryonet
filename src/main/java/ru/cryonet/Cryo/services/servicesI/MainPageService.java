package ru.cryonet.Cryo.services.servicesI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.cryonet.Cryo.entityes.UserEntity;
import ru.cryonet.Cryo.entityes.dto.authdto.RegistrationDto;

@Service
public interface MainPageService {
    ResponseEntity<String> testResponse();
    ResponseEntity<String> registrationNewAccount(RegistrationDto registrationDto);
    ResponseEntity<UserEntity> checkInfo(Authentication authentication);

}
