package com.sistema.exames.spring.backend.service.implemetation;

import com.sistema.exames.spring.backend.model.Model_Usuario;
import com.sistema.exames.spring.backend.repository.Repository_Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class Implemetation_UserDetails implements UserDetailsService {

    private final Repository_Usuario repositoryUsuario;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Model_Usuario usuario = repositoryUsuario.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return usuario;
    }

}
