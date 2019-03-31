package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.req.NewUtente;
import it.myti.academy.backend.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by david at 2019-03-20
 */

@RestController
public class UtenteController {

    private UtenteRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UtenteController(UtenteRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/utente/sign-up")
    public String signUp(@RequestBody NewUtente newUtente) {
        Utente utente = new Utente();
        utente.setNome(newUtente.getNome());
        utente.setUsername(newUtente.getUsername());
        utente.setPassword(bCryptPasswordEncoder.encode(newUtente.getPassword()));
        applicationUserRepository.save(utente);
        return "OK!";
    }
}
