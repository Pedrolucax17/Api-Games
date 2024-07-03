package br.com.fiap.games.service;

import br.com.fiap.games.model.Games;
import br.com.fiap.games.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {

    @Autowired
    private GamesRepository gamesRepository;

    public Games saveGame(Games game){
        return gamesRepository.save(game);
    }

    public List<Games> listAllGames(){
        return gamesRepository.findAll();
    }

    public Games searchGameById(Long id){
        Optional<Games> gamesOptional = gamesRepository.findById(id);
        if(gamesOptional.isPresent()){
            return gamesOptional.get();
        }else{
            throw new RuntimeException("Id inválido");
        }
    }

}
