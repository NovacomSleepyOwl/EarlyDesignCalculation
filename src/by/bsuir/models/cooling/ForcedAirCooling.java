package by.bsuir.models.cooling;

import by.bsuir.models.cooling.beans.CoolingMethod;
import by.bsuir.models.cooling.beans.InputParameters;
import by.bsuir.models.cooling.types.CoolingType;

/**
 * Created by SleepyOwl on 13.05.2017.
 */
public class ForcedAirCooling {


    private double[][] hermeticIndexArray = new double[19][2];
    private double[][] perforatedIndexArray = new double[19][2];
    private double[][] blownIndexArray20 = new double[18][2];
    private double[][] blownIndexArray40 = new double[18][2];
    private double[][] blownIndexArray60 = new double[18][2];

    public ForcedAirCooling() {
        setHermeticIndexArray();
        setPerforatedIndexArray();
    }

    public ForcedAirCooling(int massFlow) {


    }

    //В случае попадания в зону 2-4
    public double findExpectation(CoolingMethod inputParameters){

        CoolingType coolingType = inputParameters.getType();
        double heatFlux = inputParameters.getQ();
        double overheat = inputParameters.getDeltaTc();
        double g = inputParameters.getG();
        double[][] indexArray = new double[19][2];
        double coefficientW = setMassAirFlow(inputParameters.getW(), inputParameters.getType()); //коэффициент оси координат, зависящий от массового удельного расхода воздуха
        double expectation;


        if (coolingType.equals(CoolingType.AIR_HERMETIC_INTERNAL)){
            indexArray = getHermeticIndexArray();
        }
        if (coolingType.equals(CoolingType.AIR_HERMETIC_EXTERNAL)){
            indexArray = getHermeticIndexArray();
        }
        if (coolingType.equals(CoolingType.AIR_PERFORATED)){
            indexArray = getPerforatedIndexArray();
        }

        double q1 = 50;
        double q2 = q1 + 50;
        double step;
        double t;
        double t0; //выше этой температуры p>3
        expectation = 0;

        if (heatFlux < 50){

            return expectation = 10;
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

        return expectation;
    }

    private void setHermeticIndexArray() {

        //[i][j], где i - номер сегмента на графике, t0 = j0, шаг = j1
        hermeticIndexArray[0][0]= 0;
        hermeticIndexArray[0][1]= 2;

        hermeticIndexArray[1][0]= 0; //100-150
        hermeticIndexArray[2][0]= 5; //150-200
        hermeticIndexArray[3][0]= 15; //200-250
        hermeticIndexArray[4][0]= 20; //250-300
        hermeticIndexArray[5][0]= 25; //300-350
        hermeticIndexArray[6][0]= 35; //350-400
        hermeticIndexArray[7][0]= 40; //400-450
        hermeticIndexArray[8][0]= 45; //450-500
        hermeticIndexArray[9][0]= 45; //500-550
        hermeticIndexArray[10][0]= 50; //550-600
        hermeticIndexArray[11][0]= 55; //600-650
        hermeticIndexArray[12][0]= 55; //650-700
        hermeticIndexArray[13][0]= 60; //700-750
        hermeticIndexArray[14][0]= 65; //750-800
        hermeticIndexArray[15][0]= 65; //800-850
        hermeticIndexArray[16][0]= 70; //850-900
        hermeticIndexArray[17][0]= 80; //900-950
        hermeticIndexArray[18][0]= 80; //950-1000

        hermeticIndexArray[1][1]= 3;
        hermeticIndexArray[2][1]= 6.50;
        hermeticIndexArray[3][1]= 6.50;
        hermeticIndexArray[4][1]= 6.50;
        hermeticIndexArray[5][1]= 7.0;
        hermeticIndexArray[6][1]= 6.50;
        hermeticIndexArray[7][1]= 6.50;
        hermeticIndexArray[8][1]= 6.50;
        hermeticIndexArray[9][1]= 6.50;
        hermeticIndexArray[10][1]= 6.50;
        hermeticIndexArray[11][1]= 6.50;
        hermeticIndexArray[12][1]= 6.50;
        hermeticIndexArray[13][1]= 6.50;
        hermeticIndexArray[14][1]= 6.50;
        hermeticIndexArray[15][1]= 6.50;
        hermeticIndexArray[16][1]= 6.50;
        hermeticIndexArray[17][1]= 6.50;
        hermeticIndexArray[18][1]= 6.50;

    }


    private void setPerforatedIndexArray() {
        //[i][j], где i - номер сегмента на графике, t0 = j0, шаг = j1
        perforatedIndexArray[0][0]= 0;
        perforatedIndexArray[0][1]= 2;

        perforatedIndexArray[1][0]= 0; //100-150
        perforatedIndexArray[2][0]= 7; //150-200
        perforatedIndexArray[3][0]= 15; //200-250
        perforatedIndexArray[4][0]= 20; //250-300
        perforatedIndexArray[5][0]= 25; //300-350
        perforatedIndexArray[6][0]= 27; //350-400
        perforatedIndexArray[7][0]= 30; //400-450
        perforatedIndexArray[8][0]= 32; //450-500
        perforatedIndexArray[9][0]= 35; //500-550
        perforatedIndexArray[10][0]= 38; //550-600
        perforatedIndexArray[11][0]= 40; //600-650
        perforatedIndexArray[12][0]= 43; //650-700
        perforatedIndexArray[13][0]= 46; //700-750
        perforatedIndexArray[14][0]= 46; //750-800
        perforatedIndexArray[15][0]= 48; //800-850
        perforatedIndexArray[16][0]= 49; //850-900
        perforatedIndexArray[17][0]= 50; //900-950
        perforatedIndexArray[18][0]= 52; //950-1000


        perforatedIndexArray[1][1]= 3;
        perforatedIndexArray[2][1]= 6.50;
        perforatedIndexArray[3][1]= 6.50;
        perforatedIndexArray[4][1]= 6.0;
        perforatedIndexArray[5][1]= 6.0;
        perforatedIndexArray[6][1]= 6.0;
        perforatedIndexArray[7][1]= 6.0;
        perforatedIndexArray[8][1]= 6.0;
        perforatedIndexArray[9][1]= 6.0;
        perforatedIndexArray[10][1]= 6.0;
        perforatedIndexArray[11][1]= 6.0;
        perforatedIndexArray[12][1]= 6.0;
        perforatedIndexArray[13][1]= 6.0;
        perforatedIndexArray[14][1]= 6.0;
        perforatedIndexArray[15][1]= 6.0;
        perforatedIndexArray[16][1]= 6.0;
        perforatedIndexArray[17][1]= 6.0;
        perforatedIndexArray[18][1]= 6.0;

    }

    public void setBlownIndexArray20() {
        //[i][j], где i - номер сегмента на графике, t0 = j0, шаг = j1
        hermeticIndexArray[0][0]= 0;
        hermeticIndexArray[0][1]= 2;

        hermeticIndexArray[1][0]= 0; //200-300
        hermeticIndexArray[2][0]= 5; //300-400
        hermeticIndexArray[3][0]= 15; //400-500
        hermeticIndexArray[4][0]= 20; //500-600
        hermeticIndexArray[5][0]= 25; //600-700
        hermeticIndexArray[6][0]= 35; //700-800
        hermeticIndexArray[7][0]= 40; //800-900
        hermeticIndexArray[8][0]= 45; //900-100
        hermeticIndexArray[9][0]= 45; //1000-1100
        hermeticIndexArray[10][0]= 50; //1100-1200
        hermeticIndexArray[11][0]= 55; //1200-1300
        hermeticIndexArray[12][0]= 55; //1300-1400
        hermeticIndexArray[13][0]= 60; //1400-1500
        hermeticIndexArray[14][0]= 65; //1500-1600
        hermeticIndexArray[15][0]= 65; //1600-1700
        hermeticIndexArray[16][0]= 70; //1800-1900
        hermeticIndexArray[17][0]= 80; //1900-2000

        hermeticIndexArray[1][1]= 3;
        hermeticIndexArray[2][1]= 6.50;
        hermeticIndexArray[3][1]= 6.50;
        hermeticIndexArray[4][1]= 6.50;
        hermeticIndexArray[5][1]= 7.0;
        hermeticIndexArray[6][1]= 6.50;
        hermeticIndexArray[7][1]= 6.50;
        hermeticIndexArray[8][1]= 6.50;
        hermeticIndexArray[9][1]= 6.50;
        hermeticIndexArray[10][1]= 6.50;
        hermeticIndexArray[11][1]= 6.50;
        hermeticIndexArray[12][1]= 6.50;
        hermeticIndexArray[13][1]= 6.50;
        hermeticIndexArray[14][1]= 6.50;
        hermeticIndexArray[15][1]= 6.50;
        hermeticIndexArray[16][1]= 6.50;
        hermeticIndexArray[17][1]= 6.50;
    }

    public void setBlownIndexArray40() {
        //[i][j], где i - номер сегмента на графике, t0 = j0, шаг = j1
        hermeticIndexArray[0][0]= 0;
        hermeticIndexArray[0][1]= 2;

        hermeticIndexArray[1][0]= 0; //200-300
        hermeticIndexArray[2][0]= 5; //300-400
        hermeticIndexArray[3][0]= 15; //400-500
        hermeticIndexArray[4][0]= 20; //500-600
        hermeticIndexArray[5][0]= 25; //600-700
        hermeticIndexArray[6][0]= 35; //700-800
        hermeticIndexArray[7][0]= 40; //800-900
        hermeticIndexArray[8][0]= 45; //900-100
        hermeticIndexArray[9][0]= 45; //1000-1100
        hermeticIndexArray[10][0]= 50; //1100-1200
        hermeticIndexArray[11][0]= 55; //1200-1300
        hermeticIndexArray[12][0]= 55; //1300-1400
        hermeticIndexArray[13][0]= 60; //1400-1500
        hermeticIndexArray[14][0]= 65; //1500-1600
        hermeticIndexArray[15][0]= 65; //1600-1700
        hermeticIndexArray[16][0]= 70; //1800-1900
        hermeticIndexArray[17][0]= 80; //1900-2000

        hermeticIndexArray[1][1]= 3;
        hermeticIndexArray[2][1]= 6.50;
        hermeticIndexArray[3][1]= 6.50;
        hermeticIndexArray[4][1]= 6.50;
        hermeticIndexArray[5][1]= 7.0;
        hermeticIndexArray[6][1]= 6.50;
        hermeticIndexArray[7][1]= 6.50;
        hermeticIndexArray[8][1]= 6.50;
        hermeticIndexArray[9][1]= 6.50;
        hermeticIndexArray[10][1]= 6.50;
        hermeticIndexArray[11][1]= 6.50;
        hermeticIndexArray[12][1]= 6.50;
        hermeticIndexArray[13][1]= 6.50;
        hermeticIndexArray[14][1]= 6.50;
        hermeticIndexArray[15][1]= 6.50;
        hermeticIndexArray[16][1]= 6.50;
        hermeticIndexArray[17][1]= 6.50;
    }

    public void setBlownIndexArray60() {
        //[i][j], где i - номер сегмента на графике, t0 = j0, шаг = j1
        hermeticIndexArray[0][0]= 0;
        hermeticIndexArray[0][1]= 2;

        hermeticIndexArray[1][0]= 150; //200-300
        hermeticIndexArray[2][0]= 200; //300-400
        hermeticIndexArray[3][0]= 240; //400-500
        hermeticIndexArray[4][0]= 280; //500-600
        hermeticIndexArray[5][0]= 300; //600-700
        hermeticIndexArray[6][0]= 340; //700-800
        hermeticIndexArray[7][0]= 360; //800-900
        hermeticIndexArray[8][0]= 380; //900-1000
        hermeticIndexArray[9][0]= 390; //1000-1100
        hermeticIndexArray[10][0]= 410; //1100-1200
        hermeticIndexArray[11][0]= 440; //1200-1300
        hermeticIndexArray[12][0]= 480; //1300-1400
        hermeticIndexArray[13][0]= 500; //1400-1500
        hermeticIndexArray[14][0]= 0; //1500-1600
        hermeticIndexArray[15][0]= 0; //1600-1700
        hermeticIndexArray[16][0]= 0; //1800-1900
        hermeticIndexArray[17][0]= 0; //1900-2000

        hermeticIndexArray[1][1]= 100;
        hermeticIndexArray[2][1]= 100;
        hermeticIndexArray[3][1]= 100;
        hermeticIndexArray[4][1]= 100;
        hermeticIndexArray[5][1]= 100;
        hermeticIndexArray[6][1]= 100;
        hermeticIndexArray[7][1]= 100;
        hermeticIndexArray[8][1]= 100;
        hermeticIndexArray[9][1]= 100;
        hermeticIndexArray[10][1]= 100;
        hermeticIndexArray[11][1]= 100;
        hermeticIndexArray[12][1]= 100;
        hermeticIndexArray[13][1]= 100;
        hermeticIndexArray[14][1]= 100;
        hermeticIndexArray[15][1]= 100;
        hermeticIndexArray[16][1]= 100;
        hermeticIndexArray[17][1]= 100;
    }

    public double setMassAirFlow(int airFlow, CoolingType coolingType){
        int massFlow = airFlow;

        if (coolingType.equals(CoolingType.AIR_HERMETIC_INTERNAL)){
            switch (massFlow) {
                case 0:
                    return 1;

                case 1:
                    return 0.9;

                case 2:
                    return 0.7;

                case 3:
                    return 0.65;

                default:
                    return 1;

            }
        }

        if (coolingType.equals(CoolingType.AIR_HERMETIC_EXTERNAL)){
            switch (massFlow) {
                case 0:
                    return 1;

                case 1:
                    return 0.9;

                case 2:
                    return 0.8;

                case 3:
                    return 0.7;

                case 4:
                    return 0.6;

                default:
                    return 1;

            }
        }

        return 1;
    }

    public double setMassAirFlow(boolean isStatic){

        if (isStatic){
            return 300;
        }
        else return 215;
    }

    public double setMassAirFlow(double airFlow){
        return airFlow;
    }



    public double[][] getHermeticIndexArray() {
        return hermeticIndexArray;
    }

    public double[][] getPerforatedIndexArray() {
        return perforatedIndexArray;
    }



}
