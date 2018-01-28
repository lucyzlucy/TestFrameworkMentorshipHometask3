package com.epam.training.framework.core.factory;

import com.epam.training.framework.utils.StringGenerateUtils;
import com.epam.training.framework.core.entityBuilders.builders.UserBuilder;
import com.epam.training.framework.core.entityBuilders.entities.User;

public class UserFactory {

    public static User getStandartUser() {
        return new UserBuilder().setName("Hi").setSurname("2Hi").make();
    }
    public static User getEmailUser() {
        return new UserBuilder().setEmail(StringGenerateUtils.getEmail()).make();
    }
}
