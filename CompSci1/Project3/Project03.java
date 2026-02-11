
import java.util.Scanner;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashSet;

public class Project03 {

    /**
     * Selects random word from file using the reader to look in the file and select
     * one
     * refernce used
     * https://stackoverflow.com/questions/12028205/randomly-choose-a-word-from-a-text-file
     * @return randomWord
     */
    public static String SelectRandomWord() {
        String randomWord = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
            String line = reader.readLine();
            List<String> words = new ArrayList<String>();
            while (line != null) {
                String[] wordsLine = line.split(" ");
                for (String word : wordsLine) {
                    words.add(word);
                }
                line = reader.readLine();
            }

            Random rand = new Random();
            int randNum = rand.nextInt(words.size());

            randomWord = words.get(randNum);

        } catch (Exception e) {
            System.out.println("Problem with random word from file");
        }

        return randomWord;
    }

    /**
     * 
     * @param SelectRandomWord
     * @return false if char c doesn't contain
     * @return false if word letter length is not 7
     * @return true if unique lettering
     */
    public static boolean isSeven(String SelectRandomWord) {

        if (SelectRandomWord.length() != 7) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for (char c : SelectRandomWord.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;

    }

    /**
     * Scrambles word given from file using SelectRandomWord and spaces out letters
     * https://stackoverflow.com/questions/4247810/scramble-a-word-using-java
     * refernce used to scramble
     * 
     * @param SelectRandomWord
     * @return newWord
     */
    public static String scrambler(String SelectRandomWord) {
        char[] wordArray = SelectRandomWord.toCharArray();

        char[] wordArray2 = SelectRandomWord.toCharArray();

        Random randy = new Random();

        int r = randy.nextInt(wordArray.length - 1);
        int i = 0;

        int j = r + 1;

        while (i <= wordArray.length - 1) {

            wordArray2[wordArray.length - i - 1] = wordArray[i];

            i++;
        }

        while (j <= wordArray.length - 1) {
            wordArray2[j - r - 1] = wordArray[j];

            j++;
        }
        
        String scrambledWord = String.valueOf(wordArray2);
        String newWord ="\t";
        for(char letter: scrambledWord.toCharArray()){
            newWord += letter+"\t"; 
        }
        return newWord;
    }

    /**
     * 
     * @param input
     * @return true if the user input is from the file
     * @return false if the user input is not from file
     * @return false otherwise
     */
    public static boolean validWord(String input) {
        try{BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
            String line = reader.readLine();
            List<String> words = new ArrayList<String>();
            while (line != null) {
                String[] wordsLine = line.split(" ");
                for (String word : wordsLine) {
                    words.add(word);
                }
                line = reader.readLine();
            }
            if(words.contains(input)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Scores if input length is 4
     * Scores if input length is greater than 4 then scores for each character
     * Recieves no score if input is less than 4 or not a valid word from the file
     * or is the same word
     * 
     * @param input
     * @param validWord
     * @return fourLetScore
     */
    public static int scoreKeeper(String input, String validWord) {

        int fourLetScore = 0;

        if (input.length() == 4) {

            fourLetScore++;

        }

        else if (input.length() > 4) {
            for (char ch : input.toCharArray()) {
                fourLetScore++;
            }

        } else if (input.length() < 4 || !validWord(input) || input.equalsIgnoreCase(validWord)) {

            fourLetScore = 0;
        }
        return fourLetScore;

    }

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        ArrayList<String> userInput2 = new ArrayList<String>();
        String fileWord = "";
        boolean isSeven = false;
        int score = 0;
        String userCommand = "";
        int mainScore = 0;

        while (!isSeven) {
            fileWord = SelectRandomWord();
            isSeven = isSeven(fileWord);
        }
            //switch game that implments things for game and the game
        System.out.println(scrambler(fileWord));
        while (true) {
            System.out.println(mainScore);
            userCommand = in.nextLine();
            switch (userCommand) {
                //mixes word that givens letters
                case "mix":
                    System.out.println(scrambler(fileWord));
                    break;
                case "bye":
                //exits the game
                    System.exit(0);
                    break;
                //list user inputs
                case "ls":
                    for (String s : userInput2) {
                        System.out.println(s);
                    }
                    break;
                default:
                    if (validWord(userCommand)) {
                        userInput2.add(userCommand);
                        score = scoreKeeper(userCommand, fileWord);
                        mainScore = mainScore + score;
                    }
                    break;
            }
            
        }

    }
}

