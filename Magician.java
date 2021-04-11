package dungeonrun;

public class Magician extends Hero {

    public Magician(String name, int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive, int points, int playedRounds, int killCount) {
        super(name, initiative, endurance, attack, agility, totalInitiative, alive, points, playedRounds, killCount);
    }

    @Override
    public String type() {
        return "Magiker";
    }

    @Override
    public String theType() {
        return "Magikern";
    }

    @Override
    public String toString() {
        return Menues.purple+"\nMagikern: " +Menues.green+ getName()+Menues.yellow+" || Poäng: "+getPoints()+Menues.white+" || Totalt spelade äventyr: "+getPlayedRounds()+Menues.red+" || Antal dödade monster: "+ getKillCount()+Menues.white+'}';
    }
    
    
}
