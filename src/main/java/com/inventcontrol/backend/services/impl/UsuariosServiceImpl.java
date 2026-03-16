package com.inventcontrol.backend.services.impl;


import com.inventcontrol.backend.dtos.usuarios.requests.LoginRequestDTO;
import com.inventcontrol.backend.dtos.usuarios.requests.UsuarioNewDTO;
import com.inventcontrol.backend.dtos.usuarios.responses.LoginResponseDTO;
import com.inventcontrol.backend.dtos.usuarios.responses.UsuarioDTO;
import com.inventcontrol.backend.entities.Usuarios;
import com.inventcontrol.backend.mapper.UsuarioMapper;
import com.inventcontrol.backend.repositories.UsuariosRepository;
import com.inventcontrol.backend.services.IUsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuariosServiceImpl implements IUsuariosService {

    private final UsuariosRepository repository;
    private final UsuarioMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UsuarioDTO save(UsuarioNewDTO dto) {
        Usuarios usuario = new Usuarios();
        usuario.setUsername(dto.username());
        usuario.setEmail(dto.email());
        usuario.setNombreCompleto(dto.nombreCompleto());
        usuario.setRol(dto.rol());
        usuario.setActivo(true);
        usuario.setPasswordHash(dto.password());

        return mapper.toDto(repository.save(usuario));
    }

    @Override
    @Transactional
    public void changePassword(Long id, String newPassword) {
        Usuarios usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setPasswordHash(newPassword);
        repository.save(usuario);
    }

    @Override
    @Transactional
    public void toggleStatus(Long id) {
        Usuarios usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setActivo(!usuario.getActivo()); // Invierte el estado
        repository.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Usuarios usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setActivo(false); // Borrado lógico
        repository.save(usuario);
    }
    @Override
    @Transactional(readOnly = true)
    public LoginResponseDTO login(LoginRequestDTO dto) {
        // 1. Buscamos el usuario
        Usuarios usuario = repository.findByUsername(dto.username())
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));

        // 2. Verificamos si está activo
        if (!usuario.getActivo()) {
            throw new RuntimeException("El usuario está inactivo. Contacte al administrador.");
        }

        // 3. Verificamos la contraseña (Por ahora directo, después con BCrypt)
        if (!usuario.getPasswordHash().equals(dto.password())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        // 4. Retornamos los datos para la sesión de Angular
        return new LoginResponseDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getNombreCompleto(),
                usuario.getRol()
        );
    }
}