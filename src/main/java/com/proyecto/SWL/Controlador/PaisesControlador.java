package com.proyecto.SWL.Controlador;


import com.proyecto.SWL.DTO.PaisesDTO;
import com.proyecto.SWL.Servicio.PaisesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PaisesControlador {

    @Autowired
    private PaisesServicio paisesSer;

    @GetMapping("/paises")
    public String paises(Model model) {
        List<PaisesDTO> paises = paisesSer.visualizar();
        model.addAttribute("VisPaises", paises);
        return "Admin/Paises/paises";
    }

    @GetMapping("/NuevoPaises")
    public String nuevosPaises() {
        return "Admin/Paises/NuevoPaises";
    }

}

