package com.company.Client;

public class Board {

    //private ArrayList<Field> board = new ArrayList<>();
    private Field[][] board;

    //10x10
    public Board() {
        board = new Field[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                board[x][y] = new Field(0);
            }
        }
    }

    public Field[][] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.print(" \t");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + i + "   ");
        }
        System.out.println();
        for (int x = 0; x < 10; x++) {
            System.out.print( x + "\t");
            for (int y = 0; y < 10; y++) {
                System.out.print(board[y][x] + " ");
            }
            System.out.print("\n");
        }
    }

    public void setFieldStatus(int x, int y, int status) {
        board[x][y].setStatus(status);
        // board.get(x + y*x ).setStatus(status);

    }
}
