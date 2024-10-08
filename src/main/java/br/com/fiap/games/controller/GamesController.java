package br.com.fiap.games.controller;

import br.com.fiap.games.model.Games;
import br.com.fiap.games.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private GamesService gamesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Games saveGame(@RequestBody Games game){
        return gamesService.saveGame(game);
    }

    @GetMapping("/listGames")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> listAllGames(){
        return gamesService.listAllGames();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Games searchGamesById(@PathVariable Long id){
        return gamesService.searchGameById(id);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Long id){
        gamesService.deleteGame(id);
    }
}
