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
        listaIng1.add(new Ingrediente("macarrão", "500gr"));
        listaIng1.add(new Ingrediente(" linguiça calabresa picada", "2 un"));
        listaIng1.add(new Ingrediente("cebola", "1 un"));
        listaIng1.add(new Ingrediente("alho", "1 un"));
        listaIng1.add(new Ingrediente("bacon", "150gr"));
        listaIng1.add(new Ingrediente("molho pronto", "2 un"));
        listaIng1.add(new Ingrediente("creme de leite", "1 un"));
        listaIng1.add(new Ingrediente("sal", "a gosto"));
        listaIng1.add(new Ingrediente("orégano", "a gosto"));

        Receita receita1 = new Receita("Macarrão de Panela de Pressão ", TipoReceita.SALGADA, TipoRefeicao.ALMOCO_JANTA, 283.25 ,10.0
                ,"    Numa panela de pressão coloque o bacon e frite bem, junte e linguiça calabresa e deixe fritar também.\n" +
                "    Adicione o alho e depois a cebola, refogue bem. Junte o cheiro-verde, a pimenta-do-reino e o orégano, mexa.\n" +
                "    Junte o caldo de carne, o molho de tomate, o creme de leite e um pouco de água, misture bem e acerte o sal. Coloque o macarrão cru e cubra com água (até que cubra e passe 1 cm aproximadamente) e misture bem.\n" +
                "    Feche a panela de pressão. Conte 3 minutos após pegar pressão. Desligue o fogo, deixe sair a pressão, abra e mexa bem.\n" +
                "Se for necessário, deixe mais um pouco no fogo para secar, mas lembre que conforme ele esfria, ele seca naturalmente.\n" +
                " Sirva com queijo ralado de sua preferência.",10, listaIng1 );
        receita1.setId(id++);

        //Receita 2
        List<Ingrediente> listaIng2 = new ArrayList<>();
        listaIng2.add(new Ingrediente("farinha de trigo", "2 copos"));
        listaIng2.add(new Ingrediente("leite", "1 e 1/2 copo"));
        listaIng2.add(new Ingrediente("óleo de soja", "1/2 copo"));
        listaIng2.add(new Ingrediente("fermento em pó", "1/2 copo"));
        listaIng2.add(new Ingrediente("ovo", "2 un"));
        listaIng2.add(new Ingrediente("sal", "a gosto"));
        listaIng2.add(new Ingrediente("quejo", "a gosto"));
        listaIng2.add(new Ingrediente("orégano", "a gosto"));
        listaIng2.add(new Ingrediente("tomate", "2 un"));

        Receita receita2 = new Receita("Pizza rápida", TipoReceita.SALGADA, TipoRefeicao.ALMOCO_JANTA, 396.57,13.50
                ,"    Bata todos os ingredientes no liquidificador.\n" +
                "    Unte a forma com manteiga e farinha e coloque metade da massa.\n" +
                "    Acrescente o recheio.\n" +
                "    Coloque o restante da massa por cima.\n" +
                "    Espalhe bem, a camada de massa por ser mole, fica fina, mas a massa cresce.\n" +
                "    Polvilhe queijo parmesão e orégano.\n" +
                "    Coloque para assar em forno preaquecido por 30 minutos ou até que doure.",40, listaIng2
        );
        receita2.setId(id++);

        //Receita 3
        List<Ingrediente> listaIng3 = new ArrayList<>();
        listaIng3.add(new Ingrediente("ovo", "2 un"));
        listaIng3.add(new Ingrediente("tomate", "metade"));
        listaIng3.add(new Ingrediente("cebola", "metade"));
        listaIng3.add(new Ingrediente("salsa", "a gosto"));
        listaIng3.add(new Ingrediente("cebola", "metade"));
        Receita receita3 = new Receita("Omelete verde", TipoReceita.SALGADA, TipoRefeicao.LANCHE,170.0,5.75
                ,"Hum hum brigadeirinho.",10, listaIng3
        );
        receita3.setId(id++);

        //Receita 4
        List<Ingrediente> listaIng4 = new ArrayList<>();
        listaIng4.add(new Ingrediente("carne para bife", "1 kg"));
        listaIng4.add(new Ingrediente("alho", "3 dentes"));
        listaIng4.add(new Ingrediente("sal", "a gosto"));
        listaIng4.add(new Ingrediente("ovo", "1 un"));
        listaIng4.add(new Ingrediente("farinha de rosca", "300 gr"));
        listaIng4.add(new Ingrediente("óleo de soja", "300 gr"));
        listaIng4.add(new Ingrediente("cebola", "1 un"));
        listaIng4.add(new Ingrediente("molho de tomate", "1 un"));
        Receita receita4 = new Receita("Bife à parmegiana", TipoReceita.SALGADA, TipoRefeicao.ALMOCO_JANTA,650.0,30.0
                ,"Tempere os bifes com alho e sal e reserve.\n" +
                "\n" +
                "Bata o ovo inteiro e passe os bifes pelo ovo e pela farinha de rosca.\n" +
                "\n" +
                "Aqueça em uma frigideira o óleo e frite os bifes, escorra-os em papel-toalha e vá dispondo em um refratário.",90, listaIng4
        );
        receita4.setId(id++);

        //Receita 5
        List<Ingrediente> listaIng5 = new ArrayList<>();
        listaIng5.add(new Ingrediente("tapioca", "100 gr"));
        listaIng5.add(new Ingrediente("sal", "a gosto"));
        listaIng5.add(new Ingrediente("ovo", "2 un"));
        Receita receita5 = new Receita("Tapioca com ovo", TipoReceita.SALGADA,TipoRefeicao.CAFE, 200.0,4.0
                ,"    Em uma peneira fina, peneire toda a goma.\n" +
                "    Quando a massa estiver peneirada, coloque o sal a gosto.\n" +
                "    Em uma frigideira antiaderente, coloque a massa no fogo médio e espere esquentar.\n" +
                "    Faça as tapiocas e coloque a manteiga nela quentinha.\n" +
                "    Em seguida, frite os ovos, coloque-os dentro da tapioca e feche.",10, listaIng5
        );
        receita5.setId(id++);

        //Receita 6
        List<Ingrediente> listaIng6 = new ArrayList<>();
        listaIng6.add(new Ingrediente("pão de forma", "1 fatia"));
        listaIng6.add(new Ingrediente("manteiga", "1 colher"));
        listaIng6.add(new Ingrediente("orégano", "1 un"));
        listaIng6.add(new Ingrediente("ovo", "350g"));
        Receita receita6 = new Receita("Sanduíche de ovo especial ", TipoReceita.SALGADA, TipoRefeicao.LANCHE,190.5,2.0
                ,"No centro do pão, faça um buraco com forma de empadinha ou algo do tamanho.\n" +
                "    Em uma frigideira pequena, ponha a manteiga e deixe derreter, espalhando-a por toda frigideira.\n" +
                "    Coloque a fatia de pão com o buraco.\n" +
                "    Logo em seguida, ponha o ovo no buraco com sal e orégano.\n" +
                "    Depois de algum tempo, verifique se o ovo está em consistência firme na parte debaixo do pão, vire.\n" +
                "    Após o lado a ser virado estar em consistência firme, o sanduíche estará pronto.",15, listaIng6
        );
        receita6.setId(id++);

        //Receita 7
        List<Ingrediente> listaIng7 = new ArrayList<>();
        listaIng7.add(new Ingrediente("ovo", "2 un"));
        listaIng7.add(new Ingrediente("sal", "a gosto"));
        listaIng7.add(new Ingrediente("oléo de soja", "1 colher"));
        Receita receita7 = new Receita("Delícia de tomovo", TipoReceita.SALGADA,TipoRefeicao.ALMOCO_JANTA, 230.5,15.0
                ,"    Lave bem os tomates.\n" +
                "    Seque-os e corte a parte superior. Com auxílio de uma colher, vá retirando todas sementes deixando-os ocos.\n" +
                "    Passe sal por dentro de cada tomate e coloque-os em um pirex untado com azeite. Quebre os ovos e coloque com cuidado um em cada tomate.\n" +
                "    Cubra o pirex com papel alumínio e leve ao forno médio por uns 15 minutos.\n" +
                "    Retire o papel alumínio e, se necessário for, deixe mais alguns minutos até que o ovo fique no cozimento desejado.\n" +
                "    Sirva quente.",30, listaIng7
        );
        receita7.setId(id++);

        //Receita 8
        List<Ingrediente> listaIng8 = new ArrayList<>();
        listaIng8.add(new Ingrediente("ovo", "1 un"));
        listaIng8.add(new Ingrediente("manteiga", "1 colher"));
        listaIng8.add(new Ingrediente("açucar", "100 g"));
        listaIng8.add(new Ingrediente("fermento", "1 colher"));
        listaIng8.add(new Ingrediente("leite", "1 xicara"));
        Receita receita8 = new Receita("Bolo de um ovo só", TipoReceita.DOCE,TipoRefeicao.LANCHE,300.0, 15.0
                ," Bata a manteiga com o açucar,acresecnte o leite e a farinha peneirada com fermento.\n" +
                "    Adicione a clara batida em neve e a gema.\n" +
                "    Leve ao forno quente em forma untada com manteiga, por cerca de 40 minutos, ou até dourar.\n" +
                "\n",9, listaIng8
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
        listaIng10.add(new Ingrediente("leite", "100ml"));
        listaIng10.add(new Ingrediente("sal", "1 pitada"));
        listaIng10.add(new Ingrediente("óleo", "1 colher"));
        Receita receita10 = new Receita("Maionese com ovo cozido ", TipoReceita.SEM_GLUTEN,TipoRefeicao.ALMOCO_JANTA, 200.5,8.0
                ,"    Bata todos os ingredientes, menos o óleo, no liquidificador.\n" +
                "\n" +
                "    Vá acrescentando o óleo até dar ponto de patê.",18, listaIng10
        );
        receita10.setId(id++);

        //Receita 11
        List<Ingrediente> listaIng11 = new ArrayList<>();
        listaIng11.add(new Ingrediente("leite", "100ml"));
        listaIng11.add(new Ingrediente("sal", "1 pitada"));
        listaIng11.add(new Ingrediente("óleo", "1 colher"));
        listaIng11.add(new Ingrediente("alho", "1 un"));
        Receita receita11 = new Receita("Maionese", TipoReceita.SEM_GLUTEN,TipoRefeicao.ALMOCO_JANTA, 500.5,9.0
                ,"    Bata todos os ingredientes, menos o óleo, no liquidificador.\n" +
                "\n" +
                "    Vá acrescentando o óleo até dar ponto de patê.",18, listaIng11
        );
        receita11.setId(id++);

        //Receita 12
        List<Ingrediente> listaIng12 = new ArrayList<>();
        listaIng12.add(new Ingrediente("leite", "100ml"));
        listaIng12.add(new Ingrediente("farinha", "400gr"));
        listaIng12.add(new Ingrediente("açúcar", "1 xicara"));
        listaIng12.add(new Ingrediente("óleo", "1 colher"));

        Receita receita12 = new Receita("Bolinho de chuva sem ovo", TipoReceita.SEM_GLUTEN,TipoRefeicao.LANCHE, 340.0,9.0
                ," Coloque a farinha de trigo em uma vasilha acrescente o açúcar, fermento e o leite (ou água), misture de uma maneira que a massa não fique tão molenga e nem tão dura.\n" +
                "\n" +
                "    Para fritar, aqueça o óleo quando estiver quente pegue colheradas e coloque na panela abaixe o fogo para não ficar cru.\n" +
                "\n" +
                "    Depois de dourado, coloque em papel toalha para secar.\n" +
                "\n" +
                "    Para polvilhar, misture o açúcar e a canela.\n" +
                "\n" +
                "    Arrume os bolinhos e polvilhe.",18, listaIng12
        );
        receita12.setId(id++);

        //Receita 13
        List<Ingrediente> listaIng13 = new ArrayList<>();
        listaIng13.add(new Ingrediente("arroz", "100ml"));
        listaIng13.add(new Ingrediente("ovo", "2 un"));
        listaIng13.add(new Ingrediente("queijo", "1 xicara"));
        listaIng13.add(new Ingrediente("óleo", "1 colher"));

        Receita receita13 = new Receita("Bolinho de chuva sem ovo", TipoReceita.SEM_GLUTEN,TipoRefeicao.LANCHE, 360.0,9.0
                ,"     Corte em cubinhos o queijo e o presunto.\n" +
                "    coloque em um pirex o arroz com o tempero e dois copos d`água e leve ao microondas em potência alta por 9 minutos.\n" +
                "    Após 9 minutos coloque a lata de seleta de legumes , queijo e presunto em cubinhos, mexa bem e mais 3 minutos em potência alta.",18, listaIng13
        );
        receita13.setId(id++);

        //Receita 14
        List<Ingrediente> listaIng14 = new ArrayList<>();
        listaIng14.add(new Ingrediente("peixe", "500g"));
        listaIng14.add(new Ingrediente("molho de tomate", "1 un"));
        listaIng14.add(new Ingrediente("requeijão", "1 pote"));
        listaIng14.add(new Ingrediente("queijo ralado", "50 gr"));

        Receita receita14 = new Receita("Bolinho de chuva sem ovo", TipoReceita.SEM_GLUTEN,TipoRefeicao.LANCHE, 390.0,18.0
                ,"    Tempere o peixe com alho e limão, coloque - os num refratário.\n" +
                "    Coloque o requeijão.\n" +
                "    Em cima do requeijão, adicione o molho de tomate e salpique o queijo ralado.\n" +
                "    Leve ao forno em temperatura média.",18, listaIng14
        );
        receita14.setId(id++);

        //Receita 15
        List<Ingrediente> listaIng15 = new ArrayList<>();
        listaIng15.add(new Ingrediente("salsicha", "6 un"));
        listaIng15.add(new Ingrediente("pão", "3 un"));
        listaIng15.add(new Ingrediente("batata palha", "100 gr"));
        listaIng15.add(new Ingrediente("queijo ralado", "50 gr"));

        Receita receita15 = new Receita("Bolinho de chuva sem ovo", TipoReceita.SEM_GLUTEN,TipoRefeicao.LANCHE, 390.0,18.0
                ,"    ferva a salsicha, para retirar um pouco do corante e de substâncias que interferem no sabor.\n" +
                "Depois de fervida, pique em rodelinhas pequenas e reserve.\n" +
                "Depois de pronto, pode ser servido em pão francês, pão de cachorro quente, ou pode servir como mistura , acompanhado de batata palha.",18, listaIng15
        );
        receita15.setId(id++);




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
