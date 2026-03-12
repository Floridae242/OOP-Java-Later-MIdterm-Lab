package com.rpg.lab06;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int healthPoints, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
        setAttack(new WarriorStyleDecorator(getAttack()));
    }

    public int getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(int armor) {
        this.armorValue = armor;
    }

    @Override
    public void takeDamage(int amount) {
        int reducedDamage = amount - this.armorValue;
        if (reducedDamage < 0)
            reducedDamage = 0;
        System.out.println(getName() + "'s Armor: " + this.armorValue +
                " (reduces damage from " + amount + " to " + reducedDamage + ")");
        super.takeDamage(reducedDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Armor Value: " + armorValue);
    }
}
