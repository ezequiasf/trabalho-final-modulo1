package com.test;

import com.controller.OperacoesReceita;
import com.model.Ingrediente;
import com.model.Receita;
import com.utils.TipoReceita;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class TC_OperacoesReceita {

    @Test
    public void deveTestarCadastroLista(){
        //Setup
        OperacoesReceita or = new OperacoesReceita();
        List<Ingrediente> listaIng = new ArrayList<>();
        listaIng.add(new Ingrediente("arroz", "200 g"));
        listaIng.add(new Ingrediente("açucar", "100 g"));
        Receita receita = new Receita("Receita Teste"
                , TipoReceita.DOCE,13.45, "modo teste"
                ,15, listaIng);

        //Act
        int tamanhoInicial = or.listarReceitas().size();
        or.cadastrarReceita(receita);

        //Assert
        assertTrue(or.listarReceitas().size()==tamanhoInicial+1);
        assertEquals("Receita Teste", or.listarReceitas()
                .get(or.listarReceitas().size()-1).getNomeReceita());
        assertFalse(or.cadastrarReceita(null));
    }

    @Test
    public void deveTestarAtualizacaoLista (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();
        List<Ingrediente> listaIng = new ArrayList<>();
        listaIng.add(new Ingrediente("arroz", "200 g"));
        listaIng.add(new Ingrediente("açucar", "100 g"));
        Receita receita = new Receita("Receita Teste"
                , TipoReceita.DOCE,13.45, "modo teste"
                ,15, listaIng);

        //act
        String nomeReceitaInicial = or.listarReceitas().get(0).getNomeReceita();
        int tamanhoInicial = or.listarReceitas().size();
//        System.out.println(nomeReceitaInicial);
        or.atualizarReceita(0,receita);

        //Assert
        assertTrue(or.listarReceitas().get(0).getNomeReceita().equals("Receita Teste"));
        assertTrue(tamanhoInicial==or.listarReceitas().size());
        assertFalse(or.atualizarReceita(0,null));
    }
    @Test
    public void deveTestarDelecaoLista (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        int tamanhoInicial = or.listarReceitas().size();
        String nomeReceitaInicial = or.listarReceitas().get(0).getNomeReceita();
        or.removeReceita(0);

        //Assert
        assertTrue(tamanhoInicial == or.listarReceitas().size()+1);
        assertFalse(or.listarReceitas().get(0).getNomeReceita().equals(nomeReceitaInicial));
    }
}
