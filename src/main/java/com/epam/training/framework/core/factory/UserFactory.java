package com.epam.training.framework.core.factory;

import com.epam.training.framework.core.entityBuilders.builders.UserBuilder;
import com.epam.training.framework.core.entityBuilders.entities.User;

import static com.epam.training.framework.data.TestData.PASSWORD;
import static com.epam.training.framework.data.TestData.USERNAME;
import static com.epam.training.framework.utils.StringGenerateUtils.getEmail;
import static com.epam.training.framework.utils.StringGenerateUtils.getPassword;


public class UserFactory {

    public static User getNewUser() {
        return new UserBuilder().setEmail(getEmail()).setPassword(getPassword()).make();
    }

    public static User getExistingUser() {
        return new UserBuilder().setEmail(USERNAME).setPassword(PASSWORD).make();
    }
}
