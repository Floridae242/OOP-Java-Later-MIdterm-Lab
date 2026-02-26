package com.rpg.lab03;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int healthPoints, int damage, int defense,
            int accuracy, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
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

        // Ranged attack with accuracy bonus and 30% range advantage
        int baseAttackDamage = this.getDamage() + this.getWeapon().getDamage() + (this.getLevel() * 2);
        int rawAttackDamage = (int) (baseAttackDamage * 1.3); // 30% range advantage bonus

        System.out.println(this.getName() + " (Archer) fires an arrow at "
                + target.getName() + " with " + this.getWeapon().getName() + "!");
        System.out.println("Accuracy: " + accuracy + "% | Range Advantage: 30% bonus");
        System.out.println("Raw Attack Damage: " + rawAttackDamage);

        target.receiveDamage(rawAttackDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
    }
}
