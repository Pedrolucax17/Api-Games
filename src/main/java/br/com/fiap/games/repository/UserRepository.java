package br.com.fiap.games.repository;

import br.com.fiap.games.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Long, User> {

    UserDetails findByEmail(String email);

}
