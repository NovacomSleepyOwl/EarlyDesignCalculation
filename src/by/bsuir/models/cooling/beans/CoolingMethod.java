package by.bsuir.models.cooling.beans;

import by.bsuir.models.cooling.PressureCalculation;
import by.bsuir.models.cooling.types.CoolingType;
import by.bsuir.models.cooling.types.PressureType;

import java.util.ArrayList;

/**
 * Created by SleepyOwl on 18.05.2017.
 */
public class CoolingMethod {

    private CoolingType type; //тип
    private PressureType pressureType; //тип для рассчета коэффициента давления
    private double expectation; //вероятность
    private double q; //тепловой поток
    private double pressureCoefficient; //коэф. давления
    private int w; //массовый удельный расход воздуха для зоны принудительного водушного охлаждения
    private double g; //массовый удельный расход воздуха при продувном типе охлаждения
    private double deltaTc; //перегрев
    private double ambientPressure; //внешнее давление
    private double internalPressure; //внутреннее давление (при наддуве)
    private boolean isStatic; //стационарная ли аппаратура

    public CoolingMethod() {
        this.pressureCoefficient = 1;
        this.pressureType = PressureType.DEFAULT;
    }

    public CoolingMethod(double pressureCoefficient) {
        this.pressureCoefficient = pressureCoefficient;
    }

    public CoolingMethod(PressureType pressureType, double ambientPressure, double internalPressure, int airFlow) {
        this.pressureType = pressureType;
        this.ambientPressure = ambientPressure;
        this.internalPressure = internalPressure;
        this.w = airFlow;

        this.pressureCoefficient = PressureCalculation.definePressureCoefficient(pressureType, ambientPressure, internalPressure, airFlow);
    }



    public CoolingType getType() {
        return type;
    }

    public void setType(CoolingType type) {
        this.type = type;
    }

    public double getExpectation() {
        return expectation;
    }

    public void setExpectation(double expectation) {
        this.expectation = expectation;
    }

    public double getQ() {
        return q;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public double getPressureCoefficient() {
        return pressureCoefficient;
    }

    public void setPressureCoefficient(double pressureCoefficient) {
        this.pressureCoefficient = pressureCoefficient;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getDeltaTc() {
        return deltaTc;
    }

    public void setDeltaTc(double deltaTc) {
        this.deltaTc = deltaTc;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public double getAmbientPressure() {
        return ambientPressure;
    }

    public void setAmbientPressure(double ambientPressure) {
        this.ambientPressure = ambientPressure;
    }

    public double getInternalPressure() {
        return internalPressure;
    }

    public void setInternalPressure(double internalPressure) {
        this.internalPressure = internalPressure;
    }
}
