package com.execucao;

import javax.sound.sampled.SourceDataLine;

import com.contexto.Ingrediente;
import com.contexto.TipoReceita;
import com.dao.OperacoesReceita;

public class Main {

    public static void main(String[] args) {
      OperacoesReceita operacao = new OperacoesReceita();
    //  operacao.listaReceita().forEach(System.out::println);
      //  System.out.println("=================================================");
    
      operacao.cadastrarReceita("nomeReceita", TipoReceita.DIET, "modoPreparo", 12.0, 67, new Ingrediente("nome", "12quantidade"));
     
     
      operacao.atualizarReceita(10, "acarajé", TipoReceita.DOCE, "qualquer",5.6, 12, new Ingrediente("nome", "12quantidade"));
      operacao.listaReceita().forEach(System.out::println);

         operacao.removeReceita(10);
     
        operacao.listaReceita().forEach(System.out::println);
       
    }
}
