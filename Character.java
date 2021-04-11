package dungeonrun;

public abstract class Character implements Comparable<Character>, java.io.Serializable{

    private int initiative;
    private int endurance;
    private int attack;
    private int totalInitiative;
    private int agility;
    private boolean alive;

    public Character(int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive) {
        this.initiative = initiative;
        this.endurance = endurance;
        this.attack = attack;
        this.agility = agility;
        this.totalInitiative = totalInitiative;
        this.alive = alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean getAlive() {
        return alive;
    }

    @Override
    public int compareTo(Character character) {
        return (this.getTotalInitiative() > character.getTotalInitiative() ? -1
                : (this.getTotalInitiative() == character.getTotalInitiative() ? 0 : 1));
    }

    @Override
    public String toString() {
        return "Characters{" + "initiative=" + initiative + ", endurance=" + endurance + ", attack=" + attack + ", agility=" + agility + '}';
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getTotalInitiative() {
        return totalInitiative;
    }

    public void setTotalInitiative(int totalInitiative) {
        this.totalInitiative = totalInitiative;
    }

    public abstract String type();

    public abstract String theType();
    
}