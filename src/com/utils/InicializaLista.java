package com.utils;

import com.model.Ingrediente;
import com.model.Receita;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilizada para inicializar a lista geral usada nas operações.
 */
public class InicializaLista {

    public static int id = 0;

    public static List<Receita> insercaoDados (){

        List<Receita> listaInicialTeste = new ArrayList<>();
        //Receita 1
        List<Ingrediente> listaIng1 = new ArrayList<>();
        listaIng1.add(new Ingrediente("ovo", "2 un"));
        listaIng1.add(new Ingrediente("leite", "1 l"));
        Receita receita1 = new Receita("Omelete", TipoReceita.SALGADA, TipoRefeicao.CAFE, 300.5,10.0
                ,"Omeletinho do pai.",10, listaIng1
        );
        receita1.setId(id++);

        //Receita 2
        List<Ingrediente> listaIng2 = new ArrayList<>();
        listaIng2.add(new Ingrediente("carne", "200g"));
        listaIng2.add(new Ingrediente("manteiga", "2 colheres de sopa"));
        Receita receita2 = new Receita("pao", TipoReceita.SALGADA, TipoRefeicao.ALMOCO_JANTA, 300.5,13.50
                ,"Uma comida estranha.",10, listaIng2
        );
        receita2.setId(id++);

        //Receita 3
        List<Ingrediente> listaIng3 = new ArrayList<>();
        listaIng3.add(new Ingrediente("açucar", "100g"));
        listaIng3.add(new Ingrediente("leite condesado", "100ml"));
        Receita receita3 = new Receita("Brigadeiro", TipoReceita.DOCE, TipoRefeicao.LANCHE,300.5,2.75
                ,"Hum hum brigadeirinho.",10, listaIng3
        );
        receita3.setId(id++);

        //Receita 4
        List<Ingrediente> listaIng4 = new ArrayList<>();
        listaIng4.add(new Ingrediente("granola", "200g"));
        listaIng4.add(new Ingrediente("iorgute", "100ml"));
        Receita receita4 = new Receita("Iorgute da manhã", TipoReceita.DIET, TipoRefeicao.ALMOCO_JANTA,300.5,23.0
                ,"Come para daqui a pouco ta com fome de novo.",10, listaIng4
        );
        receita4.setId(id++);

        //Receita 5
        List<Ingrediente> listaIng5 = new ArrayList<>();
        listaIng5.add(new Ingrediente("ovo", "2un"));
        listaIng5.add(new Ingrediente("camarão", "500g"));
        Receita receita5 = new Receita("Camarão ao ovo", TipoReceita.SALGADA,TipoRefeicao.ALMOCO_JANTA, 300.5,2.0
                ,"Camarão frito com ovo po.",10, listaIng5
        );
        receita5.setId(id++);

        //Receita 6
        List<Ingrediente> listaIng6 = new ArrayList<>();
        listaIng6.add(new Ingrediente("leite de soja", "200ml"));
        listaIng6.add(new Ingrediente("camarão", "350g"));
        listaIng6.add(new Ingrediente("granola", "350g"));
        listaIng6.add(new Ingrediente("ovo", "350g"));
        Receita receita6 = new Receita("Nham Nham vegano", TipoReceita.VEGANA, TipoRefeicao.ALMOCO_JANTA,300.5,2.0
                ,"Joga tudo dentro de um sapato e gira.",15, listaIng6
        );
        receita6.setId(id++);

        //Receita 7
        List<Ingrediente> listaIng7 = new ArrayList<>();
        listaIng7.add(new Ingrediente("picanha", "2 kg"));
        listaIng7.add(new Ingrediente("molho barbecue", "100ml"));
        listaIng7.add(new Ingrediente("chimarrão", "10 l"));
        Receita receita7 = new Receita("Churrasco DBC", TipoReceita.SALGADA,TipoRefeicao.ALMOCO_JANTA, 300.5,2500.0
                ,"Receber do Maicon R$ 2000 para compra das carnes.",10, listaIng7
        );
        receita7.setId(id++);

        //Receita 8
        List<Ingrediente> listaIng8 = new ArrayList<>();
        listaIng8.add(new Ingrediente("meia suja", "2 kg"));
        listaIng8.add(new Ingrediente("macarrão vegano", "300 g"));
        listaIng8.add(new Ingrediente("algum grão ruim", "200 g"));
        Receita receita8 = new Receita("Porque você é vegano?", TipoReceita.VEGANA,TipoRefeicao.ALMOCO_JANTA,300.5, 1150.0
                ,"Sei la man.",9, listaIng8
        );
        receita8.setId(id++);

        //Receita 9
        List<Ingrediente> listaIng9 = new ArrayList<>();
        listaIng9.add(new Ingrediente("arroz", "200 g"));
        listaIng9.add(new Ingrediente("açucar", "100 g"));
        Receita receita9 = new Receita("Arroz doce", TipoReceita.DOCE,TipoRefeicao.ALMOCO_JANTA, 300.5,3.99
                ,"Um arroz muito doce.",18, listaIng9
        );
        receita9.setId(id++);

        //Receita 10
        List<Ingrediente> listaIng10 = new ArrayList<>();
        listaIng10.add(new Ingrediente("nescau", "100ml"));
        listaIng10.add(new Ingrediente("açucar", "2 kg"));
        listaIng10.add(new Ingrediente("leite condesado", "10 l"));
        Receita receita10 = new Receita("Toddynho sem gluten", TipoReceita.SEM_GLUTEN,TipoRefeicao.ALMOCO_JANTA, 300.5,476.0
                ,"Não fica muito doce.",18, listaIng10
        );
        receita10.setId(id++);

        listaInicialTeste.add(receita1);
        listaInicialTeste.add(receita2);
        listaInicialTeste.add(receita3);
        listaInicialTeste.add(receita4);
        listaInicialTeste.add(receita5);
        listaInicialTeste.add(receita6);
        listaInicialTeste.add(receita7);
        listaInicialTeste.add(receita8);
        listaInicialTeste.add(receita9);
        listaInicialTeste.add(receita10);
        return listaInicialTeste;
    }

    public static int getId() {
        return id;
    }
}
