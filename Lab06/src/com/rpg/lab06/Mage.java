package com.rpg.lab06;

public class Mage extends Character {
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int healthPoints, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;
        setAttack(new MageStyleDecorator(getAttack()));
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int max) {
        this.maxMana = max;
    }

    @Override
    public void displayCharacterDetails() {
        System.out.println("\n  --- " + getName().toUpperCase() + " (MAGE) ---");
        System.out.println("  Status: " + (isAlive() ? "Active" : "Defeated"));
        System.out.println("  Level: " + getLevel());
        System.out.println("  Health Points: " + getHealthPoints() + "/" + getMaxHealthPoints());
        System.out.println("  Mana: " + mana + "/" + maxMana);
        System.out.println("  Damage: " + getDamage());
        System.out.println("  Defense: " + getDefense());
        getWeapon().displayWeaponDetails();
    }
}
