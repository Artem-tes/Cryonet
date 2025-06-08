package ru.cryonet.Cryo.services.servicesIMPL;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cryonet.Cryo.entityes.UserEntity;
import ru.cryonet.Cryo.entityes.dto.authdto.RegistrationDto;
import ru.cryonet.Cryo.repositories.UserRepository;
import ru.cryonet.Cryo.services.servicesI.MainPageService;

import java.nio.IntBuffer;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MainPageServiceIMPL implements MainPageService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> testResponse() {
        return ResponseEntity.ok(String.valueOf(new Date().getTime()));

    }

    @Override
    public ResponseEntity<String> registrationNewAccount(RegistrationDto registrationDto) {
        String status = "";
        UserEntity user = userRepository.findByUsername(registrationDto.getUsername());
        if (user == null) {
            try {
                String byCryptPassword = passwordEncoder.encode(registrationDto.getPassword());
                userRepository.save(new UserEntity(null, registrationDto.getUsername(), byCryptPassword, "user"));
                status = "success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            status = "error";
        }

        return ResponseEntity.ok(status);
    }

    @Override
    public ResponseEntity<UserEntity> checkInfo(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        UserEntity user = getUserEntityByUsername(username);
        return ResponseEntity.ok(user);
    }

    private UserEntity getUserEntityByUsername(String username){
        return userRepository.findByUsername(username);
    }


}
