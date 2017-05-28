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

    @Override
    public String toString() {
        String out = "";

        if (this.type.equals(CoolingType.NATURAL_AIR)){
            out += "__________________________________________________________________ \n";
            out += "Рекомендуется использовать естественное воздушное охлаждение: \n";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            if (expectation > 3){
                out += "    * вероятность обеспечения нормального теплового режима p = " + expectation/10 + "; \n";
            }
            out += "__________________________________________________________________ \n";
        }

        if (this.type.equals(CoolingType.AIR_HERMETIC_INTERNAL)){
            out += "__________________________________________________________________ \n";
            out += "Рекомендуется использовать принудительное воздушное охлаждение, \n";
            out += "    * Для корпусов с внутренним перемешиванием воздухом: \n";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "    * вероятность обеспечения нормального теплового режима p = " + expectation/10 + "; \n";
            out += "Расход воздуха, w = " + w + ", [кг/с*м^2]; \n";
            out += "__________________________________________________________________ \n";
        }
        if (this.type.equals(CoolingType.AIR_HERMETIC_EXTERNAL)){
            out += "__________________________________________________________________ \n";
            out += "Рекомендуется использовать принудительное воздушное охлаждение, \n";
            out += "    * Для корпусов с внешним обдувом воздухом: \n";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "    * вероятность обеспечения нормального теплового режима p = " + expectation/10 + "; \n";
            out += "Расход воздуха, w = " + w + ", [кг/с*м^2]; \n";
            out += "__________________________________________________________________ \n";
        }
        if (this.type.equals(CoolingType.AIR_BLOWN)){
            out += "__________________________________________________________________ \n";
            out += "Рекомендуется использовать принудительное воздушное охлаждение, \n";
            out += "    * Для корпусов с продувом воздухом: \n";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "    * вероятность обеспечения нормального теплового режима p = " + expectation/10 + "; \n";
            out += "Расход воздуха, g = " + g + ", [кг/ч*кВт]; \n";
            out += "__________________________________________________________________ \n";
        }
        if (this.type.equals(CoolingType.AIR_PERFORATED)){
            out += "__________________________________________________________________ \n";
            out += "Рекомендуется использовать принудительное воздушное охлаждение, \n";
            out += "    * Для корпусов с перфорированным корпусом: \n";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "    * вероятность обеспечения нормального теплового режима p = " + expectation/10 + "; \n";
            out += "__________________________________________________________________ \n";
        }
        if (this.type.equals(CoolingType.FORCED_AIR_OR_FORCED_LIQUID)){
            out += "__________________________________________________________________ \n";
            out += "С одинаковой вероятностью можно прибегнуть к : \n   *принудительному охлаждению воздухом; \n    *жидкостному охлаждению";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "__________________________________________________________________ \n";
        }
        if (this.type.equals(CoolingType.FORCED_LIQUID)){
            out += "__________________________________________________________________ \n";
            out += "Рекомендуется выбрать жидкостное охлаждение :";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "__________________________________________________________________ \n";
        }
        if (this.type.equals(CoolingType.FORCED_LIQUID_OR_NATURAL_EVAPORATION)){
            out += "__________________________________________________________________ \n";
            out += "С одинаковой вероятностью можно прибегнуть к : \n   * принудительному жидкостному охлаждению; \n    * ествественному испарительному охлаждению";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "__________________________________________________________________ \n";
        }
        if (this.type.equals(CoolingType.FORCED_LIQUID_OR_NATURAL_EVAPORATION_OR_FORCED_EVAPORATION)){
            out += "__________________________________________________________________ \n";
            out += "С одинаковой вероятностью можно прибегнуть к : \n   * принудительному жидкостному охлаждению; \n    * ествественному испарительному охлаждению \n";
            out += "    * принудительному испарительному охлаждению";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "__________________________________________________________________ \n";
        }
        if (this.type.equals(CoolingType.NATURAL_EVAPORATION_OR_FORCED_EVAPORATION)){
            out += "__________________________________________________________________ \n";
            out += "С одинаковой вероятностью можно прибегнуть к : \n   * ествественному испарительному охлаждению \n";
            out += "    * принудительному испарительному охлаждению";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "__________________________________________________________________ \n";
        }
        if (this.type.equals(CoolingType.FORCED_EVAPORATION)){
            out += "__________________________________________________________________ \n";
            out += "Рекомендуется выбрать принудительноме испарительное охлаждение";
            out += "    * тепловой поток, q = " + q * pressureCoefficient + ", [Вт/м^2]; \n";
            out += "    * перегрев корпуса, ΔT = " + deltaTc + ", [K]; \n";
            out += "    * коэффициент атмосферного давления, Kp = " + pressureCoefficient + "; \n ";
            out += "__________________________________________________________________ \n";
        }


            return out;
    }
}
