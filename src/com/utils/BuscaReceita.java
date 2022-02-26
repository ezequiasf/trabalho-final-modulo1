package com.utils;

import java.util.*;
import java.util.stream.Collectors;

import com.contexto.Ingrediente;
import com.contexto.TipoReceita;

import com.contexto.Receita;

public class BuscaReceita {


    public static List<Receita> filtroLista(String ingrediente, List<Receita> lista) {
        List<Receita> receitasFiltradas = null;

        receitasFiltradas = lista.stream()
                .filter(r -> r.getIngredientes()
                        .contains(ingrediente.toLowerCase())).collect(Collectors.toList());
        return receitasFiltradas;
    }


//    public static void filtroLista(List<Receita> lista, String... ingrediente) {
//        List<Receita> receitasFiltradas = null;
//        StringBuilder resultado = new StringBuilder();
//        for (String str : ingrediente
//             ) {
//            resultado.append(str+"\n") ;
//        }
//        System.out.println(resultado.toString());
//        Iterator <Receita> iterador= lista.iterator();
//        String[] ing = ingrediente;
//        int contador = 0;
//        for (int i = 0; i < ingrediente.length; i++) {
//            String a = "";
//            a.matches()
//
//        }
//
//    }


    public static List<Receita> filtroLista(TipoReceita tipo, List<Receita> lista) {
        List<Receita> receitasFiltradas = null;

        receitasFiltradas = lista.stream()
                .filter(r -> r.getTipoReceita() == tipo)
                .collect(Collectors.toList());

        return receitasFiltradas;
    }


}
