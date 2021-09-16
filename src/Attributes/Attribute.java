package Attributes;

public class Attribute {

    private int vitality;
    private int strength;
    private int dexterity;
    private int intelligence;

    public Attribute(int vitality, int strength, int dexterity, int intelligence){
        this.vitality = vitality;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    // Testing to see what happens here
    public void increaseVitality(int increase){
        this.vitality = vitality + increase;
    }
    public void increaseStrength(int increase){
        this.strength = strength + increase;
    }
    public void increasedexterity(int increase){
        this.dexterity = dexterity + increase;
    }
    public void increaseintelligence(int increase){
        this.intelligence = intelligence + increase;
    }

    // Getters
    public int getVitality() {
        return vitality;
    }
    public int getStrength() {
        return strength;
    }
    public int getDexterity() {
        return dexterity;
    }
    public int getIntelligence() {
        return intelligence;
    }

    public void getAllAttributesString() {
        System.out.println("Vitality is: " + vitality + ", strength is: " + strength +
                ", dexterity is: " + dexterity + ", intelligence is: " + intelligence +".");
    }

    // setters
    public void setVitality(int num) {
        this.vitality = num;
    }
    public void setStrength(int num) {
        this.strength = num;
    }
    public void setDexterity(int num) {
        this.dexterity = num;
    }
    public void setIntelligence(int num) {
        this.intelligence = num;
    }

}
