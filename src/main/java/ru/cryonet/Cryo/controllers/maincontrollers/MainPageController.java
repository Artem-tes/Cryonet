package ru.cryonet.Cryo.controllers.maincontrollers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.cryonet.Cryo.entityes.dto.authdto.RegistrationDto;
import ru.cryonet.Cryo.repositories.UserRepository;
import ru.cryonet.Cryo.customfilters.JwtService;
import ru.cryonet.Cryo.entityes.UserEntity;
import ru.cryonet.Cryo.services.servicesI.MainPageService;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final MainPageService mainPageService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @GetMapping("/ping")
    @ResponseBody
    public ResponseEntity<String> testApp(){
        return mainPageService.testResponse();
    }


    @PostMapping("/login")
    public ResponseEntity<String> postLogin(@RequestBody HashMap<String, String> request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.get("username"), request.get("password"))
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtService.generateToken((UserDetails) authentication.getPrincipal());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/registr")
    public ResponseEntity<String> postReg(@Valid @RequestBody RegistrationDto registrationDto){
        return mainPageService.registrationNewAccount(registrationDto);
    }

    @GetMapping("/me")
    public ResponseEntity<UserEntity> checkInfo(Authentication authentication){
        return mainPageService.checkInfo(authentication);
    }


}
