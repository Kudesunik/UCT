package ru.kunik.uct.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import ru.kunik.uct.IHandler;
import ru.kunik.uct.combocalculator.CombinatoricsCalculator;
import ru.kunik.uct.combocalculator.FactorialCalculator;
import ru.kunik.uct.util.Filters;
import ru.kunik.uct.util.Rus;

public class CombocalculatorGUI extends MainGUI {
    
    private JPanel activeFactorPanel;
    private JButton combiCalculate;
    private JLabel combiLabel;
    private JPanel combiPanel;
    private JLabel combinationAnswer;
    private JLabel combinationRepAnswer;
    private JLabel doubleFactorialAnswer;
    private JPanel doubleFactorialPanel;
    private JLabel factorialAnswer;
    private JButton factorialCalculate;
    private JTextField factorialInput;
    private JLabel factorialLabel;
    private JPanel factorialPanel;
    private JPanel factorialTextPanel;
    private JPanel hyperFactorialPanel;
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel9;
    private JPanel jPanel10;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JSeparator jSeparator1;
    private JTextField kCombiInput;
    private JTextField nCombiInput;
    private JLabel permutationAnswer;
    private JLabel permutationRepAnswer;
    private JLabel placementAnswer;
    private JLabel placementRepAnswer;
    private JLabel primorialAnswer;
    private JPanel primorialPanel;
    private JLabel subfactorialAnswer;
    private JPanel superFactorialPanel;
    private JLabel superfactorialAnswer;
    private JLabel waitingLabel;
    private IHandler handler;
    private ActionListener buttonsActionListener;
    private MouseListener labelsMouseListener;
    
    public CombocalculatorGUI(IHandler handler) {
        super(handler, 426, 536);
        this.handler = handler;
        this.initializeGUI();
        this.initializeListeners();
    }
    
