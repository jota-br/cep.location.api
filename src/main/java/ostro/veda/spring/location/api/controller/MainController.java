package ostro.veda.spring.location.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ostro.veda.spring.location.api.dto.UserRegisterDto;
import ostro.veda.spring.location.api.service.CepService;
import ostro.veda.spring.location.api.service.UserService;

@RestController
public class MainController {

    @Autowired
    CepService cepService;
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.register(userRegisterDto).toString();
    }

    @PostMapping("/places/{cep}")
    public String addPlace(@PathVariable("cep") String cep) {
        return userService.addPlace(cep).toString();
    }

    @GetMapping("/places")
    public String getPlace() {
        return userService.getPlace().toString();
    }
}
