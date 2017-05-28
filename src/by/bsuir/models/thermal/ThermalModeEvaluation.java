package by.bsuir.models.thermal;


import by.bsuir.models.thermal.beans.Const;
import by.bsuir.models.thermal.beans.Element;
import by.bsuir.models.thermal.beans.InputData;
import by.bsuir.models.thermal.beans.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by SleepyOwl on 23.05.2017.
 */
public class ThermalModeEvaluation {

    //расчет вероятности отказа первых трех элемнтов в ряду
    public Output firstThreeEvaluation(InputData input){

        Output output = new Output();
        input.setElements(sortElementArray(input.getElements(), input.getPermissibleOverheat()));

        System.out.println("");
        Collections.sort(input.getElements(), new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return Double.compare(o1.getOverheat(), o2.getOverheat());
            }
        });

        for (int i = 0; i < input.getElements().size(); i++){
            input.getElements().get(i).setIndex(i);
        }


        double exp = calculateForThreeExpectation(input.getElements().get(0).getOverheat(),
                                                  input.getElements().get(1).getOverheat(),
                                                  input.getElements().get(2).getOverheat());

        if ( exp < 0.05){
            output.setThermalModeIsOk(true);
        }else output.setThermalModeIsOk(false); //Оценка теплового режима

        output.setExpectationForFirstThreeElements(exp);
        output.setF1(input.getElements().get(0).getOverheat());
        output.setF2(input.getElements().get(0).getOverheat());
        output.setF3(input.getElements().get(0).getOverheat());

        return output;

    }



    //рассчитать вероятность перегрева первых трех элементов
    private double calculateForThreeExpectation(double overheat1, double overheat2, double overheat3){
        if (overheat1 > 30 || overheat2 > 30 || overheat3 > 30){

            return 0;
        }

        int o1 = (int)overheat1;
        int o2 = (int)overheat2;
        int o3 = (int)overheat3;

        return (1 - Const.fFunctionValues[o1][1]) * (1 - Const.fFunctionValues[o2][1]) * (1 - Const.fFunctionValues[o3][1]);

    }

    //Отсеять элементы не подлежащие расчету оценки теплового режима
    private ArrayList<Element> sortElementArray(ArrayList<Element> elements, double overheat){
        ArrayList<Element> elements1 = elements;

        for (Element element : elements1){
            if (element.getTempPredetermined() < overheat){
                element.setSubjectToInvestigation(true);
            }
            else {
                element.setSubjectToInvestigation(false);
                //elements1.remove(element);
            }
        }

        return elements1;
    }

    //Сортировка на стадии макетирования
    private ArrayList<Element> sortElementsForModel(ArrayList<Element> inputElements){
        ArrayList<Element> outputElements = inputElements;
        int number = 0;
        for (int i = 0; i < outputElements.size() && number != i; i++){
            if ((Const.coefficientKValues[i][1] * 10) < outputElements.get(i).getOverheat()){
                number = i;
            }
        }
        number++;
        for (;number < outputElements.size(); number++){
            outputElements.remove(number);
        }

        return outputElements;
    }

    private double defineEpsilon(ArrayList<Element> inputElements){
        double epsilon = 0;

        for (Element element : inputElements){
            epsilon += element.getTempMeasured() - element.getTempCalculated();
        }
        epsilon /= inputElements.size();

        return epsilon;
    }

    private double defineS(ArrayList<Element> inputElements, double epsilon){
        double s = 0;
        for ( Element element : inputElements){
            s += Math.pow((element.getTempMeasured() - element.getTempCalculated() - epsilon), 2);
        }
        s /= inputElements.size() - 1;
        s = Math.sqrt(s);

        return s;
    }

    //Проверка соответствтия режима элемента ТУ
    private double checkElementByThermalModel(double epsilon, double s, double k){

        return epsilon + s * k;
    }

    //Оценка макета
    public Output modelEvaluation(Output input){


        return input;
    }

}
