package com.sistema.exames.spring.backend.repository;

import com.sistema.exames.spring.backend.model.Model_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository_Usuario extends JpaRepository<Model_Usuario, Long> {
    Model_Usuario findByUsername(String username);
}
