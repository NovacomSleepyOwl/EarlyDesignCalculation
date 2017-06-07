package by.bsuir.models.thermal.beans;

/**
 * Created by SleepyOwl on 24.05.2017.
 */
public class Const {

    public static  double[][] fFunctionValues = new double[31][2];
    public static  double[][] coefficientKValues = new double[201][2];
    public static  double mEpsilon = 0;
    public static  double standardDeviation = 10;
    public static  double expectation = 0.99;
    public static  double significance = 0.1;

    public Const() {
        setCoefficientKValues();
        setfFunctionValues();
    }

    private void setfFunctionValues(){
        for (int i = 0; i < 30; i++){
            fFunctionValues[i][0] = i + 1;
        }

        fFunctionValues[0][1] = 0.5;
        fFunctionValues[1][1] = 0.539;
        fFunctionValues[2][1] = 0.579;
        fFunctionValues[3][1] = 0.618;
        fFunctionValues[4][1] = 0.655;
        fFunctionValues[5][1] = 0.691;
        fFunctionValues[6][1] = 0.726;
        fFunctionValues[7][1] = 0.758;
        fFunctionValues[8][1] = 0.788;
        fFunctionValues[9][1] = 0.816;
        fFunctionValues[10][1] = 0.841;
        fFunctionValues[11][1] = 0.864;
        fFunctionValues[12][1] = 0.885;
        fFunctionValues[13][1] = 0.903;
        fFunctionValues[14][1] = 0.919;
        fFunctionValues[15][1] = 0.933;
        fFunctionValues[16][1] = 0.945;
        fFunctionValues[17][1] = 0.955;
        fFunctionValues[18][1] = 0.964;
        fFunctionValues[19][1] = 0.971;
        fFunctionValues[20][1] = 0.977;
        fFunctionValues[21][1] = 0.982;
        fFunctionValues[22][1] = 0.986;
        fFunctionValues[23][1] = 0.989;
        fFunctionValues[24][1] = 0.991;
        fFunctionValues[25][1] = 0.994;
        fFunctionValues[26][1] = 0.995;
        fFunctionValues[27][1] = 0.996;
        fFunctionValues[28][1] = 0.997;
        fFunctionValues[29][1] = 0.998;
        fFunctionValues[30][1] = 0.999;


    }

