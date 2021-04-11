package dungeonrun;

public class Troll extends Monster {

    public Troll(int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive) {
        super(initiative, endurance, attack, agility, totalInitiative, alive);
    }

    public static double frequency() {
        return 0.05;
    }

    @Override
    public String toString() {
        return Menues.red+"Ett troll stampar fram och får marken att skaka!"+Menues.white;
    }

    @Override
    public String type() {
        return "Troll";
    }

    @Override
    public String theType() {
        return "Trollet";
    }
    
}