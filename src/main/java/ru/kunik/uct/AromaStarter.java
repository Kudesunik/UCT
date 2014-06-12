package ru.kunik.uct;

import ru.kunik.uct.aroma.AromaHandler;
import ru.kunik.uct.gui.AromaGUI;

public class AromaStarter {
    
    private static final IHandler handler = new AromaHandler();
    
    public static void main(String[] args) {
        handler.initialize();
        new Thread(new AromaGUI(handler)).start();
    }
}
