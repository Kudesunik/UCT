package ru.kunik.uct.horner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang.math.Fraction;
import ru.kunik.uct.gui.HornerGUI;
import ru.kunik.uct.util.Filters;

public class HornerCalculator implements Runnable {
    
    private String str;
    private final HornerGUI horner;
    
    public HornerCalculator(HornerGUI horner, String str) {
        this.horner = horner;
        this.str = str;
    }

    public void run() {
        HornerHandler.hornerMultipliers.clear();
        String replaced = str.replace(" ", "");
        String[] splited = replaced.split(",");
        for (String strSpl : splited) {
            if (Filters.isDouble(strSpl)) {
                HornerHandler.hornerMultipliers.add(Double.parseDouble(strSpl));
            }
            else {
                this.horner.setInfo("Неверные входные данные");
                this.horner.getHandler().getLogger().writeLog("Неверные входные данные" + ": " + str);
                return;
            }
        }
        int total = HornerHandler.hornerMultipliers.size();
        StringBuilder strBuilder = new StringBuilder("<html>");
        Iterator iter = HornerHandler.hornerMultipliers.listIterator();
        boolean flagFirst = true;
        while (iter.hasNext()) {
            total -= 1;
            double i = ((Double) iter.next()).doubleValue();
            if (flagFirst && i < 0) {
                strBuilder.append("-");
            }
            if (i >= 0) {
                strBuilder.append("+");
            }
            strBuilder.append(i);
            if (total >= 1) strBuilder.append("x");
            strBuilder.append("<sup>");
            if (total > 1) strBuilder.append(total);
            strBuilder.append("</sup>");
        }
        strBuilder.append("</html>");
        this.horner.setEquation(strBuilder.deleteCharAt(6).toString());
        StringBuilder strAns = new StringBuilder();
        HornerHandler.hornerAnswer.clear();
        calculateHorner(HornerHandler.hornerMultipliers);
        for (double d : HornerHandler.hornerAnswer) {
            if (d != ((Double)d).intValue()) {
                int numerator = Fraction.getFraction(d).getNumerator();
                int denominator = Fraction.getFraction(d).getDenominator();
                strAns.append(numerator);
                strAns.append("/");
                strAns.append(denominator);
            }
            else {
                strAns.append(d);
            }
            strAns.append(", ");
        }
        this.horner.setInfo("Вычислено");
        if (!strAns.toString().isEmpty()) {
            strAns.deleteCharAt(strAns.toString().length() - 1);
            strAns.deleteCharAt(strAns.toString().length() - 1);
            this.horner.setAnswer(strAns.toString());
            this.horner.getHandler().getLogger().writeLog("Для введенных коэффициентов уравнения: " + this.str + " корни:");
            this.horner.getHandler().getLogger().writeLog(strAns.toString());
        }
        else {
            this.horner.setAnswer("Корней не найдено");
            this.horner.getHandler().getLogger().writeLog("Корней не найдено");
        }
    }
    
    public static void calculateHorner(List<Double> lst) {
        List<Double> timedMult = new LinkedList<Double>();
        double start = lst.get(lst.size() - 1);
        List<Double> hornerDividers = calculateRationalDividersArray(start, lst.get(0));
        Iterator iterDiv = hornerDividers.listIterator();
        while (iterDiv.hasNext()) {
            double div = (Double) iterDiv.next();
            Iterator iterMult = lst.listIterator();
            double mult = ((Double) iterMult.next());
            timedMult.clear();
            while (iterMult.hasNext()) {
                timedMult.add(mult);
                mult = (div * mult) + ((Double) iterMult.next());
            }
            if (mult == 0.0D) {
                if (!HornerHandler.hornerAnswer.contains(div)) HornerHandler.hornerAnswer.add(div);
                if (lst.size() == 3) addQuadraticRadixes(lst, HornerHandler.hornerAnswer);
                if (timedMult.size() == 3) addQuadraticRadixes(timedMult, HornerHandler.hornerAnswer);
                calculateHorner(timedMult);
            }
        }
    }
    
    /**
     * Old method
     * 
    private static List<Double> calculateRationalDividersArray(double num) {
        List<Double> hornerDividers = new ArrayList<Double>();
        num = Math.abs(num);
        double iter = 1.0D;
        while (iter <= num) {
            if (num % iter == 0) hornerDividers.add(iter);
            iter++;
        }
        List<Double> timedList = new ArrayList<Double>();
        Iterator divIter = hornerDividers.listIterator();
        while(divIter.hasNext()) {
            double d = (Double) divIter.next();
            timedList.add(- d);
            if (d != 1) { 
                timedList.add(1 / d);
                timedList.add(- 1 / d);
            }
        }
        hornerDividers.addAll(timedList);
        return hornerDividers;
    }
    */
    
    private static List<Double> calculateIntegerDividersArray(double num) {
        List<Double> hornerDividers = new ArrayList<Double>();
        num = Math.abs(num);
        for (double iter = (-num); iter <= num; iter++) {
            if (num % iter == 0) hornerDividers.add(iter);
        }
        return hornerDividers;
    }
    
    private static List<Double> calculateRationalDividersArray(double num, double den) {
        List<Double> hornerDividers = new ArrayList<Double>();
        double preAns;
        for (double dNum : calculateIntegerDividersArray(num)) {
            for (double dDen : calculateIntegerDividersArray(den)) {
                preAns = dNum / dDen;
                if (!hornerDividers.contains(preAns)) {
                    hornerDividers.add(preAns);
                }
            }
        }
        return hornerDividers;
    }
    
    public static void addQuadraticRadixes(List<Double> timedMult, List<Double> ans) {
        double d = Math.pow(timedMult.get(1), 2) - 4 * timedMult.get(0) * timedMult.get(2);
        if (d >= 0) {
            double rd = (-timedMult.get(1) + Math.sqrt(d))/(2 * timedMult.get(0));
            if (!ans.contains(rd)) ans.add(rd);
            rd = (-timedMult.get(1) - Math.sqrt(d))/(2 * timedMult.get(0));
            if (!ans.contains(rd)) ans.add(rd);
        }
    }
}
