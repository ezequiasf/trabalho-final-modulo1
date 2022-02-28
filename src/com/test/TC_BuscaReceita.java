package com.test;

import com.controller.OperacoesReceita;
import com.model.Receita;
import com.utils.TipoReceita;
import com.utils.BuscaReceita;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TC_BuscaReceita {

    @Test
    public void deveTestarFiltroDeUmIngrediente (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        List<Receita> lista = BuscaReceita.filtroLista("ovo",or.listarReceitas());

        //Assert
        assertTrue(lista.stream().allMatch(r->r.impressaoIngredientes().contains("ovo")));
    }

    @Test
    public void deveTestarFiltroDeVariosIngredientes (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        List<Receita> lista = BuscaReceita.filtroLista(or.listarReceitas(),"açucar","leite condesado");

        //Deve provar que todas as receitas contém os dois ingredientes
        assertTrue(lista.stream().allMatch(r->r.impressaoIngredientes().contains("açucar")));
        assertTrue(lista.stream().allMatch(r->r.impressaoIngredientes().contains("leite condesado")));
    }

    @Test
    public void deveTestarFiltroPeloTipoIngrediente (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        List<Receita> lista = BuscaReceita.filtroLista(TipoReceita.SALGADA,or.listarReceitas());

        //Assert
        assertTrue(lista.stream().allMatch(r->r.getTipoReceita()==TipoReceita.SALGADA));
    }

    @Test
    public void deveTestarFiltroPeloLimiteDeTempo (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        List<Receita> lista = BuscaReceita.filtroLista(10,or.listarReceitas());

        //Assert
        assertTrue(lista.stream().allMatch(r->r.getTempoPreparo()<=10));
    }

    @Test
    public void deveTestarFiltroPeloLimiteDePreco (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        List<Receita> lista = BuscaReceita.filtroLista(10.0,or.listarReceitas());

        //Assert
        assertTrue(lista.stream().allMatch(r->r.getMediaPreco()<=10.0));
    }

    @Test
    public void deveTestarFiltroAlmoco (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        List<Receita> lista = BuscaReceita.filtroAlmoco(or.listarReceitas(),2000.0);
        double porcentagemCaloria = 2000*0.3;
        //Assert
        assertTrue(lista.stream().allMatch(r->r.getTipoRefeicao()
                .getRefeicao().equalsIgnoreCase("Almoço ou janta")));
//        assertTrue(lis);
//
    }

}
