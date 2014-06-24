package ru.kunik.uct;

import ru.kunik.uct.gui.MagicSquareGUI;
import ru.kunik.uct.gui.magicsquare.MagicSquareHandler;

public class MagicSquareStarter {
    
    private static final IHandler handler = new MagicSquareHandler();
    
    public static void main(String[] args) {
        handler.initialize();
        new Thread(new MagicSquareGUI(handler)).start();
    }
    
}
