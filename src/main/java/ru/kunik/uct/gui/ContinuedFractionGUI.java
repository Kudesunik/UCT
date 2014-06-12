package ru.kunik.uct.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import ru.kunik.uct.IHandler;
import ru.kunik.uct.continuedfraction.ContinuedFractionCalculator;
import ru.kunik.uct.util.Rus;

public class ContinuedFractionGUI extends MainGUI {
    
    private JButton calculateToContinued;
    private JButton calculateToStandart;
    private JLabel contFractionLabel;
    private JTextField continuedFractionField;
    private JTextField denominatorField;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollBar jScrollBar1;
    private JSeparator jSeparator1;
    private JTextField numeratorField;
    private JLabel stdFractionLabel;
    private JLabel waitingLabel;
    private IHandler handler;
    private ActionListener buttonsActionListener;
    private MouseListener labelsMouseListener;
    
    public ContinuedFractionGUI(IHandler handler) {
        super(handler, 400, 276);
        this.handler = handler;
        this.initializeGUI();
        this.initializeListeners();
    }
    
    private void initializeGUI() {
        jPanel1 = new JPanel();
        numeratorField = new JTextField();
        jSeparator1 = new JSeparator();
        denominatorField = new JTextField();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jPanel2 = new JPanel();
        stdFractionLabel = new JLabel();
        jPanel3 = new JPanel();
        contFractionLabel = new JLabel();
        jPanel4 = new JPanel();
        continuedFractionField = new JTextField();
        jScrollBar1 = new JScrollBar();
        jPanel5 = new JPanel();
        calculateToContinued = new JButton();
        jPanel6 = new JPanel();
        calculateToStandart = new JButton();
        jPanel7 = new JPanel();
        waitingLabel = new JLabel();
        numeratorField.setHorizontalAlignment(JTextField.CENTER);
        numeratorField.setText("Введите число");
        denominatorField.setHorizontalAlignment(JTextField.CENTER);
        denominatorField.setText("Введите число");
        jLabel1.setText("Числитель:");
        jLabel3.setText("Знаменатель:");
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(numeratorField)
                    .addComponent(denominatorField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(numeratorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(denominatorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)))
        );
        stdFractionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        stdFractionLabel.setText("Обычная дробь:");
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(stdFractionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(stdFractionLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
        contFractionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contFractionLabel.setText("Представление цепной дроби:");
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contFractionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(contFractionLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
        continuedFractionField.setText("Введите числа через запятую");
        jScrollBar1.setOrientation(JScrollBar.HORIZONTAL);
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(continuedFractionField)
                    .addComponent(jScrollBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(continuedFractionField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        calculateToContinued.setText("Перевести из обычной в цепную");
        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calculateToContinued, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(calculateToContinued)
        );
        calculateToStandart.setText("Перевести из цепной в обычную");
        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calculateToStandart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(calculateToStandart)
        );
        waitingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        waitingLabel.setText("Ожидание действий");
        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(waitingLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(waitingLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }
    
    private void initializeListeners() {
        buttonsActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread thread;
                if (e.getSource() == calculateToContinued && !numeratorField.getText().isEmpty() && !denominatorField.getText().isEmpty()) {
                    thread = new Thread(new ContinuedFractionCalculator(instance(), (numeratorField.getText() + "\u2200" + denominatorField.getText())));
                }
                else if (e.getSource() == calculateToStandart && !continuedFractionField.getText().isEmpty()) {
                    thread = new Thread(new ContinuedFractionCalculator(instance(), continuedFractionField.getText()));
                }
                else {
                    setInfo(Rus.get("No data"));
                    handler.getLogger().writeLog(Rus.get("No data"));
                    return;
                }
                thread.start();
            }
        };
        labelsMouseListener = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == numeratorField) {
                    if (numeratorField.getText().equals("Введите число")) {
                        numeratorField.setText("");
                    }
                }
                if (e.getSource() == denominatorField) {
                    if (denominatorField.getText().equals("Введите число")) {
                        denominatorField.setText("");
                    }
                }
                if (e.getSource() == continuedFractionField) {
                    if (continuedFractionField.getText().equals("Введите числа через запятую")) {
                        continuedFractionField.setText("");
                    }
                }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        };
        jScrollBar1.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                continuedFractionField.setCaretPosition((int)((double) e.getValue() * ((double) continuedFractionField.getText().length() / 90.0D)));
            }
        });
        calculateToContinued.addActionListener(buttonsActionListener);
        calculateToStandart.addActionListener(buttonsActionListener);
        numeratorField.addMouseListener(labelsMouseListener);
        denominatorField.addMouseListener(labelsMouseListener);
        continuedFractionField.addMouseListener(labelsMouseListener);
    }
    
    public synchronized void setDirectAnswer(String str) {
        this.continuedFractionField.setText(str);
    }
    
    public synchronized void setNumerator(String str) {
        this.numeratorField.setText(str);
    }
    
    public synchronized void setDenominator(String str) {
        this.denominatorField.setText(str);
    }
    
    @Override
    public synchronized void setInfo(String str) {
        this.waitingLabel.setText(str);
    }
    
    public ContinuedFractionGUI instance() {
        return this;
    }
    
}
