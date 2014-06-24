package ru.kunik.uct.numerator;

import java.util.ArrayList;
import java.util.List;
import ru.kunik.uct.MainHandler;

public class NumeratorHandler extends MainHandler {
    
    public static volatile List<Long> numeratorList = new ArrayList<Long>();
    
    public NumeratorHandler() {
        super("1.0.0", "Numerator");
    }
    
    @Override
    public void initialize() {
        //Nothing to do here
    }
}
