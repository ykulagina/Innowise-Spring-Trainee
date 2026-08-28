package com.innowise.spring_practice10.model;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("F", new Ingredient("F", "Wheat Wrap", Ingredient.Type.WRAP));
        ingredientMap.put("C", new Ingredient("C", "Corn Wrap", Ingredient.Type.WRAP));
        ingredientMap.put("H", new Ingredient("H", "Beef", Ingredient.Type.PROTEIN));
        ingredientMap.put("B", new Ingredient("B", "Chicken", Ingredient.Type.PROTEIN));
        ingredientMap.put("T", new Ingredient("T", "Tomatoes", Ingredient.Type.VEGGIES));
        ingredientMap.put("L", new Ingredient("L", "Salad", Ingredient.Type.VEGGIES));
        ingredientMap.put("SC", new Ingredient("SC", "Parmesan", Ingredient.Type.CHEESE));
        ingredientMap.put("M", new Ingredient("M", "Mayonnaise", Ingredient.Type.SAUCE));
        ingredientMap.put("A", new Ingredient("A", "Ketchup", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
