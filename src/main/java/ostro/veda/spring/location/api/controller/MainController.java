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

    @GetMapping("/{cep}")
    public String getAddress(@PathVariable("cep") String cep) {
        return cepService.getAddress(cep);
    }
}
