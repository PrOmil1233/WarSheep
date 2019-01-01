package com.company.Client;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket client = null;
    static ObjectOutputStream out = null;
    static ObjectInputStream in = null;
    static int currentSheepCount = 0;
    static int enemySheepCount = 3;
    static boolean gameLoop = false;
    static Scanner sc = new Scanner(System.in);

    // 0 - puste/mgła wojny
    // 1 - nasza owca
    // 2 - trafiona nasza owca
    // 3 - trafiona owca wroga

    public static void main(String[] args) throws IOException {

        client = new Socket("127.0.0.1", 8888);
        out = new ObjectOutputStream(client.getOutputStream());
        in = new ObjectInputStream(client.getInputStream());


        System.out.println("Oczekiwanie na 2 gracza");
        while (!gameLoop) {
            gameLoop = false; //odpowiedz z serwera czy jest 2 gracz
        }
        System.out.println("2 gracz zawitał");
        Board myBoard = new Board();
        Board encodedEnemyBoard = new Board();
        fillBoardWithSheep(myBoard);
        System.out.println("[My board]");
        myBoard.printBoard();
        while (gameLoop) {
            System.out.println("Czas na ostrzał owiec, podaj x");
            int x = sc.nextInt();
            System.out.println("podaj y");
            int y = sc.nextInt();
            //wysylamy x i y(lub field)

            //odbieramy odpowiedz, czy trafilismy, uzupelniamy encodedEnemyBoard
            int responseFromServer = 9;
            encodedEnemyBoard.setFieldStatus(x, y, responseFromServer);
            System.out.println("[Enemy Board]");
            encodedEnemyBoard.printBoard();
            if (responseFromServer == 3) {
                enemySheepCount--;
            }
            if (enemySheepCount == 0) {
                gameLoop = false;
                //wyslanie sygnalu do servera ze tamten przegral lub serwer ogarnia kto wygral
                System.out.println("Gratulacje wygrales");
            }


        }
    }

    private static void fillBoardWithSheep(Board myBoard) {
        while (currentSheepCount < enemySheepCount) {
            System.out.println("Gdzie chcesz postawić owce? podaj x: ");
            int x = sc.nextInt();
            System.out.println("Podaj y:");
            int y = sc.nextInt();
            if (myBoard.getBoard()[x][y].getStatus() != 1) {
                myBoard.setFieldStatus(x, y, 1);
                currentSheepCount++;
            } else {
                System.out.println("na tym polu stoi juz owca");
            }
        }
    }

}
