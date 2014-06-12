package ru.kunik.uct;

import ru.kunik.uct.combocalculator.CombocalculatorHandler;
import ru.kunik.uct.gui.CombocalculatorGUI;

public class CombocalculatorStarter {
    
    private static final IHandler handler = new CombocalculatorHandler();
    
    public static void main(String[] args) {
        handler.initialize();
        new Thread(new CombocalculatorGUI(handler)).start();
    }
}
