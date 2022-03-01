package com.model;

/**
 * Esta classe representa uma entidade Ingrediente.
 */
//TODO: Falar sobre esta entidade de persistência (Funcionaria como uma tabela).
public class Ingrediente {
    private String nome;
    private String quantidade;

    /**
     * Instancia uma nova instância de Ingrediente.
     *
     * @param nome       O nome do ingrediente.
     * @param quantidade A quantidade do ingrediente junto com
     *                  a sua unidade de medida (ml,l,kg..)
     */
    public Ingrediente(String nome, String quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    /**
     * Instancia um novo Ingrediente.
     *
     * @param nome O nome do ingrediente.
     */
    public Ingrediente(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome do ingrediente ou da instância.
     *
     * @return O nome do ingrediente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Faz a inserção ou a alteração do nome do Ingrediente.
     *
     * @param nome O novo nome que se quer colocar.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a quantidade do ingrediente.
     *
     * @return A quantidade no formato qtd + unidade de medida.
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * Insere uma nova quantidade e/ou unidade de medida para o ingrediente.
     *
     * @param quantidade A nova quantidade que se deseja inserir.
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

}
