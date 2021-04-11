package dungeonrun;

public class GoldJewelry extends Treasure {

    public GoldJewelry(String type, byte value) {
        super(type, value);
    }

    static float frequency() {
        float frequency = 0.15f;
        return frequency;
    }

    @Override
    public String display() {
        return Menues.green+"Det är något som ligger och skimrar i ett hörn... guldsmycken! Du plockar upp dem. Värde: "+getValue()+" p"+Menues.white;
    }
    
    
}