package com.cardapio.domain.service;

import com.cardapio.domain.model.Food;
import com.cardapio.domain.repository.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Transactional
    public Food salvar(Food food) {
        return foodRepository.save(food);
    }
}
