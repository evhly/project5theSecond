import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hero extends Character {
    private ArrayList<Weapon> weapons; //weapons must be unique, so set
    private Map<String,Integer> potions; //key, value -- potion name, number of that kind
    private String name;
    private int maxHealth;
    private int baseStrength;
    private int strength;
    boolean strengthBoost;
    //private ArrayList<Item> items;



    /**
     * constructor
     * @param h = health of hero
     * @param n = hero's name
     * @param s = strength
     * @param bs = base strength
     */
    public Hero(int h, String n, int bs) {
        super(h);
        name = n;
        strength = bs;
        baseStrength = bs;

        maxHealth = h + 5;
        potions = new HashMap<>();
        weapons = new ArrayList<>();
        strengthBoost = false;
        weapons.add(new Weapon("Wooden Sword", 5));
        potions.put("Health potion",2);    //hero starts with 2 health potions


    }

    public String getName() {
        return name;
    }

    /**
     * this method adds items to the hero's inventory
     * @param i = the item being added.
     */
    public void addItem(Item i){
        // TODO: check if item is a weapon - if so add to weapons arraylist
        // can use instanceof eg if (i instanceof Weapon) { ...
        // if it is a potion, add it to the potions map

    }

    //add strength
    //reset to base (What does this do?)


//    public int getMaxHealth(){
//        return maxHealth;
//    }

    /**
     * provides an update on the hero's current stats
     * @return string of stats
     */


    @Override
    public String getStats() {
        //print list of weapons and potions
        return "Hero:\n"+ name + "\nHealth remaining: " + super.health + "\nWeapons: " + weapons + "\nPotions: " + potions + "\n";
    }

    public Weapon getWeapon (int index) {
        return weapons.get(index);
    }

    public void heal(int addedHealth) {
        if (!(super.getHealth() + addedHealth > maxHealth)){
            super.health += addedHealth;
        } else {
            super.health = maxHealth;
        }
    }

    public void restoreHealth(){
        super.health = maxHealth - 5;
    }

}
