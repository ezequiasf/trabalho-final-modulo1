package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.contexto.Ingrediente;
import com.contexto.Receita;
import com.contexto.TipoReceita;

public class OperacoesReceita {

    
    private List<Receita> listaGeral;

    public OperacoesReceita(){
        listaGeral = new ArrayList<>();

        Receita receita1 = new Receita("pao", TipoReceita.SALGADA, "cozinhar",
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        Receita receita2 = new Receita("pao", TipoReceita.DOCE, "cozinhar",
                new Ingrediente("ovo2doce", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita3 = new Receita("pao", TipoReceita.DIET, "cozinhar",
                new Ingrediente("ovodiete", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita4 = new Receita("pao", TipoReceita.VEGANA, "cozinhar",
                new Ingrediente("ovovegano", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita5 = new Receita("pao", TipoReceita.SEM_GLUTEN, "cozinhar",
                new Ingrediente("ovosemgluten", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita6 = new Receita("pao", TipoReceita.ZERO_LACTOSE, "cozinhar",
                new Ingrediente("ovozero", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita7 = new Receita("pao", TipoReceita.SALGADA, "cozinhar",
                new Ingrediente("ovosalgado", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita8 = new Receita("pao", TipoReceita.SALGADA, "cozinhar",
                new Ingrediente("ovo3", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita9 = new Receita("pao", TipoReceita.SALGADA, "cozinhar",
                new Ingrediente("ovo3", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita10 = new Receita("pao", TipoReceita.SALGADA, "cozinhar",
                new Ingrediente("ovo3", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        listaGeral.add(receita1);
        listaGeral.add(receita2);
        listaGeral.add(receita3);
        listaGeral.add(receita4);
        listaGeral.add(receita5);
        listaGeral.add(receita6);
        listaGeral.add(receita7);
        listaGeral.add(receita8);
        listaGeral.add(receita9);
        listaGeral.add(receita10);
    }
    
    public boolean cadastrarReceita(Integer id, String nomeReceita, TipoReceita tipo, String modoPreparo,
            Ingrediente... ingredientes) {
        Receita receita = new Receita(nomeReceita, tipo, modoPreparo, ingredientes);
        listaGeral.add(receita);
        return true;
    }

    public boolean cadastrarReceita(Integer id, String nomeReceita, TipoReceita tipo, String modoPreparo,
            Double mediaPreco, Integer tempoPreparo, Ingrediente... ingredientes) {
      //  Receita receita = new Receita(id, nomeReceita, tipo, mediaPreco, modoPreparo, tempoPreparo, ingredientes);
        return true;
    }

    public List<Receita> listaReceita() {
        return listaReceita();
    }

    public boolean atualizarReceita(Integer id) {
        return true;
    }

    public boolean removeReceita(Integer id) {
        return true;
    }

}
