package com.rpg.lab02;

public class Weapon {
    private String name;
    private String type;
    private int damage;
    private String specialAbility;

    public Weapon(String name, String type, int damage, String specialAbility) {
        this.name = name;
        this.type = type;
        this.damage = damage;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    public void displayWeaponDetails() {
        System.out.println("  Weapon: " + name + " (Type: " + type + ", Damage: " + damage + ", Ability: " + specialAbility + ")");
    }
}
