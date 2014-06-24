package ru.kunik.uct.numerator;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import ru.kunik.uct.gui.NumeratorGUI;

public class EuclideanExtAlghoritm implements Runnable {
    
    private NumeratorGUI numerator;

    public EuclideanExtAlghoritm(NumeratorGUI numerator, JList inputList) {
        this.numerator = numerator;
        NumeratorHandler.numeratorList.clear();
        for (int i = 0; i < inputList.getModel().getSize(); i++) {
            NumeratorHandler.numeratorList.add(((Integer)inputList.getModel().getElementAt(i)).longValue());
        }
    }

    public void run() {
        long gcd = gcdMulti(NumeratorHandler.numeratorList);
        long lcm = lcmMulti(NumeratorHandler.numeratorList);
        this.numerator.setNodAnswer(gcd + "");
        this.numerator.setNokAnswer(lcm + "");
        this.numerator.setInfo("Вычислено");
        StringBuilder sb = new StringBuilder();
        sb.append("Для чисел: ");
        for (long num : NumeratorHandler.numeratorList) {
            sb.append(num);
            sb.append(" ");
        }
        sb.append("НОД = ");
        sb.append(gcd);
        sb.append("; ");
        sb.append("НОК = ");
        sb.append(lcm);
        this.numerator.getHandler().getLogger().writeLog(sb.toString());
    }
    
    public static long[] gcdExt(long p, long q) {
        if (q == 0) return new long[]{p, 1, 0};
        if (p == 0) return new long[]{q, 0, 1};
        long[] vals = gcdExt(q, p % q);
        long d = vals[0];
        long a = vals[2];
        long b = vals[1] - (p / q) * vals[2];
        return new long[]{d, a, b};
    }
    
    public static long gcdMulti(List<Long> lst) {
        List<Long> lstCopied = new ArrayList<Long>();
        lstCopied.addAll(lst);
        long[] ans = new long[]{lstCopied.get(0), 0, 0};
        lstCopied.remove(0);
        for (long i2 : lstCopied) {
            ans = gcdExt(ans[0], i2);
        }
        return ans[0];
    }
    
    public static long lcmMulti(List<Long> lst) {
        List<Long> lstCopied = new ArrayList<Long>();
        lstCopied.addAll(lst);
        long ans = lstCopied.get(0);
        lstCopied.remove(0);
        for (long i2 : lstCopied) {
            ans = (Math.abs(ans) * Math.abs(i2)) / gcdExt(ans, i2)[0];
        }
        return ans;
    }
}
