package br.com.fiap.games.dto;

import br.com.fiap.games.model.User;
import br.com.fiap.games.model.UserRole;

public record UserExhibitionDto(
        Long id,
        String name,
        String email,
        UserRole role
) {
    public UserExhibitionDto(User user){
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
