package com.example.mobilelele.models.dtos.model;

import jakarta.validation.constraints.NotNull;


public class BrandDTO extends BaseEntityDTO {

    @NotNull
    private String name;

    @NotNull
    private String created;


    private String modified;

    public BrandDTO() {
    }

    public String getName() {
        return name;
    }

    public BrandDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public BrandDTO setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getModified() {
        return modified;
    }

    public BrandDTO setModified(String modified) {
        this.modified = modified;
        return this;
    }
}
