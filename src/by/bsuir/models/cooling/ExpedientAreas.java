package by.bsuir.models.cooling;

import java.util.AbstractList;

public class ExpedientAreas {
    //Класс, для алгроитма поска области целесообразного применения типов охлаждения

    private double logHeatFlux; //q
    private double overheat; //deltaT


    public ExpedientAreas(double logHeatFlux, double overheat) {
        this.logHeatFlux = logHeatFlux;
        this.overheat = overheat;

        this.EQ_1_2 = (overheat + 920)/400;
        this.formulaArray[0] = EQ_1_2;
        this.EQ_2_3 = (overheat + 433)/166;
        this.formulaArray[1] = EQ_2_3;
        this.EQ_3_4 = (overheat + 1550)/500;
        this.formulaArray[2] = EQ_3_4;
        this.EQ_4_5 = (overheat + 1600)/500;
        this.formulaArray[3] = EQ_4_5;

        this.EQ_5_6 = (overheat + 860)/215;
        this.formulaArray[4] = EQ_5_6;
        this.overFormulaArray[4] = EQ_5_6;
        this.EQ_6_7 = (overheat + 1000)/200;
        this.formulaArray[5] = EQ_6_7;
        this.overFormulaArray[5] = EQ_6_7;
        this.EQ_7_8 = (overheat + 1050)/200;
        this.formulaArray[6] = EQ_7_8;
        this.overFormulaArray[6] = EQ_7_8;
        this.EQ_8_9 = (overheat + 1400)/250;
        this.formulaArray[7] = EQ_8_9;
        this.overFormulaArray[7] = EQ_8_9;
        this.EQ_9 = (overheat + 1625)/250;
        this.formulaArray[8] = EQ_9;
        this.overFormulaArray[8] = EQ_9;

        this.EQ_1_2_100 = (overheat + 750)/250;
        this.overFormulaArray[0] = EQ_1_2_100;
        this.EQ_2_3_100 = (overheat + 700)/217;
        this.overFormulaArray[1] = EQ_2_3_100;
        this.EQ_3_4_100 = (overheat + 888)/250;
        this.overFormulaArray[2] = EQ_3_4_100;
        this.EQ_4_5_100 = (overheat + 913)/250;
        this.overFormulaArray[3] = EQ_4_5_100;



    }

    //const
    //уравнения
   private final double EQ_1_2;
   private final double EQ_2_3;
   private final double EQ_3_4;
   private final double EQ_4_5;

   private final double EQ_5_6;
   private final double EQ_6_7;
   private final double EQ_7_8;
   private final double EQ_8_9;
   private final double EQ_9;

   //формулы функций для Т > 100
   private final double EQ_1_2_100;
   private final double EQ_2_3_100;
   private final double EQ_3_4_100;
   private final double EQ_4_5_100;

   //массивы формул
   private double[] formulaArray = new double[9];
   private double[] overFormulaArray = new double[9];

    //метод поиска области целесообразности
    public int findArea(){
        int area = 0; //номер области на графике
        double q; //вычисляемая lg(q) по аппроксимированной формуле для сравнения с входной lg(q)

        //Алгоритм поиска области целесообразности
        if (overheat < 100){
            for(int i = 0; i < formulaArray.length; i++){
                q = formulaArray[i];
                if (logHeatFlux <= q){
                    area = ++i;
                    i = formulaArray.length;
                }
            }
        }

        //Для больших элементов, дельта-Т больше 100-----------------------
        if (overheat > 100){
            for(int i = 0; i < overFormulaArray.length; i++){
                q = overFormulaArray[i];
                if (logHeatFlux <= q){
                    area = ++i;
                    i = overFormulaArray.length;
                }
            }
        }
        return area;
    }
}
