package com.boot.banco.services;

public interface CardService {
    String generateCardNumber(String productId);

    void enrollCard(String card);

    void blockCard(String cardId);

    void rechargeBalance(String cardId, double balance);

    double checkBalance(String cardId);
}
