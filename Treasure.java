package dungeonrun;

public abstract class Treasure implements java.io.Serializable{

    private String type;
    private byte value;

    public Treasure(String type, byte value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    static float frequency() {
        float x = 0;
        return x;
    }

    @Override
    public String toString() {
        return type + ": " + value + " p";
    }

    public abstract String display();
}
