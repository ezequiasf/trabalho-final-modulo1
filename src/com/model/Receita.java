package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.utils.TipoReceita;
import com.utils.TipoRefeicao;

public class Receita {

    private Integer id;
    private String nomeReceita;
    private TipoReceita tipoReceita;
    private TipoRefeicao tipoRefeicao;
    private List<Ingrediente> ingredientes;
    private String modoPreparo;
    private Integer tempoPreparo;
    private Double mediaPreco;
    private Double calorias;

    public Receita(String nomeReceita, TipoReceita tipoReceita, TipoRefeicao tipoRefeicao, Double calorias, Double mediaPreco,
            String modoPreparo, Integer tempoPreparo,List<Ingrediente> ingrediente) {
        this.nomeReceita = nomeReceita;
        this.tipoReceita = tipoReceita;
        this.tipoRefeicao = tipoRefeicao;
        this.modoPreparo = modoPreparo;
        this.tempoPreparo = tempoPreparo;
        this.mediaPreco = mediaPreco;
        this.calorias = calorias;
        this.ingredientes = new ArrayList<>();
        this.setIngredientes(ingrediente);
    }

    public List<Ingrediente> getIngredientesList(){
        return this.ingredientes;
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

    public TipoRefeicao getTipoRefeicao() {
        return tipoRefeicao;
    }

    public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
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

    public String impressaoIngredientes(){
        String ingResultado = "";
        for (Ingrediente ing: this.ingredientes) {
            ingResultado += "["+ing.getNome()+"/"+ing.getQuantidade()+"] ";
        }
        return ingResultado+"\n";
    }

    @Override
    public String toString() {
        return String.format("Id: %d | Receita: %s | Tempo de preparo: %d min | Média de preço: R$ %.2f%nTipo: %s | Refeição: %s | Calorias: %.2f%n" +
                        "Ingredientes:%n"+ "%sModo de preparo:%n%s%n", this.getId(), this.getNomeReceita(), this.getTempoPreparo(),
        this.getMediaPreco(),this.getTipoReceita().getTipo(), this.getTipoRefeicao().getRefeicao(), getCalorias(), this.impressaoIngredientes(), this.getModoPreparo());
    }

}
