package com.contexto;
import com.dao.OperacoesReceita;

import java.util.List;

public class Usuario {

    private Integer id;
    private String nome;
    private List<Receita> receitas;

    public Usuario( String nome){

        this.nome = nome;
    }


//    public void atribuirReceita(id){
//        receitas = getReceitas(id);
//
//    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", receitas=" + receitas +
                '}';
    }
}
