package game;

public class Weapon extends Item {

    private double damage;
    private Weapons weapon;
    private double attackspeed;
    private double WeaponDPS;


    public Weapon(String name, Weapons weapon){
        super(name);
        this.weapon = weapon;
    }

    public double CalcWeaponDPS(){
        double DPS = 0;
        DPS = this.damage * attackspeed;
        return DPS;
        // DPS = Damage * Attack Speed
    }

    // SETTERS
    public void setName(String name){
        this.name = name;
    }
    public void setLevel(Integer level){
        this.requiredlevel = level;
    }
    public void setSlot(Slot slot){
        this.slot = slot;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public void setAttackSpeed(double speed){
        this.attackspeed = speed;
    }
    public void setWeaponstype(Weapons weapon){
        this.weapon = weapon;
    }

    // Does this underneath work?
    public void setWeaponDPS(double dps){
        this.WeaponDPS = dps;
    }

    // GETTERS
    public double getLevel(){
        return requiredlevel;
    }
    public Slot getSlot(){
        return slot;
    }
    public Weapons getWeapon(){
        return weapon;
    }
    public double getWeaponDPS(){
        return WeaponDPS;
    }
    public double getDamage() {
        return damage;
    }
    public double getAttackspeed(){
        return attackspeed;
    }

    // For testing
    public void weaponToString(){
        System.out.println("The name is: " + name + "\n" +
                "The level is: " + requiredlevel + "\n" +
                "The slot is: " + slot + "\n" +
                "The WeaponType is: " + weapon + "\n" +
                "The Damage is: " + damage + "\n" +
                "The AttackSpeed is " + attackspeed + "\n");
    }


}
