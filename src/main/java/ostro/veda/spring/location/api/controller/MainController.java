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

    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto) {
//        return userService.register(userDto);
        return null;
    }

    @PostMapping("/places")
    public String addPlace(@RequestBody PlaceDto placeDto) {
        return userService.addPlace(placeDto).toString();
    }

    @GetMapping("/places")
    public String getPlace() {
        return userService.getPlace().toString();
    }

    @GetMapping("/cep/{cep}")
    public String getAddress(@PathVariable("cep") String cep) {
        return cepService.getAddress(cep);
    }
}
