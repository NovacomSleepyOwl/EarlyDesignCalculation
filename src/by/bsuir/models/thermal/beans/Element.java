package by.bsuir.models.thermal.beans;


import java.util.Comparator;

/**
 * Created by SleepyOwl on 23.05.2017.
 */
public class Element {

    private double tempPredetermined; //Т зад.
    private double tempCalculated; //Т расч.
    private double tempMeasured; //Т изм.
    private double overheat; //перегрев
    private int numberOf; //количество
    private int index; //номер
    private String name; //имя
    private boolean isSubjectToInvestigation; //подлежит расчету
    private double thermalModel; // ожидаемый тепловой режим элемента (для сравнения с Т по ТУ)



    public double getTempPredetermined() {
        return tempPredetermined;
    }

    public void setTempPredetermined(double tempPredetermined) {
        this.tempPredetermined = tempPredetermined;
    }

    public double getTempCalculated() {
        return tempCalculated;
    }

    public void setTempCalculated(double tempCalculated) {
        this.tempCalculated = tempCalculated;
    }

    public double getTempMeasured() {
        return tempMeasured;
    }

    public void setTempMeasured(double tempMeasured) {
        this.tempMeasured = tempMeasured;
    }

    public double getOverheat() {
        return overheat;
    }

    public void setOverheat(double overheat) {
        this.overheat = overheat;
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSubjectToInvestigation() {
        return isSubjectToInvestigation;
    }

    public void setSubjectToInvestigation(boolean subjectToInvestigation) {
        isSubjectToInvestigation = subjectToInvestigation;
    }

    public Element(String name) {
        this.name = name;
    }

    public Element(int overheat, String name) {
        this.overheat = overheat;
        this.name = name;
    }

    public double getThermalModel() {
        return thermalModel;
    }

    public Element(double tempPredetermined, double tempCalculated, String name) {
        this.tempPredetermined = tempPredetermined;
        this.tempCalculated = tempCalculated;
        this.name = name;
        this.overheat = tempPredetermined - tempCalculated;
    }

    public void setThermalModel(double thermalModel) {
        this.thermalModel = thermalModel;
    }
}
