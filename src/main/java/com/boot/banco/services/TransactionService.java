package com.boot.banco.services;

import com.boot.banco.models.Transaction;

public interface TransactionService {
    void processPurchase(Transaction transaction);

    Transaction getTransactionById(String transactionId);

    boolean cancelTransaction(Transaction transaction);
}
