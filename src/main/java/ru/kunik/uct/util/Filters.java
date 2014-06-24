package ru.kunik.uct.util;

public class Filters {

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public static boolean isPositiveInteger(String str) {
        if (isInteger(str) && !str.contains("-")) {
            return true;
        }
        return false;
    }
}
