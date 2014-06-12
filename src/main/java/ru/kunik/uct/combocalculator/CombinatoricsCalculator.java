package ru.kunik.uct.combocalculator;

import java.util.HashMap;
import java.util.Map;
import ru.kunik.uct.gui.CombocalculatorGUI;

public class CombinatoricsCalculator implements Runnable {
    
    private String nStr;
    private String kStr;
    private final CombocalculatorGUI combo;
    
    public CombinatoricsCalculator(CombocalculatorGUI combo, String nStr, String kStr) {
        this.combo = combo;
        this.nStr = nStr;
        this.kStr = kStr;
    }

    public void run() {
        
        long ans;
        
        ans = calculateRepPermutation(nStr);
        combo.setPermutationRepAnswer(ans + "");
        combo.setInfo("Вычислено");
        combo.getHandler().getLogger().writeLog("Перестановки элементов строки " + nStr + " = " + ans);
        
        int n = Integer.parseInt(nStr);
        
        ans = calculatePermutation(n);
        combo.setPermutationAnswer(ans + "");
        combo.setInfo("Вычислено");
        combo.getHandler().getLogger().writeLog("Перестановки элементов n = " + n);
        
        int k = Integer.parseInt(kStr);
        
        if (k >= n) {
            combo.setPlacementAnswer("k больше или равное n");
            combo.setInfo("Число элементов в группе должно быть меньше общего числа элементов");
            combo.getHandler().getLogger().writeLog("Число элементов в группе должно быть < общего числа элементов");
        }
        else {
            ans = calculatePlacement(n, k);
            combo.setPlacementAnswer(ans + "");
            combo.setInfo("Вычислено");
            combo.getHandler().getLogger().writeLog("Размещение " + n + " по " + k + " = " + ans);
        }
        ans = calculateRepPlacement(n, k);
        combo.setPlacementRepAnswer(ans + "");
        combo.setInfo("Вычислено");
        combo.getHandler().getLogger().writeLog("Размещение с повторениями " + n + " по " + k + " = " + ans);
        if (k >= n) {
            combo.setCombinationAnswer("k больше или равное n");
            combo.setInfo("Число элементов в группе должно быть < общего числа элементов");
            combo.getHandler().getLogger().writeLog("Число элементов в группе должно быть меньше общего числа элементов");
        }
        else {
            ans = calculateCombination(n, k);
            combo.setCombinationAnswer(ans + "");
            combo.setInfo("Вычислено");
            combo.getHandler().getLogger().writeLog("Сочетание " + n + " по " + k + " = " + ans);
        }
        if (n < 2) {
            combo.setCombinationRepAnswer("n меньше 2");
            combo.setInfo("Число n должно быть больше 2");
            combo.getHandler().getLogger().writeLog("Число n должно быть больше 2");
        }
        else {
            ans = calculateRepCombination(n, k);
            combo.setCombinationRepAnswer(ans + "");
            combo.setInfo("Вычислено");
            combo.getHandler().getLogger().writeLog("Сочетание с повторениями " + n + " по " + k + " = " + ans);
        }
    }
    
    public long calculatePlacement(int n, int k) {
        return (FactorialCalculator.calculateFactorial(n) / FactorialCalculator.calculateFactorial(n - k));
    }
    
    public long calculateRepPlacement(int n, int k) {
        return (long) (Math.pow(n, k));
    }
    
    public long calculateCombination(int n, int k) {
        return FactorialCalculator.calculateFactorial(n) / (FactorialCalculator.calculateFactorial(k) * FactorialCalculator.calculateFactorial(n - k));
    }
    
    public long calculateRepCombination(int n, int k) {
        return FactorialCalculator.calculateFactorial(n + k - 1) / (FactorialCalculator.calculateFactorial(k) * FactorialCalculator.calculateFactorial(n - 1));
    }
    
    public long calculatePermutation(int n) {
        return FactorialCalculator.calculateFactorial(n);
    }
    
    public long calculateRepPermutation(String n) {
        Map<Byte, Integer> permutationHash = new HashMap<Byte, Integer>();
        for (byte iter : n.getBytes()) {
            if (!permutationHash.containsKey(iter)) {
                permutationHash.put(iter, 1);
            }
            else {
                permutationHash.put(iter, (permutationHash.get(iter) + 1));
            }
        }
        long mid = 1;
        for (byte set : permutationHash.keySet()) {
            mid *= FactorialCalculator.calculateFactorial(permutationHash.get(set));
        }
        return (FactorialCalculator.calculateFactorial(n.length()) / mid);
    }
}
