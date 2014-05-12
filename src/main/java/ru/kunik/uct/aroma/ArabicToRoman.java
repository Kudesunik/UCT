package ru.kunik.uct.aroma;

import ru.kunik.uct.gui.AromaGUI;
import ru.kunik.uct.util.Rus;

public class ArabicToRoman implements Runnable {
    
    private String str;
    private final AromaGUI aroma;

    public ArabicToRoman(AromaGUI aroma, String str) {
        this.aroma = aroma;
        this.str = str;
    }

    public void run() {

        if (typeFilter() && valueFilter()) {
            int num = Integer.parseInt(str);
            String result = "";

            while (num > 0) {
                for (Integer iter : AromaHandler.atrConv.keySet()) {
                    if (num >= iter) {
                        result += AromaHandler.atrConv.get(iter);
                        num -= iter;
                        break;
                    }
                }
            }

            this.aroma.setRome(result);
            aroma.getHandler().getLogger().writeLog(str + " - " + result);
            this.aroma.setInfo(Rus.get("Calculated"));
        }
    }
    
    public boolean typeFilter() {
        if (str.matches("\\d*")) {
            return true;
        }
        else {
            this.aroma.setInfo(Rus.get("Wrong arabic number"));
            aroma.getHandler().getLogger().writeLog(Rus.get("Wrong arabic number") + ": " + str);
            return false;
        }
    }
    
    public boolean valueFilter() {
        if (Integer.parseInt(str) > 0 && Integer.parseInt(str) < 5000) {
            return true;
        }
        else {
            this.aroma.setInfo(Rus.get("Wrong arabic number"));
            aroma.getHandler().getLogger().writeLog(Rus.get("Wrong arabic number") + ": " + str);
            return false;
        }
    }
}
