package dungeonrun;

import static dungeonrun.DungeonBMusic.stopPlaying;
import static dungeonrun.Menues.green;
import static dungeonrun.Menues.white;
import java.util.Scanner;

public class Actions {

    static int i;
    static int j;
    static int prevI;
    static int prevJ;
   
    // static boolean startRoom;

    static Scanner sc = new Scanner(System.in);

    public static void startGame(int r, int a, int b) {
        i = a;
        j = b;

        Menues.characterList.get(0).setAlive(true);

        Menues.clean();

        System.out.println("             _______________________________________________________");
        System.out.println("            |\\S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S/|");
        System.out.println("            |S¡¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¡S|");
        System.out.println("            |S|               Slottet av Dystonia                 |S|");
        System.out.println("            |S|  har en mytomspunnen historia. Det sägs en gång   |S|");
        System.out.println("            |S|   ha varit hjärtat av en lycklig stad vid namn    |S|");
        System.out.println("            |S|        Eutonia, men när en bortskämd prins        |S|");
        System.out.println("            |S|   tog över tronen växte girighet och korruption   |S|");
        System.out.println("            |S|    och landets invånare fick mindre och mindre.   |S|");
        System.out.println("            |S|   När folket enades och gick emot den maktgalne   |S|");
        System.out.println("            |S|    prinsen, förbannade han slottet med ondsinta   |S|");
        System.out.println("            |S|       varelser för att ingen skulle kunna         |S|");
        System.out.println("            |S|               komma åt skatterna.                 |S|");
        System.out.println("            |S|                                                   |S|");
        System.out.println("            |S|    Dolda faror väntar i hypnotiserande miljöer.   |S|");
        System.out.println("            |S|   Få har kommit in, ännu färre har kommit ut...   |S|");
        System.out.println("            |S|              Vågar du ge dig in här?              |S|");
        System.out.println("            |S!___________________________________________________!S|");
        System.out.println("            |/S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S\\|");
        System.out.println("            ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n\n\n");

        Menues.pressEnter();
        Menues.clean();
        
        System.out.println("      _   .:+:*:+:.   _         **************************           ");
        System.out.println("     ( `-._\\...../_.-' )        Ditt uppdrag är att samla     ");
        System.out.println("      \\   ((('_')))   /         tillbaka folkets förlorade    ");   
        System.out.println("       )   ))) (((   (          skatter.    ");
        System.out.println("      (   ((( v )))  )                   De räknar med dig.    ");
        System.out.println("       )`--') X (`-._(                    ");
        System.out.println("      /   _/     \\_   \\         ...men var på din vakt,    ");
        System.out.println("     /  .'/       \\`.  \\        jag har hört att ens själ     ");
        System.out.println("    (__/ /         \\ \\__)       kan fastna där inne    ");
        System.out.println("        /           \\           för alltid...    ");   
        System.out.println("       /             \\                        ");
        System.out.println("      /~s~s~s~s~s~s~s~\\         **************************     \n\n\n");
        Menues.pressEnter();
        Menues.clean();

        Menues.directionMenu(r);
        // newRoom(r);
    }

    public static void waiting(double sec) {
        try {
            Thread.sleep((int) (sec * 1000));
        } catch (InterruptedException e) {
            System.out.println("Ett fel uppstod.");
            e.printStackTrace();
        }
    }

