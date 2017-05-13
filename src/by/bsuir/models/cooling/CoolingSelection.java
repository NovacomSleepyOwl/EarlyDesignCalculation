package by.bsuir.models.cooling;

import by.bsuir.models.Element;
import by.bsuir.models.cooling.types.CoolingType;

import java.util.List;

public class CoolingSelection {

    private double summaryPower; //P - Максимальная рассеиваемая мощность

    private int maxAmbientTemperature; //Tc - максимальная температура окружающей среды
    private int minAmbientTemperature;

    private double maxAmbientPressure;
    private double minAmbientPressure;

    private double operationTime;

    private double blockWidth; // L1
    private double blockLength; //L2
    private double blockHeight; //L3

    private List<Element> elements; //Для расчета максимальной температуры элементов, коэффициентов заполнения.
    private double bodyVolume; // V - Объем корпуса

    private double pressureCoefficient; // Kp - Коэффициент атмосферного давления
    private int maxElementOverheat; //Ti-min - Максимальный перегрев элемента
    private double fillingFactorVolume; // Kз - Коэффициент заполнения по объему
    private double minOverheat; //deltaTc - минимально допустимый перегрев элементов
    private double heatExchangeSurface; // Sp - Поверхность теплообмена
    private double logHeatFluxDensity; //q - Плотность теплового потока, проходящего через поверхность теплообмена

    private int primaryArea;

    //конструкторы

    //Известны: Кз, L1, L2, L3, P, Ti-min, Tc, Kp = 1
    public CoolingSelection(double summaryPower, //Рассеиваемая мощность
                            int maxAmbientTemperature, //Максимальная температура окружающей среды
                            double blockWidth, //L1
                            double blockLength,//L2
                            double blockHeight, //L3
                            int maxElementOverheat, //Максимальный перегрев самого нетеплостойкого элемента
                            double fillingFactorVolume ) { //Коэф. заполнения по объему

        this.summaryPower = summaryPower;
        this.maxAmbientTemperature = maxAmbientTemperature;
        this.blockWidth = blockWidth;
        this.blockLength = blockLength;
        this.blockHeight = blockHeight;
        this.maxElementOverheat = maxElementOverheat;
        this.fillingFactorVolume = fillingFactorVolume;
        this.pressureCoefficient = 1;

        //поверхность теплообмена
        this.heatExchangeSurface = 2*(blockLength * blockWidth + (blockLength + blockWidth)* blockHeight * fillingFactorVolume);
        //десятичный логарифм теплового потока
        this.logHeatFluxDensity = Math.log10(summaryPower * pressureCoefficient/heatExchangeSurface);
        //дельта-Т
        this.minOverheat = maxElementOverheat - maxAmbientTemperature;
        //setPrimaryArea();



    }


    public CoolingType defineCoolingType(){

        ForcedAirCooling forcedAirCooling = new ForcedAirCooling();
        primaryArea = setPrimaryArea();

        switch (primaryArea){

            case 1:
                return CoolingType.NATURAL_AIR;

            case 2:
                return forcedAirCooling.findForcedAirCoolingType();

            case 3:
                return forcedAirCooling.findForcedAirCoolingType();

            case 4:
                if(forcedAirCooling.getExpectation() < 3){
                    return CoolingType.FORCED_LIQUID;
                }
                else return forcedAirCooling.findForcedAirCoolingType();

            case 5:
                return CoolingType.FORCED_LIQUID;

            case 6:
                return CoolingType.FORCED_LIQUID__NATURAL_EVAPORATION;

            case 7:
                return CoolingType.FORCED_LIQUID__NATURAL_EVAPORATION__FORCED_EVAPORATION;

            case 8:
                return CoolingType.NATURAL_EVAPORATION__FORCED_EVAPORATION;

            case 9:
                return CoolingType.FORCED_EVAPORATION;

            case 0:
                return CoolingType.ERROR;

            default:
                return CoolingType.ERROR;

        }

    }


    private int setPrimaryArea() {
        ExpedientAreas expedientArea = new ExpedientAreas(logHeatFluxDensity, minOverheat );
        return expedientArea.findArea();
    }




    public int getPrimaryArea() {
        return primaryArea;
    }

    public void showQAndT(){
        System.out.println("lg(q) = " + (logHeatFluxDensity) + " , T = " + minOverheat);
        System.out.println("Area : " + getPrimaryArea());
    }
}





































