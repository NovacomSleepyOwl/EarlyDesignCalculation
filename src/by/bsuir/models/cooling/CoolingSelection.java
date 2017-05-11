package by.bsuir.models.cooling;

import by.bsuir.models.Element;

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
    public CoolingSelection(double summaryPower,
                            int maxAmbientTemperature,
                            double blockWidth,
                            double blockLength,
                            double blockHeight,
                            int maxElementOverheat,
                            double fillingFactorVolume) {

        this.summaryPower = summaryPower;
        this.maxAmbientTemperature = maxAmbientTemperature;
        this.blockWidth = blockWidth;
        this.blockLength = blockLength;
        this.blockHeight = blockHeight;
        this.maxElementOverheat = maxElementOverheat;
        this.fillingFactorVolume = fillingFactorVolume;
        this.pressureCoefficient = 1;

        this.heatExchangeSurface = 2*(blockLength * blockWidth + (blockLength + blockWidth)* blockHeight * fillingFactorVolume);
        this.logHeatFluxDensity = Math.log10(summaryPower/heatExchangeSurface);
        this.minOverheat = maxElementOverheat - maxAmbientTemperature;
        setPrimaryArea();

    }

    private void setPrimaryArea() {
        ExpedientAreas expedientAreas = new ExpedientAreas(logHeatFluxDensity, minOverheat );
        this.primaryArea = expedientAreas.findArea();
    }

    public int getPrimaryArea() {
        return primaryArea;
    }

    public void showQAndT(){
        System.out.println("lg(q) = " + (logHeatFluxDensity) + " , T = " + minOverheat);
        System.out.println("Area : " + getPrimaryArea());
    }
}





































