package by.bsuir.models.thermal;


import by.bsuir.models.thermal.beans.Const;
import by.bsuir.models.thermal.beans.Element;
import by.bsuir.models.thermal.beans.InputData;
import by.bsuir.models.thermal.beans.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by SleepyOwl on 23.05.2017.
 */
public class ThermalModeEvaluation {


    public void firstThreeEvaluation(InputData input){

        Output output = new Output();

        System.out.println("");
        Collections.sort(input.getElements(), new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return Double.compare(o1.getOverheat(), o2.getOverheat());
            }
        });

        for (int i = 0; i < input.getElements().size(); i++){
            input.getElements().get(i).setIndex(i);
        }

        if (calculateForThreeExpectation(input.getElements().get(0).getOverheat(),
                                         input.getElements().get(1).getOverheat(),
                                         input.getElements().get(2).getOverheat()) < 0.05){


        }



    }

    private double calculateForThreeExpectation(double overheat1, double overheat2, double overheat3){
        if (overheat1 > 30 || overheat2 > 30 || overheat3 > 30){

            return 0;
        }

        int o1 = (int)overheat1;
        int o2 = (int)overheat2;
        int o3 = (int)overheat3;

        return (1 - Const.fFunctionValues[o1][1]) * (1 - Const.fFunctionValues[o2][1]) * (1 - Const.fFunctionValues[o3][1]);

    }
}
