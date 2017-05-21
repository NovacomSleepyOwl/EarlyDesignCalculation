package by.bsuir.models.cooling;

import by.bsuir.models.cooling.types.CoolingType;

/**
 * Created by SleepyOwl on 18.05.2017.
 */
public class PressureCalculation {

    /*private double internalPressure;
    private double foreignPressure;

    private double w;
*/
    private static double[][] equalHermetic = new double[10][2];
    private static double[][] unequalHermetic = new double[10][2];
    private static double[][] hermeticBlownOn = new double[10][2];
    private static double[][] hermeticMixedAir = new double[10][2];
    private static double[][] perforated = new double[10][2];


    public double definePressureCoefficient(CoolingType type){



        return 0;
    }

    private void setEqualLowerPressure() {
        equalHermetic[0][0] = 0.67;
        equalHermetic[1][0] = 0.53;
        equalHermetic[2][0] = 0.4;
        equalHermetic[3][0] = 0.27;
        equalHermetic[4][0] = 0.13;
        equalHermetic[5][0] = 0.11;
        equalHermetic[6][0] = 0.08;
        equalHermetic[7][0] = 0.05;
        equalHermetic[8][0] = 0.03;
        equalHermetic[9][0] = 0.007;

        equalHermetic[0][1] = 1.08;
        equalHermetic[1][1] = 1.12;
        equalHermetic[2][1] = 1.19;
        equalHermetic[3][1] = 1.26;
        equalHermetic[4][1] = 1.35;
        equalHermetic[5][1] = 1.38;
        equalHermetic[6][1] = 1.40;
        equalHermetic[7][1] = 1.44;
        equalHermetic[8][1] = 1.47;
        equalHermetic[9][1] = 1.51;

    }

    private void setUnequalHermetic(double internalPressure){

        for (int i = 0; i < 10; i++){
           unequalHermetic[i][0] = equalHermetic[i][0];
        }

        if (internalPressure <= 0.75 && internalPressure > 0.61){

            unequalHermetic[0][1] = 1.06;
            unequalHermetic[1][1] = 1.09;
            unequalHermetic[2][1] = 1.13;
            unequalHermetic[3][1] = 1.17;
            unequalHermetic[4][1] = 1.25;
            unequalHermetic[5][1] = 1.28;
            unequalHermetic[6][1] = 1.30;
            unequalHermetic[7][1] = 1.33;
            unequalHermetic[8][1] = 1.35;
            unequalHermetic[9][1] = 1.38;

        }

        if (internalPressure <= 0.61 && internalPressure > 0.27){

            unequalHermetic[0][1] = 0;
            unequalHermetic[1][1] = 1.11;
            unequalHermetic[2][1] = 1.15;
            unequalHermetic[3][1] = 1.19;
            unequalHermetic[4][1] = 1.26;
            unequalHermetic[5][1] = 1.29;
            unequalHermetic[6][1] = 1.31;
            unequalHermetic[7][1] = 1.33;
            unequalHermetic[8][1] = 1.36;
            unequalHermetic[9][1] = 1.38;
        }

        if (internalPressure <= 0.27 && internalPressure > 0.13){

            unequalHermetic[0][1] = 0;
            unequalHermetic[1][1] = 0;
            unequalHermetic[2][1] = 0;
            unequalHermetic[3][1] = 1.26;
            unequalHermetic[4][1] = 1.32;
            unequalHermetic[5][1] = 1.34;
            unequalHermetic[6][1] = 1.36;
            unequalHermetic[7][1] = 1.39;
            unequalHermetic[8][1] = 1.40;
            unequalHermetic[9][1] = 1.43;
        }

        if (internalPressure <= 0.13){

            unequalHermetic[0][1] = 0;
            unequalHermetic[1][1] = 0;
            unequalHermetic[2][1] = 0;
            unequalHermetic[3][1] = 0;
            unequalHermetic[4][1] = 1.35;
            unequalHermetic[5][1] = 1.37;
            unequalHermetic[6][1] = 1.40;
            unequalHermetic[7][1] = 1.42;
            unequalHermetic[8][1] = 1.45;
            unequalHermetic[9][1] = 1.46;
        }
    }

