package com.utils;

import java.util.*;
import java.util.stream.Collectors;

import com.model.Receita;

public class BuscaReceita {

    //Pesquisa por um ingrediente em específico
    public static List<Receita> filtroLista(String ingrediente, List<Receita> lista) {
        return lista.stream()
                .filter(r -> r.impressaoIngredientes()
                        .contains(ingrediente.replace(" ",""))).collect(Collectors.toList());
    }

    //Pesquisa pelo tipo de ingrediente
    public static List<Receita> filtroLista(TipoReceita tipo, List<Receita> lista) {
        return lista.stream()
                .filter(r -> r.getTipoReceita() == tipo)
                .collect(Collectors.toList());
    }

    //Pesquisa por vários ingredientes
    public static List<Receita> filtroLista(List<Receita> lista, String... ing) {
        List<Receita> listaFiltrada = new ArrayList<>();
        Iterator<Receita> iterador = lista.iterator();
        while (iterador.hasNext()){
            int contador = 0;
            Receita r = iterador.next();
            for (int i = 0; i < ing.length; i++) {
                if (r.impressaoIngredientes().contains(ing[i].replace(" ",""))){
                    contador++;
                }
            }
            if (contador == ing.length){
                listaFiltrada.add(r);
            }
        }
        return  listaFiltrada;
    }

    //Filtro de tempo: Limite de tempo
    public static List<Receita> filtroLista(int tempo, List<Receita> lista){
        return lista.stream()
                .filter(r-> r.getTempoPreparo()<=tempo)
                .collect(Collectors.toList());
    }

    // Filtro de preço: Limite de preço
    public static List<Receita> filtroLista(double preco, List<Receita> lista){
        return lista.stream()
                .filter(r-> r.getMediaPreco()<=preco)
                .sorted(Comparator.comparing(Receita::getMediaPreco))
                .collect(Collectors.toList());
    }

    // Receita mais cara para mais barata ou o inverso
    // Negativo: crescente, Positivo: Decrescente
    public static List<Receita> listaPrecos(int sinalizador,List<Receita> lista){
        return lista.stream()
                .sorted((r1,r2) ->{
                    if (sinalizador<0){
                        return Double.compare(r1.getMediaPreco(),r2.getMediaPreco());
                    }
                    return Double.compare(r2.getMediaPreco(), r1.getMediaPreco());
                })
                .collect(Collectors.toList());
    }

}
