package com.rpg.lab06;

public class Weapon {
    private String name;
    private String type;
    private int baseDamage;
    private String specialAbility;

    public Weapon(String name, String type, int baseDamage, String specialAbility) {
        this.name = name;
        this.type = type;
        this.baseDamage = baseDamage;
        this.specialAbility = specialAbility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String s) {
        this.specialAbility = s;
    }

    public void displayWeaponDetails() {
        System.out.println(
                "  Weapon: " + name + " (Type: " + type + ", Damage: " + baseDamage + ", Ability: " + specialAbility
                        + ")");
    }
}