    public static void newRoom(int r) {// När du kommer in i ett rum

        Menues.clean();

        System.out.println("\nDu går in i ett nytt rum.\n");
        //waiting(1);
        System.out.println(Map.map[i][j].getAmbience());
        // Rumsbeskrivning

        //waiting(1);
        System.out.println("\nDu ser dig omkring...");
        waiting(2.8);

        if (Map.map[i][j].monsters.size() > 0) {
            System.out.println("");
            Map.map[i][j].displayMonsters();
            waiting(1);
        }
        

        if (Map.map[i][j].getVisited() && Map.map[i][j].monsters.size() == 0) {
            System.out.println("\nDu har varit här förut.");
            waiting(1);
        }

        Map.map[i][j].setVisited(true); // Flyttas?

        if (Map.map[i][j].getExit()) { // om rummet innehåller en utgång
            menuLeaveOrContinue(r);
        } else {
            if (Map.map[i][j].monsters.size() > 0) { // om det finns monster i rummet

                Combat.Fight(i, j, prevI, prevJ);

            }

            if (Map.map[i][j].treasures.size() > 0) { // Om det finns skatter i rummet
                System.out.println("");
                pickUpTreasures();
                waiting(1);
            }
        }
       
        prevI = i;
        prevJ = j;

        if (Menues.characterList.get(0).getAlive()) {
            Menues.directionMenu(r);
        }
        //String filepath5 = "room.wav";
        //newRoomSound newrooms = new newRoomSound();
        //newrooms.playSounds(filepath5);

        //String filepath5 = "coins.wav";
        //coinsSound coins = new coinsSound();
        //coins.playSounds(filepath5);
        //String filepath5 = "hit.wav";
        //bodyHitSound hit = new bodyHitSound();
        //hit.playSounds(filepath5);
        //String filepath5 = "fight.wav";
        //fightSound fight = new fightSound();
        //fight.playSounds(filepath5);
        //String filepath5 = "miss.wav";
        //missSound miss = new missSound();
        //miss.playSounds(filepath5);
        //classer att lägga in nedan.
        //String filepath5 = "block.wav";
        //blockSound block = new blockSound();
        //block.playSounds(filepath5);
        //String filepath5 = "thief.wav";
        //thiefSound thief = new thiefSound();
        //thief.playSounds(filepath5);
        //String filepath5 = "spider.wav";
        //spiderSound spider = new spiderSound();
        //spider.playSounds(filepath5);
        //String filepath5 = "troll.wav";
        //trollSound troll = new trollSound();
        //troll.playSounds(filepath5);
    }

    public static void pickUpTreasures() {
        for (Treasure treasure : Map.map[i][j].treasures) {
            System.out.println(treasure.display());
            Hero.collectedTreasure.add(treasure);
            Menues.characterList.get(0).totalCollectedTreasure.add(treasure);
        }
        Map.map[i][j].treasures.clear();
    }

    public static void escapeFromCombat(int prevX, int prevY) {
        i = prevX;
        j = prevY;
    }

    public static void menuLeaveOrContinue(int r) {
        // if (!startRoom) {
        System.out.println("\n      _   .:+:*:+:.   _            *********************************************           ");
        System.out.println("     ( `-._\\...../_.-' )                                                 ");
        System.out.println("      \\   ((('_')))   /                       Grattis, " + Menues.characterList.get(0).getName() + "                                                  ");
        System.out.println("       )   ))) (((   (                        Du har hittat en utgång!                                                    ");
        System.out.println("      (   ((( v )))   )                                                             ");
        System.out.println("       )`--') X (`-._(                        1) Vill du lämna kartan?                                                 ");
        System.out.println("      /   _/     \\_   \\                       2) Stanna kvar på kartan?                                               ");
        System.out.println("     /  .'/       \\`.  \\                                                              ");
        System.out.println("    (__/ /         \\ \\__)        *********************************************                                                            ");
        System.out.println("        /           \\                                                                   ");
        System.out.println("       /             \\                                                               ");
        System.out.println("      /~s~s~s~s~s~s~s~\\                    \n");
        while (true) {
            System.out.print("Gör ditt val: ");
            String leaveOrStay = Menues.input();

            switch (leaveOrStay) {
                case "1":
                    stopPlaying();
                    leaveMap();
                    break;
                case "2":
                    Menues.directionMenu(r);
                    break;
                case "-":
                    System.out.println(green +"Musiken är off"+white);                   
                    break;
                case "+":
                    System.out.println(green+"Musiken är på"+white);
                    break; 
                default:
                    System.out.println("      _   .:+:*:+:.   _            *********************************************           ");
                    System.out.println("     ( `-._\\...../_.-' )                                                 ");
                    System.out.println("      \\   ((('_')))   /                      Skärp dig, " + Menues.characterList.get(0).getName() + "!                                                 ");
                    System.out.println("       )   ))) (((   (                       Vad är det för fel på dig?                                                    ");
                    System.out.println("      (   ((( v )))   )                          Välj ett alternativ                                        ");
                    System.out.println("       )`--') X (`-._(                       1) Vill du lämna kartan?                                                 ");
                    System.out.println("      /   _/     \\_   \\                      2) Stanna kvar på kartan?                                               ");
                    System.out.println("     /  .'/       \\`.  \\                                                              ");
                    System.out.println("    (__/ /         \\ \\__)        *********************************************                                                            ");
                    System.out.println("        /           \\                                                                   ");
                    System.out.println("       /             \\                                                               ");
                    System.out.println("      /~s~s~s~s~s~s~s~\\                    ");
                    break;
            }
        }
    }
    //} else {
    //    Map.map[i][j].setVisited(true);
    //    startRoom = false;
    //    directionMenu(r);
    //}

