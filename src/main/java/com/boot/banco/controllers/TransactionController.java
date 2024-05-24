package com.boot.banco.controllers;

import com.boot.banco.models.Transaction;
import com.boot.banco.services.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Transaction", description = "Operaciones relacionadas con transacciones")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    TransactionService service;

    //GET
    @GetMapping(value = "/transaction/{transactionId}")
    @ApiOperation(value = "Consultar transacción", response = List.class)
    public void consult(@PathVariable("transactionId") String transactionId){
        logger.info("SE EJECUTO EL CONTROLADOR PARA CONSULTAR TRANSACCION", transactionId);
        service.getTransactionById(transactionId);
    }

    //POST
    @PostMapping(value = "/transaction/purchase", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Transacción de compra", response = List.class)
    public String buys(@RequestBody Transaction transaction){
        logger.info("SE EJECUTO EL CONTROLADOR PARA TRANSACCION DE COMPRA", transaction);
        service.processPurchase(transaction);
        return "";
    }

    @PostMapping(value = "/transaction/anulation", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Anulación de transacciones", response = List.class)
    public String cancel(@RequestBody Transaction transaction){
        logger.info("SE EJECUTO EL CONTROLADOR PARA ANULAR LA TRANSACCION", transaction);
        return String.valueOf(service.cancelTransaction(transaction));
    }

}
