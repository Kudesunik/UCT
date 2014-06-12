package ru.kunik.uct;

import javax.swing.JFrame;
import ru.kunik.uct.util.LogManager;

public class MainHandler implements IHandler {
    
    private final String version;
    private final String workName;
    public LogManager log;
    
    public static boolean isDebugging = false;
    
    public MainHandler(String version, String workName) {
        this.version = version;
        this.workName = workName;
    }

    public String getVersion() {
        return version;
    }

    public String getWorkName() {
        return workName;
    }

    public void initialize() {}

    public LogManager getLogger() {
        return this.log;
    }
    
    public void setLogger(JFrame base) {
        this.log = new LogManager(base, workName);
    }
}
