package dungeonrun;

public class SmallTreasureChest extends Treasure {

    public SmallTreasureChest(String type, byte value) {
        super(type, value);
    }

    static float frequency() {
        float frequency = 0.05f;
        return frequency;
    }

    @Override
    public String display() {
        return Menues.green+"Du snubblar över någon sorts liten låda... en... EN SKATTKISTA!! Du släpar med dig den. Värde: "+getValue()+" p"+Menues.white;
    }

}