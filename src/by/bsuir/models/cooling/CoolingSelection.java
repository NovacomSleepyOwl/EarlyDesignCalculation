package by.bsuir.models.cooling;

import by.bsuir.models.Element;
import by.bsuir.models.cooling.beans.InputParameters;
import by.bsuir.models.cooling.types.CoolingType;

import java.util.ArrayList;


public class CoolingSelection {


    private int primaryArea;


    public CoolingType defineCoolingType(InputParameters inputParameters){

        ForcedAirCooling forcedAirCooling = new ForcedAirCooling();
        primaryArea = setPrimaryArea(inputParameters);

        switch (primaryArea){

            case 1:
                return CoolingType.NATURAL_AIR;

            case 2:
                return CoolingType.FORCED_AIR_OR_NATURAL_AIR;

            case 3:
                return CoolingType.FORCED_AIR;

            case 4:
                return CoolingType.FORCED_AIR_OR_FORCED_LIQUID;

            case 5:
                return CoolingType.FORCED_LIQUID;

            case 6:
                return CoolingType.FORCED_LIQUID_OR_NATURAL_EVAPORATION;

            case 7:
                return CoolingType.FORCED_LIQUID_OR_NATURAL_EVAPORATION_OR_FORCED_EVAPORATION;

            case 8:
                return CoolingType.NATURAL_EVAPORATION_OR_FORCED_EVAPORATION;

            case 9:
                return CoolingType.FORCED_EVAPORATION;

            case 0:
                return CoolingType.ERROR;

            default:
                return CoolingType.ERROR;

        }

    }



    /*public void recalculateInputData(){
        //поверхность теплообмена
        heatExchangeSurface = 2*(blockLength * blockWidth + (blockLength + blockWidth)* blockHeight * fillingFactorVolume);
        //тепловой поток
        heatFluxDensity = summaryPower * pressureCoefficient/heatExchangeSurface;
        //дельта-Т
        minOverheat = maxElementOverheat - maxAmbientTemperature;

    }*/


    private int setPrimaryArea(InputParameters inputParameters) {
        ExpedientAreas expedientArea = new ExpedientAreas(inputParameters.getHeatFluxDensity(), inputParameters.getMinOverheat() );
        return expedientArea.findArea();
    }




    public int getPrimaryArea() {
        return primaryArea;
    }


}





































