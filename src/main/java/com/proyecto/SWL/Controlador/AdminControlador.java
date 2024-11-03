package com.proyecto.SWL.Controlador;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminControlador {

    @GetMapping("/")
    public String dashBoard(){
        return "Admin/index";
    }


}
