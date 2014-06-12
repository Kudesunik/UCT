package ru.kunik.uct.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import ru.kunik.uct.IHandler;
import ru.kunik.uct.aroma.ArabicToRoman;
import ru.kunik.uct.aroma.RomanToArabic;
import ru.kunik.uct.util.Rus;

public class AromaGUI extends MainGUI {
    
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JTextField arabic;
    private JTextField roman;
    private JLabel label;
    private JButton romanToArabicConv;
    private JButton arabicToRomanConv;
    
    private ActionListener buttonsActionListener;
    private KeyListener labelsKeyListener;
    private MouseListener labelsMouseListener;
    
    private IHandler handler;
    
    public AromaGUI(IHandler handler) {
        super(handler, 400, 160);
        
        this.handler = handler;
        
        textPanel = new JPanel();
        buttonPanel = new JPanel();
        label = new JLabel(Rus.get("Waiting"), SwingConstants.CENTER);
        
        arabic = new JTextField(Rus.get("Arabic"), 10);
        roman = new JTextField(Rus.get("Rome"), 10);
        romanToArabicConv = new JButton(Rus.get("Rome to arabic"));
        arabicToRomanConv = new JButton(Rus.get("Arabic to rome"));
        
        this.initializeGUI();
        this.initializeListeners();
    }

    private void initializeListeners() {
        buttonsActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread thread;
                if (e.getSource() == romanToArabicConv && !roman.getText().isEmpty()) {
                    thread = new Thread(new RomanToArabic(instance(), roman.getText().toUpperCase()));
                } else if (e.getSource() == arabicToRomanConv && !arabic.getText().isEmpty()) {
                    thread = new Thread(new ArabicToRoman(instance(), arabic.getText()));
                } else {
                    setInfo(Rus.get("No data"));
                    handler.getLogger().writeLog(Rus.get("No data"));
                    return;
                }
                thread.start();
            }
        };
        labelsKeyListener = new KeyListener() {
            public void keyTyped(KeyEvent e) {
                if (e.getSource() == arabic) {
                    if (((int) e.getKeyChar()) < 48 || ((int) e.getKeyChar()) > 57) {
                        e.consume();
                    } else if (arabic.getText().equals(Rus.get("Arabic"))) {
                        arabic.setText("");
                    }
                }
                if (e.getSource() == roman) {
                    if (((int) e.getKeyChar()) == 32) {
                        e.consume();
                    } else if (roman.getText().equals(Rus.get("Rome"))) {
                        roman.setText("");
                    }
                }
            }
            public void keyPressed(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
            
        };
        labelsMouseListener = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == arabic) {
                    if (arabic.getText().equals(Rus.get("Arabic"))) {
                        arabic.setText("");
                    }
                }
                if (e.getSource() == roman) {
                    if (roman.getText().equals(Rus.get("Rome"))) {
                        roman.setText("");
                    }
                }
            }

            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        };
        romanToArabicConv.addActionListener(buttonsActionListener);
        arabicToRomanConv.addActionListener(buttonsActionListener);
        roman.addKeyListener(labelsKeyListener);
        arabic.addKeyListener(labelsKeyListener);
        roman.addMouseListener(labelsMouseListener);
        arabic.addMouseListener(labelsMouseListener);
    }
    
    private void initializeGUI() {
        this.setLayout(new GridLayout(3, 1));
        
        this.textPanel.add(arabic);
        this.textPanel.add(roman);
        this.buttonPanel.add(arabicToRomanConv);
        this.buttonPanel.add(romanToArabicConv);
        
        this.add(textPanel);
        this.add(buttonPanel);
        this.add(label);
    }
    
    @Override
    public synchronized void setInfo(String str) {
        this.label.setText(str);
    }
    
    public synchronized void setArabic(String str) {
        this.arabic.setText(str);
    }
    
    public synchronized void setRome(String str) {
        this.roman.setText(str);
    }
    
    public AromaGUI instance() {
        return this;
    }
}
