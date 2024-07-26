package com.cardapio.api.controller;

import com.cardapio.api.model.FoodModel;
import com.cardapio.domain.model.Food;
import com.cardapio.domain.repository.FoodRepository;
import com.cardapio.domain.service.FoodService;
import com.cardapio.food.FoodRequestDTO;
import com.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @Autowired
    private FoodService foodService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public Food saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        foodService.salvar(foodData);
        return foodData;
    }

//    @PutMapping("/{foodId}")
//    public Food upFood(@RequestBody FoodRequestDTO data, Long foodId) {
//
//    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @DeleteMapping("/{foodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String remover(@PathVariable Long foodId) {
        repository.deleteById(foodId);
        repository.flush();

        return "Food with id " + foodId +" has been removed!";
    }
}
