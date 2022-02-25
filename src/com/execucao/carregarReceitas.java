package com.execucao;

import com.contexto.Ingrediente;
import com.contexto.Receita;
import com.contexto.TipoReceita;

import java.util.ArrayList;
import java.util.List;

public class carregarReceitas {


    public static List<Receita> inserirReceitas (){
    int i = 0;
    List<Receita> receitas = new ArrayList();

    Receita receita1 = new Receita(i++,"pao", TipoReceita.SALGADA, "cozinhar",
            new Ingrediente("ovo", "2"),
            new Ingrediente("farinha","1 kg"),
            new Ingrediente("agua"," 200ml")
            );
        Receita receita2 = new Receita(i++,"pao", TipoReceita.DOCE, "cozinhar",
                new Ingrediente("ovo2doce", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita3 = new Receita(i++,"pao", TipoReceita.DIET, "cozinhar",
                new Ingrediente("ovodiete", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita4 = new Receita(i++,"pao", TipoReceita.VEGANA, "cozinhar",
                new Ingrediente("ovovegano", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita5 = new Receita(i++,"pao", TipoReceita.SEM_GLUTEN, "cozinhar",
                new Ingrediente("ovosemgluten", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita6 = new Receita(i++,"pao", TipoReceita.ZERO_LACTOSE, "cozinhar",
                new Ingrediente("ovozero", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita7 = new Receita(i++,"pao", TipoReceita.SALGADA, "cozinhar",
                new Ingrediente("ovosalgado", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita8 = new Receita(i++,"pao", TipoReceita.SALGADA, "cozinhar",
                new Ingrediente("ovo3", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita9 = new Receita(i++,"pao", TipoReceita.SALGADA, "cozinhar",
                new Ingrediente("ovo3", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        Receita receita10 = new Receita(i++,"pao", TipoReceita.SALGADA, "cozinhar",
                new Ingrediente("ovo3", "2"),
                new Ingrediente("farinha","1 kg"),
                new Ingrediente("agua"," 200ml")
        );
        receitas.add(receita1);
        receitas.add(receita2);
        receitas.add(receita3);
        receitas.add(receita4);
        receitas.add(receita5);
        receitas.add(receita6);
        receitas.add(receita7);
        receitas.add(receita8);
        receitas.add(receita9);
        receitas.add(receita10);

        return receitas;

    }


    //(Integer id, String nomeReceita, TipoReceita tipoReceita, String modoPreparo,
    //    Ingrediente... ingredientes)
}
