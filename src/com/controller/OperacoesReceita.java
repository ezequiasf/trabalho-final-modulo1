package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.utils.InicializaLista;
import com.utils.TipoReceita;

import com.model.Receita;

import com.model.Ingrediente;
import com.utils.TipoRefeicao;

public class OperacoesReceita {

    public int id=0;
    private final List<Receita> listaGeral;

    public OperacoesReceita(){
        listaGeral = InicializaLista.insercaoDados();
        id = InicializaLista.getId();
    }
    
    public boolean cadastrarReceita(Receita receita) {
           if (receita !=null){
               receita.setId(id++);
               listaGeral.add(receita);
               return true;
           }
        return false;
    }

    public List<Receita> listarReceitas() {
        return listaGeral;
    }

    public boolean atualizarReceita(Integer id,Receita receitaAtualizada) {
            if (receitaAtualizada!=null){
                receitaAtualizada.setId(id);
                listaGeral.add(id,receitaAtualizada);
                listaGeral.remove(id+1);
                return true;
            }
            return false;
    }

    public Receita removeReceita(int id) {
        return  listaGeral.remove(id);
    }

}
