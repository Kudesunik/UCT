package ru.kunik.uct.horner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
            if (Filters.isInteger(strSpl)) {
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
        while (iter.hasNext()) {
            total -= 1;
            int i = ((Double) iter.next()).intValue();
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
        for (double d : calculateHorner(HornerHandler.hornerMultipliers)) {
            strAns.append(d);
            strAns.append(", ");
        }
        this.horner.setInfo("Вычислено");
        if (!strAns.toString().isEmpty()) {
            strAns.deleteCharAt(strAns.toString().length() - 1);
            strAns.deleteCharAt(strAns.toString().length() - 1);
            this.horner.setAnswer(strAns.toString());
            this.horner.getHandler().getLogger().writeLog(strAns.toString());
        }
        else {
            this.horner.setAnswer("Корней не найдено");
            this.horner.getHandler().getLogger().writeLog("Корней не найдено");
        }
    }
    
    public static List<Double> calculateHorner(List<Double> lst) {
        List<Double> ans = new ArrayList<Double>();
        double start = lst.get(lst.size() - 1);
        List<Double> hornerDividers = calculateRationalDividersArray(start);
        Iterator iterDiv = hornerDividers.listIterator();
        while (iterDiv.hasNext()) {
            double div = (Double) iterDiv.next();
            Iterator iterMult = HornerHandler.hornerMultipliers.listIterator();
            double mult = ((Double) iterMult.next());
            while (iterMult.hasNext()) {
                mult = (div * mult) + ((Double) iterMult.next());
            }
            if (mult == 0.0D) ans.add(div);
        }
        return ans;
    }
    
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
}
