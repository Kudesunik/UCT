package ru.kunik.uct.aroma;

import ru.kunik.uct.gui.AromaGUI;
import ru.kunik.uct.util.Rus;

public class RomanToArabic implements Runnable {
    
    private String str;
    private final AromaGUI aroma;
    private int mid;
    
    public RomanToArabic(AromaGUI aroma, String str) {
        this.aroma = aroma;
        this.str = str;
        this.mid = 5000;
    }

    public void run() {
        
        int num = 0;

        if (!typeFilter()) {
            for (int iter1 = 0; iter1 < str.length(); iter1++) {
                if ((iter1 + 2) <= str.length()) {
                    String str3 = str.substring(iter1, iter1 + 2);
                    if (AromaHandler.rtaConv.containsKey(str3)) {
                        if (mid < AromaHandler.rtaConv.get(str3)) {
                            aroma.setInfo(Rus.get("Wrong rome number"));
                            aroma.getHandler().getLogger().writeLog(Rus.get("Wrong rome number") + ": " + str);
                            return;
                        }
                        mid = AromaHandler.rtaConv.get(str3);
                        num += mid;
                        iter1++;
                    } else {
                        if (mid < AromaHandler.rtaConv.get(str.charAt(iter1) + "")) {
                            aroma.setInfo(Rus.get("Wrong rome number"));
                            aroma.getHandler().getLogger().writeLog(Rus.get("Wrong rome number") + ": " + str);
                            return;
                        }
                        mid = AromaHandler.rtaConv.get(str.charAt(iter1) + "");
                        num += AromaHandler.rtaConv.get(str.charAt(iter1) + "");
                    }
                } else {
                    if (mid < AromaHandler.rtaConv.get(str.charAt(iter1) + "")) {
                            aroma.setInfo(Rus.get("Wrong rome number"));
                            aroma.getHandler().getLogger().writeLog(Rus.get("Wrong rome number") + ": " + str);
                            return;
                    }
                    mid = AromaHandler.rtaConv.get(str.charAt(iter1) + "");
                    num += AromaHandler.rtaConv.get(str.charAt(iter1) + "");
                }
            }

            if (!atrConvCheck(num, str)) {
                aroma.setInfo(Rus.get("Wrong rome number"));
                aroma.getHandler().getLogger().writeLog(Rus.get("Wrong rome number") + ": " + str);
                return;
            }
            
            aroma.setArabic(num + "");
            aroma.getHandler().getLogger().writeLog(str + " - " + num);
            aroma.setInfo(Rus.get("Calculated"));
        }
    }
    
    private boolean typeFilter() {
        for (char ch : str.toCharArray()) {
            if (!AromaHandler.rtaConv.containsKey(ch + "")) {
                aroma.setInfo(Rus.get("Wrong rome number"));
                aroma.getHandler().getLogger().writeLog(Rus.get("Wrong rome number") + ": " + str);
                return true;
            }
        }
        return false;
    }
    
    private boolean atrConvCheck(int num, String str) {
        if (num <= 0 || num >= 5000) return false;
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
        return result.equals(str);
    }
}
