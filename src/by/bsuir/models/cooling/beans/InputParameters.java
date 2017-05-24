package by.bsuir.models.cooling.beans;

import by.bsuir.models.cooling.PressureCalculation;
import by.bsuir.models.cooling.types.PressureType;

import java.util.ArrayList;

/**
 * Created by SleepyOwl on 18.05.2017.
 */
public class InputParameters {

    private double summaryPower; //P - Максимальная рассеиваемая мощность

    private int maxAmbientTemperature; //Tc - максимальная температура окружающей среды
    private int minAmbientTemperature;

    private double ambientPressure;

    private double operationTime;

    private double blockWidth; // L1
    private double blockLength; //L2
    private double blockHeight; //L3

    private double bodyVolume; // V - Объем корпуса

    private double pressureCoefficient; // Kp - Коэффициент атмосферного давления
    private int maxElementOverheat; //Ti-min - Максимальный перегрев элемента
    private double fillingFactorVolume; // Kз - Коэффициент заполнения по объему
    private double minOverheat; //deltaTc - минимально допустимый перегрев элементов
    private double heatExchangeSurface; // Sp - Поверхность теплообмена
    private double heatFluxDensity; //q - Плотность теплового потока, проходящего через поверхность теплообмена
    private boolean isStatic; //стационарная ли аппаратура (для учета массового расхода воздуха при продувном типе охлаждения)

    public InputParameters(double summaryPower,
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

        recalculateInputData();
    }

    public InputParameters(double summaryPower,
                           int maxAmbientTemperature,
                           double blockWidth,
                           double blockLength,
                           double blockHeight,
                           int maxElementOverheat,
                           double fillingFactorVolume,
                           double ambientPressure) {

        this.summaryPower = summaryPower;
        this.maxAmbientTemperature = maxAmbientTemperature;
        this.blockWidth = blockWidth;
        this.blockLength = blockLength;
        this.blockHeight = blockHeight;
        this.maxElementOverheat = maxElementOverheat;
        this.fillingFactorVolume = fillingFactorVolume;
        this.ambientPressure = ambientPressure;
        this.pressureCoefficient = PressureCalculation.definePressureCoefficient(PressureType.HERMETIC_EQUAL, ambientPressure, ambientPressure, 0 );;

        recalculateInputData();
    }

    public void recalculateInputData(){
        //поверхность теплообмена
        heatExchangeSurface = 2*(blockLength * blockWidth + (blockLength + blockWidth)* blockHeight * fillingFactorVolume);
        //тепловой поток
        heatFluxDensity = summaryPower /heatExchangeSurface;
        //дельта-Т
        minOverheat = maxElementOverheat - maxAmbientTemperature;

    }

    public double getSummaryPower() {
        return summaryPower;
    }

    public void setSummaryPower(double summaryPower) {
        this.summaryPower = summaryPower;
    }

    public int getMaxAmbientTemperature() {
        return maxAmbientTemperature;
    }

    public void setMaxAmbientTemperature(int maxAmbientTemperature) {
        this.maxAmbientTemperature = maxAmbientTemperature;
    }

    public int getMinAmbientTemperature() {
        return minAmbientTemperature;
    }

    public void setMinAmbientTemperature(int minAmbientTemperature) {
        this.minAmbientTemperature = minAmbientTemperature;
    }

    public double getAmbientPressure() {
        return ambientPressure;
    }

    public void setAmbientPressure(double ambientPressure) {
        this.ambientPressure = ambientPressure;
    }

    public double getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(double operationTime) {
        this.operationTime = operationTime;
    }

    public double getBlockWidth() {
        return blockWidth;
    }

    public void setBlockWidth(double blockWidth) {
        this.blockWidth = blockWidth;
    }

    public double getBlockLength() {
        return blockLength;
    }

    public void setBlockLength(double blockLength) {
        this.blockLength = blockLength;
    }

    public double getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(double blockHeight) {
        this.blockHeight = blockHeight;
    }

    public double getBodyVolume() {
        return bodyVolume;
    }

    public void setBodyVolume(double bodyVolume) {
        this.bodyVolume = bodyVolume;
    }

    public double getPressureCoefficient() {
        return pressureCoefficient;
    }

    public void setPressureCoefficient(double pressureCoefficient) {
        this.pressureCoefficient = pressureCoefficient;
    }

    public int getMaxElementOverheat() {
        return maxElementOverheat;
    }

    public void setMaxElementOverheat(int maxElementOverheat) {
        this.maxElementOverheat = maxElementOverheat;
    }

    public double getFillingFactorVolume() {
        return fillingFactorVolume;
    }

    public void setFillingFactorVolume(double fillingFactorVolume) {
        this.fillingFactorVolume = fillingFactorVolume;
    }

    public double getMinOverheat() {
        return minOverheat;
    }

    public void setMinOverheat(double minOverheat) {
        this.minOverheat = minOverheat;
    }

    public double getHeatExchangeSurface() {
        return heatExchangeSurface;
    }

    public void setHeatExchangeSurface(double heatExchangeSurface) {
        this.heatExchangeSurface = heatExchangeSurface;
    }

    public double getHeatFluxDensity() {
        return heatFluxDensity;
    }

    public void setHeatFluxDensity(double heatFluxDensity) {
        this.heatFluxDensity = heatFluxDensity;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }


}
