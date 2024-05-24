package com.boot.banco.controllers;

import com.boot.banco.services.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Card", description = "Operaciones relacionadas con tarjetas")
public class CardController {

    private static final Logger logger = LoggerFactory.getLogger(CardController.class);

    @Autowired
    CardService service;

    //GET
    @GetMapping(value = "card/{productId}/number")
    @ApiOperation(value = "Generar número de tarjeta", response = List.class)
    public void generate(@PathVariable("productId") String productId){
        logger.info("SE EJECUTO EL CONTROLADOR PARA GENERAR NUMERO DE TARJETA", productId);
        service.generateCardNumber(productId);
    }

    @GetMapping(value = "/card/balance/{cardId}")
    @ApiOperation(value = "Consulta de saldo", response = List.class)
    public void consult(@PathVariable("cardId") String cardId){
        logger.info("SE EJECUTO EL CONTROLADOR PARA CONSULTAR SALDO", cardId);
        service.checkBalance(cardId);
    }

    //POST
    @PostMapping(value = "/card/enroll", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Activar tarjeta", response = List.class)
    public String activate(@RequestBody String cardId){
        logger.info("SE EJECUTO EL CONTROLADOR PARA ACTIVAR TARJETA", cardId);
        service.enrollCard(cardId);
        return "";
    }

    @PostMapping(value = "/card/balance", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Recargar tarjeta", response = List.class)
    public String recharge(@RequestBody String card){
        logger.info("SE EJECUTO EL CONTROLADOR PARA RECARGAR SALDO", card);
        service.rechargeBalance(card, 2.2);
        return "";
    }

    //DELETE
    @DeleteMapping(value = "/card/{cardId}")
    @ApiOperation(value = "Bloquear tarjeta", response = List.class)
    public void block(@PathVariable("cardId") String idCard){
        logger.info("SE EJECUTO EL CONTROLADOR PARA BLOQUEAR TARJETA", idCard);
        service.blockCard(idCard);
    }
}
