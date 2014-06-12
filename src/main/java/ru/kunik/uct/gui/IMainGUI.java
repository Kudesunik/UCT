package ru.kunik.uct.gui;

import java.awt.Dimension;
import javax.swing.JMenuBar;
import ru.kunik.uct.IHandler;

public interface IMainGUI{
    public Dimension getScreenSize();
    public JMenuBar getMenuGUI();
    public InformationGUI getInformationGUI();
    public HelpGUI getHelpGUI();
    public IHandler getHandler();
    public void setInfo(String str);
}
