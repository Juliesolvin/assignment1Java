package Heros;

import java.util.ArrayList;

public class CharTest {
    // Naming is important
    // MethodYourAreTesting_ConditonsItsbeingTestedUnder_ExpectedBehaviour()
    // I have tried to follow this naming
    // One test-method per Character-class

    static double price(ArrayList<Double> bookarray) {
        double hei = 1.0;
        return hei;
    }

    // MAGE-TEST;
    static void MageClass_AttributesStatus_Expected2and8() {
        Mage newMage = new Mage("MageName");
        System.out.println(newMage.getLevel()); // 1
        System.out.println(newMage.base.getVitality()); // 5

        newMage.Increaselevel();

        System.out.println(newMage.getLevel()); // 2
        System.out.println(newMage.base.getVitality()); // Skal være 8, men er 3
    }

    // RANGER-TEST

    static void RangerClass_AttributesStatus_Expected2and10() {
        Ranger newRanger = new Ranger("RangerName");
        System.out.println(newRanger.getLevel()); // 1
        newRanger.base.getAllAttributesString();// 8

        newRanger.Increaselevel();

        System.out.println(newRanger.getLevel()); // 2
        newRanger.base.getAllAttributesString(); // 9
    }

    // ROGUE-TEST

    static void RogueClass_AttributesStatus_Expected2and11() {
        Rogue newRogue = new Rogue("RogueName");
        System.out.println(newRogue.getLevel()); // 1
        newRogue.base.getAllAttributesString(); // 8

        newRogue.Increaselevel();

        System.out.println(newRogue.getLevel()); // 2
        newRogue.base.getAllAttributesString(); // 11
    }


    // WARRIOR-TEST

    static void WarriorClass_AttributesStatus_Expected2and15() {
        Warrior newWarrior = new Warrior("RangerName");

        System.out.println("The level is: " + newWarrior.getLevel()); // 1
        newWarrior.base.getAllAttributesString(); // 10, 5, 2, 1

        newWarrior.Increaselevel();

        System.out.println("The level is: " + newWarrior.getLevel()); // 2
        newWarrior.base.getAllAttributesString(); // 15, 8[+3], 4[+2], 2[+1]
    }



    public static void main(String[] args) {
        //CharTest MageTest = new CharTest();
        // MageTest.MageClass_AttributesStatus_Expected2and8();

        CharTest WarriorTest = new CharTest();
        WarriorTest.WarriorClass_AttributesStatus_Expected2and15();
        // PAsses test
    }

}
