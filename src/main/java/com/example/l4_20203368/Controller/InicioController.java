package com.example.l4_20203368.Controller;


import com.example.l4_20203368.Entity.Reserva;
import com.example.l4_20203368.Entity.User;
import com.example.l4_20203368.Entity.Vuelo;
import com.example.l4_20203368.Repository.ReservaRepository;
import com.example.l4_20203368.Repository.UserRepository;
import com.example.l4_20203368.Repository.VuelosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class InicioController {
    final UserRepository userRepository;
    final VuelosRepository vuelosRepository;
    final ReservaRepository reservaRepository;
    public InicioController(UserRepository userRepository, VuelosRepository vuelosRepository, ReservaRepository repository) {
        this.userRepository = userRepository;
        this.vuelosRepository = vuelosRepository;
        this.reservaRepository = repository;
    }
    @GetMapping(value = "/inicio")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/home")
    public String home(Model model,@RequestParam(name = "userId")Integer id){
            model.addAttribute("user", userRepository.findById(id).get());
            model.addAttribute("listavuelos",vuelosRepository.findAll());
            return "home";
    }


    @PostMapping(value = "/reservar")
    @Transactional
    public String reservar(@RequestParam("vueloid") Integer vueloid, @RequestParam("userid") Integer userid, @RequestParam("precio") Integer precio, RedirectAttributes redirectAttributes){
        reservaRepository.reservar(precio,userid,vueloid);
        redirectAttributes.addAttribute("userId", userid);
        return "redirect:/home";
    }



    @PostMapping(value = "/inicio/valid")
    public String valid(@RequestParam("correo") String correo, @RequestParam("contrasena") String password, RedirectAttributes redirectAttributes){
        for(User u:userRepository.findAll()){
            if(u.getEmail().equals(correo) && u.getPassword().equals(password)){
                redirectAttributes.addAttribute("userId", u.getIduser());
                return "redirect:/home";
            }
        }
        return "redirect:/inicio";
    }
}
