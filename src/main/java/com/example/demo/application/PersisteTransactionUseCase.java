package com.example.demo.application;

import com.example.demo.application.input.PersistTransactionInput;
import com.example.demo.domain.Transaction;
import com.example.demo.domain.TransactionRepository;

public class PersisteTransactionUseCase {
    private  final TransactionRepository transactionRepository;

    public PersisteTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

        public Transaction   execute(PersistTransactionInput input){
            var transaction = new Transaction(input.description(), input.amount(),input.category());
             return transactionRepository.save(transaction);
        }
}
