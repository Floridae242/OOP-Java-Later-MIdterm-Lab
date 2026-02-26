package com.rpg.lab04;

public class WoodenBox implements Destructible {
    private String name;
    private int hitPoints;
    private int maxHitPoints;
    private boolean locked;
    private String contents;

    public WoodenBox(String name, int hitPoints, boolean locked, String contents) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.maxHitPoints = hitPoints;
        this.locked = locked;
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public boolean isLocked() {
        return locked;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public void takeDamage(int amount) {
        this.hitPoints -= amount;
        if (this.hitPoints <= 0) {
            this.hitPoints = 0;
            System.out.println(name + " takes " + amount + " damage!");
            System.out.println(name + " HP: " + hitPoints + "/" + maxHitPoints + " (DESTROYED!)");
        } else {
            System.out.println(name + " takes " + amount + " damage!");
            System.out.println(name + " HP: " + hitPoints + "/" + maxHitPoints);
        }
    }

    @Override
    public boolean isDestroyed() {
        return hitPoints <= 0;
    }

    public void breakOpen() {
        if (isDestroyed()) {
            if (locked) {
                System.out.println("The lock broke! " + name + " breaks open!");
            } else {
                System.out.println(name + " breaks open!");
            }
            System.out.println("Contents revealed: " + contents);
        } else {
            System.out.println("Cannot break open " + name + " - it's still intact!");
        }
    }

    public void displayBoxDetails() {
        System.out.println("\n  --- " + name.toUpperCase() + " (WOODEN BOX) ---");
        System.out.println("  Status: " + (isDestroyed() ? "Destroyed" : "Intact"));
        System.out.println("  Health: " + hitPoints + "/" + maxHitPoints);
        System.out.println("  Locked: " + (locked ? "Yes" : "No"));
        System.out.println("  Contains: " + contents);
    }
}
