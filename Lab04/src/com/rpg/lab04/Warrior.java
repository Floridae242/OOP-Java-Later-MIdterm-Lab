package com.rpg.lab04;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int healthPoints, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    public int getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(int armor) {
        this.armorValue = armor;
    }

    @Override
    public void attack(Destructible target) {
        if (!isAlive()) {
            System.out.println(getName() + " is defeated and cannot attack!");
            return;
        }
        int baseDamage = getDamage() + getWeapon().getDamage();
        int enhancedDamage = (int) (baseDamage * 1.5);
        String targetName = "Target";
        if (target instanceof Character) {
            targetName = ((Character) target).getName();
        }
        System.out.println(getName() + " (Warrior) performs a POWERFUL STRIKE on " + targetName + "!");
        System.out.println("  Base Damage: " + baseDamage + " → Enhanced: " + enhancedDamage + " (1.5x multiplier)");
        target.takeDamage(enhancedDamage);
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
