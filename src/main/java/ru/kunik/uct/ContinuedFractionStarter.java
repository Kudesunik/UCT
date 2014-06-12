package ru.kunik.uct;

import ru.kunik.uct.continuedfraction.ContinuedFractionHandler;
import ru.kunik.uct.gui.ContinuedFractionGUI;

public class ContinuedFractionStarter {
    
    private static final IHandler handler = new ContinuedFractionHandler();
    
    public static void main(String[] args) {
        handler.initialize();
        new Thread(new ContinuedFractionGUI(handler)).start();
    }
}
