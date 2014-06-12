package ru.kunik.uct;

import ru.kunik.uct.diophant.DiophantHandler;
import ru.kunik.uct.gui.DiophantGUI;

public class DiophantStarter {
    
    private static final IHandler handler = new DiophantHandler();
    
    public static void main(String[] args) {
        handler.initialize();
        new Thread(new DiophantGUI(handler)).start();
    }
    
}
