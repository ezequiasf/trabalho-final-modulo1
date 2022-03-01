package com.utils;

import java.util.*;
import java.util.stream.Collectors;

import com.model.Receita;

/**
 * The type Busca receita.
 */
public class BuscaReceita {

    /**
     * Filtro lista list.
     *
     * @param ingrediente the ingrediente
     * @param lista       the lista
     * @return the list
     */
//Pesquisa por um ingrediente em específico
    public static List<Receita> filtroLista(String ingrediente, List<Receita> lista) {
        return lista.stream()
                .filter(r -> r.impressaoIngredientes()
                        .contains(ingrediente.replace(" ", ""))).collect(Collectors.toList());
    }

    /**
     * Filtro lista list.
     *
     * @param tipo  the tipo
     * @param lista the lista
     * @return the list
     */
//Pesquisa pelo tipo de ingrediente
    public static List<Receita> filtroLista(TipoReceita tipo, List<Receita> lista) {
        return lista.stream()
                .filter(r -> r.getTipoReceita() == tipo)
                .collect(Collectors.toList());
    }

    /**
     * Filtro lista list.
     *
     * @param lista the lista
     * @param ing   the ing
     * @return the list
     */
//Pesquisa por vários ingredientes
    public static List<Receita> filtroLista(List<Receita> lista, String... ing) {
        List<Receita> listaFiltrada = new ArrayList<>();
        Iterator<Receita> iterador = lista.iterator();
        while (iterador.hasNext()) {
            int contador = 0;
            Receita r = iterador.next();
            for (int i = 0; i < ing.length; i++) {
                if (r.impressaoIngredientes().contains(ing[i].replace(" ", ""))) {
                    contador++;
                }
            }
            if (contador == ing.length) {
                listaFiltrada.add(r);
            }
        }
        return listaFiltrada;
    }

    /**
     * Filtro lista list.
     *
     * @param tempo the tempo
     * @param lista the lista
     * @return the list
     */
//Filtro de tempo: Limite de tempo
    public static List<Receita> filtroLista(int tempo, List<Receita> lista) {
        return lista.stream()
                .filter(r -> r.getTempoPreparo() <= tempo)
                .collect(Collectors.toList());
    }

    /**
     * Filtro lista list.
     *
     * @param preco the preco
     * @param lista the lista
     * @return the list
     */
// Filtro de preço: Limite de preço
    public static List<Receita> filtroLista(double preco, List<Receita> lista) {
        return lista.stream()
                .filter(r -> r.getMediaPreco() <= preco)
                .sorted(Comparator.comparing(Receita::getMediaPreco))
                .collect(Collectors.toList());
    }

    /**
     * Lista precos list.
     *
     * @param sinalizador the sinalizador
     * @param lista       the lista
     * @return the list
     */
// Receita mais cara para mais barata ou o inverso
    // Negativo: crescente, Positivo: Decrescente
    public static List<Receita> listaPrecos(int sinalizador, List<Receita> lista) {
        return lista.stream()
                .sorted((r1, r2) -> {
                    if (sinalizador < 0) {
                        return Double.compare(r1.getMediaPreco(), r2.getMediaPreco());
                    }
                    return Double.compare(r2.getMediaPreco(), r1.getMediaPreco());
                })
                .collect(Collectors.toList());
    }

    /**
     * Filtro almoco list.
     *
     * @param lista    the lista
     * @param calorias the calorias
     * @return the list
     */
    public static List<Receita> filtroAlmoco(List<Receita> lista, Double calorias) {
        return filtroRefeicao(lista, calorias, 0.3, TipoRefeicao.ALMOCO_JANTA,0.15);
    }

    /**
     * Filtro lanche cafe list.
     *
     * @param lista    the lista
     * @param calorias the calorias
     * @param tipo     the tipo
     * @return the list
     */
    public static List<Receita> filtroLancheCafe(List<Receita> lista, Double calorias, int tipo) {

        if (tipo == 1) {
            return filtroRefeicao(lista, calorias, 0.2, TipoRefeicao.CAFE,0.10);
        } else if (tipo == -1) {
            return filtroRefeicao(lista, calorias, 0.2, TipoRefeicao.LANCHE,0.10);
        }
        return null;
    }

    private static List<Receita> filtroRefeicao(List<Receita> lista, Double calorias, Double porcentagem
            , TipoRefeicao tipoRefeicao, Double porcentagemDelta) {

        return lista.stream().filter(r -> {
            if (r.getTipoRefeicao() == tipoRefeicao) {
                return (r.getCalorias() > calorias * porcentagemDelta) && (r.getCalorias() <= calorias * porcentagem);
            }
            return false;
        }).collect(Collectors.toList());
    }

    /**
     * Cardapio do dia list.
     *
     * @param lista    the lista
     * @param calorias the calorias
     * @return the list
     */
    public static List<Receita> cardapioDoDia(List<Receita> lista, Double calorias) {

        Random random = new Random();
        List<Receita> cafes = filtroLancheCafe(lista, calorias, 1);
        Receita cafe = null;
        if (!(cafes.size()<=0)){
            cafe = cafes.get(random.nextInt(cafes.size()));
        }

        List<Receita> lanches = filtroLancheCafe(lista, calorias, -1);
        Receita lanche = null;
        if (!(lanches.size()<=0)){
            lanche = lanches.get(random.nextInt(lanches.size()));
        }

        List<Receita> jantas = filtroAlmoco(lista, calorias);
        Receita janta = null;
        if (!(jantas.size()<=0)){
            janta = jantas.get(random.nextInt(jantas.size()));
        }

        List<Receita> almocos = filtroAlmoco(lista, calorias);
        Receita almoco = null;
        if (!(almocos.size()<=0)){
           almoco = almocos.get(random.nextInt(almocos.size()));
        }
        return new ArrayList<>(Arrays.asList(cafe, almoco, lanche, janta));
    }

    /**
     * Total calorias double.
     *
     * @param receitas the receitas
     * @return the double
     */
    public static Double totalCalorias (List<Receita> receitas){
        return receitas.stream().mapToDouble(r-> {
            if(r!=null){
               return r.getCalorias();
            }
            return 0.0;
        }).sum();
    }
}
