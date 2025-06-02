package ru.cryonet.Cryo.services.servicesI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MainPageService {
    ResponseEntity<String> testResponse();
}
