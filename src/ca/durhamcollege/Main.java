package ca.durhamcollege;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
        //Variable Declarations
        Scanner keyboard = new Scanner(System.in);
        int games = 2;
        int people = 3;
        int[][] bowling = new int[people][games];
        String[] names = new String[]{"Fleur's", "Gabriel's", "Tom's"};
        boolean isValidInput = false;
        int minScore = 0;
        int maxScore = 300;
        float totalScore = 0;

        //Displays title for output
        System.out.println("BOWLING SCORES");

        for (int x = 0; x < games; x++)
        {
            for (int y = 0; y < people; y++)
            {
                //Loops to validate the input entered by the user
                do
                {
                    //Initializes try to catch a possible error
                    try
                    {
                        // Prompts the user to enter the scores for the game
                        System.out.print("Please enter " + names[y] + " score for GAME #" + (x + 1) + ": ");
                        bowling[y][x] = keyboard.nextInt();


                        // Validates if the user enter a number between 0 and 300, inclusive
                        if (bowling[y][x] < minScore || bowling[y][x] > maxScore)
                        {
                            //Displays error message
                            System.out.println("Invalid input. Value between " + minScore + " and "
                                    + maxScore + " needed. Please try again.");
                            isValidInput = false;
                        }
                        else
                            {
                                isValidInput = true;
                            }
                    }
                    catch(InputMismatchException inputMismatchException)
                    {
                        //Displays error message
                        System.out.println("Error: You entered an invalid number. Please try again.");
                        keyboard.nextLine();
                        isValidInput = false;
                    }
                }while(!isValidInput);
            }
        }

        //Output
        for(int i = 0; i < people; i++)
        {
            System.out.println("");
            System.out.println("Score Details for " + names[i] + ":");
            for(int j = 0; j < games; j++)
            {
                System.out.println("Game # " + j + ": " + bowling[i][j]);
                totalScore += bowling[i][j];
            }
            // Average
            float average = totalScore / games;
            //Displays average and sets totalScore back to zero
            System.out.println("Average for " + names[i] + ": " + average);
            totalScore = 0;
        }
    }
}