package br.com.fiap.games.service;

import br.com.fiap.games.dto.UserExhibitionDto;
import br.com.fiap.games.dto.UserRegisterDto;
import br.com.fiap.games.model.User;
import br.com.fiap.games.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserExhibitionDto registerUser(UserRegisterDto userRegisterDto){
        String passwordEncrypted = new BCryptPasswordEncoder().encode(userRegisterDto.password());

        User user = new User();
        BeanUtils.copyProperties(userRegisterDto, user);
        user.setPassword(passwordEncrypted);

        User userSave = userRepository.save(user);

        return new UserExhibitionDto(userSave);
    }

}
