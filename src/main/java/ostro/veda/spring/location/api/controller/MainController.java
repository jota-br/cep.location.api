package ostro.veda.spring.location.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ostro.veda.spring.location.api.dto.PlaceDto;
import ostro.veda.spring.location.api.dto.UserDto;
import ostro.veda.spring.location.api.service.CepService;
import ostro.veda.spring.location.api.service.UserService;

@RestController
public class MainController {

    @Autowired
    CepService cepService;
    @Autowired
    UserService userService;
    @Autowired
    PlaceService placeService;

    @PostMapping("/register")
    public String register(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.register(userRegisterDto);
    }

    @PostMapping("/places/{cep}")
    public String addPlace(@PathVariable("cep") String cep) {
        return placeService.addPlace(cep).toString();
    }

    @GetMapping("/places")
    public String getPlace() {
        return placeService.getPlace().toString();
    }
}
