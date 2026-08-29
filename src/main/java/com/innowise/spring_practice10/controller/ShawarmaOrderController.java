package com.innowise.spring_practice10.controller;

import com.innowise.spring_practice10.model.ShawarmaOrder;
import com.innowise.spring_practice10.repository.ShawarmaOrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("shawarmaOrder")
public class ShawarmaOrderController {
    private ShawarmaOrderRepository shawarmaOrderRepository;

    public ShawarmaOrderController(ShawarmaOrderRepository shawarmaOrderRepository) {
        this.shawarmaOrderRepository = shawarmaOrderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid ShawarmaOrder shawarmaOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        this.shawarmaOrderRepository.save(shawarmaOrder);
        log.info("Shawarma order submitted: {}", shawarmaOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
