package core.entityBuilders.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String zipCode;
    private String password;
}