    private void setHermeticBlownOn(int w){

        for (int i = 0; i < 10; i++){
            hermeticBlownOn[i][0] = equalHermetic[i][0];
        }

        if (w == 1 || w == 2){

            hermeticBlownOn[0][1] = 1.03;
            hermeticBlownOn[1][1] = 1.06;
            hermeticBlownOn[2][1] = 1.1;
            hermeticBlownOn[3][1] = 1.6;
            hermeticBlownOn[4][1] = 1.24;
            hermeticBlownOn[5][1] = 1.28;
            hermeticBlownOn[6][1] = 1.3;
            hermeticBlownOn[7][1] = 1.35;
            hermeticBlownOn[8][1] = 1.37;
            hermeticBlownOn[9][1] = 1.39;
        }
        if (w == 3 || w == 4){

            hermeticBlownOn[0][1] = 1.05;
            hermeticBlownOn[1][1] = 1.09;
            hermeticBlownOn[2][1] = 1.15;
            hermeticBlownOn[3][1] = 1.22;
            hermeticBlownOn[4][1] = 1.32;
            hermeticBlownOn[5][1] = 1.35;
            hermeticBlownOn[6][1] = 1.38;
            hermeticBlownOn[7][1] = 1.45;
            hermeticBlownOn[8][1] = 1.48;
            hermeticBlownOn[9][1] = 1.51;
        }
    }

    private void setHermeticMixedAir(int w){

        for (int i = 0; i < 10; i++){
            hermeticMixedAir[i][0] = equalHermetic[i][0];
        }

        if (w == 1){

            hermeticMixedAir[0][1] = 1.05;
            hermeticMixedAir[1][1] = 1.09;
            hermeticMixedAir[2][1] = 1.13;
            hermeticMixedAir[3][1] = 1.22;
            hermeticMixedAir[4][1] = 1.35;
            hermeticMixedAir[5][1] = 1.41;
            hermeticMixedAir[6][1] = 1.47;
            hermeticMixedAir[7][1] = 1.53;
            hermeticMixedAir[8][1] = 1.61;
            hermeticMixedAir[9][1] = 1.73;
        }

        if (w == 2){

            hermeticMixedAir[0][1] = 1.07;
            hermeticMixedAir[1][1] = 1.1;
            hermeticMixedAir[2][1] = 1.16;
            hermeticMixedAir[3][1] = 1.25;
            hermeticMixedAir[4][1] = 1.4;
            hermeticMixedAir[5][1] = 1.48;
            hermeticMixedAir[6][1] = 1.54;
            hermeticMixedAir[7][1] = 1.61;
            hermeticMixedAir[8][1] = 1.70;
            hermeticMixedAir[9][1] = 1.85;
        }

        if (w == 3){

            hermeticMixedAir[0][1] = 1.08;
            hermeticMixedAir[1][1] = 1.12;
            hermeticMixedAir[2][1] = 1.18;
            hermeticMixedAir[3][1] = 1.30;
            hermeticMixedAir[4][1] = 1.48;
            hermeticMixedAir[5][1] = 1.55;
            hermeticMixedAir[6][1] = 1.64;
            hermeticMixedAir[7][1] = 1.72;
            hermeticMixedAir[8][1] = 1.85;
            hermeticMixedAir[9][1] = 2.02;
        }
    }

    private void setPerforated(){

        for (int i = 0; i < 10; i++){
            perforated[i][0] = equalHermetic[i][0];
        }

        perforated[0][1] = 1.07;
        perforated[1][1] = 1.19;
        perforated[2][1] = 1.28;
        perforated[3][1] = 1.36;
        perforated[4][1] = 1.6;
        perforated[5][1] = 1.67;
        perforated[6][1] = 1.76;
        perforated[7][1] = 1.87;
        perforated[8][1] = 2.02;
        perforated[9][1] = 2.17;

    }
}



































