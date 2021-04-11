package dungeonrun;

public class Knight extends Hero {

    public Knight(String name, int initiative, int endurance, int attack, int agility, int totalInitiative, boolean alive, int points, int playedRounds, int killCount) {
        super(name, initiative, endurance, attack, agility, totalInitiative, alive, points, playedRounds, killCount);
    }
    
    @Override
    public String type() {
        return "Riddare";
    }

    @Override
    public String theType() { 
        return "Riddaren";
    }

  @Override
  public String toString() {
       return "\nRiddaren: "+Menues.green+ getName()+Menues.yellow+" || Poäng: "+getPoints()+Menues.white+ " || Totalt spelade äventyr: "+getPlayedRounds()+ Menues.red+" || Antal dödade monster: "+ getKillCount()+Menues.white;
   }

}
