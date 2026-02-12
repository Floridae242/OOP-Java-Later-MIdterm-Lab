package com.rpg.lab02;

public class Healer extends Character {
    private int healingPower;

    public Healer(String name, int level, int healthPoints, int damage, int defense, 
                  Weapon weapon, int healingPower) {
        super(name, level, healthPoints, damage, defense, weapon, "Healer");
        this.healingPower = healingPower;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public void heal() {
        if (!this.isAlive()) {
            System.out.println(this.getName() + " is fainted and cannot be healed!");
            return;
        }

        int healAmount = healingPower + (this.getLevel() * 3);
        int newHP = this.getHealthPoints() + healAmount;
        if (newHP > this.getMaxHealthPoints()) {
            newHP = this.getMaxHealthPoints();
        }

        this.setHealthPoints(newHP);
        
        System.out.println(this.getName() + " (Healer) casts a healing spell!");
        System.out.println("Healing Amount: " + healAmount + " (Base: " + healingPower 
            + " + Level Bonus: " + (this.getLevel() * 3) + ")");
        System.out.println("Restored " + healAmount + " HP! Current HP: " 
            + this.getHealthPoints() + "/" + this.getMaxHealthPoints());
    }

    public void healAlly(Character target) {
        if (!this.isAlive()) {
            System.out.println(this.getName() + " is fainted and cannot heal others!");
            return;
        }

        if (!target.isAlive()) {
            System.out.println(target.getName() + " is fainted and cannot be healed!");
            return;
        }

        int healAmount = healingPower + (this.getLevel() * 3);
        int newHP = target.getHealthPoints() + healAmount;
        if (newHP > target.getMaxHealthPoints()) {
            newHP = target.getMaxHealthPoints();
        }

        target.setHealthPoints(newHP);
        
        System.out.println(this.getName() + " (Healer) casts healing spell on " 
            + target.getName() + "!");
        System.out.println("Healing Amount: " + healAmount);
        System.out.println("Restored " + healAmount + " HP to " + target.getName() 
            + "! Their HP: " + target.getHealthPoints());
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Healing Power: " + healingPower);
        System.out.println("-".repeat(40));
    }
}
