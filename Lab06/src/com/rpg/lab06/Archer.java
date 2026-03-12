package com.rpg.lab06;

public class Archer extends Character {
    private int accuracy;
    private boolean rangeAdvantage;

    public Archer(String name, int level, int healthPoints, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
        this.rangeAdvantage = true;
        setAttack(new ArcherStyleDecorator(getAttack()));
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public boolean hasRangeAdvantage() {
        return rangeAdvantage;
    }

    public void setRangeAdvantage(boolean rangeAdvantage) {
        this.rangeAdvantage = rangeAdvantage;
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Accuracy: " + accuracy + "%");
        System.out.println("  Range Advantage: " + (rangeAdvantage ? "Yes (30% bonus)" : "No"));
    }
}
