package com.main;

import com.controller.OperacoesReceita;
import com.model.Ingrediente;
import com.model.Receita;
import com.model.TipoReceita;
import com.view.Tela;
import com.utils.BuscaReceita;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Tela.telaPrincipal();

         OperacoesReceita op = new OperacoesReceita();

//        BuscaReceita.filtroLista("ovo", "carne", op.listaReceita());
//        System.out.println(BuscaReceita.filtroLista("ovo", "leite", op.listaReceita()));

//        List<Ingrediente> listaIng2 = new ArrayList<>();
//        listaIng2.add(new Ingrediente("ovo"));
//        listaIng2.add(new Ingrediente("leite"));
//
//
//
//        BuscaReceita.filtroLista(op.listaReceita(), "ovo","leite");

    }
}