    private void initializeGUI() {
        combiLabel = new JLabel();
        factorialTextPanel = new JPanel();
        factorialLabel = new JLabel();
        activeFactorPanel = new JPanel();
        factorialInput = new JTextField();
        factorialCalculate = new JButton();
        factorialPanel = new JPanel();
        jLabel1 = new JLabel();
        factorialAnswer = new JLabel();
        doubleFactorialPanel = new JPanel();
        jLabel3 = new JLabel();
        doubleFactorialAnswer = new JLabel();
        primorialPanel = new JPanel();
        jLabel5 = new JLabel();
        primorialAnswer = new JLabel();
        superFactorialPanel = new JPanel();
        jLabel7 = new JLabel();
        superfactorialAnswer = new JLabel();
        hyperFactorialPanel = new JPanel();
        jLabel9 = new JLabel();
        subfactorialAnswer = new JLabel();
        jSeparator1 = new JSeparator();
        combiPanel = new JPanel();
        jLabel11 = new JLabel();
        jPanel3 = new JPanel();
        jLabel12 = new JLabel();
        nCombiInput = new JTextField();
        jLabel13 = new JLabel();
        kCombiInput = new JTextField();
        jPanel2 = new JPanel();
        combiCalculate = new JButton();
        jPanel4 = new JPanel();
        jLabel14 = new JLabel();
        placementAnswer = new JLabel();
        jPanel5 = new JPanel();
        jLabel15 = new JLabel();
        placementRepAnswer = new JLabel();
        jPanel6 = new JPanel();
        jLabel16 = new JLabel();
        combinationAnswer = new JLabel();
        jPanel7 = new JPanel();
        jLabel17 = new JLabel();
        combinationRepAnswer = new JLabel();
        jPanel8 = new JPanel();
        jLabel18 = new JLabel();
        permutationAnswer = new JLabel();
        jPanel9 = new JPanel();
        jLabel19 = new JLabel();
        permutationRepAnswer = new JLabel();
        jPanel10 = new JPanel();
        waitingLabel = new JLabel();

        combiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        combiLabel.setText("Комбинаторные вычисления");
        factorialLabel.setHorizontalAlignment(SwingConstants.CENTER);
        factorialLabel.setText("Вычисление факториалов");
        GroupLayout factorialTextPanelLayout = new GroupLayout(factorialTextPanel);
        factorialTextPanel.setLayout(factorialTextPanelLayout);
        factorialTextPanelLayout.setHorizontalGroup(
            factorialTextPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(factorialTextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(factorialLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        factorialTextPanelLayout.setVerticalGroup(
            factorialTextPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(factorialLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
        factorialInput.setText("Введите текст");
        GroupLayout activeFactorPanelLayout = new GroupLayout(activeFactorPanel);
        activeFactorPanel.setLayout(activeFactorPanelLayout);
        activeFactorPanelLayout.setHorizontalGroup(
            activeFactorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(factorialInput)
        );
        activeFactorPanelLayout.setVerticalGroup(
            activeFactorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, activeFactorPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(factorialInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        factorialCalculate.setText("Вычислить");
        jLabel1.setText("Факториал:");
        factorialAnswer.setText("Неизвестно");
        GroupLayout factorialPanelLayout = new GroupLayout(factorialPanel);
        factorialPanel.setLayout(factorialPanelLayout);
        factorialPanelLayout.setHorizontalGroup(
            factorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(factorialPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(factorialAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        factorialPanelLayout.setVerticalGroup(
            factorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(factorialPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(factorialAnswer, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        );
        jLabel3.setText("Двойной факториал:");
        doubleFactorialAnswer.setText("Неизвестно");
        GroupLayout doubleFactorialPanelLayout = new GroupLayout(doubleFactorialPanel);
        doubleFactorialPanel.setLayout(doubleFactorialPanelLayout);
        doubleFactorialPanelLayout.setHorizontalGroup(
            doubleFactorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(doubleFactorialPanelLayout.createSequentialGroup()
                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doubleFactorialAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        doubleFactorialPanelLayout.setVerticalGroup(
            doubleFactorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(doubleFactorialAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLabel5.setText("Праймориал:");
        primorialAnswer.setText("Неизвестно");
        GroupLayout primorialPanelLayout = new GroupLayout(primorialPanel);
        primorialPanel.setLayout(primorialPanelLayout);
        primorialPanelLayout.setHorizontalGroup(
            primorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(primorialPanelLayout.createSequentialGroup()
                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(primorialAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        primorialPanelLayout.setVerticalGroup(
            primorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(primorialPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(primorialAnswer, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        );
        jLabel7.setText("Суперфакториал:");
        superfactorialAnswer.setText("Неизвестно");
        GroupLayout superFactorialPanelLayout = new GroupLayout(superFactorialPanel);
        superFactorialPanel.setLayout(superFactorialPanelLayout);
        superFactorialPanelLayout.setHorizontalGroup(
            superFactorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(superFactorialPanelLayout.createSequentialGroup()
                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(superfactorialAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        superFactorialPanelLayout.setVerticalGroup(
            superFactorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(superfactorialAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLabel9.setText("Субфакториал:");
        subfactorialAnswer.setText("Неизвестно");
        GroupLayout hyperFactorialPanelLayout = new GroupLayout(hyperFactorialPanel);
        hyperFactorialPanel.setLayout(hyperFactorialPanelLayout);
        hyperFactorialPanelLayout.setHorizontalGroup(
            hyperFactorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(hyperFactorialPanelLayout.createSequentialGroup()
                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subfactorialAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hyperFactorialPanelLayout.setVerticalGroup(
            hyperFactorialPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(hyperFactorialPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(subfactorialAnswer, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        );
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setText("Комбинаторные вычисления");
        GroupLayout combiPanelLayout = new GroupLayout(combiPanel);
        combiPanel.setLayout(combiPanelLayout);
        combiPanelLayout.setHorizontalGroup(
            combiPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(combiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        combiPanelLayout.setVerticalGroup(
            combiPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
        jLabel12.setText("Число n:");
        nCombiInput.setText("Введите число");
        jLabel13.setText("Число k:");
        kCombiInput.setText("Введите число");
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nCombiInput, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kCombiInput, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nCombiInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addComponent(kCombiInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        combiCalculate.setText("Вычислить");
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(combiCalculate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(combiCalculate)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLabel14.setText("Размещение:");
        placementAnswer.setText("Неизвестно");
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(placementAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(placementAnswer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLabel15.setText("Размещение с повторениями:");
        placementRepAnswer.setText("Неизвестно");
        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(placementRepAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(placementRepAnswer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLabel16.setText("Сочетание:");
        combinationAnswer.setText("Неизвестно");
        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combinationAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(combinationAnswer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLabel17.setText("Сочетание с повторениями:");
        combinationRepAnswer.setText("Неизвестно");
        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combinationRepAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(combinationRepAnswer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLabel18.setText("Перестановка:");
        permutationAnswer.setText("Неизвестно (значение из n)");
        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permutationAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(permutationAnswer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLabel19.setText("Перестановка с повторениями:");
        permutationRepAnswer.setText("Неизвестно (значение из n)");
        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permutationRepAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(permutationRepAnswer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        waitingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        waitingLabel.setText("Ожидание действий");
        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(waitingLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(waitingLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(factorialPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(factorialTextPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(activeFactorPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(factorialCalculate, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
                    .addComponent(doubleFactorialPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(primorialPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(superFactorialPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hyperFactorialPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(combiPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(factorialTextPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(activeFactorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(factorialCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(factorialPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doubleFactorialPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(primorialPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(superFactorialPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hyperFactorialPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combiPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }
    
    private void initializeListeners() {
        buttonsActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread thread;
                if (e.getSource() == factorialCalculate) {
                    if (factorialInput.getText().isEmpty()) {
                        setInfo(Rus.get("No data"));
                        handler.getLogger().writeLog(Rus.get("No data"));
                        return;
                    }
                    if (!Filters.isPositiveInteger(factorialInput.getText())) {
                        setInfo("Строка не является положительным числом");
                        getHandler().getLogger().writeLog("Строка " + factorialInput.getText() + " не является положительным числом");
                        return;
                    }
                    thread = new Thread(new FactorialCalculator(instance(), factorialInput.getText()));
                    thread.start();
                }
                if (e.getSource() == combiCalculate) {
                    if (nCombiInput.getText().isEmpty() && kCombiInput.getText().isEmpty()) {
                        setInfo(Rus.get("No data"));
                        handler.getLogger().writeLog(Rus.get("No data"));
                        return;
                    }
                    if (!Filters.isPositiveInteger(nCombiInput.getText()) && !Filters.isPositiveInteger(kCombiInput.getText())) {
                        setInfo("Строки не являются положительным числом");
                        getHandler().getLogger().writeLog("Строки не являются положительным числом");
                        return;
                    }
                    thread = new Thread(new CombinatoricsCalculator(instance(), nCombiInput.getText(), kCombiInput.getText()));
                    thread.start();
                }
            }
        };
        factorialCalculate.addActionListener(buttonsActionListener);
        combiCalculate.addActionListener(buttonsActionListener);
    }
    
    @Override
    public synchronized void setInfo(String str) {
        this.waitingLabel.setText(str);
    }
    
    public synchronized void setFactorialAnswer(String str) {
        this.factorialAnswer.setText(str);
    }
    
    public synchronized void setDoubleFactorialAnswer(String str) {
        this.doubleFactorialAnswer.setText(str);
    }
    
    public synchronized void setPrimorialAnswer(String str) {
        this.primorialAnswer.setText(str);
    }
    
    public synchronized void setSuperfactorialAnswer(String str) {
        this.superfactorialAnswer.setText(str);
    }
    
    public synchronized void setSubfactorialAnswer(String str) {
        this.subfactorialAnswer.setText(str);
    }
    
    public synchronized void setPlacementAnswer(String str) {
        this.placementAnswer.setText(str);
    }
    
    public synchronized void setPlacementRepAnswer(String str) {
        this.placementRepAnswer.setText(str);
    }
    
    public synchronized void setCombinationAnswer(String str) {
        this.combinationAnswer.setText(str);
    }
    
    public synchronized void setCombinationRepAnswer(String str) {
        this.combinationRepAnswer.setText(str);
    }
    
    public synchronized void setPermutationAnswer(String str) {
        this.permutationAnswer.setText(str);
    }
    
    public synchronized void setPermutationRepAnswer(String str) {
        this.permutationRepAnswer.setText(str);
    }
    
    public CombocalculatorGUI instance() {
        return this;
    }
}
