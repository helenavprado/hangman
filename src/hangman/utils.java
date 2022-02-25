package hangman;

import java.util.Random;


public class utils {

    public static final Random RANDOM = new Random();


    public String chooseCity(String[] citiesList) {
        return citiesList[RANDOM.nextInt(citiesList.length)];
}}
