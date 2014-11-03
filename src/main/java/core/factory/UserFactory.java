package core.factory;

import utils.StringGenerateUtils;
import core.entityBuilders.builders.UserBuilder;
import core.entityBuilders.entities.User;

public class UserFactory {

    public static User getStandartUser() {
        return new UserBuilder().setName("Hi").setSurname("2Hi").make();
    }
    public static User getEmailUser() {
        return new UserBuilder().setEmail(StringGenerateUtils.getEmail()).make();
    }
}
