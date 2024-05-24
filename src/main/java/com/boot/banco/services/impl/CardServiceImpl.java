package com.boot.banco.services.impl;

import com.boot.banco.services.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private static final Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);
    @Override
    public String generateCardNumber(String productId) {
        // Implementación para generar el número de tarjeta basado en el producto ID
        logger.info("SERVICE GENERAR NUMERO TARJETA: ", productId);
        return "1234567890123456"; // Ejemplo de número de tarjeta generado
    }

    @Override
    public void enrollCard(String card) {
        // Implementación para inscribir una tarjeta en el sistema
        logger.info("ESTE ES EL SERVICIO PARA ACTIVAR TARJETA: ", card);
    }

    @Override
    public void blockCard(String cardId) {
        // Implementación para bloquear una tarjeta
        logger.info("ESTE ES EL SERVICIO PARA BLOQUEAR TARJETA: ", cardId);
    }

    @Override
    public void rechargeBalance(String cardId, double balance) {
        // Implementación para recargar el saldo de una tarjeta
        logger.info("ESTE ES EL SERVICIO PARA RECARGAR SALDO: ", cardId);
    }

    @Override
    public double checkBalance(String cardId) {
        // Implementación para verificar el saldo de una tarjeta
        logger.info("ESTE ES EL SERVICIO PARA CONSULTAR SALDO: ", cardId);
        return 5000.00; // Ejemplo de saldo
    }
}
