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

    @PostMapping("/login")
    public String getAddress(@RequestBody Login login) {
        return userService.login(login);
    }

    @PostMapping("/register")
    public String getAddress(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/places")
    public String getAddress() {
        return placeService.add(user);
    }

    @GetMapping("/places")
    public String getAddress() {
        return placeService.getPlace(user);
    }

    @GetMapping("/{cep}")
    public String getAddress(@PathVariable("cep") String cep) {
        return cepService.getAddress(cep);
    }
}
