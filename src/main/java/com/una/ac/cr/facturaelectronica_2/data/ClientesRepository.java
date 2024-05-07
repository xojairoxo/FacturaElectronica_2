package com.una.ac.cr.facturaelectronica_2.data;

import com.una.ac.cr.facturaelectronica_2.logic.ClientesEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends CrudRepository<ClientesEntity, String>{
    Iterable<ClientesEntity> findClientesByProveedorc(String identificacionPro);

    ClientesEntity findClientesByIdcliente(int id);

    @Transactional
    @Modifying
    @Query("UPDATE ClientesEntity c SET c.nombrec = :nombrec, c.correo = :correo, c.telefono = :telefono WHERE c.identificacionc = :identificacionc AND c.proveedorc = :proveedorc")
    void updateClientes(String identificacionc, String proveedorc, String nombrec, String correo, int telefono);
    Iterable<ClientesEntity> findClientesByIdentificacioncAndProveedorc(String identificacionCli,String identificacionPro);
}