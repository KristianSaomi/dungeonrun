package dungeonrun;

public class Coins extends Treasure {

    public Coins(String type, byte value) {
        super(type, value);
    }

    static float frequency() {
        float frequency = 0.4f;
        return frequency;
    }

    @Override
    public String display() {
        return Menues.green+"Du hittar några lösa slantar på golvet! Värde: "+getValue()+" p"+Menues.white;
    }
    
}