package com.sistema.exames.spring.backend.configuration.filter;

import com.sistema.exames.spring.backend.service.implemetation.Implemetation_UserDetails;
import com.sistema.exames.spring.backend.util.Util_Jwt;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
@Component
public class Filter_JwtAuthentication extends OncePerRequestFilter {

    private final Implemetation_UserDetails implemetationUserDetails;
    private final Util_Jwt utilJwt;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);

            try {
                username = this.utilJwt.extractUsername(jwtToken);
            } catch (ExpiredJwtException expiredJwtException) {
                System.out.println("El token ha expirado");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            System.out.println("Token invalido, no empiza con bearer string");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.implemetationUserDetails.loadUserByUsername(username);

            if (this.utilJwt.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } else {
                System.out.println("Token no es valido");
            }
            filterChain.doFilter(request, response);
        }
    }
}
