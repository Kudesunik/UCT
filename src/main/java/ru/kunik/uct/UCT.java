package ru.kunik.uct;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import ru.kunik.uct.gui.MainGUI;
import ru.kunik.uct.util.Rus;

public class UCT extends MainGUI {
    
    private String[] args;
    private JPanel buttonPanel1;
    private JPanel buttonPanel2;
    private JButton aroma;
    private JButton factorization;
    private JButton numerator;
    private JButton horner;
    private JButton fractions;
    private JButton diophantineEq;
    private JButton combiCalc;
    private JButton magicSquare;
    private ActionListener buttonsActionListener;
    
    public UCT() {
        super(new MainHandler("0.6.5", "Universal calculation tool"), 580, 100, false);
    }
    
    public static void main(String[] args) {
        UCT main = new UCT();
        main.args = args;
        main.run();
    }
    
    @Override
    public void run() {
        buttonPanel1 = new JPanel();
        buttonPanel2 = new JPanel();
        aroma = new JButton(Rus.get("Aroma"));
        factorization = new JButton(Rus.get("Factorization"));
        numerator = new JButton(Rus.get("Numerator"));
        horner = new JButton(Rus.get("Horner"));
        fractions = new JButton(Rus.get("Fractions"));
        diophantineEq = new JButton(Rus.get("DiophantineEq"));
        combiCalc = new JButton(Rus.get("CombiCalc"));
        magicSquare = new JButton(Rus.get("MagicSquare"));
        this.initializeGUI();
        this.initializeListeners();
        this.setName("UCTMain");
        this.setVisible(true);
    }
    
    private void initializeListeners() {
        buttonsActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == aroma) {
                    AromaStarter.main(args);
                    setVisible(false);
                }
                if (e.getSource() == factorization) {
                    FactorizationStarter.main(args);
                    setVisible(false);
                }
                if (e.getSource() == numerator) {
                    NumeratorStarter.main(args);
                    setVisible(false);
                }
                if (e.getSource() == combiCalc) {
                    CombocalculatorStarter.main(args);
                    setVisible(false);
                }
                if (e.getSource() == horner) {
                    HornerStarter.main(args);
                    setVisible(false);
                }
                if (e.getSource() == diophantineEq) {
                    DiophantStarter.main(args);
                    setVisible(false);
                }
                if (e.getSource() == fractions) {
                    ContinuedFractionStarter.main(args);
                    setVisible(false);
                }
            }
        };
        aroma.addActionListener(buttonsActionListener);
        factorization.addActionListener(buttonsActionListener);
        numerator.addActionListener(buttonsActionListener);
        combiCalc.addActionListener(buttonsActionListener);
        horner.addActionListener(buttonsActionListener);
        diophantineEq.addActionListener(buttonsActionListener);
        fractions.addActionListener(buttonsActionListener);
    }
    
    private void initializeGUI() {
        
        //Disable not programmed buttons
        this.magicSquare.setEnabled(false);
        
        this.setLayout(new GridLayout(2, 1));
        this.buttonPanel1.add(aroma);
        this.buttonPanel1.add(factorization);
        this.buttonPanel1.add(numerator);
        this.buttonPanel1.add(horner);
        this.buttonPanel2.add(fractions);
        this.buttonPanel2.add(diophantineEq);
        this.buttonPanel2.add(combiCalc);
        this.buttonPanel2.add(magicSquare);
        this.add(buttonPanel1);
        this.add(buttonPanel2);
    }
}
