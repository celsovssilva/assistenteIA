package com.example.demo.domain;


import lombok.Getter;

@Getter
public class Transaction {
    private TransactionId id;
    private String descrption;
    private Long amount;
    private Category category;


        public Transaction(String descrption, Long amount,Category category){
            this.id = new TransactionId();
            this.descrption = descrption;
            this.amount = amount;
            this.category =category;
        }
}



