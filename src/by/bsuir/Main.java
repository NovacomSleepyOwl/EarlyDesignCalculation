package by.bsuir;

import by.bsuir.models.cooling.CoolingSelection;
import by.bsuir.models.cooling.ExpedientAreas;

public class Main {

    public static void main(String[] args) {

        CoolingSelection coolingSelection = new CoolingSelection(6.95,
                40,
                0.09,
                0.07,
                0.055,
                70,
                0.5 );
        coolingSelection.showQAndT();

        //ExpedientAreas expedientAreas = new ExpedientAreas(3.7, 20);
        //System.out.println("Area : " + expedientAreas.findArea());
    }
}
