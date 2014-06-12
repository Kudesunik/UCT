package ru.kunik.uct.continuedfraction;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import ru.kunik.uct.gui.ContinuedFractionGUI;
import ru.kunik.uct.util.Filters;

public class ContinuedFractionCalculator implements Runnable {

    private String str;
    private final ContinuedFractionGUI contFraction;
    
    public ContinuedFractionCalculator(ContinuedFractionGUI contFraction, String str) {
        this.contFraction = contFraction;
        this.str = str;
    }

    public void run() {
        int[] ans = null;
        if (str.contains("\u2200")) {
            String[] strSplitted = str.split("\u2200");
            if (Filters.isInteger(strSplitted[0]) && Filters.isInteger(strSplitted[1])) {
                List<Integer> continuedFractionDirect = continuedFractionDirect(Integer.parseInt(strSplitted[0]), Integer.parseInt(strSplitted[1]));
                Iterator iter = continuedFractionDirect.listIterator();
                StringBuilder strAns = new StringBuilder();
                while (iter.hasNext()) {
                    strAns.append((Integer)iter.next());
                    strAns.append(", ");
                }
                if (!strAns.toString().isEmpty()) {
                    strAns.deleteCharAt(strAns.toString().length() - 1);
                    strAns.deleteCharAt(strAns.toString().length() - 1);
                    this.contFraction.setDirectAnswer(strAns.toString());
                    this.contFraction.setInfo("Вычислено");
                    this.contFraction.getHandler().getLogger().writeLog(strAns.toString());
                } else {
                    this.contFraction.setDirectAnswer("Ошибка в расчете");
                    this.contFraction.getHandler().getLogger().writeLog("Ошибка в расчете");
                    return;
                }
                ans = continuedFractionReverse(continuedFractionDirect);
            } else {
                this.contFraction.setInfo("Неверные входные данные");
                this.contFraction.getHandler().getLogger().writeLog("Неверные входные данные" + ": " + str);
            }
        } else {
            List<Integer> continuedFractionReverse = new LinkedList<Integer>();
            str = str.replace(" ", "");
            String[] strSplitted = str.split(",");
            for (String strSpl : strSplitted) {
                if (Filters.isInteger(strSpl)) {
                    continuedFractionReverse.add(Integer.parseInt(strSpl));
                } else {
                    this.contFraction.setInfo("Неверные входные данные");
                    this.contFraction.getHandler().getLogger().writeLog("Неверные входные данные" + ": " + str);
                    return;
                }
            }
            ans = continuedFractionReverse(continuedFractionReverse);
            this.contFraction.setInfo("Вычислено");
        }
        if (ans != null) {
            this.contFraction.setNumerator(ans[0] + "");
            this.contFraction.setDenominator(ans[1] + "");
        }
    }
    
    public List<Integer> continuedFractionDirect(double num, double den) {
        List<Integer> lst = new LinkedList<Integer>();
        double ans, buf;
        int iter1 = 10000;
        while (iter1-- >= 0) {
            ans = Math.floor(num / den);
            lst.add(((Double) ans).intValue());
            buf = num;
            num = den;
            den = buf - ans * den;
            if (den == 0) return lst;
        }
        return null;
    }

    public int[] continuedFractionReverse(List<Integer> lst) {
        Collections.reverse(lst);
        double buf, n1 = lst.get(0), n2 = 1;
        lst.remove(0);
        for (int ans : lst) {
            buf = n1;
            n1 = n2 + ans * n1;
            n2 = buf;
        }
        return new int[]{((Double) n1).intValue(), ((Double) n2).intValue()};
    }
}
