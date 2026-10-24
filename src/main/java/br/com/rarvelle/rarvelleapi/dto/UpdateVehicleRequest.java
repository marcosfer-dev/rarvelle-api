package br.com.rarvelle.rarvelleapi.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateVehicleRequest(
        @NotBlank
        String model,

        @NotBlank
        String version,

        @NotNull
        @DecimalMin(value = "0.00", inclusive = false)
        BigDecimal price,

        @NotNull
        boolean active
    ) {
}
