package by.bsuir.models.cooling;

import by.bsuir.models.cooling.types.CoolingType;

/**
 * Created by SleepyOwl on 13.05.2017.
 */
public class ForcedAirCooling {

    private double logHeatFlux; //q
    private double overheat; //deltaT

    private double expectation; //вероятность
    private int massFlow; //массовый удельный расход воздуха
    private double CoefficientW; //коэффициент оси координат, зависящий от массового удельного расхода воздуха

    public ForcedAirCooling() {

    }

    public ForcedAirCooling(int massFlow) {
        this.massFlow = massFlow;

        switch (massFlow) {
            case 0:
                this.CoefficientW = 1;
                break;

            case 1:
                this.CoefficientW = 0.9;
                break;

            case 2:
                this.CoefficientW = 0.7;
                break;

            case 3:
                this.CoefficientW = 0.65;
                break;

            default:
                this.CoefficientW = 1;

        }

    }

    //В случае попадания в зону 2-4
    public CoolingType findForcedAirCoolingType(){


        return null;
    }

    public double getExpectation() {
        return expectation;
    }

    private void setExpectation(double expectation) {
        this.expectation = expectation;
    }
}
