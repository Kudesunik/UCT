package ru.kunik.uct.gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import ru.kunik.uct.util.Dialogs;
import ru.kunik.uct.util.Rus;

public class MenuGUI extends JMenuBar implements IMenuGUI {
    
    private JMenu menuFile;
    private JMenuItem menuExit;
    private JMenu menuOptions;
    private JCheckBoxMenuItem menuSave;
    private JMenuItem menuClear;
    private JMenu menuHelp;
    private JMenuItem menuManual;
    private JMenuItem menuAbout;
    private JFrame main;
    
    public MenuGUI(JFrame main) {
        this.main = main;
        menuFile = new JMenu(Rus.get("File"));
        menuExit = new JMenuItem(Rus.get("Exit"));
        menuOptions = new JMenu(Rus.get("Options"));
        menuSave = new JCheckBoxMenuItem(Rus.get("Apply log"), true);
        menuClear = new JMenuItem(Rus.get("Clear log"));
        menuHelp = new JMenu(Rus.get("Reference"));
        menuManual = new JMenuItem(Rus.get("Help"));
        menuAbout = new JMenuItem(Rus.get("About"));
        initializeGUI();
        initializeListeners();
    }
    
    private void initializeListeners() {
        this.menuAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((IMainGUI) main).getInformationGUI().setVisible(true);
            }
        });
        this.menuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                for (Frame f : Frame.getFrames()) {
                    if (f.getName().equalsIgnoreCase("UCTMain")) {
                        f.setVisible(true);
                        return;
                    }
                }
                System.exit(0);
            }
        });
        this.menuClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Dialogs.showQuestionDialog(main, "Вы уверены?", "Очистка лога") == 0) {
                    ((IMainGUI) main).getHandler().getLogger().clearLog();
                    ((AromaGUI) main).setInfo("Лог очищен");
                }
            }
        });
        this.menuManual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((IMainGUI) main).getHelpGUI().setVisible(true);
            }
        });
    }
    
    private void initializeGUI() {
        this.menuFile.add(menuExit);
        this.menuOptions.add(menuSave);
        this.menuOptions.add(menuClear);
        this.menuHelp.add(menuManual);
        this.menuHelp.add(menuAbout);
        this.add(menuFile);
        this.add(menuOptions);
        this.add(menuHelp);
    }

    public boolean isSaveApproved() {
        return menuSave.getState();
    }
}
