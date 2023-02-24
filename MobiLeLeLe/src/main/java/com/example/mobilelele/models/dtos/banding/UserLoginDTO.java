package com.example.mobilelele.models.dtos.banding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {

    @NotNull
    @Size(min = 5,max = 20)
    private String username;

    @NotNull
    @Size(min = 5,max = 20)
    private String password;

    public UserLoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
