package com.test;

import com.utils.CalculoEnergeticoAtividade;
import org.junit.Assert;
import org.junit.Test;


public class TC_CalculoEnergeticoAtividade {

    @Test
    public void testarCalculoEnergeticoAtividadeLeve() {
        CalculoEnergeticoAtividade calculoEnergeticoAtividade = new CalculoEnergeticoAtividade("leve");
        Double calorias =
                calculoEnergeticoAtividade.calculoGastoEnergetico(1.70, 85.0, "M", 35);
        //Assegurar que o método calcula de maneira correta as calorias de acordo com a fórmula da OMS.
        Assert.assertEquals(2864.741, calorias,0.0);
    }

    @Test
    public void testarCalculoEnergeticoAtividadeModerada() {
        CalculoEnergeticoAtividade calculoEnergeticoAtividade = new CalculoEnergeticoAtividade("moderada");
        Double calorias =
                calculoEnergeticoAtividade.calculoGastoEnergetico(1.85, 97.5, "F", 24);
        /*
           Assegurar que o método calcula de maneira correta as calorias de acordo com a fórmula da OMS.
            Neste caso, colocamos uma variação de erro em 0.1.
         */
        Assert.assertEquals(3573.0, calorias,0.1);
    }

    @Test
    public void testarCalculoEnergeticoAtividadeIntensa() {
        CalculoEnergeticoAtividade calculoEnergeticoAtividade = new CalculoEnergeticoAtividade("intensa");
        Double calorias =
                calculoEnergeticoAtividade.calculoGastoEnergetico(1.60, 75.0, "M", 54);
           /*
           Assegurar que o método calcula de maneira correta as calorias de acordo com a fórmula da OMS.
            Neste caso, colocamos uma variação de erro em 0.1.
         */
        Assert.assertEquals(3813.7, calorias,0.1);
    }
}