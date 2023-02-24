package com.example.mobilelele.models.beans;

import com.example.mobilelele.models.dtos.model.UserRoleDTO;

import java.util.List;

public class LoggedUser {

    private String id;
    private String username;
    private List<UserRoleDTO> roles;

    public LoggedUser() {
    }

    public String getId() {
        return id;
    }

    public LoggedUser setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<UserRoleDTO> getRoles() {
        return roles;
    }

    public LoggedUser setRoles(List<UserRoleDTO> roles) {
        this.roles = roles;
        return this;
    }

    public void clearFields() {
        setId(null);
        setUsername(null);
        setRoles(null);
    }
}
