package ru.kunik.uct;

import ru.kunik.uct.factorization.FactorizationHandler;
import ru.kunik.uct.gui.FactorizationGUI;

public class FactorizationStarter {
    
    private static final IHandler handler = new FactorizationHandler();
    
    public static void main(String[] args) {
        handler.initialize();
        new Thread(new FactorizationGUI(handler)).start();
    }
}
