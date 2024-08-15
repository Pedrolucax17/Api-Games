package br.com.fiap.games.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
