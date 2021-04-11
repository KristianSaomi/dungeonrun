package dungeonrun;

public class Spider extends Monster {

    public Spider(int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive) {
        super(initiative, endurance, attack, agility, totalInitiative, alive);
    }

    public static double frequency() {
        return 0.2;
    }

    @Override
    public String toString() {
        return Menues.red+"En jättespindel kryper fram!"+Menues.white;
    }

    @Override
    public String type() {
        return "Jättespindel";
    }

    @Override
    public String theType() {
        return "Spindeln";
    }
    
}