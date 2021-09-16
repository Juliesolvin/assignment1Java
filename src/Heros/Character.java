package Heros;


import Attributes.Attribute;
import Exceptions.InvalidArmorException;
import Exceptions.InvaliddWeaponException;
import game.Armor;
import game.Item;
import game.Slot;
import game.Weapon;

import java.util.HashMap;

abstract class Character {
    // All of the attributes in Charater must be in the other classes aswell
    // Protected = Alle subklasser har tilgang
    // Private - Ingen har tilgang
    // Public - Alle har tilgang
    protected int level;
    protected String name;

    // Their main attributes
    protected Attribute base;

    // Base attributes + armor attributes
    protected Attribute totalAttribute;

    // <key, value>
    // Gets an error with this attribute - I dont understand why
    public HashMap<Slot,Item> equipment;
    protected double DPS;

    // What are their "start" values?
    // Det er deres primary attributes altså !!!
    protected double damage;
    protected double health;


    public Character(String name){
        this.name = name;
        this.level = 1;
    }

    public void Increaselevel() {
        this.level = this.level + 1;
    }

    // Sets slot with item (either weapon or armor)
    public void setslotanditem (Slot slot, Item item) {

        equipment.put(slot, item);
        // Need to put the attributes correct here
        calculateTotalAttribute();
    }

    // Some getters for testing
    public int getLevel(){
        int i = level;
        return level;
    }

    // checks if level of char is high enough for weapon
    // Maybe some unnecessary code
    public boolean checkweapon(Weapon weapon){
        if(weapon.getlevel() < this.level){
            return true;
        }
        return false;
    }

    boolean equipWeapon(Weapon weapon) throws InvaliddWeaponException {
        if(checkweapon(weapon)){
            throw new InvaliddWeaponException("Your character has low level");
        }

        return true;
    }

    // checks if level of char is high enough for armor
    // Maybe some unnecessary code
    public boolean checkarmor(Armor armor){
        if(armor.getlevel() < this.level){
            return true;
        }
        return false;
    }

    boolean equipArmor(Armor armor) throws InvalidArmorException {
        if(checkarmor(armor)){
            throw new InvalidArmorException("Your character has low level");
        }
        return true;
    }


    // Calculate Armor attributes
    public Attribute calcArmorAtt(){

        // Vi har equipment hashmapen -
        // Gå gjennom hele, om det er et Armor-item - Ta det ut og plusse på.
        // Vi har hashmap<key, value>, her i form av  <Slot, Item>
        // Og det er alle ITems som er = Armor som vi ønsker å få ut
        int vitality = 0;
        int strength = 0;
        int dexterity = 0;
        int intelligence = 0;
        // Goes through <Slot,Item> hashmap, and finds all the armors
        // First: Checks if we have items at all
        if (!(equipment.values().isEmpty())) {
            for (Item value : equipment.values()) {
                if (value instanceof Armor) {
                    vitality = vitality + ((Armor) value).getBase().getVitality();
                    strength = strength + ((Armor) value).getBase().getStrength();
                    dexterity = dexterity + ((Armor) value).getBase().getDexterity();
                    intelligence = intelligence + ((Armor) value).getBase().getIntelligence();
                }
            }
        } else {
            DPS = 1;
        }
        Attribute ArmorAttributes = new Attribute(vitality, strength, dexterity, intelligence);
        return ArmorAttributes;
    }

    public void calculateTotalAttribute(){
        // Total Attribute = Base + ArmorAttributes.
        totalAttribute.setVitality(base.getVitality() + calcArmorAtt().getVitality());
        totalAttribute.setStrength(base.getStrength() + calcArmorAtt().getStrength());
        totalAttribute.setDexterity(base.getDexterity() + calcArmorAtt().getDexterity());
        totalAttribute.setIntelligence(base.getIntelligence() + calcArmorAtt().getIntelligence());
    }

    // What should this return?
    public double CalculateWeaponsDPS(){
        // Finding the DPS of every weapon
        double WeaponDPS = 0;
        // Goes through every weapon in the hashmap
        for (Item value : equipment.values()) {
            if (value instanceof Weapon){
                WeaponDPS =+ ((Weapon) value).getWeaponDPS();
            }
        }
        // If no weapon => DPS = 1;
        if (WeaponDPS == 0){
            this.DPS = 1;
            return 1;
        } else {
            return WeaponDPS;
        }
        // Returns the WeaponDPS
        }


    public void statsToString() {
      // Calculates the Total Attributes
        calculateTotalAttribute();
        // Part A: creates StringBuilder and adds all the value
        StringBuilder builder = new StringBuilder();
        builder.append(name).append("\n");
        builder.append(level).append("\n");
        builder.append(totalAttribute.getStrength()).append("\n");
        builder.append(totalAttribute.getDexterity()).append("\n");
        builder.append(totalAttribute.getIntelligence()).append("\n");
        builder.append(totalAttribute.getVitality()).append("\n");
        builder.append(DPS);

        // Part B: display results.
        String result = builder.toString();
        System.out.println(result);

    }



    }







