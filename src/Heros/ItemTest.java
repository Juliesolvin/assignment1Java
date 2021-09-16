package Heros;

import Attributes.Attribute;
import Exceptions.InvaliddWeaponException;
import game.*;
import org.junit.Test;

import java.util.ArrayList;

public class ItemTest {

    // Naming is important
    // MethodYourAreTesting_ConditonsItsbeingTestedUnder_ExpectedBehaviour();

    @Test
    private static boolean assertEquals(Object obj1, Object obj2) {
        if (obj1.equals(obj2)){
            return true;
        } else {
            return false;
        }
    }

    @Test
    static void WeaponClass_AttributesStatus_ExpetsNoFalse() {
        Weapon testWeapon = new Weapon("Common Axe", Weapons.Axe);
        testWeapon.setLevel(1);
        testWeapon.setSlot(Slot.Weapon);
        testWeapon.setDamage(7);
        testWeapon.setAttackSpeed(1.1);
        testWeapon.weaponToString();

        // Checks and tests here
        System.out.println(assertEquals(testWeapon.getDamage(), 7.0));
        System.out.println(assertEquals(testWeapon.getlevel(), 1.0));
        System.out.println(assertEquals(testWeapon.getSlot(), Slot.Weapon));
        System.out.println(assertEquals(testWeapon.getAttackspeed(), 1.1));

    }

    @Test
    static void ArmorClass_AttributesStatus_ExpetsNoFalse() {
        Armor testPlateBody = new Armor("Common Plate Body Armor", Armors.Plate);
        testPlateBody.setLevel(1);
        testPlateBody.setSlot(Slot.Body);
        testPlateBody.setAttributes(new Attribute(1, 0, 0, 2));
        testPlateBody.armorToString();

        // Checks and tests here
        System.out.println(assertEquals(testPlateBody.getlevel(), 1.0));
        System.out.println(assertEquals(testPlateBody.getSlot(), Slot.Body));

    }

    public static void main(String[] args){

        ItemTest WarriorTest = new ItemTest();
        WarriorTest.WeaponClass_AttributesStatus_ExpetsNoFalse();

        WarriorTest.ArmorClass_AttributesStatus_ExpetsNoFalse();

    }



}
