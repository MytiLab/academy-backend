package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.UtenteRichiesta;
import it.myti.academy.backend.model.errori.eccezioni.RegistrazioneException;
import it.myti.academy.backend.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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

    @PostMapping("/registrazione")
    public Utente registrazione(@RequestBody UtenteRichiesta utenteRichiesta) throws RegistrazioneException {
        Utente utente = new Utente();
        utente.setNome(utenteRichiesta.getNome());
        utente.setUsername(utenteRichiesta.getUsername());
        utente.setPassword(bCryptPasswordEncoder.encode(utenteRichiesta.getPassword()));
        try {
            applicationUserRepository.save(utente);
        }catch(Exception e){
            throw new RegistrazioneException();
        }

        return utente;
    }
}
