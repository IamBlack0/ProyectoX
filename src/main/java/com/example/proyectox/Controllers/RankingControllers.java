package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Ranking;
import com.example.proyectox.Service.RankingDB;
import com.example.proyectox.Service.UsuarioDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankingControllers {

    @GetMapping("/ranking/all")
    public List<Ranking> ObtenerTodosRanking(){
        return new RankingDB().ObtenerRanking();

    }
}