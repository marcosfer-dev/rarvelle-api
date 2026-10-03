package br.com.rarvelle.rarvelleapi.veiculo;

import java.math.BigDecimal;

public class Vehicle {
    private Long id;
    private String model;
    private String version;
    private BigDecimal price;
    private boolean active;

    public Vehicle(Long id, String model, String version, BigDecimal price, boolean active) {
        this.id = id;
        this.model = model;
        this.version = version;
        this.price = price;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}