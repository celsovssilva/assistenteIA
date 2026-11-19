package com.example.demo.infrastrucutre.persistence.entity;

import com.example.demo.domain.Category;
import com.example.demo.domain.Transaction;
import com.example.demo.domain.TransactionId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    @Id
    private UUID id;

    private String description;
    private long amount;
    private Category category;

    public TransactionEntity(UUID id, String descrption, Long amount, Category category) {
    }

    public static TransactionEntity from (Transaction transaction){
        return new TransactionEntity(
                transaction.getId().id(),
                transaction.getDescrption(),
                transaction.getAmount(),
                transaction.getCategory()
        );

    }

    public Transaction toDomain() {
        return new Transaction(
                new TransactionId(this.id),
                    this.description,
                this.amount,
                this.category
        );
    }
}
