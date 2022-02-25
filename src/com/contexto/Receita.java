package com.contexto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Receita {

    private Integer id;
    private String nomeReceita;
    private TipoReceita tipoReceita;
    private final List<Ingrediente> ingredientes;
    private String modoPreparo;
    private Integer tempoPreparo;
    private Double mediaPreco;

    public Receita(){
        ingredientes = new ArrayList<>();
    }
    
    public Receita(String nomeReceita, TipoReceita tipoReceita, String modoPreparo,
    Ingrediente... ingredientes) {
        this.nomeReceita = nomeReceita;
        this.tipoReceita = tipoReceita;
        this.ingredientes = new ArrayList<>();
        this.setIngredientes(ingredientes);
        this.modoPreparo = modoPreparo;
    }

    public Receita(String nomeReceita, TipoReceita tipoReceita, Double mediaPreco,
            String modoPreparo, Integer tempoPreparo,Ingrediente ingrediente) {
        this.nomeReceita = nomeReceita;
        this.tipoReceita = tipoReceita;
        this.ingredientes = new ArrayList<>();
        this.setIngredientes(ingrediente);
        this.modoPreparo = modoPreparo;
        this.tempoPreparo = tempoPreparo;
        this.mediaPreco = mediaPreco;
    }

    public List<Ingrediente> getIngredientes() {
        return Collections.unmodifiableList(this.ingredientes);
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

    public void setIngredientes(Ingrediente... ingredientes) {
        this.ingredientes.addAll(Arrays.asList(ingredientes));
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
        String resultado="";
        List<String> ingredientes = this.getIngredientes().stream()
            .map(ing-> ing.toString())
            .collect(Collectors.toList());
        for (String ing: ingredientes){
            resultado += ing+"\n";
        }
        return resultado;    
    }
    @Override
    public String toString() {

        if ((this.getMediaPreco()==null)||(this.getTempoPreparo()==null)){
            return String.format("%s%nIngredientes:"+
            "%sModo de preparo:%n%s", this.getNomeReceita(),impressaoIngredientes(), 
            this.getModoPreparo());
        }

        return String.format("%s | Tempo de preparo:%d | Média de preço:%.2f%nIngredientes:"+
        "%sModo de preparo:%n%s", this.getNomeReceita(), this.getTempoPreparo(), 
        this.getMediaPreco(),impressaoIngredientes(), this.getModoPreparo());
    }

}
