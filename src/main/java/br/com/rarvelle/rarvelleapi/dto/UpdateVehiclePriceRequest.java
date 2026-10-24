package br.com.rarvelle.rarvelleapi.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateVehiclePriceRequest(
        @NotNull
        @DecimalMin(value = "0.00", inclusive = false)
        BigDecimal price
    ) {
}