    private void setCoefficientKValues(){
        for (int i = 0; i < 199; i++){
            coefficientKValues[i][0] = i;
        }

        coefficientKValues[2][1] = 48.43;
        coefficientKValues[3][1] = 12.86;
        coefficientKValues[4][1] = 8.29;
        coefficientKValues[5][1] = 6.63;
        coefficientKValues[6][1] = 5.77;
        coefficientKValues[7][1] = 5.25;
        coefficientKValues[8][1] = 4.89;
        coefficientKValues[9][1] = 4.63;
        coefficientKValues[10][1] = 4.43;
        coefficientKValues[11][1] = 4.28;
        coefficientKValues[12][1] = 4.15;
        coefficientKValues[13][1] = 4.04;
        coefficientKValues[14][1] = 3.95;
        coefficientKValues[15][1] = 3.88;
        coefficientKValues[16][1] = 3.81;
        coefficientKValues[17][1] = 3.75;
        coefficientKValues[18][1] = 3.70;
        coefficientKValues[19][1] = 3.66;
        coefficientKValues[20][1] = 3.61;
        coefficientKValues[21][1] = 3.58;
        coefficientKValues[22][1] = 3.54;
        coefficientKValues[23][1] = 3.51;
        coefficientKValues[24][1] = 3.48;
        coefficientKValues[25][1] = 3.46;
        coefficientKValues[26][1] = 3.43;
        coefficientKValues[27][1] = 3.41;
        coefficientKValues[28][1] = 3.39;
        coefficientKValues[29][1] = 3.37;
        coefficientKValues[30][1] = 3.35;
        coefficientKValues[31][1] = 3.33;
        coefficientKValues[32][1] = 3.32;
        coefficientKValues[33][1] = 3.30;
        coefficientKValues[34][1] = 3.29;
        coefficientKValues[35][1] = 3.27;
        coefficientKValues[36][1] = 3.26;
        coefficientKValues[37][1] = 3.25;
        coefficientKValues[38][1] = 3.24;
        coefficientKValues[39][1] = 3.23;
        coefficientKValues[40][1] = 3.21;
        coefficientKValues[41][1] = 3.20;
        coefficientKValues[42][1] = 3.19;
        coefficientKValues[43][1] = 3.18;
        coefficientKValues[44][1] = 3.17;
        coefficientKValues[45][1] = 3.16;
        coefficientKValues[46][1] = 3.16;
        coefficientKValues[47][1] = 3.15;
        coefficientKValues[48][1] = 3.14;
        coefficientKValues[49][1] = 3.13;
        coefficientKValues[50][1] = 3.12;
        coefficientKValues[51][1] = 3.12;
        coefficientKValues[52][1] = 3.11;
        coefficientKValues[53][1] = 3.11;
        coefficientKValues[54][1] = 3.10;
        coefficientKValues[55][1] = 3.10;
        coefficientKValues[56][1] = 3.09;
        coefficientKValues[57][1] = 3.09;
        coefficientKValues[58][1] = 3.08;
        coefficientKValues[59][1] = 3.08;
        coefficientKValues[60][1] = 3.07;
        coefficientKValues[61][1] = 3.07;
        coefficientKValues[62][1] = 3.06;
        coefficientKValues[63][1] = 3.06;
        coefficientKValues[64][1] = 3.05;
        coefficientKValues[65][1] = 3.05;
        coefficientKValues[66][1] = 3.04;
        coefficientKValues[67][1] = 3.04;
        coefficientKValues[68][1] = 3.03;
        coefficientKValues[69][1] = 3.03;
        coefficientKValues[70][1] = 3.02;
        coefficientKValues[71][1] = 3.02;
        coefficientKValues[72][1] = 3.02;
        coefficientKValues[73][1] = 3.02;
        coefficientKValues[74][1] = 3.02;
        coefficientKValues[75][1] = 3.00;
        coefficientKValues[76][1] = 3.00;
        coefficientKValues[77][1] = 3.00;
        coefficientKValues[78][1] = 3.00;
        coefficientKValues[79][1] = 3.00;
        coefficientKValues[80][1] = 2.99;
        coefficientKValues[81][1] = 2.99;
        coefficientKValues[82][1] = 2.99;
        coefficientKValues[83][1] = 2.99;
        coefficientKValues[84][1] = 2.99;
        coefficientKValues[85][1] = 2.97;
        coefficientKValues[86][1] = 2.97;
        coefficientKValues[87][1] = 2.97;
        coefficientKValues[88][1] = 2.97;
        coefficientKValues[89][1] = 2.97;
        coefficientKValues[90][1] = 2.96;
        coefficientKValues[91][1] = 2.96;
        coefficientKValues[92][1] = 2.96;
        coefficientKValues[93][1] = 2.96;
        coefficientKValues[94][1] = 2.96;
        coefficientKValues[95][1] = 2.94;
        coefficientKValues[96][1] = 2.94;
        coefficientKValues[97][1] = 2.94;
        coefficientKValues[98][1] = 2.94;
        coefficientKValues[99][1] = 2.94;
        coefficientKValues[100][1] = 2.93;
        coefficientKValues[101][1] = 2.93;
        coefficientKValues[102][1] = 2.93;
        coefficientKValues[103][1] = 2.93;
        coefficientKValues[104][1] = 2.93;
        coefficientKValues[105][1] = 2.92;
        coefficientKValues[106][1] = 2.92;
        coefficientKValues[107][1] = 2.92;
        coefficientKValues[108][1] = 2.92;
        coefficientKValues[109][1] = 2.92;
        coefficientKValues[110][1] = 2.91;
        coefficientKValues[111][1] = 2.91;
        coefficientKValues[112][1] = 2.91;
        coefficientKValues[113][1] = 2.91;
        coefficientKValues[114][1] = 2.91;
        coefficientKValues[115][1] = 2.90;
        coefficientKValues[116][1] = 2.90;
        coefficientKValues[117][1] = 2.90;
        coefficientKValues[118][1] = 2.90;
        coefficientKValues[119][1] = 2.90;
        coefficientKValues[120][1] = 2.89;
        coefficientKValues[121][1] = 2.89;
        coefficientKValues[122][1] = 2.89;
        coefficientKValues[123][1] = 2.89;
        coefficientKValues[124][1] = 2.89;
        coefficientKValues[125][1] = 2.89;
        coefficientKValues[126][1] = 2.89;
        coefficientKValues[127][1] = 2.89;
        coefficientKValues[128][1] = 2.89;
        coefficientKValues[129][1] = 2.89;
        coefficientKValues[130][1] = 2.88;
        coefficientKValues[131][1] = 2.88;
        coefficientKValues[132][1] = 2.88;
        coefficientKValues[133][1] = 2.88;
        coefficientKValues[134][1] = 2.88;
        coefficientKValues[135][1] = 2.88;
        coefficientKValues[136][1] = 2.88;
        coefficientKValues[137][1] = 2.88;
        coefficientKValues[138][1] = 2.88;
        coefficientKValues[139][1] = 2.88;
        coefficientKValues[140][1] = 2.87;
        coefficientKValues[141][1] = 2.87;
        coefficientKValues[142][1] = 2.87;
        coefficientKValues[143][1] = 2.87;
        coefficientKValues[144][1] = 2.87;
        coefficientKValues[145][1] = 2.87;
        coefficientKValues[146][1] = 2.87;
        coefficientKValues[147][1] = 2.87;
        coefficientKValues[148][1] = 2.87;
        coefficientKValues[149][1] = 2.87;
        coefficientKValues[150][1] = 2.86;
        coefficientKValues[151][1] = 2.86;
        coefficientKValues[152][1] = 2.86;
        coefficientKValues[153][1] = 2.86;
        coefficientKValues[154][1] = 2.86;
        coefficientKValues[155][1] = 2.86;
        coefficientKValues[156][1] = 2.86;
        coefficientKValues[157][1] = 2.86;
        coefficientKValues[158][1] = 2.86;
        coefficientKValues[159][1] = 2.86;
        coefficientKValues[160][1] = 2.85;
        coefficientKValues[161][1] = 2.85;
        coefficientKValues[162][1] = 2.85;
        coefficientKValues[163][1] = 2.85;
        coefficientKValues[164][1] = 2.85;
        coefficientKValues[165][1] = 2.85;
        coefficientKValues[166][1] = 2.85;
        coefficientKValues[167][1] = 2.85;
        coefficientKValues[168][1] = 2.85;
        coefficientKValues[169][1] = 2.85;
        coefficientKValues[170][1] = 2.84;
        coefficientKValues[171][1] = 2.84;
        coefficientKValues[172][1] = 2.84;
        coefficientKValues[173][1] = 2.84;
        coefficientKValues[174][1] = 2.84;
        coefficientKValues[175][1] = 2.84;
        coefficientKValues[176][1] = 2.84;
        coefficientKValues[177][1] = 2.84;
        coefficientKValues[178][1] = 2.84;
        coefficientKValues[179][1] = 2.84;
        coefficientKValues[180][1] = 2.83;
        coefficientKValues[181][1] = 2.83;
        coefficientKValues[182][1] = 2.83;
        coefficientKValues[183][1] = 2.83;
        coefficientKValues[184][1] = 2.83;
        coefficientKValues[185][1] = 2.83;
        coefficientKValues[186][1] = 2.83;
        coefficientKValues[187][1] = 2.83;
        coefficientKValues[188][1] = 2.83;
        coefficientKValues[189][1] = 2.83;
        coefficientKValues[190][1] = 2.82;
        coefficientKValues[191][1] = 2.82;
        coefficientKValues[192][1] = 2.82;
        coefficientKValues[193][1] = 2.82;
        coefficientKValues[194][1] = 2.82;
        coefficientKValues[195][1] = 2.82;
        coefficientKValues[196][1] = 2.82;
        coefficientKValues[197][1] = 2.82;
        coefficientKValues[198][1] = 2.82;
        coefficientKValues[199][1] = 2.82;
        coefficientKValues[200][1] = 2.81;

    }

}
