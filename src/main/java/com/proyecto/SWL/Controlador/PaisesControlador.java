package com.proyecto.SWL.Controlador;


import com.proyecto.SWL.DTO.PaisesDTO;
import com.proyecto.SWL.Servicio.PaisesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import java.util.List;

@Controller
public class PaisesControlador {

    @Autowired
    private PaisesServicio paisesSer;

    @GetMapping("/paises") // Visualizar Datos
    public String paises(Model model) {
        List<PaisesDTO> paises = paisesSer.visualizar();
        model.addAttribute("VisPaises", paises);
        return "Admin/Paises/paises";
    }

    @GetMapping("/NuevoPaises") //Visualizar formulario
    public String nuevosPaises(Model model) {
        PaisesDTO paisesDTO = new PaisesDTO();
        model.addAttribute("PaisesVis", paisesDTO);
        return "Admin/Paises/NuevoPaises";
    }

    @PostMapping("/DatosNuevosPaises")
    public String datosNuevos(@ModelAttribute("PaisesVis") PaisesDTO paisesDTO, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Admin/Paises/NuevoPaises?Error";
        }
        paisesSer.GuardarNuevoPais(paisesDTO);
        return "redirect:/paises?Correcto";
    }


}

