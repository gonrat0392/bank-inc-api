package com.boot.banco.daos;

import com.boot.banco.models.Cliente;

import java.util.List;

public interface ClienteDao {
    void agregarCliente(Cliente cliente);
    Cliente recuperarCliente(int idCliente);
    void eliminarCliente(int idCliente);
    List<Cliente> devolverClientes();
    Cliente devolverCliente();
    void actualizarCliente(Cliente cliente);
}
