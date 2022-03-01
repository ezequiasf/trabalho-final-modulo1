package com.view;

import com.exceptions.OpcaoInvalidaException;
import com.model.Ingrediente;
import com.model.Receita;
import com.utils.*;
import com.controller.OperacoesReceita;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe utilizada como view para a interação com o usuário.
 */
public class Tela {

    private final static Scanner scanner = new Scanner(System.in);
    private final static OperacoesReceita operacoes = new OperacoesReceita();

    /**
     * Neste método ocorre toda a lógica e fluxo da view.
     */
    //TODO: Falar sobre o tratamento de erros.
    public static void telaPrincipal() {
        int respostaInicial = 0;

        do {
            try {
                switch (opcoesIniciais()) {
                    case 1 -> viewListaTodasReceitas();
                    case 2 -> viewCadastro();
                    case 3 -> viewAtualiza();
                    case 4 -> viewDeletar();
                    case 5 -> viewFiltros();
                    case 6 -> viewTuaSaude();
                    case 7 -> {
                        System.out.println("Bon Apetit! Nos vemos na churrascada...");
                        respostaInicial = 7;
                    }
                    default -> throw new OpcaoInvalidaException("Opa! Opção inválida, escolha uma das opções informadas, por gentileza.");
                }
            } catch (InputMismatchException ex) {
                //Unchecked Exception (Não precisaria ser tratada).
                //Caso o que seja digitado não seja número.
                scanner.nextLine(); //Flush
                System.out.println("Aconteceu um erro, abortando operação...");
                respostaInicial = 8;
            } catch (OpcaoInvalidaException ex2) {
                System.out.println(ex2.getMessage());
                respostaInicial = 8;
            }
        } while (respostaInicial != 7);
    }


    private static int opcoesIniciais() throws InputMismatchException {
        viewLogo();
        System.out.println("""
                O que deseja fazer agora?
                [1] - Listar Receitas
                [2] - Cadastrar Receita
                [3] - Modificar uma receita
                [4] - Deletar Receita
                [5] - Filtros de Receita
                [6] - Tua saúde
                [7] - Sair""");
        int resposta = scanner.nextInt();
        scanner.nextLine(); //Flush
        return resposta;
    }

    //View complementar que serve para view de atualizar e deletar.
    private static void viewPersonalizadaId(String descricao) {
        System.out.println("Primeiro informe qual receita deseja " + descricao + " (Informe o Id):");
        operacoes.listarReceitas().forEach(r -> System.out.printf("Id: %d | Receita: %s%n", r.getId(), r.getNomeReceita()));
    }

