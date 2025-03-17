package ostro.veda.spring.location.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ostro.veda.spring.location.api.service.CepService;

@RestController
public class MainController {

    @Autowired
    CepService cepService;

    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }

    @PostMapping("/places")
    public String addPlace(@RequestBody PlaceDto placeDto) {
        return userService.addPlace(placeDto);
    }

    @GetMapping("/places")
    public String getPlace() {
        return userService.getPlace();
    }

    @GetMapping("/cep/{cep}")
    public String getAddress(@PathVariable("cep") String cep) {
        return cepService.getAddress(cep);
    }
}
