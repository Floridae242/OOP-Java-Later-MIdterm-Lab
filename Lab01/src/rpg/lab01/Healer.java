package rpg.lab01;

public class Healer extends Character {
    private int healingPower;

    public Healer(String name, int level, int healthPoints, Weapon weapon, int healingPower) {
        super(name, level, healthPoints, weapon, "Healer");
        this.healingPower = healingPower;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public void heal() {
        int healAmount = healingPower + (getLevel() * 3);
        int newHP = getHealthPoints() + healAmount;
        if (newHP > getMaxHealthPoints()) {
            newHP = getMaxHealthPoints();
        }
        setHealthPoints(newHP);
        System.out.println(getName() + " heals themselves for " + healAmount + " HP!");
        System.out.println(getName() + "'s HP: " + getHealthPoints() + "/" + getMaxHealthPoints());
    }

    public void heal(Character target) {
        int healAmount = healingPower + (getLevel() * 3);
        int newHP = target.getHealthPoints() + healAmount;
        if (newHP > target.getMaxHealthPoints()) {
            newHP = target.getMaxHealthPoints();
        }
        target.setHealthPoints(newHP);
        System.out.println(getName() + " heals " + target.getName() + " for " + healAmount + " HP!");
        System.out.println(target.getName() + "'s HP: " + target.getHealthPoints() + "/" + target.getMaxHealthPoints());
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("  Healing Power: " + healingPower);
        System.out.println("-".repeat(40));
    }
}
