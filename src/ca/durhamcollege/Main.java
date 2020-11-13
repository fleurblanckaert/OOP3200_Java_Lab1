/**
 * @Author: Gabriel Dietrich (100764733), Fleur Blanckaert (100747083)
 * @Date: Nov 12 2020
 * @Description: This application prompts the user to enter the score of 2 bowling
 *               games for a total of 3 people and then calculates the average
 *               score for each player
 */
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
        String[] names = new String[]{"Fleur", "Gabriel", "Tom"};
        boolean isValidInput = false;
        int minScore = 0;
        int maxScore = 300;
        float totalScore = 0;

        //Displays title for output
        System.out.println("BOWLING SCORES");

        //Loops through 2 dimensional array
        for (int x = 0; x < games; x++)
        {
            for (int y = 0; y < people; y++)
            {
                //Loops until user enters valid input
                do
                {
                    //Initializes try to catch a possible error
                    try
                    {
                        //Prompts the user to enter the scores for the game
                        System.out.print("Please enter " + names[y] + "'s score for GAME #" + (x + 1) + ": ");
                        bowling[y][x] = keyboard.nextInt();


                        //Validates if the user enter a number between 0 and 300, inclusive
                        if (bowling[y][x] < minScore || bowling[y][x] > maxScore)
                        {
                            //Displays error message
                            System.out.println("\nError: You entered an invalid range. Value between " + minScore + " and "
                                    + maxScore + " needed. Please try again.\n");
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
                        System.out.println("\nError: You entered an invalid number. Please try again.\n");
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
                System.out.println("Game # " + (j+1) + ": " + bowling[i][j]);
                totalScore += bowling[i][j];
            }

            //Calculates Average
            float average = totalScore / games;

            //Displays average and sets totalScore back to zero
            System.out.println("Average for " + names[i] + ": " + average);
            totalScore = 0;
        }
    }
}