package com.caso1.controller;

import com.caso1.service.*;
import com.caso1.entity.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PeliculaController {
    
    @Autowired
    private IPeliculaService peliculaService;

    @Autowired
    private ISalaService salaService;

    @GetMapping("/pelicula")
    public String index(Model model) {
        List<Pelicula> listaPelicula = peliculaService.getAllPelicula();
        model.addAttribute("titulo", "Tabla Peliculas");
        model.addAttribute("pelicula", listaPelicula);
        return "pelicula";
    }

    @GetMapping("/peliculaN")
    public String crearPelicula(Model model) {
        List<Sala> listaSala = salaService.listCountry();
        model.addAttribute("titulo", "Agregar Pelicula");
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("sala", listaSala);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminarPelicula(@PathVariable("id") Long idPelicula) {
        peliculaService.delete(idPelicula);
        return "redirect:/pelicula";
    }

    @PostMapping("/save")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.savePelicula(pelicula);
        return "redirect:/pelicula";
    }

    @GetMapping("/editPelicula/{id}")
    public String editarPelicula(@PathVariable("id") Long idPelicula, Model model) {
        Pelicula pelicula = peliculaService.getPeliculaById(idPelicula);
        List<Sala> listaSala = salaService.listCountry();
        model.addAttribute("titulo", "Editar Persona");
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("sala", listaSala);
        return "crear";
    }
}
