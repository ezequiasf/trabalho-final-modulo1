package com.test;

import com.utils.CalculoEnergetico;
import org.junit.Assert;
import org.junit.Test;


public class TC_CalculoEnergetico {


    @Test
    public void testarCalculoEnergetico(){
        //setup
        CalculoEnergetico calculoEnergetico = new CalculoEnergetico();
        Double calorias =
        calculoEnergetico.calculoGastoEnergetico(1.70,85.0,  "M", 35);
        //Assegurar que o método calcula de maneira correta as calorias de acordo com a fórmula da OMS.
        Assert.assertEquals(1848.22, calorias, 0.0);
    }

}


