package com.test;

import com.controller.OperacoesReceita;
import com.model.Ingrediente;
import com.model.Receita;
import com.utils.TipoReceita;
import com.utils.BuscaReceita;
import com.utils.TipoRefeicao;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        assertTrue(lista.stream().allMatch(r->{
            if ((r.getCalorias()<=porcentagemCaloria)&&(r.getCalorias()>porcentagemCaloria*0.15)){
                return true;
            }
            return false;
        }));
    }

    @Test
    public void deveTestarFiltroLanche (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        List<Receita> lista = BuscaReceita.filtroLancheCafe(or.listarReceitas(),2000.0,-1);
        double porcentagemCaloria = 2000*0.2;

        //Assert
        assertTrue(lista.stream().allMatch(r->r.getTipoRefeicao()
                .getRefeicao().equalsIgnoreCase("Lanche")));
        assertTrue(lista.stream().allMatch(r->{
            if ((r.getCalorias()<=porcentagemCaloria)&&(r.getCalorias()>porcentagemCaloria*0.10)){
                return true;
            }
            return false;
        }));
    }

    @Test
    public void deveTestarFiltroCafe (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        List<Receita> lista = BuscaReceita.filtroLancheCafe(or.listarReceitas(),2000.0,1);
        double porcentagemCaloria = 2000*0.2;

        //Assegurar que vai retornar null
        List<Receita> listaNull = BuscaReceita.filtroLancheCafe(or.listarReceitas(),2000.0,10);

        //Assert
        assertTrue(lista.stream().allMatch(r->r.getTipoRefeicao()
                .getRefeicao().equalsIgnoreCase("Café da Manhã")));
        assertTrue(lista.stream().allMatch(r->{
            if ((r.getCalorias()<=porcentagemCaloria)&&(r.getCalorias()>porcentagemCaloria*0.10)){
                return true;
            }
            return false;
        }));
        assertTrue(listaNull==null);

    }

    @Test
    public void deveTestarCardapioDoDia (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();

        //act
        List<Receita> listaCardapio = BuscaReceita.cardapioDoDia(or.listarReceitas(),2000.0);

        //Assert
        assertTrue(listaCardapio.get(0).getTipoRefeicao()== TipoRefeicao.CAFE);
        assertTrue(listaCardapio.get(1).getTipoRefeicao()== TipoRefeicao.ALMOCO_JANTA);
        assertTrue(listaCardapio.get(2).getTipoRefeicao()== TipoRefeicao.LANCHE);
        assertTrue(listaCardapio.get(3).getTipoRefeicao()== TipoRefeicao.ALMOCO_JANTA);

        assertNull(BuscaReceita.cardapioDoDia(or.listarReceitas(),10.000).get(0));
        assertNull(BuscaReceita.cardapioDoDia(or.listarReceitas(),10.000).get(1));
        assertNull(BuscaReceita.cardapioDoDia(or.listarReceitas(),10.000).get(2));
        assertNull(BuscaReceita.cardapioDoDia(or.listarReceitas(),10.000).get(3));
    }

    @Test
    public void deveTestarTotalCalorias (){
        //Setup
        OperacoesReceita or = new OperacoesReceita();
        //Receita 1
        List<Ingrediente> listaIng1 = new ArrayList<>();
        listaIng1.add(new Ingrediente("ovo", "2 un"));
        listaIng1.add(new Ingrediente("leite", "1 l"));
        Receita receita1 = new Receita("Omelete", TipoReceita.SALGADA, TipoRefeicao.CAFE, 300.5,10.0
                ,"Omeletinho do pai.",10, listaIng1
        );
        //Receita 2
        List<Ingrediente> listaIng2 = new ArrayList<>();
        listaIng2.add(new Ingrediente("carne", "200g"));
        listaIng2.add(new Ingrediente("manteiga", "2 colheres de sopa"));
        Receita receita2 = new Receita("pao", TipoReceita.SALGADA, TipoRefeicao.CAFE, 300.5,13.50
                ,"Uma comida estranha.",10, listaIng2
        );
        //Receita 3
        List<Ingrediente> listaIng3 = new ArrayList<>();
        listaIng3.add(new Ingrediente("açucar", "100g"));
        listaIng3.add(new Ingrediente("leite condesado", "100ml"));
        Receita receita3 = new Receita("Brigadeiro", TipoReceita.DOCE, TipoRefeicao.LANCHE,234.5,2.75
                ,"Hum hum brigadeirinho.",10, listaIng3
        );

        //TOTAL = 835,5

        //act
        List<Receita> listaSoma = new ArrayList<>();
        listaSoma.add(receita1);
        listaSoma.add(receita2);
        listaSoma.add(receita3);

        //Assert
        Double total = BuscaReceita.totalCalorias(listaSoma);
        assertTrue(835.5 == total);
    }
}
