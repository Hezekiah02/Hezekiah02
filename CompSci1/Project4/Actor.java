import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    
    /**
     * makes the dungeon using the given size
     * @param size
     * @return dungeon
     */
    public static Actor[][] makeDungeon(int size) {
        Actor[][] dungeon = new Actor[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            }
        }
        return dungeon;
    }

    /**
     * Makes monster and hero fight if there in the same room
     * @param p1
     * @param monsters
     */  
    public static void fight(Actor p1, ArrayList<Actor> monsters, Actor[][] dungeon){

        for(int i = 0; i < monsters.size(); i++){
            Actor m1 = monsters.get(i);
            if(p1.inSameRoom(m1)){
                while ((p1.isAlive()) && (m1.isAlive())) {
                    m1.dealDamage(p1);
                    p1.dealDamage(m1);
        
                    System.out.println(p1 + " " + m1);
                }
                if(!m1.isAlive()){
                    System.out.println(m1.getName() + " has been slain!");

                    //removes monster from dungeon
                    dungeon[m1.getX()][m1.getY()] = null;

                    //removes monster from list
                    monsters.remove(i);
                    i--;
                }
            }
        }
    }

    /**
     * smells the north,south,east,west of the player then senses monsters 
     * then counts the number of monsters nearby given the location of the monster and players
     * @param p1
     * @param monsters
     * @return smells
     */
    public static int smellMon(Actor p1, ArrayList<Actor> monsters) {

        int smells = 0;

        for (Actor m : monsters) {
            if ((p1.getX() - 1) == m.getX() && p1.getY() == m.getY()) {
                smells++;
            } else if (p1.getX() + 1 == m.getX()) {
                smells++;
            } else if (p1.getY() - 1 == m.getY()) {
                smells++;
            } else if (p1.getY() + 1 == m.getY()) {
                smells++;
            }

        }
        return smells;

    }

    /**
     * makes the monster for every 6 rooms dependent on the dungeon size
     * @param dungeon
     * @return monsters
     */
    public static ArrayList<Actor> makeMonsters(Actor[][] dungeon) {
        int size = dungeon.length;
        Random rand = new Random();

        ArrayList<Actor> monsters = new ArrayList<Actor>();

        for (int i = 0; i < (size * size) / 6; i++) {

            int locationX = rand.nextInt(size);
            int locationY = rand.nextInt(size);
            while (locationY == 0 || locationX == 0 || dungeon[locationX][locationY] != null){
            locationX = rand.nextInt(size);
            locationY = rand.nextInt(size);
            }

            Actor m1 = new Actor("M" + i, 25, 5, locationX, locationY);
            dungeon[m1.getX()][m1.getY()] = m1;
            monsters.add(m1);

        }
        return monsters;

    }


    public static void main(String[] args) throws Exception {

        // Actors making name, health, row and column
        Scanner in = new Scanner(System.in);

        System.out.print("What is your name, heroic adventurer? ");
        String name = in.next();

        
        System.out.println("How wide of a catacomb do you want to face (5-10)?");
        Actor p1 = new Actor(name, 100, 10, 0, 0);
        
        //while the size is greater then 5 or less than 10
        //if its less or greater it will break and will wait to re-give number
        int size = 0;
        while (true) {
            size = in.nextInt();
            if (size < 5 || size > 10) {
                System.out.println("That is not a valid size!");
            } else
            break;
        }
        
        Actor[][] dungeon = makeDungeon(size);
        
        //gameplay
        ArrayList<Actor> monsters = makeMonsters(dungeon);
        boolean moveCheck = false;
        dungeon[p1.getX()][p1.getY()] = p1;
        in.nextLine();
        while(p1.isAlive() && !p1.hasEscaped(size)){
            while(moveCheck == false){
                int smells = smellMon(p1, monsters);
                System.out.println("You smell " + smells + " monsters nearby.");
                System.out.println("Direction?(north,south,east,west)");
                String direction = in.nextLine().toLowerCase();
                moveCheck = p1.move(dungeon, direction);
                if(moveCheck == false){
                    System.out.println("Invalid move");
                }else{
                    System.out.println("Moved Hero " + direction + ". New location: (" + p1.getX() + "," + p1.getY() + ")");
                    System.out.println("Health: " + p1.getHealth());
                    break;
                }
            }
            moveCheck=false;
            
            // fights 
            fight(p1, monsters,dungeon);
            
            
            
            



        }
        //Screen of if player has escaped or died
        if(p1.isAlive()){
            System.out.println("You have Escaped!");
        }else{
            System.out.println("YOU ARE DEAD");
        }
        
    }


}
