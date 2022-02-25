package com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.contexto.Ingrediente;
import com.contexto.Receita;
import com.contexto.TipoReceita;

public class OperacoesReceita {

    private static int id=0;
    private List<Receita> listaGeral;

    public OperacoesReceita(){
        listaGeral = new ArrayList<>();

        Receita receita1 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita1.setId(id++);
        Receita receita2 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita2.setId(id++);
        Receita receita3 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita3.setId(id++);
        Receita receita4 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita4.setId(id++);
        Receita receita5 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita5.setId(id++);
        Receita receita6 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita6.setId(id++);
        Receita receita7 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita7.setId(id++);
        Receita receita8 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita8.setId(id++);
        Receita receita9 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita9.setId(id++);
        Receita receita10 = new Receita("pao", TipoReceita.SALGADA, 2.0,"preparo",10,
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        receita10.setId(id++);
        
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
    
    public boolean cadastrarReceita(String nomeReceita, TipoReceita tipo, String modoPreparo,
            Double mediaPreco, Integer tempoPreparo, Ingrediente... ingredientes) {
       
        Receita receita = new Receita(nomeReceita, tipo,  mediaPreco,
           modoPreparo, tempoPreparo,ingredientes);
           receita.setId(id++);
           listaGeral.add(receita);
        return true;
    }

    public List<Receita> listaReceita() {
        return listaGeral;
    }

    public boolean atualizarReceita(Integer id,String nomeReceita, TipoReceita tipo, String modoPreparo,
    Double mediaPreco, Integer tempoPreparo, Ingrediente... ingredientes ) {
        Receita receita = listaGeral.get(id);
        receita.setIngredientes(ingredientes);
        receita.setMediaPreco(mediaPreco);
        receita.setModoPreparo(modoPreparo);
        receita.setNomeReceita(nomeReceita);
        receita.setTipoReceita(tipo);
        receita.setTempoPreparo(tempoPreparo);
        return true;
    }

    public Receita removeReceita(int id) {
        return  listaGeral.remove(id);
    }

}
