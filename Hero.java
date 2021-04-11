package dungeonrun;

import java.util.ArrayList;

public abstract class Hero extends Character{

    static ArrayList<Treasure> collectedTreasure = new ArrayList<>(); // needs to be static
    ArrayList<Treasure> totalCollectedTreasure = new ArrayList<>(); 
    ArrayList<Monster> killedMonsters = new ArrayList<>();

    private String name;
    private int points;
    private int playedRounds;
    private int killCount;

    public Hero(String name, int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive, int points, int playedRounds, int killCount) {
        super(initiative, endurance, attack, agility, totalInitiative, alive);
        this.killCount = killCount;
        this.playedRounds = playedRounds;
        this.points = points;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int getPlayedRounds() {
        return playedRounds;
    }
    
    public void setPlayedRounds (int playedRounds) {
        this.playedRounds = playedRounds;
    }
    
    public int getKillCount() {
        return killCount;
    }
    
    public void setKillCount (int killCount) {
        this.killCount = killCount;
    }

    @Override
    public String toString() {
        return "Heroes{" + "name=" + name +'}';
    }
}
