package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.repository.UtenteRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utenti")
public class UtentiController {

    private UtenteRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UtentiController(UtenteRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody Utente user) {

        Utente utente = new Utente();
        utente.setNome(user.getNome());
        utente.setUsername(user.getUsername());
        utente.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);

        return "{\"status\": true}";
    }
}