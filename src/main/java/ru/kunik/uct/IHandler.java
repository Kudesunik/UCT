package ru.kunik.uct;

import javax.swing.JFrame;
import ru.kunik.uct.util.LogManager;

public interface IHandler {
    public String getVersion();
    public String getWorkName();
    public LogManager getLogger();
    public void setLogger(JFrame base);
    public void initialize();
}
