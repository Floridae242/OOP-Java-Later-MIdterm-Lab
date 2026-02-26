package com.rpg.lab04;

public class Mage extends Character {
    private int mana;
    private int maxMana;
    private static final int SPELL_COST = 30;

    public Mage(String name, int level, int healthPoints, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;
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
    public void attack(Destructible target) {
        if (!isAlive()) {
            System.out.println(getName() + " is defeated and cannot attack!");
            return;
        }
        String targetName = "Target";
        if (target instanceof Character) {
            targetName = ((Character) target).getName();
        }

        if (this.mana >= SPELL_COST) {
            this.mana -= SPELL_COST;
            int baseDamage = getDamage() + getWeapon().getDamage();
            int spellBonus = getDamage() / 2;
            int totalDamage = baseDamage + spellBonus;
            System.out.println(getName() + " (Mage) casts MAGIC MISSILE at " + targetName + "!");
            System.out.println(
                    "  Spell Damage: " + totalDamage + " (Base: " + baseDamage + " + Spell Bonus: " + spellBonus + ")");
            System.out.println("  Mana Used: " + SPELL_COST + " | Remaining: " + this.mana + "/" + this.maxMana);
            target.takeDamage(totalDamage);
        } else {
            System.out.println(getName() + " attempts to cast Magic Missile, but has insufficient mana!");
            System.out.println("  Current Mana: " + this.mana + "/" + this.maxMana + " (Need: " + SPELL_COST + ")");
        }
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
