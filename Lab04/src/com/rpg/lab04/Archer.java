package com.rpg.lab04;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int healthPoints, int damage, int defense, int accuracy, Weapon weapon) {
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
    public void attack(Destructible target) {
        if (!isAlive()) {
            System.out.println(getName() + " is defeated and cannot attack!");
            return;
        }
        int baseDamage = getDamage() + getWeapon().getDamage();
        int rangeBonus = (int) (baseDamage * 0.30);
        int totalDamage = baseDamage + rangeBonus;
        String targetName = "Target";
        if (target instanceof Character) {
            targetName = ((Character) target).getName();
        }
        System.out.println(getName() + " (Archer) shoots a precise arrow at " + targetName + "!");
        System.out.println("  Base Damage: " + baseDamage + " + Range Bonus: " + rangeBonus + " = " + totalDamage);
        System.out.println("  Accuracy: " + accuracy + "% (HIT!)");
        target.takeDamage(totalDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Accuracy: " + accuracy + "%");
        System.out.println("  Range Advantage: Yes (30% bonus)");
    }
}
