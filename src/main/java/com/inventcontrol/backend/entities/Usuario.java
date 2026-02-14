package com.inventcontrol.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private String nombreCompleto;
    private String rol;
    private Boolean activo;
}
