package com.example.mobilelele.models.dtos.model;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UserDTO extends BaseEntityDTO{

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private boolean isActive;

    private List<UserRoleDTO> role;

    private String imageURL;

    private String created;

    private String modified;

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserDTO setActive(boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRoleDTO> getRole() {
        return role;
    }

    public UserDTO setRole(List<UserRoleDTO> role) {
        this.role = role;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public UserDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public UserDTO setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getModified() {
        return modified;
    }

    public UserDTO setModified(String modified) {
        this.modified = modified;
        return this;
    }

    public boolean isValid(){
        return getId() != null;
    }
}
