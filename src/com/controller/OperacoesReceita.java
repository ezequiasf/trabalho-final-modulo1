package com.controller;

import java.util.List;

import com.utils.InicializaLista;


import com.model.Receita;

public class OperacoesReceita {

    /**
     * Essa variável é inicializada a partir do método estático da classe
     * InicializaLista. O método de cadastro incrementa em 1 a cada inserção
     * na lista.
     */
    public int id;
    private final List<Receita> listaGeral;

    public OperacoesReceita(){
        listaGeral = InicializaLista.insercaoDados();
        id = InicializaLista.getId();
    }

    /**
     * Cadastra uma receita.
     *
     * @param receita Uma instância de receita.
     * @return Um valor verdadeiro(true) caso a receita seja cadastrada na lista
     * e o valor não seja nulo.
     */
    public boolean cadastrarReceita(Receita receita) {
           if (receita !=null){
               receita.setId(id++);
               listaGeral.add(receita);
               return true;
           }
        return false;
    }

    /**
     * Faz a listagem de todas as receitas presentes na lista.
     *
     * @return A lista de receita inicializada no construtor.
     */
    public List<Receita> listarReceitas() {
        return listaGeral;
    }

    /**
     * Atualiza a lista de receitas.
     *
     * @param id                O id da receita que deseja atualizar.
     * @param receitaAtualizada A instância de receita que irá substituir a antiga
     *                          instância.
     * @return Um valor verdadeiro caso a instância recebida por parâmetro não seja nula.
     */
    public boolean atualizarReceita(Integer id,Receita receitaAtualizada) {
            if (receitaAtualizada!=null){
                receitaAtualizada.setId(id);
                listaGeral.add(id,receitaAtualizada);
                listaGeral.remove(id+1);
                return true;
            }
            return false;
    }

    /**
     * Remove uma instância de receita da lista.
     *
     * @param id O id da instância que se deseja remover.
     * @return A instância removida.
     */
    public Receita removeReceita(int id) {
        return  listaGeral.remove(id);
    }

}
