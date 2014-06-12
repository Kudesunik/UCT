package ru.kunik.uct;

import ru.kunik.uct.numerator.NumeratorHandler;
import ru.kunik.uct.gui.NumeratorGUI;

public class NumeratorStarter {

    private static final IHandler handler = new NumeratorHandler();

    public static void main(String[] args) {
        handler.initialize();
        new Thread(new NumeratorGUI(handler)).start();
    }
}
