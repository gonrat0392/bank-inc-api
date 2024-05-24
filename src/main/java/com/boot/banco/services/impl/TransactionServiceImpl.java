package com.boot.banco.services.impl;

import com.boot.banco.models.Transaction;
import com.boot.banco.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Override
    public void processPurchase(Transaction transaction) {
        // Implementación para procesar una transacción de compra
        logger.info("SERVICE TRANSACCION DE COMPRA", transaction);
    }

    @Override
    public Transaction getTransactionById(String transactionId) {
        // Implementación para obtener los detalles de una transacción por su ID
        logger.info("SERVICE CONSULTAR TRANSACCION: ", transactionId);
        return null; // Ejemplo de retorno nulo
    }

    @Override
    public boolean cancelTransaction(Transaction transaction) {
        // Implementación para cancelar una transacción
        logger.info("SERVICE ANULAR TRANSACCION: ", transaction);
        return false; // Ejemplo de retorno falso
    }
}
