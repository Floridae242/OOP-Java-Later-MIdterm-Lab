package com.rpg.lab04;

public class CastleGate implements Destructible {
    private String name;
    private int durability;
    private int maxDurability;
    private boolean locked;
    private boolean reinforced;

    public CastleGate(String name, int durability, boolean locked, boolean reinforced) {
        this.name = name;
        this.durability = durability;
        this.maxDurability = durability;
        this.locked = locked;
        this.reinforced = reinforced;
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isReinforced() {
        return reinforced;
    }

    @Override
    public void takeDamage(int amount) {
        int actualDamage = amount;
        if (reinforced) {
            actualDamage = amount / 2;
            System.out.println(name + " is REINFORCED! (reduces damage from " + amount + " to " + actualDamage + ")");
        }
        this.durability -= actualDamage;
        System.out.println(
                name + " takes " + actualDamage + " damage! (Durability: " + durability + "/" + maxDurability + ")");
        if (durability <= 0) {
            System.out.println(name + " has been BREACHED! The gate COLLAPSES!");
        }
    }

    @Override
    public boolean isDestroyed() {
        return durability <= 0;
    }

    public void displayGateDetails() {
        System.out.println("\n  --- " + name.toUpperCase() + " ---");
        System.out.println("  Status: " + (isDestroyed() ? "BREACHED" : "INTACT"));
        System.out.println("  Durability: " + Math.max(0, durability) + "/" + maxDurability);
        System.out.println("  Locked: " + (locked ? "Yes" : "No"));
        System.out.println("  Reinforced: " + (reinforced ? "Yes" : "No"));
    }
}
