package dungeonrun;

public class Skeleton extends Monster {

    public Skeleton(int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive) {
        super(initiative, endurance, attack, agility, totalInitiative, alive);
    }

    public static double frequency() {
        return 0.15;
    }

    @Override
    public String toString() {
        return Menues.red+"Ett skelett ranglar fram!"+Menues.white;
    }
    
    @Override
    public String type() {
        return "Skelett";
    }

    @Override
    public String theType() {
        return "Skelettet";
    }
    
}