package com.una.ac.cr.facturaelectronica_2.data;

import com.una.ac.cr.facturaelectronica_2.logic.UsuariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity, String> {
    UsuariosEntity findByIdentificacionuAndContrasenia(String identificacion, String contrasenia);

    Iterable<UsuariosEntity> findByTipoAndAprobado(String tipo, byte aprobado);

    UsuariosEntity findByIdentificacionu(String identificacion);

    @Transactional
    @Modifying
    @Query("UPDATE UsuariosEntity u SET u.nombreu = :nombre, u.contrasenia = :contrasenia, u.tipoPersona = :tipoPersona WHERE u.identificacionu = :identificacion")
    void updateUsuario(String identificacion, String nombre, String contrasenia, String tipoPersona);
}
