package com.cardapio.domain.repository;

import com.cardapio.domain.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
