package com.test;

import com.controller.OperacoesReceita;
import com.model.Ingrediente;
import com.model.Receita;
import com.utils.TipoReceita;
import com.utils.TipoRefeicao;
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
                , TipoReceita.DOCE, TipoRefeicao.ALMOCO_JANTA,300.5,13.45, "modo teste"
                ,15, listaIng);

        //Act
        int tamanhoInicial = or.listarReceitas().size();
        or.cadastrarReceita(receita);

        //Assert
        //Assegurar que o tamanho aumentou em 1 após o cadastro acima.
        assertTrue(or.listarReceitas().size()==tamanhoInicial+1);
        //Assegurar que na última posição da lista está a receita cadastrada acima.
        assertEquals("Receita Teste", or.listarReceitas()
                .get(or.listarReceitas().size()-1).getNomeReceita());
        //Assegurar que se passar um valor nulo, o método não irá cadastrar nenhuma receita.
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
                , TipoReceita.DOCE,TipoRefeicao.ALMOCO_JANTA,300.5,13.45, "modo teste"
                ,15, listaIng);

        //act
        String nomeReceitaInicial = or.listarReceitas().get(0).getNomeReceita();
        int tamanhoInicial = or.listarReceitas().size();
        or.atualizarReceita(0,receita);

        //Assert
        //Assegurar que o valor na posição 0 foi atualizado.
        assertTrue(or.listarReceitas().get(0).getNomeReceita().equals("Receita Teste"));
        //Após a atualização, a lista continua com o tamanho igual.
        assertTrue(tamanhoInicial==or.listarReceitas().size());
        //Se passarmos um valor nulo, o método não atualiza a lista.
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
        //Assegurar que o tamanho inicial é maior do que depois.
        assertTrue(tamanhoInicial == or.listarReceitas().size()+1);
        //O nome da receita na posição 0 não é mais o mesmo.
        assertFalse(or.listarReceitas().get(0).getNomeReceita().equals(nomeReceitaInicial));
    }
}
