package com.example.mobilelele.models.dtos.model;

import com.example.mobilelele.models.entites.Brand;
import com.example.mobilelele.models.enums.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class ModelDTO extends BaseEntityDTO{

    @NotNull
    private String name;

    @NotNull
    private Category category;

    @Size(min = 8,max = 512)
    private String imageURL;

    private Integer startYear;

    private Integer endYear;

    private String created;

    private String modified;

    private Brand brand;

    public ModelDTO() {
    }


    public String getName() {
        return name;
    }

    public ModelDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ModelDTO setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ModelDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelDTO setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelDTO setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public ModelDTO setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getModified() {
        return modified;
    }

    public ModelDTO setModified(String modified) {
        this.modified = modified;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public ModelDTO setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
