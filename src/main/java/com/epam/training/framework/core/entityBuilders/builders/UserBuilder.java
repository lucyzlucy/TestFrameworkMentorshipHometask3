package com.epam.training.framework.core.entityBuilders.builders;

import com.epam.training.framework.core.entityBuilders.entities.User;

public class UserBuilder {
    private User user = new User();
    public User make() {
        return user;
    }
    
    public UserBuilder setName(String name) {
        user.setName(name);
        return this;
    }
    public UserBuilder setSurname(String surname) {
        user.setSurname(surname);
        return this;
    }
    public UserBuilder setEmail(String email) {
        user.setEmail(email);
        return this;
    }
    public UserBuilder setPhone(String phone) {
        user.setPhone(phone);
        return this;
    }
    public UserBuilder setAddress(String address) {
        user.setAddress(address);
        return this;
    }
    public UserBuilder setZipCode(String zipCode) {
        user.setZipCode(zipCode);
        return this;
    }
    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }
    
}
