package ca.durhamcollege;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //VARIABLE DECLARATION
        Scanner keyboard = new Scanner(System.in);
        int games = 2;
        int people = 3;
        int[][] bowling = new int[people][games];
        String[] names = {"Fleur's", "Gabriel's", "Thom's"};
        boolean isValidInput = false;

        System.out.println("BOWLING SCORES");
        //PROCESSING
        while (!isValidInput)
        {
            try
            {
                for (int x = 0; x < games; x++)
                {
                    for (int y = 0; y < people; y++)
                    {
                        System.out.print("Please enter " + names[y] + " score for GAME #" + (x + 1) + ": ");
                        bowling[y][x] = keyboard.nextInt();
                        isValidInput = true;
                    }
                }

            }
            catch (InputMismatchException inputMismatchException)
            {
                System.out.println("Error: You must entered an invalid number");
                keyboard.nextLine();
                isValidInput = false;
            }

        }
    }
}

