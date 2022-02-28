package com.main;

import com.utils.Calculo;

public class CalculoEnergetico implements Calculo {



    Double peso;
    int idade;
    Double altura;
    int sexo;

    public CalculoEnergetico(Double peso, Double altura, int sexo) {
        this.peso = peso;
        this.idade = idade;
    }



    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }


    @Override
    public Double calculoGastoEnergetico(Double altura, Double peso, int sexo) {
        if(idade < 3 && sexo == 1){

        }


    }
}
