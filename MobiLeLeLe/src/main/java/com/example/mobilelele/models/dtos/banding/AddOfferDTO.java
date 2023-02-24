package com.example.mobilelele.models.dtos.banding;

import com.example.mobilelele.models.entites.Model;
import com.example.mobilelele.models.enums.Engine;
import com.example.mobilelele.models.enums.Transmission;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddOfferDTO {

    private Model model;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Engine engine;

    @NotNull
    private Transmission transmission;

    private LocalDateTime created;

    @NotNull
    private Integer mileage;

    @NotNull
    private String description;

    private String imageURL;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
