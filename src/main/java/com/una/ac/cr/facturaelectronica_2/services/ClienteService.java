package com.una.ac.cr.facturaelectronica_2.services;

import com.una.ac.cr.facturaelectronica_2.data.ClientesRepository;
import com.una.ac.cr.facturaelectronica_2.logic.ClientesEntity;
import com.una.ac.cr.facturaelectronica_2.statusHttp.STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/clientes")
public class ClienteService {
    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping
    public Iterable<ClientesEntity> getClientes() {
        return clientesRepository.findAll();
    }
    @GetMapping("{cedula}")
    public ClientesEntity getClientesByCedula(int cedula) {
        try {
            return clientesRepository.findClientesByIdcliente(cedula);
        } catch (Exception e) {
            throw  new ResponseStatusException(STATUS.NOT_FOUND.getStatus() , "Cliente no encontrado");
        }
    }
    @GetMapping("/findClientesByProveedor")
    public Iterable<ClientesEntity> findClientesByProveedor(@RequestParam String id) {
        try {
            return clientesRepository.findClientesByProveedorc(id);
        } catch (Exception e) {
            throw  new ResponseStatusException(STATUS.NOT_FOUND.getStatus() , "Clientes no encontrados");
        }
    }

}
