package com.utils;

import java.util.*;
import java.util.stream.Collectors;

import com.model.Receita;
import com.model.TipoReceita;

public class BuscaReceita {

    public static List<Receita> filtroLista(String ingrediente, List<Receita> lista) {
       return lista.stream()
                .filter(r -> r.getIngredientes()
                        .contains(ingrediente.toLowerCase())).collect(Collectors.toList());
    }

    public static List<Receita> filtroLista(TipoReceita tipo, List<Receita> lista) {
        return lista.stream()
                .filter(r -> r.getTipoReceita() == tipo)
                .collect(Collectors.toList());
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

}
