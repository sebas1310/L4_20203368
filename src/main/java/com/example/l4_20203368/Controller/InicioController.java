package com.example.l4_20203368.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping(value = "/inicio")
    public String index(){
        System.out.println("dweef");
        return "index";
    }
}
