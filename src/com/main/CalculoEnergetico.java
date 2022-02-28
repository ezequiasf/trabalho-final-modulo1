package com.main;

import com.utils.Calculo;

public class CalculoEnergetico implements Calculo {

    @Override
    public Double calculoGastoEnergetico(Double altura, Double peso, Character sexo, int idade) {
        Double multiplicador = 0.0;
        Double numero = 0.0;
        if (idade < 3) {
                if(sexo.toString().equalsIgnoreCase("M")){
                    multiplicador = 59.512;
                    numero = -30.4;
                }else if(sexo.toString().equalsIgnoreCase("F")) {
                multiplicador = 58.317;
                numero = 31.1;
                }
        }
        if (idade > 3 && idade <10) {
            if(sexo.toString().equalsIgnoreCase("M")){
                multiplicador = 22.706;
                numero = 504.3;
            }else if(sexo.toString().equalsIgnoreCase("F")) {
                multiplicador = 20.315;
                numero = 485.9;
            }
        }
        if (idade > 10 && idade <17) {
            if(sexo.toString().equalsIgnoreCase("M")){
                multiplicador = 17.686;
                numero = 658.2;
            }else if(sexo.toString().equalsIgnoreCase("F")) {
                multiplicador = 13.384;
                numero = 692.6;
            }
        }

        if (idade > 18 && idade <30) {
            if(sexo.toString().equalsIgnoreCase("M")){
                multiplicador = 15.057;
                numero = 692.2;
            }else if(sexo.toString().equalsIgnoreCase("F")) {
                multiplicador = 14.818;
                numero = 486.6;
            }
        }
        if (idade > 30 && idade <60) {
            if(sexo.toString().equalsIgnoreCase("M")){
                multiplicador = 11.472;
                numero = 873.1;
            }else if(sexo.toString().equalsIgnoreCase("F")) {
                multiplicador = 8.126;
                numero = 845.6;
            }
        }
        if (idade > 60) {
            if(sexo.toString().equalsIgnoreCase("M")){
                multiplicador = 11.711;
                numero = 587.7;
            }else if(sexo.toString().equalsIgnoreCase("F")) {
                multiplicador = 9.082;
                numero = 658.5;
            }
        }
        return  (multiplicador * peso) + numero;
    }

        }
