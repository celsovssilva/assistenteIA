package com.example.demo.application.input;

import com.example.demo.domain.Category;

public record PersistTransactionInput(
        String description, Long amount, Category category
) {
}
