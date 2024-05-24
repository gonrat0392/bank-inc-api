package com.boot.banco.services;

import com.boot.banco.models.Cliente;

import java.util.List;

public interface ClienteService {
    String agregarCliente(Cliente cliente);
    List<Cliente> recuperarClientes();
    void actualizarCliente(Cliente cliente);
    boolean eliminarCliente(int idCliente);
    Cliente buscarCliente(int idCliente);
}
