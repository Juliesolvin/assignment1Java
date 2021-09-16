package Heros;

import Attributes.Attribute;
import Exceptions.InvalidArmorException;
import Exceptions.InvaliddWeaponException;
import game.Armor;
import game.Armors;
import game.Weapon;
import game.Weapons;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name);
        this.base = new Attribute(10, 5, 2, 1);
        // damage depends on strength, so start-value must be 5
        damage = 5;
        // Health depends on vitality, so start-value must be vitality * 10
        health = 10 * 10;
    }

    @Override
    public void Increaselevel() {
        super.Increaselevel();
        increaseVitality(5);

        // Strength does not work
        increaseStrength(3);

        this.base.increasedexterity(2);

        // Intelligence is wrong
        this.base.increaseintelligence(1);
        health += 5 * 10;
    }

    // If Vitality increases, health increases
    public void increaseVitality(int increase){
        base.increaseVitality(increase);
        health =  health + (increase * 10);
    }

    // Each point intelligence increases, the damage increases 1%
    public void increaseStrength(int increase){
        base.increaseStrength(increase);
        damage = damage + (0.1 * increase);
    }

    @Override
    boolean equipWeapon(Weapon weapon) throws InvaliddWeaponException {
        super.equipWeapon(weapon);
        if(weapon.getWeapon() != Weapons.Sword && weapon.getWeapon() != Weapons.Hammer
                && weapon.getWeapon() != Weapons.Sword){
            throw new InvaliddWeaponException("This weapon can not be equipped by a Warrior");
        }
        // Underneath is the hashmap structure
        equipment.put(weapon.getSlot(), weapon);
        return true;
    }

    @Override
    boolean equipArmor(Armor armor) throws InvalidArmorException {
        super.equipArmor(armor);
        if(armor.getArmor() != Armors.Plate && armor.getArmor() != Armors.Mail){
            throw new InvalidArmorException("Wrong type of armor for your character");
        }
        // Underneath: Puts it in the hashmap.
        equipment.put(armor.getSlot(), armor);
        return true;
    }

    public void CalculateWarriorDPS(){
        double CharacterDPS = 0;
        // Character DPS = Weapon DPS * (1 + TotalPrimaryAttribute/100)
        CharacterDPS = super.CalculateWeaponsDPS() * (1 + (base.getStrength()/100));
        this.DPS = CharacterDPS;
    }


}
