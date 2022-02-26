package com.utils;

import java.util.*;
import java.util.stream.Collectors;

import com.model.Ingrediente;
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
//        StringBuilder resultado = new StringBuilder("[");
//        for (String str : ingrediente
//        ) {
//            resultado.append("("+str +")\\n");
//        }resultado.append("]");
//        System.out.println(resultado.toString());
//        receitasFiltradas = lista.stream()
//                .filter(r -> r.getIngredientes().matches(resultado.toString())).collect(Collectors.toList());
//        System.out.println(receitasFiltradas);
//    }


    public static List<Receita> filtroLista(String ingrediente, String ingrediente2, List<Receita> lista) {
        List<Receita> filtrar = lista.stream()
                .filter(r -> r.getIngredientes()
                        .contains(ingrediente.toLowerCase())).collect(Collectors.toList());

        filtrar = filtrar.stream()
                .filter(r -> r.getIngredientes()
                        .contains(ingrediente2.toLowerCase())).collect(Collectors.toList());

        return filtrar;
    }

//    public static List<Receita> filtroLista(String ingrediente, List<Ingrediente> ing, List<Receita> lista){
////        lista.stream().collect(Collectors.groupingBy(lista.contains(ing), Collectors.mapping()));
//        lista.stream().takeWhile()
//        return filtrar;
//    }

//    public static List<Receita> filtroLista(List<Ingrediente> ingredientes, List<Receita> lista) {
////        return ingredientes.stream()
////                .anyMatch(algumItem -> lista.contains(algumItem));
//        return lista.stream()
//                .filter( receita -> ingredientes.stream().anyMatch(algumItem -> lista.contains(algumItem)))
//                .collect(Collectors.toList());
////            if (ingredientes.stream()
////                            .anyMatch(algumItem -> lista.contains(algumItem))==true);
////                }return
////                );
//    }

//    public static List<Receita> filtroLista(List<Ingrediente> ingredientes, List<Receita> lista) {
////        return ingredientes.stream()
////                .anyMatch(algumItem -> lista.contains(algumItem));
//        StringBuilder resultado = new StringBuilder();
//        for (Ingrediente ing : ingredientes
//             ) {
//            resultado.append(ing.getNome()+"\n") ;
//        }
//        System.out.println(resultado);
//
//        List<Receita> e = lista.stream()
//                .filter( receita -> receita.getIngredientesList().stream().anyMatch(r -> r.getIngredientes.contains(resultado.toString())))
//                .collect(Collectors.toList());
//        System.out.println(e);
//        return e;
//
//
////            if (ingredientes.stream()
////                            .anyMatch(algumItem -> lista.contains(algumItem))==true);
////                }return
////                );
//    }

}
