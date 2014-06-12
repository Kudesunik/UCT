package ru.kunik.uct.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.JFrame;
import ru.kunik.uct.gui.IMainGUI;
import ru.kunik.uct.gui.IMenuGUI;

public class LogManager {
    
    private String logName;
    private JFrame main;
    private File file;
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedReader reader;
    private BufferedWriter writer;

    public LogManager(JFrame main, String logName) {
        this.main = main;
        this.logName = logName;
        file = new File(logName + "Log.txt");
        this.initialize();
    }
    
    public void initialize() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Dialogs.showErrorDialog(this.main, "Невозможно создать лог: " + ex.getMessage());
            }
        }
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            Dialogs.showErrorDialog(this.main, "Невозможно открыть лог: " + ex.getMessage());
        }
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException ex) {
            Dialogs.showErrorDialog(this.main, "Невозможно открыть лог: " + ex.getMessage());
        }
        reader = new BufferedReader(fileReader);
        writer = new BufferedWriter(fileWriter);
    }
    
    public void writeLog(String str) {
        this.writeLog(str, true);
    }
    
    public void writeLog(String str, boolean isSaveChecking) {
        if (isSaveChecking && (!((IMenuGUI)((IMainGUI) main).getMenuGUI()).isSaveApproved())) {
            return;
        }
        try {
            writer.write(Calendar.getInstance().getTime() + " | " + str);
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            Dialogs.showErrorDialog(this.main, "Невозможно записать лог: " + ex.getMessage());
            try {
                writer.close();
            } catch (IOException ex1) {}
        }
    }
    
    public void clearLog() {
        try {
            writer.close();
            reader.close();
            file.delete();
            file.createNewFile();
            fileWriter = new FileWriter(file, true);
            writer = new BufferedWriter(fileWriter);
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
        } catch (IOException ex) {
            Dialogs.showErrorDialog(this.main, "Невозможно удалить лог: " + ex.getMessage());
        }
    }
}
