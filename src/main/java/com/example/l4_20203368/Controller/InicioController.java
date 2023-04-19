package com.example.l4_20203368.Controller;


import com.example.l4_20203368.Entity.User;
import com.example.l4_20203368.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {
    final UserRepository userRepository;

    public InicioController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping(value = "/inicio")
    public String index(){
        return "index";
    }

    @PostMapping(value = "/inicio/valid")
    public String valid(@RequestParam("correo") String correo, @RequestParam("contrasena") String password){
        System.out.printf("fefef");
        for(User u:userRepository.findAll()){
            if(u.getEmail().equals(correo) && u.getPassword().equals(password)){
                return "home";
            }
        }
        return "index";
    }
}
