package Heros;

import Attributes.Attribute;
import Exceptions.InvalidArmorException;
import Exceptions.InvaliddWeaponException;
import game.Armor;
import game.Armors;
import game.Weapon;
import game.Weapons;

public class Ranger extends Character{


    public Ranger(String name) {
        super(name);
        this.base = new Attribute( 8, 1, 7, 1);
        // damage depends on dexterity, so start-value must be 7
        damage = 7;
        // Health depends on vitality, so start-value must be vitality * 10
        health = 8 * 10;
    }

    @Override
    public void Increaselevel() {
        super.Increaselevel();
        increaseVitality(2);;
        this.base.increaseStrength(1);
        increaseDexterity(5);
        this.base.increaseintelligence(1);
    }

    // If Vitality increases, health increases
    public void increaseVitality(int increase){
        base.increaseVitality(increase);
        health += increase * 10;
    }

    // Each point Dexterity increases, the damage increases
    public void increaseDexterity(int increase){
        base.increasedexterity(increase);
        damage =+ (0.1 * increase);
    }


    @Override
    boolean equipWeapon(Weapon weapon) throws InvaliddWeaponException {
        super.equipWeapon(weapon);
        if(weapon.getWeapon() != Weapons.Bow){
            throw new InvaliddWeaponException("This weapon can not be equipped by a Ranger");
        }
        // Underneath is the hashmap structure
        equipment.put(weapon.getSlot(), weapon);
        return true;
    }

    @Override
    boolean equipArmor(Armor armor) throws InvalidArmorException {
        super.equipArmor(armor);
        if(armor.getArmor() != Armors.Leather && armor.getArmor() != Armors.Mail){
            throw new InvalidArmorException("Wrong type of armor for your character");
        }
        // Underneath: Puts it in the hashmap.
        equipment.put(armor.getSlot(), armor);
        return true;
    }

    public void CalculateRangerDPS(){
        double CharacterDPS = 0;
        // Character DPS = Weapon DPS * (1 + TotalPrimaryAttribute/100)
        CharacterDPS = super.CalculateWeaponsDPS() * (1 + (base.getDexterity()/100));
        this.DPS = CharacterDPS;
    }

}
