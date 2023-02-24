package com.example.mobilelele.models.dtos.banding;

import com.example.mobilelele.models.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserRegisterDTO {

    @NotNull
    @Size(min = 4,max = 20)
    private String firstName;

    @NotNull
    @Size(min = 5,max = 20)
    private String lastName;

    @NotNull
    @Size(min = 5,max = 20)
    private String username;

    @NotNull
    @Size(min = 5,max = 20)
    private String password;

    private Role role;

    public UserRegisterDTO() {
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

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRegisterDTO setRole(Role role) {
        this.role = role;
        return this;
    }
}
