package Heros;

import Exceptions.InvalidArmorException;
import Exceptions.InvaliddWeaponException;
import game.*;
import org.junit.Test;

public class BehaviorTest {

    // (1) Char equip high level weapon
    @Test
    static void ExceptionsMethods_EquipWeapon_ExpetsException() throws InvaliddWeaponException {
        Warrior newWarrior = new Warrior("RangerName");
        Weapon testWeapon = new Weapon("Common Axe", Weapons.Axe);
        testWeapon.setLevel(2);
        newWarrior.equipWeapon(testWeapon);
    }

    // (2) Char equip high level armor
    @Test
    static void ExceptionsMethods_EquipArmor_ExpetsException() throws InvaliddWeaponException, InvalidArmorException {
        Warrior newWarrior = new Warrior("RangerName");
        Armor testArmor = new Armor("Plate Body Armor", Armors.Plate);
        // Important to set Slot!
        testArmor.setSlot(Slot.Head);
        testArmor.setLevel(2);
        newWarrior.equipArmor(testArmor);
    }

    public static void main(String[] args) throws InvaliddWeaponException, InvalidArmorException {

        // Test 1
           BehaviorTest WarriorTest = new BehaviorTest();
        // WarriorTest.ExceptionsMethods_EquipWeapon_ExpetsException();
        // Passed: Gets "This weapon can not be equipped by a Warrior"

        // Test 2
        WarriorTest.ExceptionsMethods_EquipArmor_ExpetsException();


    }

}
