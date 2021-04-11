package dungeonrun;

public class MoneyPouch extends Treasure {

    public MoneyPouch(String type, byte value) {
        super(type, value);
    }

    static float frequency() {
        float frequency = 0.2f;
        return frequency;
    }
    
    @Override
    public String display() {
        return Menues.green+"Det ligger en pengapung på golvet! Du plockar upp den. Värde: "+getValue()+" p"+Menues.white;
    }

}