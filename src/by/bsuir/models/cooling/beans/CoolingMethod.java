package by.bsuir.models.cooling.beans;

import by.bsuir.models.cooling.types.CoolingType;

import java.util.ArrayList;

/**
 * Created by SleepyOwl on 18.05.2017.
 */
public class CoolingMethod {

    private CoolingType type; //тип
    private double expectation; //вероятность
    private double q; //тепловой поток
    private double pressureCoefficient; //коэф. давления
    private int w; //массовый удельный расход воздуха для зоны принудительного водушного охлаждения
    private double g; //массовый удельный расход воздуха при продувном типе охлаждения
    private double deltaTc;


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
}
