package ch.noseryoung.meilyv.domain.user.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UserRegisterDTO extends ExtendedDTO {
    private String firstName;

    private String lastName;

    private String userName;

    @Email
    @NotNull
    private String email;

    private String password;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(UUID id, String firstName, String lastName, String userName, String email, String password) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserRegisterDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}