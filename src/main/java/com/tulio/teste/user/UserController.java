package com.tulio.teste.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cadastro")
public class UserController {

    @Autowired
    IUserRepository userRepository;

    @PostMapping("/")
    public void cadastrar(@RequestBody UserModel userModel)
    {
        this.userRepository.save(userModel);
    }
}
