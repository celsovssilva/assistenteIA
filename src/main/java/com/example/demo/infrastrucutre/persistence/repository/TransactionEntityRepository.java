package com.example.demo.infrastrucutre.persistence.repository;

import com.example.demo.domain.Category;
import com.example.demo.infrastrucutre.persistence.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionEntityRepository extends CrudRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findAllByCategory(Category category);

}
