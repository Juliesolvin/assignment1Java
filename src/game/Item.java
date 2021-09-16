package game;

import Attributes.Attribute;

abstract public class Item {
    String name;
    double requiredlevel;
    Slot slot;


    // Constructor
    public Item(String name) {
        this.name = name;
    }



    // getters
    public Double getlevel() {
        return requiredlevel;
    }




}
