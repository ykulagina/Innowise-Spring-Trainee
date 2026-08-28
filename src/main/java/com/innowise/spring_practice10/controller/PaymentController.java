package com.innowise.spring_practice10.controller;

import com.innowise.spring_practice10.model.PaymentRequest;
import com.innowise.spring_practice10.model.StandardResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final String sharedKey = "SHARED_KEY";
    private static final String STATUS_SUCCESS = "success";
    private static final String STATUS_ERROR = "error";
    private static final Integer CODE_SUCCESS = 100;
    private static final Integer CODE_AUTH_FAILURE = 102;

    @GetMapping
    public StandardResponse showStatus() {
        return new StandardResponse(STATUS_SUCCESS, CODE_SUCCESS);
    }

    @PostMapping("/pay")
    public StandardResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
        final StandardResponse response;
        if (Objects.equals(sharedKey, key.toUpperCase())) {
            int userId = request.getUserId();
            String itemId = request.getItemId();
            double discount = request.getDiscount();
            System.out.printf("PaymentRequest is parsed. Id: %d, itemId: %s, discount: %.2f", userId, itemId, discount);
            response = new StandardResponse(STATUS_SUCCESS, CODE_SUCCESS);
        } else {
            response = new StandardResponse(STATUS_ERROR, CODE_AUTH_FAILURE);
        }
        return response;
    }
}
