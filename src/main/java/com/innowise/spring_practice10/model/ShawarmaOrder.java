package com.innowise.spring_practice10.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShawarmaOrder {
    @NotBlank(message = "Delivery Name may not be blank.")
    private String deliveryName;
    @NotBlank(message = "Street may not be blank.")
    private String deliveryStreet;
    @NotBlank(message = "City may not be blank.")
    private String deliveryCity;
    @NotBlank(message = "State may not be blank.")
    private String deliveryState;
    @NotBlank(message = "Zip Code may not be blank.")
    private String deliveryZipCode;
    @CreditCardNumber(message = "Invalid Card Number.")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([2-9][0-9])$", message = "Must be formatted MM/YY.")
    private String ccExpiration;
//    @Digits(integer = 3, fraction = 0, message = "Only 3 digits are allowed.")
    @Pattern(regexp = "^\\d{3}$", message = "Must be 3 numbers only.")
    private String ccCVV;
    private List<Shawarma> shawarmas = new ArrayList<>();

    public void addShawarma(Shawarma shawarma) {
        this.shawarmas.add(shawarma);
    }
}
