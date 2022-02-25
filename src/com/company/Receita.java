package com.company;

import java.util.ArrayList;

public class Receita {

    ArrayList<Ingrediente> ingredientes = new ArrayList<>();
    private String modoPreparo;
    private Integer tempoPreparo;
    private Double mediaPreco;

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
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


    @Override
    public String toString() {
        return "Receita{" +
                "ingredientes=" + ingredientes +
                ", modoPreparo='" + modoPreparo + '\'' +
                ", tempoPreparo=" + tempoPreparo +
                ", mediaPreco=" + mediaPreco +
                '}';
    }
}
