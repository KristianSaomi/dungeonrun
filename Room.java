package dungeonrun;
import java.util.ArrayList;
public class Room {
// Allt som är rött är klasser som inte finns och arraylists som därmed inte funkar

    ArrayList<Monster> monsters = new ArrayList<>();
    ArrayList<Treasure> treasures = new ArrayList<>();

    private String ambience;
    private boolean exit = false;
    private boolean visited = false;

    public String status() {
        if (visited) {
            if (monsters.size() > 0) {
                return Menues.red+"M"+Menues.white;
            } else {
                return " ";
            }
        } else {
            return "?";
        }
    }

    public void addMonsters() {
         

        // Om (ett slumpat tal 0-1) är lägre än ett monsters (statiska) Vanlighets-tal...
        if (Math.random()< Spider.frequency()) {
            // ...skapas ett nytt monster av den typen...
            Monster spi = new Spider(7, 1, 2, 3, 0, true);
            // ...och läggs till i ArrayListen monsters
            monsters.add(spi);
        }
        // Upprepas för varje typ av monster, nytt tal slumpas...
        if (Math.random() < Skeleton.frequency()) {
            Monster ske = new Skeleton(4, 2, 3, 3, 0, true);
            monsters.add(ske);
        }
        if (Math.random() < Orc.frequency()) {
            Monster orc = new Orc(6, 3, 4, 4, 0, true);
            monsters.add(orc);
        }
        if (Math.random() < Troll.frequency()) {
            Monster tro = new Troll(2, 4, 7, 2, 0, true);
            monsters.add(tro);
        }
    }

    public void addTreasures() {

        // Om (ett slumpat tal 0-1) är lägre än en skatts (statiska) Vanlighets-tal...
        if (Math.random() < Coins.frequency()) {
            // ...skapas en ny skatt av den typen...
            Treasure coi = new Coins("Lösa slantar", (byte)2);
            // ...och läggs till i ArrayListen treasures
            treasures.add(coi);
        }
        if (Math.random() < MoneyPouch.frequency()) {
            Treasure pou = new MoneyPouch("Pengapung",(byte)6);
            treasures.add(pou);
        }
        if (Math.random() < GoldJewelry.frequency()) {
            Treasure jew = new GoldJewelry("Guldsmycken",(byte)10);
            treasures.add(jew);
        }
        if (Math.random() < Gemstone.frequency()) {
            Treasure gem = new Gemstone("Ädelsten",(byte)14);
            treasures.add(gem);
        }
        if (Math.random() < SmallTreasureChest.frequency()) {
            Treasure che = new SmallTreasureChest("Liten skattkista",(byte)20);
            treasures.add(che);
        }

    }

    public void addAmbience() {

        int random = (int) (Math.random() * 5 + 1);

        switch (random) {
            case 1:
                ambience = "Det droppar någon slajmig vätska från taket,\noch ekot från dropparna som träffar golvet når djupt in i de okända gångarna.";
                break;
            case 2:
                ambience = "En jordig doft leder tankarna till skog.\nDet växer mossa i hörnen, och du kan ana ljudet av syrsor.";
                break;
            case 3:
                ambience = "Du ser ner över en stor svart grottsjö.\nEn strimma solljus har letat sig in från ovan och glittrar på vattenytan.";
                break;
            case 4:
                ambience = "Inbäddat i gnistrande kristallformationer,\npåminner det dig om ett vinterlandskap.\nEn rysning går genom kroppen.";
                break;
            case 5:
                ambience = "Det är kallt, rått och dunkelt.\nSpindelväv och trasiga kedjor hänger från taket.";
                break;
        }

        
    }

    public String getAmbience() {
        return ambience;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
    public boolean getExit() {
        return exit;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public boolean getVisited() {
        return visited;
    }

    // Metoder för att testa att det funkar
    void displayMonsters() {
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
        System.out.println("");
    }

    void displayTreasures() {
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
        System.out.println("");
    }
    
}