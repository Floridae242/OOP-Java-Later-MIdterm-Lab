package rpg.lab01;

public class Character {
    private String name;
    private int level;
    private int healthPoints;
    private int maxHealthPoints;
    private Weapon weapon;
    private String characterClass;

    public Character(String name, int level, int healthPoints, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = healthPoints;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int attack() {
        int damage = weapon.getDamage() + (level * 2);
        System.out.println(name + " attacks with " + weapon.getName() + "!");
        System.out.println("Using special ability: " + weapon.getSpecialAbility());
        System.out.println("Damage dealt: " + damage);
        return damage;
    }

    public void levelUp() {
        level++;
        int hpIncrease = 100;
        maxHealthPoints += hpIncrease;
        healthPoints = maxHealthPoints;
        System.out.println(name + " leveled up to Level " + level + "!");
        System.out.println("Max HP increased by " + hpIncrease + ". Current HP: " + healthPoints);
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
        System.out.println(name + " takes " + damage + " damage!");
        System.out.println(name + "'s HP: " + healthPoints + "/" + maxHealthPoints);
        if (healthPoints == 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    public void displayCharacterDetails() {
        System.out.println("-".repeat(40));
        System.out.println("Name: " + name + " (" + characterClass + ")");
        System.out.println("Level: " + level);
        System.out.println("HP: " + healthPoints + "/" + maxHealthPoints);
        weapon.displayWeaponDetails();
        System.out.println("-".repeat(40));
    }
}
