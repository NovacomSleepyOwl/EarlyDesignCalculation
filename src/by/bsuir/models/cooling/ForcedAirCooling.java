package by.bsuir.models.cooling;

import by.bsuir.models.cooling.types.CoolingType;

/**
 * Created by SleepyOwl on 13.05.2017.
 */
public class ForcedAirCooling {

    private double heatFlux; //q
    private double overheat; //deltaT

    private double expectation = 0; //вероятность
    private int massFlow; //массовый удельный расход воздуха
    private double coefficientW; //коэффициент оси координат, зависящий от массового удельного расхода воздуха


    private double[][] indexArray = new double[17][2];

    public ForcedAirCooling() {
        coefficientW = 1;
        setIndexArray();
    }

    public ForcedAirCooling(int massFlow) {
        this.massFlow = massFlow;
        setIndexArray();

        switch (massFlow) {
            case 0:
                this.coefficientW = 1;
                break;

            case 1:
                this.coefficientW = 0.9;
                break;

            case 2:
                this.coefficientW = 0.7;
                break;

            case 3:
                this.coefficientW = 0.65;
                break;

            default:
                this.coefficientW = 1;

        }

    }

    //В случае попадания в зону 2-4
    public CoolingType findForcedAirCoolingType(double heatFlux, double overheat){
        double q1 = 50;
        double q2 = q1 + 50;
        double step;
        double t;
        double t0; //выше этой температуры p>3
        expectation = 0;

        if (heatFlux < 50){
            expectation = 1;
            return CoolingType.NATURAL_AIR;
        }

        boolean j = true; //вспомогательный флаг
        for (int i = 0; i < indexArray.length && j; i++){

            expectation = 3;

            if(heatFlux >= q1 && heatFlux < q2){
                j = false;
                t0 = indexArray[i][0];
                step = indexArray[i][1];
                t = t0 * coefficientW;

                if (overheat < t0){
                    expectation = 1;
                }
                else{
                    while (overheat > t){
                        t += step * coefficientW;
                        expectation++;
                        if (expectation == 10){
                            t = overheat;
                        }
                    }
                }
            }
            if (j){
                q1 += 50;
                q2 += 50;
            }

        }



        return null;
    }

    private void setIndexArray() {

        //[i][j], где i - номер сегмента на графике, t0 = j0, шаг = j1
        indexArray[0][0]= 0;
        indexArray[0][1]= 2;

        indexArray[1][0]= 0; //100-150
        indexArray[2][0]= 5;
        indexArray[3][0]= 15;
        indexArray[4][0]= 20;
        indexArray[5][0]= 25;
        indexArray[6][0]= 35;
        indexArray[7][0]= 40;
        indexArray[8][0]= 45;
        indexArray[9][0]= 45;
        indexArray[10][0]= 50;
        indexArray[11][0]= 55;
        indexArray[12][0]= 55;
        indexArray[13][0]= 60;
        indexArray[14][0]= 65;
        indexArray[15][0]= 65;
        indexArray[16][0]= 70;

        indexArray[1][1]= 3;
        indexArray[2][1]= 6.50;
        indexArray[3][1]= 6.50;
        indexArray[4][1]= 6.50;
        indexArray[5][1]= 7.0;
        indexArray[6][1]= 6.50;
        indexArray[7][1]= 6.50;
        indexArray[8][1]= 6.50;
        indexArray[9][1]= 6.50;
        indexArray[10][1]= 6.50;
        indexArray[11][1]= 6.50;
        indexArray[12][1]= 6.50;
        indexArray[13][1]= 6.50;
        indexArray[14][1]= 6.50;
        indexArray[15][1]= 6.50;
        indexArray[16][1]= 6.50;

    }

    public double getExpectation() {
        return expectation;
    }

    private void setExpectation(double expectation) {
        this.expectation = expectation;
    }
}
