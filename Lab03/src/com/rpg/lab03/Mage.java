package com.rpg.lab03;

public class Mage extends Character {
    private int mana;
    private int maxMana;
    private static final int SPELL_COST = 30;

    public Mage(String name, int level, int healthPoints, int damage, int defense,
            int mana, Weapon weapon) {
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

        if (this.mana >= SPELL_COST) {
            // Magic Missile spell attack
            this.mana -= SPELL_COST;
            int rawAttackDamage = this.getDamage() + this.getWeapon().getDamage() + (this.getLevel() * 2);

            System.out.println(this.getName() + " (Mage) casts Magic Missile at "
                    + target.getName() + " with " + this.getWeapon().getName() + "!");
            System.out.println("Mana used: " + SPELL_COST + " | Remaining Mana: " + this.mana + "/" + this.maxMana);
            System.out.println("Raw Attack Damage: " + rawAttackDamage);

            target.receiveDamage(rawAttackDamage);
        } else {
            System.out.println(this.getName() + " doesn't have enough mana! ("
                    + this.mana + "/" + this.maxMana + ")");
            System.out.println(this.getName() + " performs a basic staff attack instead.");

            int rawAttackDamage = this.getDamage() + this.getWeapon().getDamage();

            System.out.println(this.getName() + " (Mage) attacks "
                    + target.getName() + " with " + this.getWeapon().getName() + "!");
            System.out.println("Raw Attack Damage: " + rawAttackDamage);

            target.receiveDamage(rawAttackDamage);
        }
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Mana: " + mana + "/" + maxMana);
    }
}
