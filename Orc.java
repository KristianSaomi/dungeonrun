package dungeonrun;

public class Orc extends Monster {

    public Orc(int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive) {
        super(initiative, endurance, attack, agility, totalInitiative, alive);
    }

    public static double frequency() {
        return 0.1;
    }

    @Override
    public String toString() {
        return Menues.red+"En orch stampar fram!"+Menues.white;
    }

    @Override
    public String type() {
        return "Orch";
    }

    @Override
    public String theType() {
        return "Orchen";
    }
    
}