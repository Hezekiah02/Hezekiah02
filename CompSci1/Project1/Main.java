import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) throws Exception {
        
        //variables
        Scanner scan = new Scanner(System.in); //read user input
        String name;                           //to store users name
        double dabloons;                       //store double input of gold
        boolean yeOrNa;                        //stores boolean to show if the user has mana
        String doYouHaveMana;                  //sotres string input for mana

        //User info gathering
        //Intro and name prompt
        System.out.println("Greeting adventurer, what is your name? ");

        //inputs to store data
        name = scan.nextLine();

        //prompt for gold input
        System.out.println("How much gold do you have on you?(Enter as  decimal number) ");
        dabloons = scan.nextDouble();       //store gold input

        //scanner to clear text
        scan.nextLine();

        //Ask user if they have mana
        System.out.println("Do you have mana within you?(Yes or No) ");
        doYouHaveMana = scan.nextLine(); //stores the answer for mana
        

        //display welcome message and amount of gold on user
        System.out.println("Welcome to the Masters Guild " + name + " we have been excited for your arrival! ");
        System.out.println("Your leather pouch contains " + dabloons + " gold");

        //conversion string to boolean for mana check
        yeOrNa = doYouHaveMana.equalsIgnoreCase("yes");
        if(yeOrNa){
            System.out.println("Mana flows within you " + name+".");
        } else{
            System.out.println("You have no mana.");
        }

        //choice 1
        System.out.println("You have 3 options adventurer(Type A,B, or C for your choice)");
        System.out.println("A. You can leave the guild and become a peasant.");
        System.out.println("B. Go to a shop.");
        System.out.println("C. You sign up to join the guild.");

        String choice = scan.nextLine(); //gets play choice

        //Path A
        if(choice.equalsIgnoreCase("A")){
            //Ending 2
            System.out.println("You are now a a poor peasant farmer(LAME ENDING)");
            return;
        }

        //Path B for them going to the shop
        else if(choice.equalsIgnoreCase("B")){
            
            //choice 4
            System.out.println("Welcome to the Mystic Exchange  what would you like?");
            System.out.println("A. To exchange your gold for mana crystals.");
            System.out.println("B. Would like to aquire a magic weapon.");

            choice = scan.nextLine();       //get shop choice
            
            //Option A: Exhange gold for mana crystals
            if(choice.equalsIgnoreCase("A")){

                double manaConv = dabloons / 2;
            System.out.println("You have obtained " + manaConv + " mana crystals from your gold.");
            System.out.println("The " + manaConv +  " mana crystals stur around you.(true or false)");
            
                //Decision 2
                //based on mana crystal obtained
                if(manaConv >= 10){
                       //Ending 6
                    System.out.println("You feel a great power flow through as the " + manaConv +" crystals flow through you as you gain legendary power.");
                    System.out.println("You then go and defeat the Demon King.");
                    System.out.println("LEGENDARY ENDING");
                    return;
                }
                else{
                    //ending 5
                    System.out.println("You then leave feeling  sad you then quit adventuring on the spot(DISSAPOINTED ENDING)");
                    return;
                }
            }

            //Option B: Trying to obtain a magic weapn
            else if(choice.equalsIgnoreCase("B")){
                System.out.println("Can you handle the legendary sword the Dark Moon  Greatsword.(true or false)");
                boolean answer = scan.nextBoolean();
                    if(answer == true){
                        System.out.println("You pick up the sword");
                        System.out.println("You feel...... nothing");
                        System.out.println("the sword does not attune to you.");
                        //ending 5
                        System.out.println("you then quit adventuring on the spot(DISSAPOINTED ENDING)");
                        return;
                    }
                    else{
                        System.out.println("You pick up the sword");
                        System.out.println("The sword feels your humility, humbleness, and respect");
                        System.out.println("The sword attunes with you and you feel a great deal of magic swell within you");
                        //ending 4
                        System.out.println("You then become the Greatest Wizard and Sword Master(MASTER OF TRADES ENDING)");
                        return;
                    }
            }

            //Path C
        }else if(choice.equalsIgnoreCase("C")){
            System.out.println("Another brave soul joins our ranks. May your blade stay sharp and your heart true.");
            System.out.println("Let's get a feel for your mana");

            //mana check
            if(doYouHaveMana.equalsIgnoreCase("yes")){
                System.out.println("Woah you have immense mana within you do ");
            }
            else{
                System.out.println("You have barley any magic but it'll be alright");
            }

            //choice 2
            System.out.println("A. Go on a adventure solo");
            System.out.println("B. Go to an academy to learn about magic, sword skill, and everything about the world");
            System.out.println("C. Become a merchant and get the big bucks");

            choice = scan.nextLine();

            //Option A solo adventure
            if(choice.equalsIgnoreCase("A")){
                System.out.println("You go multiple solo quest and build up your skills");
                System.out.println("Your skills have built up");
                System.out.println("Would you say you have become way more powerful then before!(true or false)");
                
                boolean answer = scan.nextBoolean();  //Power growth decision

                //Decision 1
                if(answer == true){

                    System.out.println("You are truly the strongest adventurer you are...the Hero!");
                    System.out.println("MASTER OF TRADES ENDING");

                }else{

                    System.out.println("You look within yourself and see not much power");
                    System.out.println("DISSAPOINTED ENDING");
                }

            }

            //Option B: Go to school
            else if(choice.equalsIgnoreCase("B")){
                
                //choice 3
                System.out.println("You learn an immense about yourself and magic");
                System.out.println("You then decide to: ");
                System.out.println("A. Strengthen your power in magic and sword play to develop even further beyond");
                System.out.println("B. Seek out more power but from the forbidden text you read in the accademy");

                choice = scan.nextLine();

                if(choice.equalsIgnoreCase("A")){

                    System.out.println("You become greatest in magic and sword play");
                    //ending 4
                    System.out.println("MASTER OF TRADES ENDING");
                }
                else if(choice.equalsIgnoreCase("B")){
                    System.out.println("You become a evil dark lord who uses forbidden magic no one can stop you!");
                    //Ending 3
                    System.out.println("VILLAIN ENDING");
                }
            }

            //Option C: Become a merchant
            else if(choice.equalsIgnoreCase("C")){
                System.out.println("You have become richest man in the world");
                //Ending 1
                System.out.println("RICHEST THERE IS ENDING");
            }
        }
        
        


    }
}

