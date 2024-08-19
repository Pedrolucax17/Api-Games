package br.com.fiap.games.service;

import br.com.fiap.games.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256("fiap");

        String token = JWT
                .create()
                .withIssuer("ads-fiap")
                .withSubject(user.getUsername())
                .withExpiresAt(generateDate())
                .sign(algorithm);

        return token;
    }

    public String validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256("fiap");

        try{
            return JWT
                    .require(algorithm)
                    .withIssuer("ads-fiap")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch(JWTVerificationException e){
            return "";
        }
    }

    public Instant generateDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