    public static void chooseAnotherRoom() {
        System.out.println("      _   .:+:*:+:.   _            *********************************************           ");
        System.out.println("     ( `-._\\...../_.-' )                                                 ");
        System.out.println("      \\   ((('_')))   /               Ooops... Ehhhhmmmm...                                                   ");
        System.out.println("       )   ))) (((   (                Du kan inte gå igenom väggarna än...                                                    ");
        System.out.println("      (   ((( v )))   )               Kan jag föreslå att du använder en av                                                ");
        System.out.println("       )`--') X (`-._(                dörrarna istället?                                                  ");
        System.out.println("      /   _/     \\_   \\                                                                    ");
        System.out.println("     /  .'/       \\`.  \\         *********************************************                                                     ");
        System.out.println("    (__/ /         \\ \\__)                                                                    ");
        System.out.println("        /           \\                                                                   ");
        System.out.println("       /             \\                                                               ");
        System.out.println("      /~s~s~s~s~s~s~s~\\                    ");
        waiting(2);
    }

    public static void leaveMap() {
        int points = 0;

        System.out.println("\n\n\n");
        System.out.println("\nDu har klarat dig ut med livet i behåll, bra jobbat!\n");

        waiting(1.5);

        boxTop();
        boxMiddle("Insamlade skatter: ");
        for (Treasure treasure : Hero.collectedTreasure) {
            boxMiddle("" + treasure);
            points += treasure.getValue();
        }
        SaveLatest(points);
        boxMiddle("");
        boxMiddle("Total poäng: " + points + " p");
        boxBottom();
        System.out.println("\n\n\n");
        waiting(2);
        Menues.pressEnter();
        Menues.startMenu();

    }

    public static void boxTop() {

        System.out.println(" _______________________________");
        System.out.println("|\\S~S~S~S~S~S~S~S~S~S~S~S~S~S~S/|");
        System.out.println("|S¡¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¡S|");
    }

    public static void boxMiddle(String s) {

        System.out.print("|S|  " + s);
        for (int i = 0; i < 25 - s.length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|S|");
    }

    public static void boxBottom() {
        System.out.println("|S!___________________________!S|");
        System.out.println("|/S~S~S~S~S~S~S~S~S~S~S~S~S~S~S\\|");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
    }
    public static void SaveLatest(int points) {
        int TotalPoints = points+Menues.characterList.get(0).getPoints(); // för beräkning av totalt samlade poäng till characterList.
        Menues.characterList.get(0).setPoints(TotalPoints);
        int round = 0;
        round++;
        int TotalRounds =round+Menues.characterList.get(0).getPlayedRounds();
        Menues.characterList.get(0).setPlayedRounds(TotalRounds);
        SaveToFile.saveToFile();
    }

    //
    //     *
    //    / \
    //   /___\
    //   (·_·)
    //  /(( ))\
    //  \(_:_)/
    //   d! !b
    //
}
