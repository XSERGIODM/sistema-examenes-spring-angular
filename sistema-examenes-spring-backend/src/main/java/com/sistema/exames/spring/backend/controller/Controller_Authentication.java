package com.sistema.exames.spring.backend.controller;

import com.sistema.exames.spring.backend.model.Model_JwtRequest;
import com.sistema.exames.spring.backend.model.Model_JwtResponse;
import com.sistema.exames.spring.backend.service.implemetation.Implemetation_UserDetails;
import com.sistema.exames.spring.backend.util.Util_Jwt;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController

public class Controller_Authentication {

    private final AuthenticationManager authenticationManager;
    private final Implemetation_UserDetails implemetationUserDetails;
    private final Util_Jwt utilJwt;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody Model_JwtRequest jwtRequestBody) throws Exception {
        try {
            autenticar(jwtRequestBody.getUsername(),jwtRequestBody.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }
        UserDetails userDetails = this.implemetationUserDetails.loadUserByUsername(jwtRequestBody.getUsername());
        String token = this.utilJwt.generateToken(userDetails);
        return ResponseEntity.ok(new Model_JwtResponse(token));
    }

    private void autenticar(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException disabledException){
            throw  new Exception("USUARIO DESHABILITADO" + disabledException.getMessage());
        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("Credenciales invalidas " + badCredentialsException.getMessage());

        }
    }

}
