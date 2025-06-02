package ru.cryonet.Cryo.services.servicesIMPL;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.cryonet.Cryo.services.servicesI.MainPageService;

import java.util.Date;

@Service
public class MainPageServiceIMPL implements MainPageService {

    @Override
    public ResponseEntity<String> testResponse() {
        return ResponseEntity.ok(String.valueOf(new Date().getTime()));

    }


}
