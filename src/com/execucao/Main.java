package com.execucao;

import static com.execucao.carregarReceitas.inserirReceitas;

public class Main {

    public static void main(String[] args) {
	// write your code here

       inserirReceitas().forEach(System.out::println);

    }
}
