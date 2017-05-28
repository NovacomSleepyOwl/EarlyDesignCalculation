package by.bsuir;

import by.bsuir.models.cooling.CoolingSelection;
import by.bsuir.models.cooling.beans.CoolingMethod;
import by.bsuir.models.cooling.beans.InputParameters;
import by.bsuir.models.cooling.types.CoolingType;
import by.bsuir.models.thermal.ThermalModeEvaluation;
import by.bsuir.models.thermal.beans.Element;
import by.bsuir.models.thermal.beans.InputData;
import by.bsuir.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main{


    public static void main(String[] args) {


//        InputParameters inputParameters = new InputParameters(550,
//                40, 0.90, 0.5, 0.2, 79, 0.5);
//
//        CoolingSelection coolingSelection = new CoolingSelection();
//        ArrayList<CoolingMethod> coolingMethods = coolingSelection.verifyArea(coolingSelection.defineCoolingType(inputParameters));
//
//        for (CoolingMethod i:
//             coolingMethods) {
//
//            System.out.println("Type - " + i.getType() + ", exp - " + i.getExpectation() + ", W = " + i.getW() + ", q = " + i.getQ());
//        }
//
//        CoolingMethod coolingMethod = new CoolingMethod();
//        coolingMethod.setStatic(true);
//        coolingMethod.setDeltaTc(inputParameters.getMinOverheat());
//        coolingMethod.setQ(inputParameters.getHeatFluxDensity());
//        coolingMethod.setType(CoolingType.AIR_BLOWN);
//        coolingMethods.clear();
//        coolingMethods = coolingSelection.verifyArea(coolingMethod);
//        System.out.println("Type - " + coolingMethods.get(coolingMethods.size() - 1 ).getType() + ", exp - " + coolingMethods.get(coolingMethods.size() - 1).getExpectation() + ", W = " + coolingMethods.get(coolingMethods.size() - 1).getG() + ", q = " + coolingMethods.get(coolingMethods.size() - 1).getQ());
//        InputData inputData = new InputData();
//        ThermalModeEvaluation evaluation = new ThermalModeEvaluation();
//        ArrayList<Element> elements = new ArrayList<>();
//        elements.add(new Element(32, "2"));
//        elements.add(new Element(55, "5"));
//        elements.add(new Element(11, "1"));
//        elements.add(new Element(34, "3"));
//        elements.add(new Element(42, "4"));
//        Element a = new Element(21,"fa");
//        elements.add(a);
//        inputData.setElements(elements);
//        for (Element i :
//             elements) {
//            System.out.println(i.getName());
//        }
//
//        System.out.println("");
//        Collections.sort(elements, new Comparator<Element>() {
//            @Override
//            public int compare(Element o1, Element o2) {
//                return Double.compare(o1.getOverheat(), o2.getOverheat());
//            }
//        });
//
//        for (int i = 0; i < elements.size(); i++){
//            elements.get(i).setIndex(i + 1);
//        }
//
//        evaluation.firstThreeEvaluation(inputData);
//
//        for (Element i :
//                elements) {
//            System.out.println( i.getIndex() + "  " + i.getName());
//        }
//
        View view = new View();
        view.setVisible(true);


    }

}
