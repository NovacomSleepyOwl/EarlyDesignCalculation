package by.bsuir.models.thermal.beans;

import java.util.ArrayList;

/**
 * Created by SleepyOwl on 23.05.2017.
 */
public class InputData {

    private double ambientTemperature; //Т окр. среды
    private double averageBlockTemperature; //средняя температура в блоке (расч)
    private double permissibleOverheat; //допустимый перегрев
    private double permissibleAmbientTemperature; //допустимая температура вокруг элементов
    private ArrayList<Element> elements; //массив элементов
    private double expectationForFirstThreeElements; //вероятность отказа первых трех элементов

    private boolean isForcedCooling; //принудительное охлаждение




    public double getAmbientTemperature() {
        return ambientTemperature;
    }

    public void setAmbientTemperature(double ambientTemperature) {
        this.ambientTemperature = ambientTemperature;
    }

    public double getAverageBlockTemperature() {
        return averageBlockTemperature;
    }

    public void setAverageBlockTemperature(double averageBlockTemperature) {
        this.averageBlockTemperature = averageBlockTemperature;
    }

    public boolean isForcedCooling() {
        return isForcedCooling;
    }

    public void setForcedCooling(boolean forcedCooling) {
        isForcedCooling = forcedCooling;
    }

    public double getPermissibleOverheat() {
        return permissibleOverheat;
    }

    public void setPermissibleOverheat(double permissibleOverheat) {
        this.permissibleOverheat = permissibleOverheat;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    public double getExpectationForFirstThreeElements() {
        return expectationForFirstThreeElements;
    }

    public void setExpectationForFirstThreeElements(double expectationForFirstThreeElements) {
        this.expectationForFirstThreeElements = expectationForFirstThreeElements;
    }

    public double getPermissibleAmbientTemperature() {
        return permissibleAmbientTemperature;
    }

    public void setPermissibleAmbientTemperature(double permissibleAmbientTemperature) {
        this.permissibleAmbientTemperature = permissibleAmbientTemperature;
    }
}
