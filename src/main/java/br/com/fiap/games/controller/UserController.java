package br.com.fiap.games.controller;

import br.com.fiap.games.dto.UserExhibitionDto;
import br.com.fiap.games.dto.UserRegisterDto;
import br.com.fiap.games.model.User;
import br.com.fiap.games.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registerUser(@RequestBody UserRegisterDto dto){
        UserExhibitionDto user = userService.registerUser(dto);
        return ResponseEntity.ok(user);
    }

}
