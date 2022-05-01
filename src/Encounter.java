import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Encounter {
    private String begText;
    private Enemy e1;
    private Hero hero;
    private Scanner scnr = new Scanner(System.in);
    private Random rand = new Random();
    private int roundWEnemey = 2;

    public Encounter(Hero h, Enemy e, String bt){
        hero = h;
        e1 = e;
        begText = bt;
    }

    /**
     *
     * @return true if hero lives and false if enemy wins
     */
    public boolean battle(){
        while(!hero.isDead() || !e1.isDead()){
            System.out.println(hero.getStats());
            System.out.println(e1.getStats());
            System.out.println(hero.getName() + " what do you want to do?");
            System.out.println("Enter 1 to use weapon.");
            int actionChoice = scnr.nextInt();
            int damage = 0;
            // TODO: currently only one option for weapon---
            if (actionChoice == 1){
                damage = attack(hero.getWeapon(0).getMaxDamage()); //Todo ask which weopon  //todo add to this number if strength potion is in effect
            } if(actionChoice == 2){
                //use potion
            }
            e1.takeDamage(damage);
            System.out.println("You attack "+ e1.getName()+" for " + damage + " damage.");
            if (e1.isDead()){
                System.out.println("Congratulations! You defeated " + e1.getName() + "!");
                hero.restoreHealth();
                return true;
            }
            int enemyDamage = attack(e1.getWeapon().getMaxDamage());
            hero.takeDamage(enemyDamage);
            System.out.println(e1.getName() + " takes a turn.");
            System.out.println(e1.getName()+ " attacks "+ hero.getName() + " for " + enemyDamage + " damage.\n" +  '\n' + "---------Round " +  roundWEnemey + " with " + e1.getName() + "---------");
            if (hero.isDead()){
                System.out.println("You died! Game over!");
                return false;
            }
            roundWEnemey++;
        }
        // following code should not be reachable
        return false;
    }

    private int attack(int maxDmg) {
        int bound = maxDmg - (maxDmg/2);       //damage ranges between half and max for that weapon
        int damage = rand.nextInt(bound) + (maxDmg/2);
        return damage;
    }

    /**
     * text at beginnig of each encounter
     * Eg: "You reach the top of a hill and stumble on a Troll. His name is..."...
     * @param begText
     */
    public void setBegText(String begText) {
        this.begText = begText;
    }

    public void setE1(Enemy e1) {
        this.e1 = e1;
    }

    public String getBegText() {
        return begText;
    }

    public static Encounter firstEncounter(Hero h){
        //public Enemy(int h, String n, String t, Weapon w, ArrayList<Item> dl) {
        Weapon club = new Weapon("club", 4);
        ArrayList<Item> drp = new ArrayList<>();
        drp.add(club);
        Enemy en = new Enemy(5, "Eric", "Toad",club,drp);

        String begTxt = "You begin your adventure. \nYou leave your town in search of the great dragon, Steve.\n"+
                "But as you enter the woods you encounter your first enemy, Eric the Toad.\n";
        return new Encounter(h, en, begTxt);

    }

    public static Encounter bossEncounter(Hero h){
        Weapon fire = new Weapon ("fire",10);
        ArrayList<Item> drp = new ArrayList<>();
        drp.add(fire);
        Enemy en = new Enemy(15, "Steve", "Dragon",fire,drp);
        String finalRText = "Congratulations! You have made it to the final round!! Your last opponent is Steve the Dragon! Good luck!!";
        return new Encounter(h,en, finalRText);
    }




    //......
}
