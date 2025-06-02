package ru.cryonet.Cryo.controllers.maincontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.cryonet.Cryo.services.servicesI.MainPageService;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final MainPageService mainPageService;

    @GetMapping("/")
    private String mainPage(){
        return "main";
    }

    @GetMapping("/ping")
    @ResponseBody
    private ResponseEntity<String> testApp(){
        return mainPageService.testResponse();
    }


}
