package ru.kunik.uct.aroma;

import java.util.LinkedHashMap;
import java.util.Map;
import ru.kunik.uct.MainHandler;

public class AromaHandler extends MainHandler {
    
    public static volatile Map<Integer, String> atrConv = new LinkedHashMap<Integer, String>();
    public static volatile Map<String, Integer> rtaConv = new LinkedHashMap<String, Integer>();
    
    public AromaHandler() {
        super("1.5.0", "Aroma");
    }
    
    @Override
    public void initialize() {
        atrConv.put(1000, "M");
        atrConv.put(900, "CM");
        atrConv.put(500, "D");
        atrConv.put(400, "CD");
        atrConv.put(100, "C");
        atrConv.put(90, "XC");
        atrConv.put(50, "L");
        atrConv.put(40, "XL");
        atrConv.put(10, "X");
        atrConv.put(9, "IX");
        atrConv.put(5, "V");
        atrConv.put(4, "IV");
        atrConv.put(1, "I");
        
        for (Integer iter : atrConv.keySet()) {
            rtaConv.put(atrConv.get(iter), iter);
        }
    }
}
