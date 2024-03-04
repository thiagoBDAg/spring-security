package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.boot.security.UserDetails;
import org.springframework.boot.security.UserDetailsService;
import org.springframework.boot.security.UsernameNotFoundException;

import application.model.User;
import application.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário Não Encontrado.");
        }
        UserDetails userDetails = 
            org.springframework.security.core.userdetails.User.builder()
    }
}
