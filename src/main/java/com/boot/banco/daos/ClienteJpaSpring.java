package com.boot.banco.daos;

import com.boot.banco.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteJpaSpring extends JpaRepository<Cliente, Integer> {
    Cliente findById(int idCliente);
    @Transactional
    @Modifying
    @Query("Delete from Cliente c Where c.idCliente=?1")
    void eliminarPorId(int idCliente);
}
