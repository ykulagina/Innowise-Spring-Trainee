package com.innowise.spring_practice10.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder encoder) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(encoder.encode(password));
//        user.setFullName(fullName);
//        user.setStreet(street);
//        user.setCity(city);
//        user.setState(state);
//        user.setZip(zip);
//        user.setPhoneNumber(phone);
        return new User(username, encoder.encode(password), fullName, street, city, state, zip, phone);
    }
}
