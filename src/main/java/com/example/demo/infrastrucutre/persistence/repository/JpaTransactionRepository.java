package com.example.demo.infrastrucutre.persistence.repository;

import com.example.demo.domain.Category;
import com.example.demo.domain.Transaction;
import com.example.demo.domain.TransactionRepository;
import com.example.demo.infrastrucutre.persistence.entity.TransactionEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JpaTransactionRepository implements TransactionRepository {
    private final TransactionEntityRepository transactionEntityRepository;

    public JpaTransactionRepository(TransactionEntityRepository transactionEntityRepository) {
        this.transactionEntityRepository = transactionEntityRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        var entity = TransactionEntity.from(transaction);
        return  transactionEntityRepository.save(entity).toDomain();
    }

    @Override
    public List<Transaction> findAllByCategory(Category category) {

       return  transactionEntityRepository.findAllByCategory(category)
               .stream().map(TransactionEntity::toDomain).toList();
    }
}