    private static Receita viewAtualizaECadastra() {
        System.out.println("Qual é o nome da receita?");
        String nomeReceita = scanner.nextLine();

        TipoReceita tipoDaReceita;
        TipoRefeicao tipoRefeicao;
        int tempoReceita;

        try {
            /*Lança um IllegalArgument caso o valor do enum seja inválidoeo método retorna null.
             * O null é tratado no método viewCadastro(Não acontece o cadastro).
             */
            System.out.println("Em qual opção sua receita se encaixa melhor?\n [DIET] | " +
                    "[VEGANA] | [VEGETARIANA] | [SALGADA] | [DOCE] | [SEM_GLUTEN] |" +
                    " [ZERO_LACTOSE]");
            tipoDaReceita = TipoReceita.valueOf(scanner.nextLine().replace(" ", "").toUpperCase());

            System.out.println("Qual é o tipo de refeição?\n [CAFE] | " +
                    "[ALMOCO] | [LANCHE] | [JANTA]");
            String respostaRefeicao = scanner.nextLine();
            if (respostaRefeicao.equalsIgnoreCase("Almoco") || respostaRefeicao.equalsIgnoreCase("Janta")) {
                respostaRefeicao = "ALMOCO_JANTA";
            }
            tipoRefeicao = TipoRefeicao.valueOf(respostaRefeicao.replace(" ", "").toUpperCase());

            /*
                Lança uma OpcaoInvalida caso o tempo seja passado como negativo.
                Também pode lançar um InputMismatch e retornar null.
             */
            System.out.println("Quanto tempo em média leva para fazer? Digite um número em min");
            tempoReceita = scanner.nextInt();
            scanner.nextLine(); //Flush
            if (tempoReceita <= 0) {
                throw new OpcaoInvalidaException("O tempo informado não é válido.");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Esta opção não está listada acima, abortando...");
            return null;
        } catch (InputMismatchException ex2) {
            System.out.println("Opa! isto não é um número, abortando...");
            scanner.nextLine(); //Flush
            return null;
        } catch (OpcaoInvalidaException ex3) {
            System.out.println(ex3.getMessage());
            return null;
        }

        System.out.println("Agora vamos aos ingredientes: Digite no seguinte formato:\n" +
                "nomeIngrediente1,quantidade medida/nomeIngrediente2,quantidade medida/...");
        String ingredientesJuntos = scanner.nextLine();
        List<Ingrediente> listaIngredientes = new ArrayList<>();
        String[] primeiraSeparacao = ingredientesJuntos.replace(" ", "").split("/");
        for (String str : primeiraSeparacao) {
            listaIngredientes.add(new Ingrediente(str.split(",")[0], str.split(",")[1]));
        }

        System.out.println("Quantas calorias tem em média essa refeição?");
        double qtdCalorias = scanner.nextDouble();
        scanner.nextLine(); //Flush

        System.out.println("Ok. Você sabe quanto custa em média? Digite [n], Caso não saiba.");
        String preco = scanner.nextLine();
        double mediaPreco;
        if (!preco.equalsIgnoreCase("n")) {
            try {
                mediaPreco = Double.parseDouble(preco);
            } catch (NumberFormatException nex) {
                mediaPreco = 0.0;
            }
        } else {
            mediaPreco = 0.0;
        }

        System.out.println("Já estamos quase lá. Descreva sucintamente como fazer a receita:");
        String descricao = scanner.nextLine();

        return new Receita(nomeReceita, tipoDaReceita, tipoRefeicao, qtdCalorias, mediaPreco, descricao
                , tempoReceita, listaIngredientes);
    }

    private static void viewListaTodasReceitas() {
        operacoes.listarReceitas().forEach(System.out::println);
    }

    private static void viewCadastro() {
        /*
            Se passar null como parâmetro no cadastrarReceita
            nada acontece e o fluxo da view volta.
         */
        if (operacoes.cadastrarReceita(viewAtualizaECadastra())) {
            System.out.println("Ufa! Você já pode ver sua receita na lista ;)");
        }
    }

    /*
        Este método está sendo tratado na TelaPrincipal.
     */
    private static void viewAtualiza() throws InputMismatchException {
        viewPersonalizadaId("atualizar");
        int receita = scanner.nextInt(); // -> Throws InputMismatchException
        scanner.nextLine(); //Flush

        /*
            Se o número passado pelo usuário não estiver no limite permitido o método
            não atualiza.
            Caso o método viewAtualizaECadastra retornar um null a lista também não é
            atualizada.
         */
        if (!((receita > operacoes.listarReceitas().size() - 1) || (receita < 0))) {
            if (operacoes.atualizarReceita(receita, viewAtualizaECadastra())) {
                System.out.println("Atualizado com sucesso!");
            } else {
                System.out.println("Não foi possível atualizar.");
            }
        } else {
            System.out.println("Não existe esta receita no banco de dados.");
        }
    }

    private static void viewDeletar() throws InputMismatchException {
        viewPersonalizadaId("remover");
        int resposta = scanner.nextInt();
        scanner.nextLine(); //Flush
        /*
            Se o número passado pelo usuário não estiver no limite permitido o método
            não atualiza.
         */
        if (!((resposta > operacoes.listarReceitas().size() - 1) || (resposta < 0))) {
            operacoes.removeReceita(resposta);
            System.out.println("Receita apagada! X_X");
        } else {
            System.out.println("Não existe esta receita no banco de dados.");
        }
    }

    private static void viewFiltros() throws InputMismatchException, OpcaoInvalidaException {
        System.out.print("""
                Como você gostaria de pesquisar as receitas?
                [1] - Ingredientes
                [2] - Tempo de preparo
                [3] - Preço
                [4] - Tipo de receita
                """);
        int resposta = scanner.nextInt();
        scanner.nextLine(); //Flush

        switch (resposta) {
            case 1 -> {
                System.out.println("Digite os ingredientes que você tem no seguinte formato:" +
                        "ing1,ing2,ing3..");
                String[] ingredientes = scanner.nextLine().split(",");
                /*
                    Se o array tiver apenas um ingrediente, o método apenas usa o primeiro elemento.
                 */
                if (ingredientes.length == 1) {
                    BuscaReceita.filtroLista(ingredientes[0], operacoes.listarReceitas()).forEach(System.out::println);
                } else if (ingredientes.length > 1) {
                    BuscaReceita.filtroLista(operacoes.listarReceitas(), ingredientes).forEach(System.out::println);
                } else {
                    resposta = -1;
                }
            }
            case 2 -> {
                /*
                    Pode lançar uma InputMismatch (Tratado no método TelaPrincipal)
                 */
                System.out.println("Quanto tempo você tem para preparar a receita? (Em minutos)");
                int tempoReceita = scanner.nextInt();
                if (tempoReceita <= 0) {
                    throw new OpcaoInvalidaException("Este tempo não é válido");
                }
                BuscaReceita.filtroLista(tempoReceita, operacoes.listarReceitas()).forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Escolha uma forma de filtro > [1] - Limite de preço |" +
                        " [2] - Da receita barata para mais cara | [3] - Da cara para mais barata");
                switch (scanner.nextInt()) {
                    case 1 -> {
                        System.out.println("Até quanto você pode gastar?");
                        BuscaReceita.filtroLista(scanner.nextDouble(), operacoes.listarReceitas()).forEach(System.out::println);
                    }
                    case 2 -> BuscaReceita.listaPrecos(-1, operacoes.listarReceitas()).forEach(System.out::println);
                    case 3 -> BuscaReceita.listaPrecos(1, operacoes.listarReceitas()).forEach(System.out::println);
                    default -> throw new OpcaoInvalidaException("Opção inválida de filtro de preços...");
                }
            }
            case 4 -> {
                System.out.println("Em qual opção sua receita se encaixa melhor?\n [DIET] | " +
                        "[VEGANA] | [VEGETARIANA] | [SALGADA] | [DOCE] | [SEM_GLUTEN] |" +
                        " [ZERO_LACTOSE]");
                try {
                    BuscaReceita.filtroLista(TipoReceita.valueOf(scanner.nextLine().replace(" ", "")
                                    .toUpperCase()), operacoes.listarReceitas())
                            .forEach(System.out::println);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Aconteceu um erro, abortando...");
                    resposta = 5;
                }
            }
            default -> throw new OpcaoInvalidaException("Não existe esta opção, abortando...");
        }
        if ((resposta <= 4) && (resposta > 0)) {
            System.out.println("Aqui estão as opções filtradas! ;)");
        }
    }

