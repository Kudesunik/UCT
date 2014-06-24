package ru.kunik.uct.gui.magicsquare;

import ru.kunik.uct.gui.MagicSquareGUI;
import ru.kunik.uct.util.Filters;

public class MagicSquareCalculator implements Runnable {
    
    private String str;
    private final MagicSquareGUI magicSquare;
    
    public MagicSquareCalculator(MagicSquareGUI magicSquare, String str) {
        this.magicSquare = magicSquare;
        this.str = str;
    }

    public void run() {
        if (Filters.isInteger(str)) {
            int num = Integer.parseInt(str);
            int ansConst = calculateMagicNumber(num);
            this.magicSquare.setMagicNumber(ansConst + "");
            if (num == 4 || num % 2 != 0) {
                MagicSquareHandler.magicSquareArray = calculateSquare(num);
                this.magicSquare.setInfo("Вычислено с матрицей");
                this.magicSquare.getHandler().getLogger().writeLog("Для числа " + num + " магическая константа = " + ansConst);
                this.magicSquare.getHandler().getLogger().writeLog("--------------------------------------------------------");
                StringBuilder sb;
                for (int iter1 = 0; iter1 < MagicSquareHandler.magicSquareArray.length; iter1++) {
                    sb = new StringBuilder();
                    for (int iter2 = 0; iter2 < MagicSquareHandler.magicSquareArray.length; iter2++) {
                        sb.append(MagicSquareHandler.magicSquareArray[iter1][iter2]);
                        sb.append("\t");
                    }
                    this.magicSquare.appendMagicMatrixText(sb.toString());
                    this.magicSquare.appendMagicMatrixText("\n");
                    this.magicSquare.getHandler().getLogger().writeLog(sb.toString());
                    this.magicSquare.getHandler().getLogger().writeLog("");
                }
                this.magicSquare.getHandler().getLogger().writeLog("--------------------------------------------------------");
            }
            else {
                this.magicSquare.setInfo("Вычислено без матрицы");
                this.magicSquare.getHandler().getLogger().writeLog("Для числа " + num + " магическая константа = " + ansConst);
                this.magicSquare.getHandler().getLogger().writeLog("Таблица не вычисляется для чётных чисел, кроме 4");
            }
        }
        else {
            this.magicSquare.setInfo("Неверные входные данные");
            this.magicSquare.getHandler().getLogger().writeLog("Неверные входные данные" + ": " + str);
        }
    }

    public int[][] calculateSquare(int n) {
        int arr[][] = new int[n][n];
        int i, j, k, t;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) arr[i][j] = 0;
        }
        if (n % 2 != 0) {
            i = 0;
            j = n / 2;
            k = 1;
            while (k <= n * n) {
                arr[i][j] = k++;
                i--;
                j++;
                if (i < 0 && j > n - 1) {
                    i = i + 2;
                    j--;
                }
                if (i < 0) i = n - 1;
                if (j > n - 1) j = 0;
                if (arr[i][j] > 0) {
                    i = i + 2;
                    j--;
                }
            }
        } else {
            k = 1;
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    arr[i][j] = k++;
                }
            }
            j = n - 1;
            for (i = 0; i < n / 2; i++) {
                t = arr[i][i];
                arr[i][i] = arr[j][j];
                arr[j][j] = t;
                t = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = t;
                j--;
            }
        }
        return arr;
    }
    
    public int calculateMagicNumber(int num) {
        return (int) ((num * (Math.pow(num, 2) + 1)) / 2);
    }
}
