package com.innowise.spring_practice10.controller;

import com.innowise.spring_practice10.model.Ingredient;
import com.innowise.spring_practice10.model.Ingredient.Type;
import com.innowise.spring_practice10.model.Shawarma;
import com.innowise.spring_practice10.model.ShawarmaOrder;
import com.innowise.spring_practice10.repository.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("shawarmaOrder")
public class ShawarmaDesignController {
    private IngredientRepository ingredientRepository;

    @Autowired
    public ShawarmaDesignController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
//        List<Ingredient> ingredients = Arrays.asList(
//                new Ingredient("F", "Wheat Wrap", Type.WRAP),
//                new Ingredient("C", "Corn Wrap", Type.WRAP),
//                new Ingredient("H", "Beef", Type.PROTEIN),
//                new Ingredient("B", "Chicken", Type.PROTEIN),
//                new Ingredient("T", "Tomatoes", Type.VEGGIES),
//                new Ingredient("L", "Salad", Type.VEGGIES),
//                new Ingredient("SC", "Parmesan", Type.CHEESE),
//                new Ingredient("PC", "Goat Cheese", Type.CHEESE),
//                new Ingredient("M", "Mayonnaise", Type.SAUCE),
//                new Ingredient("A", "Ketchup", Type.SAUCE));
        List<Ingredient> ingredients = new ArrayList<>();
        this.ingredientRepository.findAll().forEach(ingredients::add);
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "shawarmaOrder")
    public ShawarmaOrder order() {
        return new ShawarmaOrder();
    }

    @ModelAttribute(name = "shawarma")
    public Shawarma shawarma() {
        return new Shawarma();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processShawarma(@Valid Shawarma shawarma, Errors errors, ShawarmaOrder shawarmaOrder) {
        if (errors.hasErrors()) {
            return "design";
        }
        shawarmaOrder.addShawarma(shawarma);
        log.info("Processing shawarma: {}", shawarma);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(i -> i.getType().equals(type)).toList();
    }
}
