package com.view;

import com.model.Ingrediente;
import com.model.Receita;
import com.model.TipoReceita;
import com.controller.OperacoesReceita;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tela {

    //TODO:
    // * Validação de respostas (Exceptions) Criar um método para validação.

    static Scanner sc = new Scanner(System.in);
    static OperacoesReceita op = new OperacoesReceita();

    public static void telaPrincipal (){
        int resposta = 0;

        System.out.printf("************************************************************%n" +
                "O que dá para fazer? - Receitas \u00A9 By Ezequias B., Pablo K.%n" +
                "************************************************************\n\n");
        do{
            switch (opcoes()){
                case 1:
                    viewLista();
                    break;
                case 2:
                    viewCadastro();
                    break;
                case 3:
                    viewAtualiza();
                    break;
                case 4:
                    viewDeletar();
                    break;
                case 5:
                    viewFiltros();
                    break;
                case 6:
                    System.out.println("Bon Apetit! Nos vemos na churrascada...");
                    resposta = 6;
            }
        }while(resposta!=6);

    }

    private static int opcoes ()  {
        System.out.println("O que deseja fazer agora?\n[1] - Listar Receitas\n[2] - Cadastrar Receita\n" +
                "[3] - Modificar uma receita\n[4] - Deletar Receita\n[5] - Filtros de Receita\n" +
                "[6] - Sair");
        int resposta = sc.nextInt();
        sc.nextLine(); //Flush
        return resposta;
    }

    private static void viewIdReceita (String descricao){
        System.out.println("Primeiro informe qual receita deseja "+descricao+" (Informe o Id):");
        op.listaReceita().forEach(r-> System.out.printf("Id: %d | Receita: %s%n",r.getId(),r.getNomeReceita()));
    }

    private static Receita viewAtualizaCadastra(){
        System.out.println("Qual é o nome da receita?");
        String nomeReceita = sc.nextLine();

        System.out.println("Em qual opção sua receita se encaixa melhor?\n [DIET] | " +
                "[VEGANA] | [VEGETARIANA] | [SALGADA] | [DOCE] | [SEM_GLUTEN] |" +
                " [ZERO_LACTOSE]");
        TipoReceita tr = TipoReceita.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Quanto tempo em média leva para fazer? Digite um número em min");
        int tempo = sc.nextInt();
        sc.nextLine(); //Flush

        System.out.println("Agora vamos aos ingredientes: Digite no seguinte formato:\n" +
                "nomeIngrediente1,quantidade medida/nomeIngrediente2,quantidade medida/...");
        String ingredientes = sc.nextLine();
        List<Ingrediente> listaIngredientes = new ArrayList<>();
        String[] primeiraSeparacao = ingredientes.split("/");
        for (String str: primeiraSeparacao){
            listaIngredientes.add(new Ingrediente(str.split(",")[0],str.split(",")[1]));
        }

        System.out.println("Ok. Você sabe quanto custa em média? Digite [n], Caso não saiba.");
        String preco = sc.nextLine();
        double mediaPreco;
        if (!preco.equalsIgnoreCase("n")){
            try{
                mediaPreco = Double.valueOf(preco);
            }catch(NumberFormatException nex){
                mediaPreco = 0.0;
            }
        }else{
            mediaPreco = 0.0;
        }

        System.out.println("Já estamos quase lá. Descreva sucintamente como fazer a receita:");
        String descricao = sc.nextLine();

        return new Receita(nomeReceita,tr,mediaPreco,descricao
                ,tempo,listaIngredientes);
    }

    private static void viewLista (){
        op.listaReceita().forEach(System.out::println);
    }

    private static void viewCadastro (){
        op.cadastrarReceita(viewAtualizaCadastra());
        System.out.println("Ufa! Você já pode ver sua receita na lista ;)");
    }

    private static void viewAtualiza (){
        viewIdReceita("atualizar");
        int receita = sc.nextInt();
        sc.nextLine(); //Flush
        op.atualizarReceita(receita,viewAtualizaCadastra());
        System.out.println("Atualizado com sucesso!");
    }

    private static void viewDeletar (){
        viewIdReceita("remover");
        int resposta = sc.nextInt();
        sc.nextLine(); //Flush
        op.removeReceita(resposta);
        System.out.println("Receita apagada! X_X");
    }

    private static void viewFiltros (){
        //chamar classe Busca filtros e apresentar uma view



    }
}
