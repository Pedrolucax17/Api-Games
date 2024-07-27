package br.com.fiap.games.repository;

import br.com.fiap.games.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Games, Long> {
}
