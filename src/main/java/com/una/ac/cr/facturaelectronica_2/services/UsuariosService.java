package com.una.ac.cr.facturaelectronica_2.services;

import com.una.ac.cr.facturaelectronica_2.data.UsuariosRepository;
import com.una.ac.cr.facturaelectronica_2.logic.UsuariosEntity;
import com.una.ac.cr.facturaelectronica_2.statusHttp.STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuarios")
public class UsuariosService {
    @Autowired
    UsuariosRepository usuariosRepository;

    public UsuariosService() {

    }
    @PostMapping("/findUsuario")
    public UsuariosEntity findUsuarioByIdAndContrasena(@RequestParam String id, @RequestParam String contrasena) {

        try {
            return usuariosRepository.findByIdentificacionuAndContrasenia(id, contrasena);
        } catch (Exception e) {
            throw  new ResponseStatusException(STATUS.NOT_FOUND.getStatus() , "Usuario no encontrado");
        }
    }


}
