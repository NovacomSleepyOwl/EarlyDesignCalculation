package by.bsuir;

import by.bsuir.models.cooling.CoolingSelection;
import by.bsuir.models.cooling.ExpedientAreas;
import by.bsuir.models.cooling.ForcedAirCooling;
import by.bsuir.models.cooling.beans.CoolingMethod;
import by.bsuir.models.cooling.types.CoolingType;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        CoolingSelection coolingSelection = new CoolingSelection();

        CoolingMethod coolingMethod = new CoolingMethod();
        coolingMethod.setQ(200);
        coolingMethod.setDeltaTc(20);
        coolingMethod.setType(CoolingType.FORCED_AIR_OR_NATURAL_AIR);
        ArrayList<CoolingMethod> output = coolingSelection.verifyArea(coolingMethod);

        for (CoolingMethod i : output){
            System.out.println(i.getExpectation() + " " + i.getType() + " " + "W = " + i.getW());

        }


    }
}
