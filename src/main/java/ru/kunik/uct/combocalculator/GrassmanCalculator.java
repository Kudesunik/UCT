package ru.kunik.uct.combocalculator;

import ru.kunik.uct.gui.CombocalculatorGUI;
import ru.kunik.uct.util.Filters;

public class GrassmanCalculator implements Runnable {

    private final CombocalculatorGUI combo;
    private String[] strArr;
    
    public GrassmanCalculator(CombocalculatorGUI combo, String[] strArr) {
        this.combo = combo;
        this.strArr = strArr;
    }
    
    //oAB1 = A + B - pAB1
    //oABC2 = A + B + C - pAB2 - pBC2 - pAC2 + pABC2
    public void run() {
        for (String strArr1 : strArr) {
                if (!Filters.isInteger(strArr1) && !strArr1.equals("")) {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
        if (strArr.length == 4) {
            if (strArr[0].equals("")) {
                if (checkAdditionalNull(strArr, 0)) {
                    this.combo.setAField1Answer(Integer.parseInt(strArr[2]) - Integer.parseInt(strArr[1]) + Integer.parseInt(strArr[3]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[1].equals("")) {
                if (checkAdditionalNull(strArr, 1)) {
                    this.combo.setBField1Answer(Integer.parseInt(strArr[2]) - Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[3]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[2].equals("")) {
                if (checkAdditionalNull(strArr, 2)) {
                    this.combo.setOAB1Answer(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]) - Integer.parseInt(strArr[3]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[3].equals("")) {
                if (checkAdditionalNull(strArr, 3)) {
                    this.combo.setPAB1Answer(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]) - Integer.parseInt(strArr[2]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
        }
        else if (strArr.length == 8) {
            if (strArr[0].equals("")) {
                if (checkAdditionalNull(strArr, 0)) {
                    this.combo.setAField2Answer(Integer.parseInt(strArr[7]) - Integer.parseInt(strArr[1]) - Integer.parseInt(strArr[2]) - Integer.parseInt(strArr[6]) + Integer.parseInt(strArr[3]) + Integer.parseInt(strArr[4]) + Integer.parseInt(strArr[5]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[1].equals("")) {
                if (checkAdditionalNull(strArr, 1)) {
                    this.combo.setBField2Answer(Integer.parseInt(strArr[7]) - Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[2]) - Integer.parseInt(strArr[6]) + Integer.parseInt(strArr[3]) + Integer.parseInt(strArr[4]) + Integer.parseInt(strArr[5]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[2].equals("")) {
                if (checkAdditionalNull(strArr, 2)) {
                    this.combo.setCField2Answer(Integer.parseInt(strArr[7]) - Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[1]) - Integer.parseInt(strArr[6]) + Integer.parseInt(strArr[3]) + Integer.parseInt(strArr[4]) + Integer.parseInt(strArr[5]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[3].equals("")) {
                if (checkAdditionalNull(strArr, 3)) {
                    this.combo.setPAB2Answer(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]) + Integer.parseInt(strArr[2]) - Integer.parseInt(strArr[4]) - Integer.parseInt(strArr[5]) + Integer.parseInt(strArr[7]) - Integer.parseInt(strArr[6]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[4].equals("")) {
                if (checkAdditionalNull(strArr, 4)) {
                    this.combo.setPBC2Answer(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]) + Integer.parseInt(strArr[2]) - Integer.parseInt(strArr[3]) - Integer.parseInt(strArr[5]) + Integer.parseInt(strArr[7]) - Integer.parseInt(strArr[6]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[5].equals("")) {
                if (checkAdditionalNull(strArr, 5)) {
                    this.combo.setPCA2Answer(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]) + Integer.parseInt(strArr[2]) - Integer.parseInt(strArr[3]) - Integer.parseInt(strArr[4]) + Integer.parseInt(strArr[7]) - Integer.parseInt(strArr[6]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[6].equals("")) {
                if (checkAdditionalNull(strArr, 6)) {
                    this.combo.setPABC2Answer(-Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[1]) - Integer.parseInt(strArr[2]) + Integer.parseInt(strArr[3]) + Integer.parseInt(strArr[4]) + Integer.parseInt(strArr[5]) + Integer.parseInt(strArr[7]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
            if (strArr[7].equals("")) {
                if (checkAdditionalNull(strArr, 7)) {
                    this.combo.setOABC2Answer(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]) + Integer.parseInt(strArr[2]) - Integer.parseInt(strArr[3]) - Integer.parseInt(strArr[4]) - Integer.parseInt(strArr[5]) + Integer.parseInt(strArr[6]) + "");
                    this.combo.setGrassmanInfo("Вычислено");
                }
                else {
                    this.combo.setGrassmanInfo("Неверные входные данные");
                    return;
                }
            }
        }
    }
    
    private boolean checkAdditionalNull(String[] arr, int except) {
        for (int iter = 0; iter < arr.length; iter++) {
            if (iter != except && arr[iter].equals("")) {
                return false;
            }
        }
        return true;
    }
}
