package com.example.demo.application.output;

import com.example.demo.domain.Transaction;

public record PersistTransactionOutput(String id, String description, String category, double value, Long amount) {
    public static PersistTransactionOutput from(Transaction transaction){
        return  new PersistTransactionOutput(transaction.getId().id().toString(), transaction.getDescrption(),
                transaction.getCategory().name(),transaction.getAmount(),transaction.getAmount());
    }
}
