package ru.kunik.uct.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import ru.kunik.uct.IHandler;
import ru.kunik.uct.gui.magicsquare.MagicSquareCalculator;
import ru.kunik.uct.gui.magicsquare.MagicSquareHandler;
import ru.kunik.uct.util.Rus;

public class MagicSquareGUI extends MainGUI {
    
    private JButton calculateButton;
    private JTextField inputField;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JFrame ansFrame;
    private JLabel magicConstAnswer;
    private JButton magicSquareAnswer;
    private JLabel waitingLabel;
    private JPanel ansSqButtonPanel;
    private JPanel ansSqPanel;
    private JButton jButton2;
    private JInternalFrame jInternalFrame1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private IHandler handler;
    private ActionListener buttonsActionListener;
    private MouseListener labelsMouseListener;
    
    public MagicSquareGUI(IHandler handler) {
        super(handler, 300, 125);
        this.handler = handler;
        this.initializeGUI();
        this.initializeSquareGUI();
        this.initializeListeners();
        handler.getLogger().writeLog("====================================================");
        handler.getLogger().writeLog("МАИ (НИУ) / Факультет № 3 / Кафедра № 308");
        handler.getLogger().writeLog("Курсовая работа по дискретной математике MagicSquare");
        handler.getLogger().writeLog("Группа: 3О - 113Б / Кузнецов Н.В. / Москва 2014");
        handler.getLogger().writeLog("Программа MagicSquare запущена");
        handler.getLogger().writeLog("====================================================");
    }
    
    private void initializeGUI() {
        jPanel1 = new JPanel();
        inputField = new JTextField();
        calculateButton = new JButton();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        magicConstAnswer = new JLabel();
        jPanel3 = new JPanel();
        magicSquareAnswer = new JButton();
        jPanel4 = new JPanel();
        waitingLabel = new JLabel();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        inputField.setText("Введите число");
        calculateButton.setText("Вычислить");
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(inputField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calculateButton, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(inputField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addComponent(calculateButton))
        );
        jLabel1.setText("Магическая константа:");
        magicConstAnswer.setText("Неизвестно");
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(magicConstAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(magicConstAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        magicSquareAnswer.setText("Вывести квадрат на экран");
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(magicSquareAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(magicSquareAnswer)
        );
        waitingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        waitingLabel.setText("Ожидание действий");
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(waitingLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(waitingLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }
    
    private void initializeSquareGUI() {
        ansFrame = new JFrame();
        ansFrame.setVisible(false);
        jInternalFrame1 = new JInternalFrame();
        ansSqPanel = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        ansSqButtonPanel = new JPanel();
        jButton2 = new JButton();
        jInternalFrame1.setVisible(true);
        GroupLayout jInternalFrame1Layout = new GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jButton2.setText("Закрыть");
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        GroupLayout ansSqPanelLayout = new GroupLayout(ansSqPanel);
        ansSqPanel.setLayout(ansSqPanelLayout);
        ansSqPanelLayout.setHorizontalGroup(
            ansSqPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        ansSqPanelLayout.setVerticalGroup(
            ansSqPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ansSqPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        GroupLayout ansSqButtonPanelLayout = new GroupLayout(ansSqButtonPanel);
        ansSqButtonPanel.setLayout(ansSqButtonPanelLayout);
        ansSqButtonPanelLayout.setHorizontalGroup(
            ansSqButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ansSqButtonPanelLayout.setVerticalGroup(
            ansSqButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, ansSqButtonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(ansFrame.getContentPane());
        ansFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(ansSqPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ansSqButtonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ansSqPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ansSqButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ansFrame.pack();
    }
    
    private void initializeListeners() {
        buttonsActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread thread;
                if (e.getSource() == calculateButton) {
                    if (!inputField.getText().isEmpty()) {
                        jTextArea1.setText("");
                        thread = new Thread(new MagicSquareCalculator(instance(), inputField.getText()));
                        thread.start();
                    } else {
                        setInfo(Rus.get("No data"));
                        handler.getLogger().writeLog(Rus.get("No data"));
                    }
                }
                if (e.getSource() == magicSquareAnswer) {
                    if (MagicSquareHandler.magicSquareArray != null) {
                        ansFrame.setVisible(true);
                    }
                    else {
                        setInfo(Rus.get("No data"));
                        handler.getLogger().writeLog(Rus.get("No data"));
                    }
                }
                if (e.getSource() == jButton2) {
                    ansFrame.setVisible(false);
                }
            }
        };
        labelsMouseListener = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == inputField) {
                    if (inputField.getText().equals("Введите число")) {
                        inputField.setText("");
                    }
                }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        };
        calculateButton.addActionListener(buttonsActionListener);
        magicSquareAnswer.addActionListener(buttonsActionListener);
        jButton2.addActionListener(buttonsActionListener);
        inputField.addMouseListener(labelsMouseListener);
    }
    
    @Override
    public synchronized void setInfo(String str) {
        this.waitingLabel.setText(str);
    }
    
    public synchronized void setMagicNumber(String str) {
        this.magicConstAnswer.setText(str);
    }
    
    public synchronized void appendMagicMatrixText(String str) {
        this.jTextArea1.append(str);
    }
    
    public MagicSquareGUI instance() {
        return this;
    }
}
