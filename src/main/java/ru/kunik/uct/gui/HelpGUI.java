package ru.kunik.uct.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import ru.kunik.uct.util.Rus;

public class HelpGUI extends JFrame {
    
    private IMainGUI main;
    private JButton buttonAbout;
    private JButton buttonExit;
    private JButton buttonReference;
    private JButton buttonRestrictions;
    private JPanel buttonsPanel;
    private JScrollPane jScrollPane1;
    private JTextArea textArea;
    private JPanel textPanel;
    private ActionListener buttonsActionListener;
    
    public HelpGUI(IMainGUI main) {
        super(main.getHandler().getWorkName() + " V " + main.getHandler().getVersion() + " (C) Kunik");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setDefaultLookAndFeelDecorated(true);
        this.setResizable(false);
        this.setBounds(main.getScreenSize().width/2 - 300, main.getScreenSize().height/2 - 160, 600, 320);
        
        this.main = main;
        buttonsPanel = new JPanel();
        buttonAbout = new JButton(Rus.get("About"));
        buttonReference = new JButton(Rus.get("Reference"));
        buttonRestrictions = new JButton(Rus.get("Restrictions"));
        buttonExit = new JButton(Rus.get("Close"));
        textPanel = new JPanel();
        jScrollPane1 = new JScrollPane();
        textArea = new JTextArea();
        textArea.setText(Rus.getAbout(main.getHandler().getWorkName()));
        
        this.initializeGUI();
        this.initializeListeners();
    }
    
    private void initializeListeners() {
        buttonsActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonAbout) {
                    textArea.setText(Rus.getAbout(main.getHandler().getWorkName()));
                    textArea.setCaretPosition(0);
                }
                if (e.getSource() == buttonReference) {
                    textArea.setText(Rus.getReference(main.getHandler().getWorkName()));
                    textArea.setCaretPosition(0);
                }
                if (e.getSource() == buttonRestrictions) {
                    textArea.setText(Rus.getRestrictions(main.getHandler().getWorkName()));
                    textArea.setCaretPosition(0);
                }
                if (e.getSource() == buttonExit) {
                    setVisible(false);
                }
            }
        };
        buttonAbout.addActionListener(buttonsActionListener);
        buttonReference.addActionListener(buttonsActionListener);
        buttonRestrictions.addActionListener(buttonsActionListener);
        buttonExit.addActionListener(buttonsActionListener);
    }
    
    private void initializeGUI() {
        GroupLayout buttonsPanelLayout = new GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(buttonAbout, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addComponent(buttonRestrictions, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonReference, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addComponent(buttonAbout, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonReference, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRestrictions, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(buttonExit, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        );
        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        GroupLayout textPanelLayout = new GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );
        textPanelLayout.setVerticalGroup(
            textPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(textPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pack();
    }
}
