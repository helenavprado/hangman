package hangman;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class hangman {

    public static void main(String[] args) {
        utils utils = new utils();
        ArrayList<String> wrongLetters = new ArrayList<String>();
        String[] citiesList = {"Floripa", "Sao paulo", "Rio de janeiro"};
        int maxTries = 10;
        int currentTries = 0;
        int index = 0;
        boolean gameOver = false;
        String city = utils.chooseCity(citiesList);
        int numberOfLetters = city.length();

        // replace letters with underscore
        StringBuilder userDisplayOfWord = new StringBuilder();
        for (int i=0; i<numberOfLetters; i++) {
            if (city.charAt(i) == ' ') {
                userDisplayOfWord.append(' ');
            } else {
                userDisplayOfWord.append('_');
            }
        }

        // welcome
        System.out.println("Here's the word:");
        System.out.println(userDisplayOfWord);

        // start game
        while (!gameOver) {
        Scanner letter = new Scanner(System.in);


        System.out.println("Guess a letter:");
        String userInput = letter.nextLine();
        String toLowerCase = userInput.toLowerCase(Locale.ROOT);
        char letterGuessed = toLowerCase.charAt(0);

            index = city.indexOf(letterGuessed);
            if (index > -1) {
                index = city.indexOf(letterGuessed);
                while (index > -1) {
                    userDisplayOfWord.setCharAt(index, letterGuessed);
                    index = city.indexOf(letterGuessed, index + 1);
                }
            } else {
                wrongLetters.add(toLowerCase);
                currentTries++;
            }

        System.out.println("You are guessing: " + userDisplayOfWord);
        System.out.println(String.format("You have guessed %d wrong letters: %s", currentTries, wrongLetters));



        if (currentTries >= maxTries) {
            gameOver = true;
            System.out.println("Sorry! You ran out of tries");
        } else if (userDisplayOfWord.indexOf("_") == -1 ){
            gameOver = true;
            System.out.println("Congrats! You guessed the word right!");
        }
        }











    }

    }



















