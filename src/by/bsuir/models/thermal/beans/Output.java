package by.bsuir.models.thermal.beans;

/**
 * Created by SleepyOwl on 24.05.2017.
 */
public class Output {

    private double expectationForFirstThreeElements; //вероятность перегрева первых трех элементов
    private boolean thermalModeIsOk = false;
    //значения функции Ф() для первых трех элементов
    private double f1;
    private double f2;
    private double f3;

    //соответствие тепловому режиму i-го элемента
    private boolean elementIsOk;
    private Element searchableElement;

    public double getExpectationForFirstThreeElements() {
        return expectationForFirstThreeElements;
    }

    public void setExpectationForFirstThreeElements(double expectationForFirstThreeElements) {
        this.expectationForFirstThreeElements = expectationForFirstThreeElements;
    }

    public boolean isThermalModeIsOk() {
        return thermalModeIsOk;
    }

    public void setThermalModeIsOk(boolean thermalModeIsOk) {
        this.thermalModeIsOk = thermalModeIsOk;
    }

    public double getF1() {
        return f1;
    }

    public void setF1(double f1) {
        this.f1 = f1;
    }

    public double getF2() {
        return f2;
    }

    public void setF2(double f2) {
        this.f2 = f2;
    }

    public double getF3() {
        return f3;
    }

    public void setF3(double f3) {
        this.f3 = f3;
    }
}
