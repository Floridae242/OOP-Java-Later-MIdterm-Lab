package com.rpg.lab03;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int healthPoints, int damage, int defense,
            int armorValue, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    public int getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(int armorValue) {
        this.armorValue = armorValue;
    }

    @Override
    public void attack(Character target) {
        if (!this.isAlive()) {
            System.out.println(this.getName() + " is fainted and cannot attack!");
            return;
        }

        if (!target.isAlive()) {
            System.out.println(target.getName() + " is already fainted!");
            return;
        }

        // Warrior deals 1.5x damage
        int rawAttackDamage = (int) ((this.getDamage() + this.getWeapon().getDamage() + (this.getLevel() * 2)) * 1.5);

        System.out.println(this.getName() + " (Warrior) attacks "
                + target.getName() + " with " + this.getWeapon().getName() + "!");
        System.out.println("Warrior Bonus: 1.5x damage multiplier!");
        System.out.println("Raw Attack Damage: " + rawAttackDamage);

        target.receiveDamage(rawAttackDamage);
    }

    @Override
    public void receiveDamage(int rawDamage) {
        // Subtract armor value from incoming damage before passing to parent
        int reducedDamage = rawDamage - this.armorValue;
        if (reducedDamage < 0) {
            reducedDamage = 0;
        }

        System.out.println(this.getName() + "'s Armor absorbs " + Math.min(rawDamage, this.armorValue)
                + " damage (Armor Value: " + this.armorValue + ")");

        // Use super to apply the standard defense and HP reduction logic
        super.receiveDamage(reducedDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Armor Value: " + armorValue);
    }
}
