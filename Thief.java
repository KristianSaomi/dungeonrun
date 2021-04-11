package dungeonrun;

public class Thief extends Hero {

    public Thief(String name, int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive, int points, int playedRounds, int killCount) {
        super(name, initiative, endurance, attack, agility, totalInitiative, alive, points, playedRounds, killCount);
    }
    
    @Override
    public String type() {
        return "Tjuv";
    }

    @Override
    public String theType() {
        return "Tjuven";
    }

    @Override
    public String toString() {
        return Menues.lightBlue+"\nTjuven: "+Menues.green+ getName()+Menues.yellow+" || Poäng: "+getPoints()+Menues.white+" || Totalt spelade äventyr: "+getPlayedRounds()+Menues.red+" || Antal dödade monster: "+ getKillCount()+Menues.white+'}';
    }
    
    
    
}
