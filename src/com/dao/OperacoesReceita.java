package com.dao;

import java.util.List;

import com.contexto.Ingrediente;
import com.contexto.Receita;
import com.contexto.TipoReceita;

public class OperacoesReceita {

    public boolean cadastrarReceita(Integer id, String nomeReceita, TipoReceita tipo, String modoPreparo,
            Ingrediente... ingredientes) {
        

       // Receita receita = new Receita(id, nomeReceita, tipo, modoPreparo, ingredientes);
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
