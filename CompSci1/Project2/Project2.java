import java.util.Scanner;
import java.util.Random;

public class Project2 {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {

        boolean condition = true;
        String save = "";
        int Userscore = 0;

        Scanner in = new Scanner(System.in);

        Random rand = new Random();

        System.out.println("Lets play Simon Says!");

        // do while loop for the code to continue over and over if prompted to
        do {
            System.out.print("Select difficulty(easy or hard): ");
            String mode = in.nextLine();
            save = "";

            if (mode.replace(" ", "").equalsIgnoreCase("easy")) {
                System.out.println("easy mode - colors");

                while(true) {

                    int randNum = rand.nextInt(4);
                    String colors = "";

                    switch (randNum) {

                        case (0):
                            colors = "red";
                            break;

                        case (1):
                            colors = "blue";
                            break;

                        case (2):
                            colors = "green";
                            break;

                        case (3):
                            colors = "yellow";
                            break;

                    }// End of switch

                    save += colors + " ";
                    System.out.print("Simon says: " + save);
                    sleep();
                    clearScreen();
                    String answer = in.nextLine();

                    // if statement to add score and color
                    if (answer.replace(" ", "").equalsIgnoreCase(save.replace(" ", ""))) {
                        Userscore++;
                        System.out.println("Score: " + Userscore);
                        continue;
                    } else {
                        break;
                    }

                } // end of easy mode for loop

                System.out.println("Game over! Your score was: " + Userscore);
                boolean nextRound = true;

                //repeats game and asks questions if the user wants to play the game
                while (nextRound == true) {
                    System.out.print("Do you want to play again?(yes/no): ");
                    String playAgain = in.nextLine();

                    if (playAgain.replace(" ", "").equalsIgnoreCase("Yes")) {
                        nextRound = false;
                        continue;
                    } else if (playAgain.replace(" ", "").equalsIgnoreCase("No")) {
                        condition = false;
                            break;
                    } else {
                        continue;
                    }
                }

                // start of hard mode
            } else if (mode.replace(" ", "").equalsIgnoreCase("hard")) {
                System.out.println("hard mode - numbers");

                Userscore = 0;

                //runs game till you get wrong answer
                while(true) {
                    int randNum = rand.nextInt(10);
                    save += randNum + " ";
                    System.out.print("Simon says: " + save);
                    sleep();
                    clearScreen();
                    String answer = in.nextLine();
                    // if statement for hardmode keeping score and numbers
                    if (answer.replace(" ", "").equalsIgnoreCase(save.replace(" ", ""))) {
                        Userscore++;
                        System.out.println("Points: " + Userscore);
                        continue;
                    } else {
                        break;
                    }
                } // end of hard loop

                System.out.println("Game over! Your score was " + Userscore);

                // while loop asking if you want to play again or not
                boolean playAgain = true;
                while (playAgain == true) {
                    System.out.print("Do you want to play again?(Yes/No): ");
                    String again = in.nextLine();
                    if (again.replace(" ", "").equalsIgnoreCase("Yes")) {
                        playAgain = false;
                        continue;
                    } else if (again.replace(" ", "").equalsIgnoreCase("No")) {
                        condition = false;
                        // break to stop game if you don't want to play again
                        break;
                    } else {
                        continue;
                    }
                }
                // if you enter in a invalid difficulty
            } else {
                System.out.println("Invalid difficulty");
                continue;
            }
            // After you don't want to play again gives message
        } while (condition == true);

        System.out.println("Thanks for playing!");

        in.close();
    }

    //clears screen after 3 seconds
    public static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
