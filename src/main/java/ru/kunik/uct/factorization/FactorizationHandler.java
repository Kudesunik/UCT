package ru.kunik.uct.factorization;

import java.util.ArrayList;
import java.util.List;
import ru.kunik.uct.MainHandler;

public class FactorizationHandler extends MainHandler {
    
    public static volatile List<Integer> factorList = new ArrayList<Integer>();
    public static volatile List<Integer> dividersList = new ArrayList<Integer>();
    public static volatile int dividersNumber;
    public static volatile int dividersSum;
    
    public FactorizationHandler() {
        super("1.0.0", "Factorization");
    }
    
    @Override
    public void initialize() {
        //Nothing to do here
    }
}
