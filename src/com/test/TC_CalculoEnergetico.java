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
        Assert.assertTrue(calorias == 1848.22);
    }

}


