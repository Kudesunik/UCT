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
            NumeratorHandler.numeratorList.add((Integer) inputList.getModel().getElementAt(i));
        }
    }

    public void run() {
        this.numerator.setNodAnswer(gcdMulti(NumeratorHandler.numeratorList) + "");
        this.numerator.setNokAnswer(lcmMulti(NumeratorHandler.numeratorList) + "");
    }
    
    public static int[] gcdExt(int p, int q) {
        if (q == 0) return new int[]{p, 1, 0};
        if (p == 0) return new int[]{q, 0, 1};
        int[] vals = gcdExt(q, p % q);
        int d = vals[0];
        int a = vals[2];
        int b = vals[1] - (p / q) * vals[2];
        return new int[]{d, a, b};
    }
    
    public static int gcdMulti(List<Integer> lst) {
        List<Integer> lstCopied = new ArrayList<Integer>();
        lstCopied.addAll(lst);
        int[] ans = new int[]{lstCopied.get(0), 0, 0};
        lstCopied.remove(0);
        for (int i2 : lstCopied) {
            ans = gcdExt(ans[0], i2);
        }
        return ans[0];
    }
    
    public static int lcmMulti(List<Integer> lst) {
        List<Integer> lstCopied = new ArrayList<Integer>();
        lstCopied.addAll(lst);
        int ans = lstCopied.get(0);
        lstCopied.remove(0);
        for (int i2 : lstCopied) {
            ans = (Math.abs(ans) * Math.abs(i2)) / gcdExt(ans, i2)[0];
        }
        return ans;
    }
}
