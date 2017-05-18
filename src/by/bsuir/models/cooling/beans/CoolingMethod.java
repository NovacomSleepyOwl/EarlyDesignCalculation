package by.bsuir.models.cooling.beans;

import by.bsuir.models.cooling.types.CoolingType;

import java.util.ArrayList;

/**
 * Created by SleepyOwl on 18.05.2017.
 */
public class CoolingMethod {

    private CoolingType type;
    private double expectation;
    private double q; //тепловой поток
    private double pressureCoefficient; //коэф. давления
    private double W; //массовый удельный расход воздуха для зоны принудительного водушного охлаждения
    private double G; //массовый удельный расход воздуха при продувном типе охлаждения


}
