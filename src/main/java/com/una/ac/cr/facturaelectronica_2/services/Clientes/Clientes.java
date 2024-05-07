package com.una.ac.cr.facturaelectronica_2.services.Clientes;

import com.una.ac.cr.facturaelectronica_2.data.ClientesRepository;
import com.una.ac.cr.facturaelectronica_2.logic.ClientesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class Clientes {
    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping
    public Iterable<ClientesEntity> getClientes() {
        return clientesRepository.findAll();
    }
    @GetMapping("{cedula}")
    public ClientesEntity getClientesByCedula(int cedula) {
        return clientesRepository.findClientesByIdcliente(cedula);
    }

}
