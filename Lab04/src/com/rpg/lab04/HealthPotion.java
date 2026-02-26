package com.rpg.lab04;

public class HealthPotion implements Consumable {
    private String name;
    private int healAmount;
    private int quantity;

    public HealthPotion(String name, int healAmount, int quantity) {
        this.name = name;
        this.healAmount = healAmount;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void use(Character user) {
        if (quantity <= 0) {
            System.out.println("No " + name + " remaining!");
            return;
        }
        quantity--;
        int oldHp = user.getHealthPoints();
        int newHp = Math.min(oldHp + healAmount, user.getMaxHealthPoints());
        user.setHealthPoints(newHp);
        System.out.println(user.getName() + " drinks " + name + "!");
        System.out.println("  Health restored: " + oldHp + " → " + newHp + " (+" + (newHp - oldHp) + ")");
        System.out.println("  " + name + " remaining: " + quantity);
    }

    public void displayPotionDetails() {
        System.out.println("\n  --- " + name.toUpperCase() + " ---");
        System.out.println("  Healing Power: " + healAmount + " HP");
        System.out.println("  Quantity: " + quantity);
        System.out.println("  Type: Consumable");
    }
}
