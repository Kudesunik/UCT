package ru.kunik.uct;

import ru.kunik.uct.gui.HornerGUI;
import ru.kunik.uct.horner.HornerHandler;

public class HornerStarter {
    
    private static final IHandler handler = new HornerHandler();
    
    public static void main(String[] args) {
        handler.initialize();
        new Thread(new HornerGUI(handler)).start();
    }
}
