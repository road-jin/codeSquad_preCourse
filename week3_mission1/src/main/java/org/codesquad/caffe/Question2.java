package org.codesquad.caffe;

import org.codesquad.caffe.v1.*;
import org.codesquad.caffe.v2.*;

public class Question2 {

    public static void main(String[] args) {

        Coffee etiopiaAmericano = new EtiopiaAmericano();
        etiopiaAmericano.brewing();
        System.out.println();

        Coffee kenyaAmericano = new KenyaAmericano();
        kenyaAmericano.brewing();
        System.out.println();

        Coffee kenyaLatte = new Latte(kenyaAmericano);
        kenyaLatte.brewing();
        System.out.println();

        Coffee brazilMocha = new Mocha(new Latte(new BrazilAmericano()));
        brazilMocha.brewing();
        System.out.println();

        Coffee hawaiiWhippedMocha = new WhippedCream(new Mocha(new Latte( new HawaiiAmericano())));
        hawaiiWhippedMocha.brewing();
        System.out.println();

        System.out.println("==================================================");

        CoffeeV2 etiopiaAmericanoV2 = new EtiopiaAmericanoV2();
        etiopiaAmericanoV2.brewing();
        System.out.println();

        CoffeeV2 kenyaAmericanoV2 = new KenyaAmericanoV2();
        kenyaAmericanoV2.brewing();
        System.out.println();

        CoffeeV2 kenyaLatteV2 = new LatteV2(kenyaAmericanoV2);
        kenyaLatteV2.brewing();
        System.out.println();

        CoffeeV2 brazilMochaV2 = new MochaV2(new LatteV2(new BrazilAmericanoV2()));
        brazilMochaV2.brewing();
        System.out.println();

        CoffeeV2 hawaiiWhippedMochaV2 = new WhippedCreamV2(new MochaV2(new LatteV2( new HawaiiAmericanoV2())));
        hawaiiWhippedMochaV2.brewing();
        System.out.println();
    }
}
