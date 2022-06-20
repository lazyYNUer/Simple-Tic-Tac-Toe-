package tictactoe;
import java.util.Scanner;

public class Main {
    boolean xTurn = false;
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] field = new char[3][3];//数组储存棋盘
        boolean notFinshed = true;
        while (notFinshed) {

        }
    }

    //打印棋盘
    public static void printField(char[][] twoDimArray) {
        System.out.println("---------");
        for (int i = 0; i <twoDimArray.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < twoDimArray[0].length; j++) {
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    //下棋
    public static void play(int x, int y, char[][] field) {
        if (x > 3 || x < 1 || y > 3 || y < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else {
            if (field[x - 1][y - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                if (xTurn) {
                    field[x - 1][y - 1] = 'X';
                    xTurn = false;
                } else {
                    field[x - 1][y - 1] = 'O';
                    xTurn = true;
                }
            }
        }
    }

    //判断比赛胜负
    public static String check(char[][] field) {
        int xNum = 0;
        int oNum = 0;
        boolean xxx = false;
        boolean ooo = false;
        int rowSum = 0, colSum = 0, lineSum1 = 0, lineSum2 = 0;
        String result;

        // check if row or column or any of diagonals is win for someone
        for (int i = 0; i < 3; i++) {
            int row = 0;
            int clm = 0;
            int mDiag = 0;
            int aDiag = 0;

            for (int j = 0; j < 3; j++) {
                row += field[i][j];
                clm += field[j][i];
                mDiag += field[j][j];
                aDiag += field[j][2-j];
            }

            // ASCII value for X is 88 (X+X+X is 264)
            // ASCII value for O is 79 (O+O+O is 237)
            xxx = xxx || row == 264 || clm == 264 || mDiag == 264 || aDiag == 264;
            ooo = ooo || row == 237 || clm == 237 || mDiag == 237 || aDiag == 237;
        }

        if (xxx) {
            result = "X wins";
        } else if (ooo) {
            result = "O wins";
        } else {
            result = null;
        }

        return result;
    }
}


