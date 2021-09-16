package game;

import Attributes.Attribute;

public class Armor extends Item{

    private Armors armor;
    Attribute base;

    // Konstruktør
    public Armor(String name, Armors armor){
        super(name);
        this.armor = armor;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }
    public void setLevel(Integer level){
        this.requiredlevel = level;
    }
    public void setAttributes(Attribute attribute){
        this.base = attribute;
    }
    public void setSlot(Slot slot){
       this.slot = slot;
    }

    // Getters
    public Armors getArmor(){
        return armor;
    }
    public Slot getSlot(){
        return slot;
    }
    public Attribute getBase(){
        return base;
    }

    // For testing
    public void armorToString(){
            System.out.println("The name is: " + name + "\n" +
                    "The level is: " + requiredlevel + "\n" +
                    "The slot is: " + slot + "\n" +
                    "The WeaponType is: " + armor + "\n" +
                    "The Attributes are: ");
                    base.getAllAttributesString();
        }

    }

