package com.boot.banco.services;

import com.boot.banco.daos.ClienteDao;
import com.boot.banco.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    ClienteDao dao;


    @Override
    public String agregarCliente(Cliente cliente) {
        try {
            logger.info("ESTA ES LA IMPLEMENTACIÓN DEL SERVICIO !!");
            if (cliente.getIdCliente() == 0){
                logger.info("EL NÚMERO DE DOCUMENTO ES NULO !!");
                return "El numero de documento es nulo";
            }

            if(dao.recuperarCliente(cliente.getIdCliente()) == null){
                logger.info("ESTE ES EL CLIENTE QUE SE ENVIO A GUARDAR: {}", cliente);
                dao.agregarCliente(cliente);
                logger.info("EL CLIENTE FUE AGREGADO CORRECTAMENTE");
                return "El cliente se aguardo correctamente con el id: " + cliente.getIdCliente();
            }
            logger.warn("NO SE PUEDE AGREGAR EL CLIENTE, LOS DATOS INGRESADOS YA SE ENCUENTRAN EN LA BASE DE DATOS");
            return "No se puede agregar el cliente, el número de documento ya se encuentras en la BD";
        } catch (Exception e){
            return "El nombre o el correo ya se encuentra guardado en la BD";
        }
    }

    @Override
    public List<Cliente> recuperarClientes() {
        return dao.devolverClientes();
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        logger.info("ESTA ES LA IMPLEMENTACIÓN DEL SERVICIO !!");
        logger.debug("ESTE ES EL CLIENTE QUE SE ENVIO A ACTUALIZAR: ", cliente);
        if(dao.recuperarCliente(cliente.getIdCliente()) != null){
            dao.actualizarCliente(cliente);
            logger.info("EL CLIENTE FUE ACTUALIZADO CORRECTAMENTE");
        }
        logger.warn("NO SE PUDO ACTUALIZAR EL CLIENTE, VERFIQUE LA INFORMACION INGRESADA");
    }

    @Override
    public boolean eliminarCliente(int idCliente) {
        logger.info("ESTA ES LA IMPLEMENTACIÓN DEL SERVICIO !!");
        logger.debug("ESTE ES EL IDCLIENTE QUE SE ENVIO A ELIMINAR: ", idCliente);
        if(dao.recuperarCliente(idCliente) != null){
            dao.eliminarCliente(idCliente);
            logger.info("EL CLIENTE SE ELIMINÓ CORRECTAMENTE");
            return true;
        }
        logger.warn("NO SE PUDO ELIMINAR EL CLIENTE, VERFIQUE LA INFORMACION INGRESADA");
        return false;
    }

    @Override
    public Cliente buscarCliente(int idCliente) {
        logger.info("ESTA ES LA IMPLEMENTACIÓN DEL SERVICIO !!");
        logger.debug("ESTE ES EL IDCLIENTE QUE SE ENVIO A BUSCAR: ", idCliente);
        return dao.recuperarCliente(idCliente);
    }
}
