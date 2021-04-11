package dungeonrun;

public class Gemstone extends Treasure {

    public Gemstone(String type, byte value) {
        super(type, value);
    }

    static float frequency() {
        float frequency = 0.1f;
        return frequency;
    }

    @Override
    public String display() {
        return Menues.green+"Det är något som ligger och blänker i ett hörn... en ädelsten! Du plockar upp den. Värde: "+getValue()+" p"+Menues.white;
    }
    
    
}