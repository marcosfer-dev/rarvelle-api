package br.com.rarvelle.rarvelleapi.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateVehicleRequest(

        @NotBlank
        String model,

        @NotBlank
        String version,

        @NotNull
        @DecimalMin(value = "0.00", inclusive = false)
        BigDecimal price,

        boolean active

    ) {
}