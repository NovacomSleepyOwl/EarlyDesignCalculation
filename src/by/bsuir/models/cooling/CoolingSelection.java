package by.bsuir.models.cooling;

import by.bsuir.models.Element;
import by.bsuir.models.cooling.beans.CoolingMethod;
import by.bsuir.models.cooling.beans.InputParameters;
import by.bsuir.models.cooling.types.CoolingType;

import java.util.ArrayList;


public class CoolingSelection {


    //определения лучшего способа охлаждения воздухом
    public ArrayList<CoolingMethod> verifyArea(CoolingMethod inputMethod){

        ArrayList<CoolingMethod> output = new ArrayList<>();

        if (inputMethod.getType().equals(CoolingType.FORCED_AIR) ||
                inputMethod.getType().equals(CoolingType.FORCED_AIR_OR_NATURAL_AIR) ||
                inputMethod.getType().equals(CoolingType.FORCED_AIR_OR_FORCED_LIQUID)){

                ForcedAirCooling forcedAirCooling = new ForcedAirCooling();

                if (inputMethod.getType().equals(CoolingType.FORCED_AIR_OR_NATURAL_AIR)){
                    CoolingMethod coolingMethod = new CoolingMethod();
                    coolingMethod.setType(CoolingType.AIR_HERMETIC_INTERNAL);
                    coolingMethod.setQ(inputMethod.getQ());
                    coolingMethod.setDeltaTc(inputMethod.getDeltaTc());
                    coolingMethod.setW(0);
                    coolingMethod.setExpectation(forcedAirCooling.findExpectation(coolingMethod));

                    if (coolingMethod.getExpectation() >= 4){
                        coolingMethod.setType(CoolingType.NATURAL_AIR);
                        output.add(coolingMethod);
                        return output;
                    }
                }

                for(int i = 1; i <= 3 ; i++){
                    CoolingMethod coolingMethod = new CoolingMethod();
                    coolingMethod.setType(CoolingType.AIR_HERMETIC_INTERNAL);
                    coolingMethod.setQ(inputMethod.getQ());
                    coolingMethod.setDeltaTc(inputMethod.getDeltaTc());
                    coolingMethod.setW(i);
                    coolingMethod.setExpectation(forcedAirCooling.findExpectation(coolingMethod));

                    output.add(coolingMethod);
                }


                return output;
        }
        if (inputMethod.getType().equals(CoolingType.AIR_BLOWN)){
            ForcedAirCooling forcedAirCooling = new ForcedAirCooling();

            CoolingMethod coolingMethod = new CoolingMethod();
            coolingMethod.setType(CoolingType.AIR_BLOWN);
            coolingMethod.setQ(inputMethod.getQ());
            coolingMethod.setDeltaTc(inputMethod.getDeltaTc());

            if (inputMethod.getG() > 0){
                coolingMethod.setG(inputMethod.getG());
            }
            else {
                if (inputMethod.isStatic()){
                    coolingMethod.setG(300);
                }
                else {
                    coolingMethod.setG(215);
                }
            }
            coolingMethod.setStatic(inputMethod.isStatic());
            coolingMethod.setExpectation(forcedAirCooling.findExpectation(coolingMethod));

            output.add(coolingMethod);
            return output;
        }
        else{
            output.add(inputMethod);
            return output;
        }
    }

    //определение первичных способов охлаждения
    public CoolingMethod defineCoolingType(InputParameters inputParameters){

        CoolingMethod coolingMethod = new CoolingMethod();
        coolingMethod.setAmbientPressure(inputParameters.getAmbientPressure());
        coolingMethod.setPressureCoefficient(inputParameters.getPressureCoefficient());

        int primaryArea;
        primaryArea = setPrimaryArea(inputParameters);

        switch (primaryArea){

            case 1:
                coolingMethod.setType(CoolingType.NATURAL_AIR);
                return coolingMethod;

            case 2:
                coolingMethod.setType(CoolingType.FORCED_AIR_OR_NATURAL_AIR);
                return coolingMethod;

            case 3:
                coolingMethod.setType(CoolingType.FORCED_AIR);
                return coolingMethod;

            case 4:
                coolingMethod.setType(CoolingType.FORCED_AIR_OR_FORCED_LIQUID);
                return coolingMethod;

            case 5:
                coolingMethod.setType(CoolingType.FORCED_LIQUID);
                return coolingMethod;

            case 6:
                coolingMethod.setType(CoolingType.FORCED_LIQUID_OR_NATURAL_EVAPORATION);
                return coolingMethod;

            case 7:
                coolingMethod.setType(CoolingType.FORCED_LIQUID_OR_NATURAL_EVAPORATION_OR_FORCED_EVAPORATION);
                return coolingMethod;

            case 8:
                coolingMethod.setType(CoolingType.NATURAL_EVAPORATION_OR_FORCED_EVAPORATION);
                return coolingMethod;

            case 9:
                coolingMethod.setType(CoolingType.FORCED_EVAPORATION);
                return coolingMethod;

            case 0:
                coolingMethod.setType(CoolingType.ERROR);
                return coolingMethod;

            default:
                coolingMethod.setType(CoolingType.ERROR);
                return coolingMethod;

        }

    }

    //поиск первичной области по рис. 2.35
    private int setPrimaryArea(InputParameters inputParameters) {

        //для пониженного давления
        if (inputParameters.getPressureCoefficient() != 1){
            ExpedientAreas expedientArea = new ExpedientAreas(inputParameters.getHeatFluxDensity() * inputParameters.getPressureCoefficient(), inputParameters.getMinOverheat());
            return expedientArea.findArea();
        }
        ExpedientAreas expedientArea = new ExpedientAreas(inputParameters.getHeatFluxDensity(), inputParameters.getMinOverheat());
        return expedientArea.findArea();
    }




}





































