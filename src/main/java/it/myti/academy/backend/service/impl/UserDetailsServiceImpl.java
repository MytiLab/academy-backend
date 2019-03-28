package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.repository.UtenteRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

/**
 * Created by david at 2019-03-20
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UtenteRepository applicationUserRepository;

    public UserDetailsServiceImpl(UtenteRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
