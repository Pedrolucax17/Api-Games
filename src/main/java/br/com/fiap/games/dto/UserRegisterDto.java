package br.com.fiap.games.dto;

import br.com.fiap.games.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterDto(
        String name,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email inválido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String password,
        UserRole role
) {
}
