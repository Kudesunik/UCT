package ru.kunik.uct.combocalculator;

import java.util.ArrayList;
import ru.kunik.uct.gui.CombocalculatorGUI;

public class FactorialCalculator implements Runnable {

    private String str;
    private final CombocalculatorGUI combo;

    public FactorialCalculator(CombocalculatorGUI combo, String str) {
        this.combo = combo;
        this.str = str;
    }

    public void run() {
        int num = Integer.parseInt(str);
        long ans = calculateFactorial(num);
        combo.setFactorialAnswer(ans + "");
        combo.setInfo("Вычислено");
        combo.getHandler().getLogger().writeLog("Факториал " + str + " = " + ans);
        ans = calculateDoubleFactorial(num);
        combo.setDoubleFactorialAnswer(ans + "");
        combo.setInfo("Вычислено");
        combo.getHandler().getLogger().writeLog("Двойной факториал " + str + " = " + ans);
        ans = calculatePrimorial(num);
        combo.setPrimorialAnswer(ans + "");
        combo.setInfo("Вычислено");
        combo.getHandler().getLogger().writeLog("Праймориал " + str + " = " + ans);
        ans = calculateSuperfactorial(num);
        combo.setSuperfactorialAnswer(ans + "");
        combo.setInfo("Вычислено");
        combo.getHandler().getLogger().writeLog("Суперфакториал " + str + " = " + ans);
        ans = calculateSubFactorial(num);
        combo.setSubfactorialAnswer(ans + "");
        combo.setInfo("Вычислено");
        combo.getHandler().getLogger().writeLog("Субфакториал " + str + " = " + ans);
    }

    public static long calculateFactorial(long num) {
        if (num == 0) return 1;
        return num * calculateFactorial(num - 1);
    }

    public long calculateDoubleFactorial(long num) {
        if (num <= 0) return 1;
        return num * calculateDoubleFactorial(num - 2);
    }

    public long calculatePrimorial(long num) {
        long primorial = 1;
        for (long i : getPrimeNumbers(num)) {
            primorial *= i;
        }
        return primorial;
    }

    private ArrayList<Long> getPrimeNumbers(long n) {
        ArrayList<Long> primeNums = new ArrayList<Long>();
        primeNums.add(Long.valueOf(1));
        primeNums.add(Long.valueOf(2));
        for (long i = 3; i <= n; i += 2) {
            int count = 0;
            for (long k : primeNums) {
                if (i % k == 0) {
                    count++;
                }
            }
            if (count < 2) {
                primeNums.add(i);
            }
        }
        return primeNums;
    }
    
    public long calculateSuperfactorial(long num){
        if (num == 0) return 1;
        return calculateFactorial(num) * calculateSuperfactorial(num - 1);
    }
    
    public long calculateSubFactorial(long num) {
        double ans = 1.0D;
        for (int iter1 = 1; iter1 <= num; iter1++) {
            ans += ((1.0D/(double) calculateFactorial(iter1)) * (Math.pow((-1), iter1)));
        }
        return Math.round(ans * calculateFactorial(num));
    }
}
