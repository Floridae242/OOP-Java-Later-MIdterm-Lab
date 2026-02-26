package com.rpg.lab04;

public class Character implements Destructible {
    private String name;
    private int level;
    private int healthPoints;
    private int maxHealthPoints;
    private int damage;
    private int defense;
    private Weapon weapon;
    private String characterClass;

    public Character(String name, int level, int healthPoints, int damage, int defense, Weapon weapon,
            String characterClass) {
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = healthPoints;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    // Getters and setters
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

    public void setHealthPoints(int hp) {
        this.healthPoints = hp;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int hp) {
        this.maxHealthPoints = hp;
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

    public void setCharacterClass(String c) {
        this.characterClass = c;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public void attack(Destructible target) {
        if (!isAlive()) {
            System.out.println(name + " is defeated and cannot attack!");
            return;
        }
        int rawAttackDamage = this.damage + this.weapon.getDamage();
        String targetName = "Target";
        if (target instanceof Character) {
            targetName = ((Character) target).getName();
        }
        System.out
                .println(name + " (" + characterClass + ") attacks " + targetName + " with " + weapon.getName() + "!");
        System.out.println("  Raw Attack Damage: " + rawAttackDamage);
        target.takeDamage(rawAttackDamage);
    }

    @Override
    public void takeDamage(int amount) {
        int actualDamage = amount - this.defense;
        if (actualDamage < 0)
            actualDamage = 0;
        System.out.println(this.name + "'s Defense: " + this.defense +
                " (reduces damage from " + amount + " to " + actualDamage + ")");
        System.out.println("Actual Damage Taken: " + actualDamage);
        this.healthPoints -= actualDamage;
        if (this.healthPoints < 0)
            this.healthPoints = 0;
        System.out.println(this.name + "'s HP: " + this.healthPoints + "/" + this.maxHealthPoints);
    }

    @Override
    public boolean isDestroyed() {
        return !isAlive();
    }

    public void displayCharacterDetails() {
        System.out.println("\n  --- " + name.toUpperCase() + " (" + characterClass.toUpperCase() + ") ---");
        System.out.println("  Status: " + (isAlive() ? "Active" : "Defeated"));
        System.out.println("  Level: " + level);
        System.out.println("  Health Points: " + healthPoints + "/" + maxHealthPoints);
        System.out.println("  Damage: " + damage);
        System.out.println("  Defense: " + defense);
        weapon.displayWeaponDetails();
    }

    public void levelUp() {
        this.level++;
        this.maxHealthPoints += 20;
        this.healthPoints = Math.min(healthPoints + 20, maxHealthPoints);
        this.damage += 3;
        this.defense += 1;
        System.out.println(name + " leveled up to Level " + level + "!");
    }
}
