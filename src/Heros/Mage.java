package Heros;

import Attributes.Attribute;
import Exceptions.InvalidArmorException;
import Exceptions.InvaliddWeaponException;
import game.*;

import java.text.ParseException;
import java.util.HashMap;

public class Mage extends Character {

    // Makes Mage-Character, by using Character attributes.

    public Mage(String name){
        super(name);
        this.base = new Attribute( 5, 1, 1, 8);
        // damage depends on intelligence, so start-value must be 8
        damage = 8;
        // Health depends on vitality, so start-value must be vitality * 10
        health = 5 * 10;
    }

    // Total primary attribute er base attribute + Armor
    // Base er det man lager karakteren

    @Override
    public void Increaselevel() {
        super.Increaselevel();
        // Encapsulated increasing of levels
        increaseVitality(3);
        this.base.increaseStrength(1);
        this.base.increasedexterity(1);
        increaseintelligence(5);
    }

    // If Vitality increases, health increases
    public void increaseVitality(int increase){
        base.increaseVitality(increase);
        health += increase * 10;
    }

    // Each point intelligence increases, the damage increases 1%
    public void increaseintelligence(int increase){
        base.increaseintelligence(increase);
        damage =+ (0.1 * increase);
    }

    public void setDamage(double Double){
        damage = Double;
    }


    @Override
    boolean equipWeapon(Weapon weapon) throws InvaliddWeaponException {
        super.equipWeapon(weapon);
        if(weapon.getWeapon() != Weapons.Staff && weapon.getWeapon() != Weapons.Wand){
            throw new InvaliddWeaponException("This weapon can not be equipped by a Mage");
        }
        // Under er hashmap greia
        equipment.put(weapon.getSlot(), weapon);
        return true;
    }

    @Override
    boolean equipArmor(Armor armor) throws InvalidArmorException {
        super.equipArmor(armor);
        if(armor.getArmor() != Armors.Cloth){
            throw new InvalidArmorException("Wrong type of armor for your character");
        }
        // Underneath: Puts it in the hashmap.
        equipment.put(armor.getSlot(), armor);
        return true;
    }

    // What should this return?
    public void CalculateMageDPS(){
        double CharacterDPS = 0;
        // Character DPS = Weapon DPS * (1 + TotalPrimaryAttribute/100)
        CharacterDPS = super.CalculateWeaponsDPS() * (1 + (base.getIntelligence()/100));
        this.DPS = CharacterDPS;
    }

    public static void main(String[] args) throws ParseException {

        // Making new object of Mage
        // Mage Mage1 = new Mage ("Joey");

    }


}