    private static void viewTuaSaude() throws InputMismatchException {
        System.out.println("A partir desta funcionalidade,você poderá escolher uma dieta adequada" +
                " as suas necessidades :)");
        System.out.println("Vamos as informações necessárias:");

        System.out.println("Qual é o seu sexo? [M] | [F]");
        String sexo = scanner.nextLine();

        /*
            Pode lançar uma InputMismatch. Será tratado no método TelaPrincipal.
         */
        System.out.println("Qual é a sua idade?");
        int idade = scanner.nextInt();

        /*
            Pode lançar uma InputMismatch. Será tratado no método TelaPrincipal.
         */
        System.out.println("Agora digite o seu peso:");
        double peso = scanner.nextDouble();

        /*
            Pode lançar uma InputMismatch. Será tratado no método TelaPrincipal.
         */
        System.out.println("ok, informe sua altura:");
        double altura = scanner.nextDouble();

        /*
            Pode lançar uma InputMismatch. Será tratado no método TelaPrincipal.
         */
        System.out.println("Você costuma fazer atividades físicas? 1 - [Sim] / 2 - [Não]");
        int respostaAtvFisica = scanner.nextInt();
        scanner.nextLine(); //Flush
        double calorias;
        if (respostaAtvFisica == 1) {
            System.out.println("Como costuma ser a ocorrência das atividades? 1 - [LEVE] | 2 - " +
                    "[MODERADA] | 3 - [INTENSO]");
            String ocorrenciaAtividades = scanner.nextLine();
            CalculoEnergeticoAtividade calculoEnergeticoAtv = new CalculoEnergeticoAtividade(ocorrenciaAtividades);
            calorias = calculoEnergeticoAtv.calculoGastoEnergetico(altura, peso, sexo, idade);
        } else {
            CalculoEnergetico calculoEnergetico = new CalculoEnergetico();
            calorias = calculoEnergetico.calculoGastoEnergetico(altura, peso, sexo, idade);
        }
        System.out.println("Você deseja visualizar uma lista ou um " +
                "cardápio do dia personalizado? 1 - Lista / 2 - Cardápio do dia");
        int respostaCardapio = scanner.nextInt();
        if (respostaCardapio == 1) {
            System.out.println("===================== Opções de Café =======================");
            BuscaReceita.filtroLancheCafe(operacoes.listarReceitas(), calorias, 1).forEach(System.out::println);
            System.out.println("===================== Opções de Refeição (Almoço e Janta) =======================");
            BuscaReceita.filtroAlmoco(operacoes.listarReceitas(), calorias).forEach(System.out::println);
            System.out.println("===================== Opções de Lanche =======================");
            BuscaReceita.filtroLancheCafe(operacoes.listarReceitas(), calorias, -1).forEach(System.out::println);
        } else {
            System.out.println("================ Cardápio do dia ======================");
            List<Receita> cardapio = BuscaReceita.cardapioDoDia(operacoes.listarReceitas(), calorias);
            /*
                Caso o método cardapioDoDia retorne uma lista com elementos nulos
                é tratada a NullPointer.
             */
            System.out.println("********* Café da manha *********");
            if (cardapio.get(0) != null) {
                System.out.println(cardapio.get(0));
            } else {
                System.out.println("Desculpe, não temos opções no momento!");
            }
            System.out.println("********* Almoço *********");
            if (cardapio.get(1) != null) {
                System.out.println(cardapio.get(1));
            } else {
                System.out.println("Desculpe, não temos opções no momento!");
            }
            System.out.println("********* Lanche *********");
            if (cardapio.get(2) != null) {
                System.out.println(cardapio.get(2));
            } else {
                System.out.println("Desculpe, não temos opções no momento!");
            }
            System.out.println("********* Janta *********");
            if (cardapio.get(3) != null) {
                System.out.println(cardapio.get(3));
            } else {
                System.out.println("Desculpe, não temos opções no momento!");
            }
            System.out.println("Total de calorias do cardápio:: "
                    + BuscaReceita.
                    totalCalorias(BuscaReceita.cardapioDoDia(operacoes.listarReceitas(), calorias))
                    +"\nVocê deve consumir em média:: "+calorias);
        }
    }

    private static void viewLogo() {
        System.out.printf("""
                ************************************************************%nO que dá para fazer? - Receitas \u00A9 By Ezequias B., Pablo K.%n************************************************************

                """);
    }

}
