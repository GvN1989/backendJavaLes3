package nl.Novi;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bonus {

    public static void main(String[] args) {

        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber = setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback(stringnumber);
    }

    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect = false;

        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        System.out.println("Doe een gok, Let op vul 4 getallen in.");

        while (!isCorrect) {

            StringBuilder feedback = new StringBuilder();
            String guess = scanner.nextLine();

            if (guess.length() != 4) {
                System.out.println("Ongeldige invoer. Zorg ervoor dat je precies 4 getallen invoert.");
                continue;
        }
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("Gefeliciteerd je hebt het goed");
                isCorrect = true;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("O");
                    } else {
                        feedback.append("X");
                    }
                }
                System.out.println(feedback.toString());
                System.out.println("Probeer het opnieuw. Vul opnieuw 4 getallen in.");
            }
        }
    }

    public static HashSet<Integer> randomnumbergenerator(){

        Random rand = new Random();

        HashSet<Integer> secretnumber = new HashSet<>();

        while (secretnumber.size () <4) {
            int randomnumber = rand.nextInt(9) +1;
            secretnumber.add(randomnumber);}
        return secretnumber;

    }

    public static String setToStringConverter(HashSet<Integer> secretnumber){
       StringBuilder stringnumber= new StringBuilder();

       for (Integer element : secretnumber) {
           stringnumber.append(element.toString());
       }
       return stringnumber.toString();
       }


}
