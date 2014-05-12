package ru.kunik.uct.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import ru.kunik.uct.util.Rus;

public class InformationGUI extends JFrame {
    
    public String workName;
    private JPanel infoPanel;
    private JLabel infoLabel;
    private JButton infoContinue;
    private JButton infoExit;
    private JFrame main;
    
    public InformationGUI(String workName, JFrame main) {
        this.workName = workName;
        this.main = main;
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setBounds(((IMainGUI) main).getScreenSize().width / 2 - 160, ((IMainGUI) main).getScreenSize().height / 2 - 225, 320, 450);
        infoPanel = new JPanel();
        infoLabel = new JLabel("", SwingConstants.CENTER);
        infoContinue = new JButton(Rus.get("Continue"));
        infoExit = new JButton(Rus.get("Exit"));
        initializeGUI();
        initializeListeners();
    }
    
    private void initializeGUI() {
        infoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), Rus.get("Info")));
        infoExit.setPreferredSize(new Dimension(100, 25));
        this.infoLabel.setText(Rus.getInformation(workName));
        this.infoPanel.add(infoLabel);
        this.infoPanel.add(infoExit);
        this.infoPanel.add(infoContinue);
        this.add(infoPanel);
    }
    
    private void initializeListeners() {
        this.infoExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
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
        this.infoContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                main.setVisible(true);
            }
        });
    }
}
