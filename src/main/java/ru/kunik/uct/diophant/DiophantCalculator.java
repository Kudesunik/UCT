package ru.kunik.uct.diophant;

import ru.kunik.uct.gui.DiophantGUI;
import ru.kunik.uct.numerator.EuclideanExtAlghoritm;
import ru.kunik.uct.util.Filters;

public class DiophantCalculator implements Runnable {
    
    private String str;
    private final DiophantGUI diophant;
    
    public DiophantCalculator(DiophantGUI diophant, String str) {
        this.diophant = diophant;
        this.str = str;
    }

    public void run() {
        String[] splited = str.split("\n2200");
        int[] val = new int[3];
        int count = 0;
        for (String strSpl : splited) {
            if (Filters.isInteger(strSpl)) {
                val[count] = Integer.parseInt(strSpl);
                count++;
            }
            else {
                this.diophant.setInfo("Неверные входные данные");
                this.diophant.getHandler().getLogger().writeLog("Неверные входные данные" + ": " + str);
                return;
            }
        }
        long[] gcdExt = EuclideanExtAlghoritm.gcdExt(val[0], val[1]);
        int ansX = (int) ((gcdExt[1] * val[2]) / gcdExt[0]);
        int ansY = (int) ((gcdExt[2] * val[2]) / gcdExt[0]);
        this.diophant.setXVariable(ansX + "");
        this.diophant.setYVariable(ansY + "");
        StringBuilder strX = new StringBuilder();
        StringBuilder strY = new StringBuilder();
        strX.append(ansX);
        strY.append(ansY);
        int midX = (int) (val[1] / gcdExt[0]);
        int midY = (int) -(val[0] / gcdExt[0]);
        if (midX >= 0) {
            strX.append("+");
        }
        if (midY >= 0) {
            strY.append("+");
        }
        strX.append(midX);
        strY.append(midY);
        strX.append("k");
        strY.append("k");
        
        this.diophant.setXMulti(strX.toString());
        this.diophant.setYMulti(strY.toString());
        this.diophant.setInfo("Вычислено");
        this.diophant.getHandler().getLogger().writeLog("Для значений a = " + val[0] + "; b = " + val[1] + "; c = " + val[2] + " вычислено:");
        this.diophant.getHandler().getLogger().writeLog("x = " + ansX + "; y = " + ansY + "; множество всех x = " + strX.toString() + "; множество всех y = " + strY.toString());
    }
}
