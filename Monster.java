package dungeonrun;

public abstract class Monster extends Character {

    public Monster(int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive) {
        super(initiative, endurance, attack, agility, totalInitiative, alive);
    }

    public static double frequency() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Monster: ";
    }
    
    
}