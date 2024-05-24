package com.boot.banco.daos;

import com.boot.banco.models.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class ClienteDaoImpl implements ClienteDao {

    private static final Logger logger = LoggerFactory.getLogger(ClienteDaoImpl.class);

    @Autowired
    ClienteJpaSpring clienteJpa;

    @Override
    public void agregarCliente(Cliente cliente) {
        logger.info("ESTA ES LA IMPLEMENTACIÓN DEL DAO !!");
        logger.debug("ESTE ES EL CLIENTE QUE SE ENVIO A GUARDAR: ", cliente);
        clienteJpa.save(cliente);
    }

    @Override
    public Cliente recuperarCliente(int idCliente) {
        logger.info("ESTA ES LA IMPLEMENTACIÓN DEL DAO !!");
        logger.debug("ESTE ES EL IDCLIENTE QUE SE ENVIO A BUSCAR: ", idCliente);
        return clienteJpa.findById(idCliente);
    }

    @Override
    public void eliminarCliente(int idCliente) {
        logger.info("ESTA ES LA IMPLEMENTACIÓN DEL DAO !!");
        logger.debug("ESTE ES EL IDCLIENTE QUE SE ENVIO A ELIMINAR: ", idCliente);
        clienteJpa.eliminarPorId(idCliente);
    }

    @Override
    public List<Cliente> devolverClientes() {
        return clienteJpa.findAll();
    }

    @Override
    public Cliente devolverCliente() {
        return null;
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        logger.info("ESTA ES LA IMPLEMENTACIÓN DEL DAO !!");
        logger.debug("ESTE ES EL CLIENTE QUE SE ENVIO A ACTUALIZAR: ", cliente);
        clienteJpa.save(cliente);
    }
}
