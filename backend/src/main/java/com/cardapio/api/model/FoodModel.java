package com.cardapio.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FoodModel {
    private Long id;
    private String title;
    private String image;
    private Integer price;
}

