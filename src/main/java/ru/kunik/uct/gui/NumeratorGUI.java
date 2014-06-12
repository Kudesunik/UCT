package ru.kunik.uct.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import ru.kunik.uct.numerator.EuclideanExtAlghoritm;
import ru.kunik.uct.IHandler;
import ru.kunik.uct.util.Filters;
import ru.kunik.uct.util.Rus;

public class NumeratorGUI extends MainGUI {
    
    private JButton addButton;
    private JButton calculateButton;
    private JButton clearButton;
    private JTextField inputField;
    private JList inputList;
    private JList jList2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JPanel jPanel7;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JLabel nodAnswer;
    private JLabel nodLabel;
    private JLabel nokAnswer;
    private JLabel nokLabel;
    private JLabel waitingField;
    private DefaultListModel listModel;
    
    private IHandler handler;
    private ActionListener buttonsActionListener;
    private MouseListener labelsMouseListener;
    
    public NumeratorGUI(IHandler handler) {
        super(handler, 382, 169);
        this.handler = handler;
        this.initializeGUI();
        this.initializeListeners();
    }
    
    private void initializeGUI() {
        jScrollPane2 = new JScrollPane();
        jList2 = new JList();
        jPanel5 = new JPanel();
        jScrollPane3 = new JScrollPane();
        inputList = new JList();
        jPanel1 = new JPanel();
        addButton = new JButton();
        inputField = new JTextField();
        jPanel2 = new JPanel();
        clearButton = new JButton();
        calculateButton = new JButton();
        jPanel3 = new JPanel();
        nodLabel = new JLabel();
        nodAnswer = new JLabel();
        nokLabel = new JLabel();
        nokAnswer = new JLabel();
        jPanel7 = new JPanel();
        waitingField = new JLabel();
        listModel = new DefaultListModel();
        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);
        inputList.setModel(listModel);
        jScrollPane3.setViewportView(inputList);
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
        );
        addButton.setText("Добавить");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inputField.setText("Введите число");
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputField)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        clearButton.setText("Очистить список");
        calculateButton.setText("Вычислить");
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(clearButton)
                .addComponent(calculateButton))
        );
        nodLabel.setText("НОД:");
        nodAnswer.setText("Неизвестно");
        nokLabel.setText("НОК:");
        nokAnswer.setText("Неизвестно");
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nodAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nokLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nokAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(nodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(nodAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(nokLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(nokAnswer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        waitingField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        waitingField.setText("Ожидание действий");
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(waitingField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(waitingField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }
    
    private void initializeListeners() {
        buttonsActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread thread;
                if (e.getSource() == addButton) {
                    if (inputField.getText().isEmpty()) {
                        setInfo(Rus.get("No data"));
                        handler.getLogger().writeLog(Rus.get("No data"));
                        return;
                    }
                    if (!Filters.isInteger(inputField.getText())) {
                        setInfo("Строка не является числом");
                        handler.getLogger().writeLog("Строка не является числом");
                        return;
                    }
                    if (inputList.getModel().getSize() > 4) {
                        setInfo("Количество чисел не должно быть более 5");
                        handler.getLogger().writeLog("Количество чисел не должно быть более 5");
                        return;
                    }
                    listModel.addElement(Integer.parseInt(inputField.getText()));
                }
                if (e.getSource() == calculateButton) {
                    if (inputList.getModel().getSize() < 2) {
                        setInfo("Количество чисел не должно быть меньше 2");
                        handler.getLogger().writeLog("Количество чисел не должно быть меньше 2");
                        return;
                    }
                    thread = new Thread(new EuclideanExtAlghoritm(instance(), inputList));
                    thread.start();
                }
                if (e.getSource() == clearButton) {
                    if (listModel.isEmpty()) {
                        setInfo("Лист пуст");
                        handler.getLogger().writeLog("Лист пуст");
                        return;
                    }
                    listModel.clear();
                    setInfo("Лист очищен");
                    handler.getLogger().writeLog("Лист очищен");
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
        inputList.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    if (listModel.isEmpty()) {
                        setInfo("Лист пуст");
                        handler.getLogger().writeLog("Лист пуст");
                        return;
                    }
                    int index = inputList.locationToIndex(e.getPoint());
                    listModel.remove(index);
                }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        addButton.addActionListener(buttonsActionListener);
        calculateButton.addActionListener(buttonsActionListener);
        clearButton.addActionListener(buttonsActionListener);
        inputField.addMouseListener(labelsMouseListener);
    }
    
    @Override
    public synchronized void setInfo(String str) {
        this.waitingField.setText(str);
    }
    
    public synchronized void setNodAnswer(String str) {
        this.nodAnswer.setText(str);
    }
    
    public synchronized void setNokAnswer(String str) {
        this.nokAnswer.setText(str);
    }
    
    public NumeratorGUI instance() {
        return this;
    }
}
