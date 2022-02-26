package com.model;

import java.util.ArrayList;
import java.util.List;

public class Receita {

    private Integer id;
    private String nomeReceita;
    private TipoReceita tipoReceita;
    private List<Ingrediente> ingredientes;
    private String modoPreparo;
    private Integer tempoPreparo;
    private Double mediaPreco;

    public Receita(String nomeReceita, TipoReceita tipoReceita, Double mediaPreco,
            String modoPreparo, Integer tempoPreparo,List<Ingrediente> ingrediente) {
        this.nomeReceita = nomeReceita;
        this.tipoReceita = tipoReceita;
        this.modoPreparo = modoPreparo;
        this.tempoPreparo = tempoPreparo;
        this.mediaPreco = mediaPreco;
        this.ingredientes = new ArrayList<>();
        this.setIngredientes(ingrediente);
    }

    public List<Ingrediente> getIngredientesList(){
        return this.ingredientes;
    }

    public String getIngredientes() {
        String ingResultado = "";
        for (Ingrediente ing: this.ingredientes) {
            ingResultado += "["+ing.getNome()+"/"+ing.getQuantidade()+"] ";
        }
        return ingResultado+"\n";
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Double getMediaPreco() {
        return mediaPreco;
    }

    public void setMediaPreco(Double mediaPreco) {
        this.mediaPreco = mediaPreco;
    }

    private String impressaoIngredientes(){
        return this.getIngredientes();

    }
    @Override
    public String toString() {
        return String.format("Id: %d | Receita: %s | Tempo de preparo: %d min | Média de preço: R$ %.2f%n" +
                        "Ingredientes:%n"+ "%sModo de preparo:%n%s%n", this.getId(), this.getNomeReceita(), this.getTempoPreparo(),
        this.getMediaPreco(),impressaoIngredientes(), this.getModoPreparo());
    }

}
