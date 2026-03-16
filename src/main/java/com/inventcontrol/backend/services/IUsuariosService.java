package com.inventcontrol.backend.services;

import com.inventcontrol.backend.dtos.usuarios.requests.LoginRequestDTO;
import com.inventcontrol.backend.dtos.usuarios.requests.UsuarioNewDTO;
import com.inventcontrol.backend.dtos.usuarios.responses.LoginResponseDTO;
import com.inventcontrol.backend.dtos.usuarios.responses.UsuarioDTO;

import java.util.List;

public interface IUsuariosService {
    List<UsuarioDTO> findAll();
    UsuarioDTO save(UsuarioNewDTO dto);
    void changePassword(Long id, String newPassword);
    void toggleStatus(Long id);
    void delete(Long id);
    LoginResponseDTO login(LoginRequestDTO dto);
}
