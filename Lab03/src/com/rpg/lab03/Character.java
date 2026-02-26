package com.rpg.lab03;

public class Character {
    private String name;
    private int level;
    private int healthPoints;
    private int maxHealthPoints;
    private int damage;
    private int defense;
    private Weapon weapon;
    private String characterClass;

    public Character(String name, int level, int healthPoints, int damage, int defense,
            Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = healthPoints;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints < 0) {
            this.healthPoints = 0;
        } else if (healthPoints > this.maxHealthPoints) {
            this.healthPoints = this.maxHealthPoints;
        } else {
            this.healthPoints = healthPoints;
        }
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public void attack(Character target) {
        if (!this.isAlive()) {
            System.out.println(this.name + " is fainted and cannot attack!");
            return;
        }

        if (!target.isAlive()) {
            System.out.println(target.getName() + " is already fainted!");
            return;
        }

        int rawAttackDamage = this.damage + this.weapon.getDamage() + (this.level * 2);

        System.out.println(this.name + " (" + this.characterClass + ") attacks "
                + target.getName() + " with " + this.weapon.getName() + "!");
        System.out.println("Raw Attack Damage: " + rawAttackDamage);

        target.receiveDamage(rawAttackDamage);
    }

    public void receiveDamage(int rawDamage) {
        int actualDamage = rawDamage - this.defense;
        if (actualDamage < 0) {
            actualDamage = 0;
        }

        System.out.println(this.name + "'s Defense: " + this.defense + " (reduces damage from "
                + rawDamage + " to " + actualDamage + ")");
        System.out.println("Actual Damage Taken: " + actualDamage);

        this.healthPoints -= actualDamage;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }

        System.out.println(this.name + "'s HP: " + this.healthPoints + "/" + this.maxHealthPoints);

        if (!this.isAlive()) {
            System.out.println(this.name + " has fainted!");
        }
    }

    public void levelUp() {
        if (this.isAlive()) {
            this.level++;
            int hpIncrease = 100;
            this.maxHealthPoints += hpIncrease;
            this.healthPoints = this.maxHealthPoints;
            System.out.println(this.name + " leveled up to Level " + this.level + "!");
            System.out.println("Max Health increased to " + this.maxHealthPoints + " (full heal applied)");
        } else {
            System.out.println(this.name + " cannot level up while fainted!");
        }
    }

    public void displayCharacterDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " (" + characterClass.toUpperCase() + ") ---");
        System.out.println("Status: " + (isAlive() ? "Active" : "Fainted"));
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + healthPoints + "/" + maxHealthPoints);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        weapon.displayWeaponDetails();
    }
}
