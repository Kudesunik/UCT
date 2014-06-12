package ru.kunik.uct.factorization;

import ru.kunik.uct.gui.FactorizationGUI;
import ru.kunik.uct.util.Debug;
import ru.kunik.uct.util.Filters;

public class FactorizationCalculator implements Runnable {

    private String str;
    private final FactorizationGUI factor;

    public FactorizationCalculator(FactorizationGUI factor, String str) {
        this.factor = factor;
        this.str = str;
    }

    public void run() {
        FactorizationHandler.factorList.clear();
        FactorizationHandler.dividersList.clear();
        FactorizationHandler.dividersNumber = 0;
        FactorizationHandler.dividersSum = 0;
        if (filter(str)) {
            int num = Integer.parseInt(str);
            calculateFactor(num);
            calculateDividersArray(num);
            calculateDividersNumberAndSum();
            factor.setInfo("Вычислено");
            factor.getHandler().getLogger().writeLog("Введенное число: " + num);
            factor.getHandler().getLogger().writeLog("Сомножители: ");
            StringBuilder strb = new StringBuilder();
            for (int iter : FactorizationHandler.factorList) {
                strb.append(iter);
                strb.append(", ");
            }
            if (strb.length() > 2) {
                strb.delete(strb.length() - 2, strb.length() - 1);
            }
            factor.setFactor(strb.toString());
            factor.getHandler().getLogger().writeLog(strb.toString());
            factor.getHandler().getLogger().writeLog("Множество делителей: ");
            strb = new StringBuilder();
            for (int iter : FactorizationHandler.dividersList) {
                strb.append(iter);
                strb.append(", ");
            }
            strb.delete(strb.length() - 2, strb.length() - 1);
            factor.setDividersArray(strb.toString());
            factor.getHandler().getLogger().writeLog(strb.toString());
            factor.setDividersNumber(FactorizationHandler.dividersNumber + "");
            factor.getHandler().getLogger().writeLog("Число делителей: " + FactorizationHandler.dividersNumber);
            factor.setDividersSum(FactorizationHandler.dividersSum + "");
            factor.getHandler().getLogger().writeLog("Сумма делителей: " + FactorizationHandler.dividersSum);
        }
    }

    private void calculateFactor(int num) {
        Debug.startProfiler("calculateFactor");
        boolean flag = true;
        while (flag) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    FactorizationHandler.factorList.add(i);
                    num = num / i;
                    flag = true;
                    break;
                } else if (flag) {
                    flag = false;
                }
            }
            if (num == 2) {
                flag = false;
            }
        }
        if (num != 1) {
            FactorizationHandler.factorList.add(num);
        }
        Debug.stopProfiler("calculateFactor");
    }
    
    /**
    private void calculateFactor(int num) {
        for (int iter = 2, limit = (int) Math.ceil(Math.sqrt(num)); iter <= limit;) {
            if (num % iter == 0) {
                num = num / iter;
                limit = (int) Math.ceil(Math.sqrt(num));
                FactorizationHandler.dividersList.add(iter);
            } else {
                iter++;
            }
        }
    }
    */

    private void calculateDividersArray(int num) {
        Debug.startProfiler("calculateDividersArray");
        int iter = 1;
        while (iter <= num) {
            if (num % iter == 0) {
                FactorizationHandler.dividersList.add(iter);
            }
            iter++;
        }
        Debug.stopProfiler("calculateDividersArray");
    }

    private void calculateDividersNumberAndSum() {
        Debug.startProfiler("calculateDividersNumberAndSum");
        for (int iter : FactorizationHandler.dividersList) {
            FactorizationHandler.dividersNumber++;
            FactorizationHandler.dividersSum += iter;
        }
        Debug.stopProfiler("calculateDividersNumberAndSum");
    }

    private boolean filter(String str) {
        if (str.length() <= 9 && Filters.isPositiveInteger(str)) {
            return true;
        } else {
            this.factor.setInfo("Неверное число");
            factor.getHandler().getLogger().writeLog("Неверное число" + ": " + str);
            factor.setFactor("Неизвестно");
            factor.setDividersArray("Неизвестно");
            factor.setDividersNumber("Неизвестно");
            factor.setDividersSum("Неизвестно");
        }
        return false;
    }
}
