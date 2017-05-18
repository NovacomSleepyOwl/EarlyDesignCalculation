package by.bsuir;

import by.bsuir.models.cooling.CoolingSelection;
import by.bsuir.models.cooling.ExpedientAreas;
import by.bsuir.models.cooling.ForcedAirCooling;
import by.bsuir.models.cooling.types.CoolingType;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ForcedAirCooling forcedAirCooling = new ForcedAirCooling();
        forcedAirCooling.findForcedAirCoolingType(500, 15);

        //ExpedientAreas expedientAreas = new ExpedientAreas(3.7, 20);
        System.out.println(forcedAirCooling.getExpectation());

        ArrayList<CoolingType> coolingTypes = new ArrayList<CoolingType>();


        for(CoolingType i: coolingTypes){
            System.out.println("Cooling types : " + i);
        }
    }
}
