package ru.kunik.uct.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import ru.kunik.uct.IHandler;

public class MainGUI extends JFrame implements IMainGUI, Runnable {
    
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JMenuBar menu;
    private JFrame info;
    private JFrame help;
    private IHandler handler;
    
    public MainGUI(IHandler handler, int width, int height) {
        this(handler, width, height, true);
    }

    public MainGUI(IHandler handler, int width, int height, boolean isMenu) {
        super(handler.getWorkName() + " V " + handler.getVersion() + " (C) Kunik");
        this.handler = handler;
        
        //Warning about the loss of 'this' in the constructor does not matter. Logger is not used before this class is loaded. Kunik.
        handler.setLogger(this);
        
        menu = new MenuGUI(this);
        help = new HelpGUI(this);
        info = new InformationGUI(handler.getWorkName(), this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (Frame f : Frame.getFrames()) {
            if (f.getName().equalsIgnoreCase("UCTMain")) {
                final Frame ff = f;
                this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                this.addWindowListener(new WindowListener() {
                    public void windowOpened(WindowEvent e) {}
                    public void windowClosing(WindowEvent e) {
                        ff.setVisible(true);
                    }
                    public void windowClosed(WindowEvent e) {}
                    public void windowIconified(WindowEvent e) {}
                    public void windowDeiconified(WindowEvent e) {}
                    public void windowActivated(WindowEvent e) {}
                    public void windowDeactivated(WindowEvent e) {}
                });
            }
        }
        setDefaultLookAndFeelDecorated(false);
        this.setResizable(false);
        this.setBounds(screenSize.width/2 - (width/2), screenSize.height/2 - (height/2), width, height);
        if (isMenu) {
            this.setJMenuBar(menu);
        }
    }

    public Dimension getScreenSize() {
        return this.screenSize;
    }

    public JMenuBar getMenuGUI() {
        return (MenuGUI) this.menu;
    }

    public InformationGUI getInformationGUI() {
        return (InformationGUI) this.info;
    }

    public HelpGUI getHelpGUI() {
        return (HelpGUI) this.help;
    }
    
    public void setInfo(String str) {
        //Overrides by other
    }

    public void run() {
        this.getInformationGUI().setVisible(true);
    }

    public IHandler getHandler() {
        return this.handler;
    }
    
}
