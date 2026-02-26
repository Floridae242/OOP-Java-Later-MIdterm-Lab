package com.rpg.lab04;

public class StoneWall implements Destructible {
    private String name;
    private int durability;
    private int maxDurability;
    private String location;

    public StoneWall(String name, int durability, String location) {
        this.name = name;
        this.durability = durability;
        this.maxDurability = durability;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    @Override
    public void takeDamage(int amount) {
        this.durability -= amount;
        System.out
                .println(name + " takes " + amount + " damage! (Durability: " + durability + "/" + maxDurability + ")");
        if (durability <= 0) {
            System.out.println(name + " has CRUMBLED to pieces!");
        }
    }

    @Override
    public boolean isDestroyed() {
        return durability <= 0;
    }

    public void displayWallDetails() {
        System.out.println("\n  --- " + name.toUpperCase() + " ---");
        System.out.println("  Type: " + location);
        System.out.println("  Status: " + (isDestroyed() ? "DESTROYED" : "STANDING"));
        System.out.println("  Durability: " + Math.max(0, durability) + "/" + maxDurability);
    }
}
