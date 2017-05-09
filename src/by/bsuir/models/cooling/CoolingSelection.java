package by.bsuir.models.cooling;

import by.bsuir.models.Element;

import java.util.List;

/**
 * Created by SleepyOwl on 10.05.2017.
 */
public class CoolingSelection {

    //Вводимые данные
    private double summaryPower; //Максимальная рассеиваемая мощность

    private int maxAmbientTemperature;
    private int minAmbientTemperature;

    private double maxAmbientPressure;
    private double minAmbientPressure;

    private double operationTime;

    private List<Element> elements; //Для расчета максимальной температуры элементов, коэффициентов заполнения.
    private double bodyVolume; //Объем корпуса


    //Рассчитываемые данные
    private double pressureCoefficient; //Коэффициент атмосферного давления
    private double maxElementTemperature;
    private double fillingFactorVolume; //Коэффициент заполнения по объему
    private double heatExchangeSurface; //Поверхность теплообмена
    private double heatFluxDensity; // Плотность теплового потока, проходящего через поверхность теплообмена


}
