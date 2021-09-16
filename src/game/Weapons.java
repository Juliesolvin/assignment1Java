package game;

public enum Weapons {
    Axe("AXE"),
    Bow("BOX"),
    Dagger("DAGGER"),
    Hammer("HAMMER"),
    Staff("STAFF"),
    Sword("SWORD"),
    Wand("WAND");

    private String name;
    private Weapons(String name){
        this.name = name;
    }
}
