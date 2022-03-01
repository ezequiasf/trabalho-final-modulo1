package com.exceptions;

//TODO: Classe para controle de exceções na Tela.
public class OpcaoInvalidaException extends Exception{
    /**
     * Instancia uma nova Opcao invalida exception.
     *
     * @param mensagem A mensagem que se deseja mostrar para o usuário.
     */
    public OpcaoInvalidaException (String mensagem){
        super(mensagem);
    }
}
