package dungeonrun;

import static dungeonrun.Actions.i;
import static dungeonrun.Actions.j;
import static dungeonrun.DungeonBMusic.bgMusic;
import static dungeonrun.DungeonBMusic.musicPlay;
import static dungeonrun.DungeonBMusic.stopPlaying;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//import sun.audio.*;
import java.io.*;

public class Menues {

    static Scanner sc = new Scanner(System.in);
    static boolean loop = true;
    public static ArrayList<Hero> characterList = new ArrayList<>();
    // Definierade färger. Enbart red,white % green används just nu. /Jacob
    static String red = (char) 27 + "[31m";
    static String white = (char) 27 + "[37m";
    static String green = (char) 27 + "[32m";
    static String purple = (char) 27 + "[35m";
    static String blue = (char) 27 + "[34m";
    static String lightBlue = (char) 27 + "[36m";
    static String yellow = (char) 27 + "[33m";

    public static void main(String[] args) {
        //System.out.println(red+"red "+green+"green "+purple+"purple "+blue+"blue "+lightBlue+"lightBlue "+yellow+"yellow"+white);
        //System.out.println("\n<"+lightBlue+"("+blue+"()"+lightBlue+")"+white+">   <"+lightBlue+"("+blue+"()"+lightBlue+")"+white+">\n");
        String filepath1 = "welcome.wav";
        welcomeMessageSound welcome = new welcomeMessageSound();
        welcome.playSounds(filepath1);
        startMenu();

    }

    public static void startMenu() {
      
        bgMusic();
        
        System.out.println("\n\n\n\n\n                           "+red+"/\\                                                        /\\          ");
        System.out.println("                          /--\\                                                      /--\\         ");
        System.out.println("                         /....\\                                                    /....\\        ");
        System.out.println("                        /______\\                                                  /______\\"+white+"       ");
        System.out.println("                         |:   |                                                    |:   |        ");
        System.out.println("                         |[]  |       ::_:::_::                    ::_:::_::       | :[]|        ");
        System.out.println("                         |:   |       |_______|.:.:.:.:.:.:.:.:.:.:|_______|       |:   |        ");
        System.out.println("                         |    !:.:.:.:.|:    |  ,----------------,  |:    |.:.:.:.:!    |        ");
        System.out.println("                         |:            | :   |/'    "+red+"____..____"+white+"    '\\| :   |             |        ");
        System.out.println("                          \\  []        |:    |    "+red+"/'    ||    '\\"+white+"    |:    |        []  /         ");
        System.out.println("                           |:     []   | :   |   "+red+"|"+yellow+"o"+red+"     ||     "+yellow+"o"+red+"|"+white+"   | :   |  []       |          ");
        System.out.println("                           |:          |: _  |   "+red+"|     _||_     |"+white+"   |: _  |           |          ");
        System.out.println("                           |:  []      | "+yellow+"(_)"+white+" |   "+red+"|    "+yellow+"(_"+red+"||"+yellow+"_)"+red+"    |"+white+"   | "+yellow+"(_)"+white+" |       []  |          ");
        System.out.println("                           |:          |:    |   "+red+"|     "+yellow+"("+red+"||"+yellow+")"+red+"     |"+white+"   |:    |           |          ");
        System.out.println("                           |;          | :   |   "+red+"|      ||      |"+white+"   | :   |           |          ");
        System.out.println("                         /''           |:    |   "+red+"|"+yellow+"o"+red+"     ||     "+yellow+"o"+red+"|"+white+"   |:    |           ''\\        ");
        System.out.println("                        [_____________[_______]--"+red+"'------''------'"+white+"--[_______]_____________]       ");
        System.out.println("                                                                                                ");  
        System.out.println(green+"                          _________   ___  ___ __  ___   _____  _______  __"+yellow+"/\\"+green+"__  __  ___");
        System.out.println("                          \\  |   \\ \\  | |  | | | \\ | |  / /  \\| | |  \\| / "+yellow+"/  \\"+green+" \\ | \\ | |");
        System.out.println("                           | |    \\ \\ | |  | | | |\\| | | |  ___ | |==  | "+yellow+"< "+red+"()"+yellow+" >"+green+" || |\\| |");
        System.out.println("                           | |     | | \\_\\_!_| |_| \\_|  \\_\\_/_| |_!__/| \\_"+yellow+"\\  /"+green+"_/ |_| \\_|");
        System.out.println("                           | |     ! | "+white+"__________  ___  ___ __  ___        "+yellow+"\\/"+green);
        System.out.println("                           | |    / /  "+white+"\\  |    \\ \\ | |  | | | \\ | |"+purple+"  ||  ¡    ¡  ||  |!"+green);
        System.out.println("                          /__!___/_/    "+white+"| |     ! || |  | | | |\\| |"+purple+"  !|  ||  ||  ||  !");
        System.out.println("                                    ¡   "+white+"| |____/ /  \\_\\_!_| |_| \\_|"+purple+"   !  !!  ||  |!  ");
        System.out.println("                            !  !|  ||   "+white+"| |   \\ \\"+white+"                   "+red+"O        "+purple+"!|  !");
        System.out.println("                                !  !|   "+white+"| |    \\ \\"+yellow+"  -==============="+green+"|"+red+"xxx"+green+"("+red+"o"+green+"}   "+purple+"!");
        System.out.println("                                    !  "+white+"/__|     \\_\\_"+white+"                "+red+"O  "+white);
        System.out.println("                                                                                                ");
        System.out.println("                                    .-----------------------------------------.                 ");
        System.out.println("                                    |      Välkommen till Dungeon Run!        |                 ");
        System.out.println("                                    |                                         |                 ");
        System.out.println("                                    |            1) Starta spel.              |                 ");
        System.out.println("                                    |            2) Statistik meny.           |                 ");
        System.out.println("                                    |            0) Avsluta spel.             |                 ");
        System.out.println("                                    '-----------------------------------------'                 ");
//        System.out.println("                             _______________________________________________________");
//        System.out.println("                            |\\S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S/|");
//        System.out.println("                            |S¡¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¡S|");
//        System.out.println("                            |S|            Välkommen till Dungeon Run!            |S|");
//        System.out.println("                            |S|                                                   |S|");
//        System.out.println("                            |S|               1) Starta spel.                     |S|");
//        System.out.println("                            |S|               2) Statistik meny.                  |S|");
//        System.out.println("                            |S|               0) Avsluta spel.                    |S|");
//        System.out.println("                            |S!___________________________________________________!S|");
//        System.out.println("                            |/S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S~S\\|");
//        System.out.println("                            ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        SaveToFile.readFromFile(); // läser in den sparade filen.
        while (true) {
            System.out.print("Ditt val: ");
            String choice = input();

            switch (choice) {
                case "1":
                    ChooseCharacterType();
                    break;
                case "2":
                    statisticsmenu();
                    break;
                case "0":
                    goodBye();
                    break;
                case "-":
                    System.out.println(green +"Musiken är av"+white);
                    break;
                case "+":
                    System.out.println(green+"Musiken är på"+white);
                    break;
                default:
                    errorMessage();
            }
        }

    }

 public static void statisticsmenu() {
        while (true) {
        System.out.println("\n                                     .----------------------------------------------.      ");
        System.out.println("                                     |          Välj ett alternativ                 |      ");
        System.out.println("                                     |                                              |      ");
        System.out.println("                                     |      1) Totalt spelade äventyr               |      ");
        System.out.println("                                     |      2) Totalt ihopsamlade skatter           |      ");
        System.out.println("                                     |      3) Antal besegrade monster per typ      |      ");
        System.out.println("                                     |      4) Sammanställd statisik över spelare   |      ");
        System.out.println("                                     |      0) Tillbaka till startmeny              |      ");
        System.out.println("                                     '----------------------------------------------'      ");
            System.out.println("Ditt val: ");
        String choice = input();
        
        switch (choice) {
            case "1":
                System.out.println(" ----- Spelade omgångar ----- ");
                for (int k = 0; k < characterList.size(); k++) {
                    System.out.println(green+characterList.get(k).getName()+white+ " antal spelade äventyr: ");
                    System.out.println(characterList.get(k).getPlayedRounds());
                    }
                break;
            case "2":
                System.out.println(" ----- Ihopsamlade skatter ----- ");
                for (int k = 0; k < characterList.size(); k++) {
                    System.out.println("\n"+green+characterList.get(k).getName()+white+ " har samlat ihop följande skatter: ");
                    for (Treasure treasure : characterList.get(k).totalCollectedTreasure) {
                        System.out.println(treasure);
                    }
                    System.out.println(yellow+"Totalt: "+ characterList.get(k).getPoints()+" poäng"+white);
                }
                break;
            case "3":
                System.out.println(" ----- Dödade monster ----- ");
                for (int k = 0; k < characterList.size(); k++) {
                    System.out.println("\n"+green+characterList.get(k).getName()+white+ " har dödat följande monster: ");
                    for (Monster Mo : characterList.get(k).killedMonsters) {
                        System.out.println(red+"  "+Mo.type()+white);
                    }
                     System.out.println(yellow+"Totalt: "+ characterList.get(k).getKillCount()+" dödade monster"+white);
                }
                break;
            case "4":
                System.out.println(characterList);
                break;
            case "0":
                stopPlaying();
                startMenu();
                break;
            default:
        
        }
    }
}

    public static void ChooseCharacterType() {
        System.out.println("                                    .-----------------------------------------.     ");
        System.out.println("                                    |           Välj ett alternativ           |     ");
        System.out.println("                                    |                                         |     ");
        System.out.println("                                    |      1) Skapa en egen spelkaraktär      |     ");
        System.out.println("                                    |      2) Välja en befintlig karaktär     |     ");
        System.out.println("                                    |      0) Tillbaka till startmeny         |     ");
        System.out.println("                                    '-----------------------------------------'     ");
        while (true) {
            System.out.print("Ditt val: ");
            String choice = input();

            switch (choice) {
                case "1":
                    ChooseNewCharacter();
                case "2":
                    choosePrevChar();
                    adventureSize();
                    break;
                case "0":
                    startMenu();
                    break;
                case "-":
                    System.out.println(green +"Musiken är av"+white);
                    break;
                case "+":
                    System.out.println(green+"Musiken är på"+white);
                    break;
                case "Exit":
                    goodBye();
                    break;
                default:
                    errorMessage();
            }
        }
    }

    public static void pressEnter() {

        System.out.print(green+"Tryck Enter för att gå vidare"+white);
        input();
        clean();

    }

    public static void asciiArt() {
        System.out.println("                 Riddaren                              Magikern                            Tjuven                  ");
        System.out.println("                                                                                                                  ");
        System.out.println("                                                      __/_*_*(_                            .´´¨¨)                    ");
        System.out.println("   ,   A           {}                                / _______ \\                          | a_a\\                   ");
        System.out.println("  / \\, | ,        .--.                              _\\_)/___\\(_/_                         | | \"]                 ");
        System.out.println(" |    =|= >      /.--.\\                            / _((\\- -/))_ \\                      __| '-\\___               ");
        System.out.println("  \\ /` | `       |====|                            \\ \\()) - (()/ /                    .----.___.-'\\              ");
        System.out.println("   `   |         |`::`|                             ' \\(((()))/ '                    /        _    \\               ");
        System.out.println("       |     .-;`\\..../`;_.-^-._                   / ' \\)).))/ ' \\                  /   .-. (~T~) /|              ");
        System.out.println("      /\\\\/  /  |...::..|`   :   `|                / _ \\ - | - /_  \\                 |  /\\:  .--  / \\            ");
        System.out.println("       \\ /\\;-,/\\   ::  |...MIOS..|               (   ( .;''';. .'  )                \\ |  []_|_|_] \\ |           ");
        System.out.println("       |\\ <` >  >._::_.|':BOTTAR:|               _\\\"__ /    )\\ __\"/_                 | \\ |___   _\\ ]_}        ");
        System.out.println("       | `\"\"`  /   ^^  |   ':'   |                 \\/  \\   ' /  \\/                   '-' /   '.'  |             ");
        System.out.println("       |       |       \\    :    /                  .'  '...' ' )                       /    /|:  |                 ");
        System.out.println("       |       |        \\   :   /                    / /  |  \\ \\                        |   / |:  /             ");
        System.out.println("       |       |___/\\___|`-.:.-`                    / .   .   . \\                       /  /  |  /               ");
        System.out.println("       |        \\_ || _/                           /   .     .   \\                     |  /  /  |               ");
        System.out.println("       |        <_ >< _>                          /   /   |   \\   \\                    |/\\/  |/|/         ");
        System.out.println("       |        |  ||  |                        .'   /    b    '.  '.                  |  |  | /           ");
        System.out.println("       |        |  ||  |                    _.-'    /     Bb     '-. '-._              | /   | |__                   ");
        System.out.println("       |       _\\.:||:./_               _.-'       |      BBb       '-.  '-.           / |   |____)                 ");
        System.out.println("       |      /____/\\____\\             (________mrf\\____.dBBBb.________)____)         |_/                         ");
    }

    public static void ChooseNewCharacter() {
        asciiArt();
        System.out.println("                                                                                                                  ");
        System.out.println("       Som riddare är du uthållig          Genom att vara stadens magiker            Som tjuv är du smidigare än                                                                                                   ");
        System.out.println("       som få. Riddaren orkar ta           attackerar du monstren                    någon annan och juvelerna du   ");
        System.out.println("       strider mot stadens mörker          bättre än någon annan.                    har i sikte är din starka      ");
        System.out.println("       mer än någon annan.                                                           motivation att ta dig vidare.  ");
        System.out.println("                                                                                                                  ");
        System.out.println("       Din specialförmåga som är           Din specialförmåga är ljusskenet          Din specialförmåga är din                                                                                                  ");
        System.out.println("       ditt sköldblock som skyddar         du trollar fram i dina strider,           kritiska träff som gör att du  ");
        System.out.println("       dig mot första attacken i           ljuset gör att monstren du möter          har 25% chans att göra dubbel  ");
        System.out.println("       varje ny strid.                     blir blinda och du kommer att ha          skada när du attackerar                                                                 ");
        System.out.println("                                           en 80% chans att fly.                     ett monster.                   ");
        System.out.println("                                                                                                                  ");
        pressEnter();
        asciiArt();
        System.out.println("                                                                                                                  ");
        System.out.println("          .---------------------.               .---------------------.               .---------------------.     ");
        System.out.println("          |  Riddaren:          |               |   Magikern:         |               |  Tjuven             |     ");
        System.out.println("          |  ----------         |               |   ----------        |               |  ----------         |     ");
        System.out.println("          |  Initiativ 5        |               |   Initiativ 6       |               |  Initiativ  7       |     ");
        System.out.println("          |  Tålighet  9        |               |   Tålighet  4       |               |  Tålighet   5       |     ");
        System.out.println("          |  Styrka    6        |               |   Styrka    9       |               |  Styrka     5       |     ");
        System.out.println("          |  Smidighet 4        |               |   Smidighet 5       |               |  Smidighet  7       |     ");
        System.out.println("          |  -----------------  |               |   ----------------- |               |  -----------------  |     ");
        System.out.println("          |  Speciell förmåga:  |               |   Speciell förmåga: |               |  Speciell förmåga:  |     ");
        System.out.println("          |  Sköldblock         |               |   Ljussken          |               |  Kritisk träff      |     ");
        System.out.println("          '---------------------'               '---------------------'               '---------------------'     ");

        System.out.println("\n                                     .-----------------------------------------.    ");
        System.out.println("                                     |         Välj en spelkaraktär            |      ");
        System.out.println("                                     |                                         |      ");
        System.out.println("                                     |           1) Riddaren                   |      ");
        System.out.println("                                     |           2) Magikern                   |      ");
        System.out.println("                                     |           3) Tjuven                     |      ");
        System.out.println("                                     |           0) Tillbaka till startmeny    |      ");
        System.out.println("                                     '-----------------------------------------'      ");
        while (true) {
            System.out.print("Ditt val: ");
            String choice = input();

            switch (choice) {
                case "1":
                    addKnight();
                   
                    adventureSize();
                    break;
                case "2":
                    addMagician();
                    adventureSize();
                    break;
                case "3":
                    addThief();
                    adventureSize();
                    break;
                case "0":
                    startMenu();
                    adventureSize();
                    break;
                case "Exit":
                    goodBye();
                    break;
                case "-":
                    System.out.println(green +"Musiken är off"+white);
                    break;
                case "+":
                    System.out.println(green+"Musiken är på"+white);
                    break;
                default:
                    errorMessage();
            }
        }
    }
    

    public static void addKnight() {
        System.out.print("Skriv in karaktärens namn: ");
        String name = inputName();

        Hero knight = new Knight(name, 5, 9, 6, 4, 0, true, 0, 0, 0);
        characterList.add(knight);
        Collections.swap(characterList, characterList.indexOf(knight), 0);
        
        String filepath = "riddaren.wav";
        HeroSound riddareSound = new HeroSound();
        riddareSound.playMusic(filepath);
        
        welcomeMessage();
        //System.out.println(Room.monsters);
    }

    public static void addMagician() {
        System.out.print("Skriv in karaktärens namn: ");
        String name = inputName();

        Hero mag = new Magician(name, 6, 4, 9, 5, 0, true, 0, 0, 0);
        characterList.add(mag);
        System.out.println("\nDu har skapat en magiker!");
        Collections.swap(characterList, characterList.indexOf(mag), 0);
        
        String filepath = "magiker.wav";
        HeroSound mageSound = new HeroSound();
        mageSound.playMusic(filepath);
        
        welcomeMessage();
    }

    public static void addThief() {
        System.out.print("Skriv in karaktärens namn: ");
        String name = inputName();

        Hero thief = new Thief(name, 7, 5, 5, 7, 0, true, 0, 0, 0);
        characterList.add(thief);
        System.out.println("\nDu har skapat en tjuv!");
        Collections.swap(characterList, characterList.indexOf(thief), 0);
        
        String filepath = "thief.wav";
        HeroSound theifSound = new HeroSound();
        theifSound.playMusic(filepath);
        
        welcomeMessage();
    }

    public static void choosePrevChar() {
       boolean found = false;
        do {
        System.out.println(characterList);
        System.out.println("\n1) Välja en befintlig karaktär (från listan ovan)");
        System.out.println("0) Tillbaka till förgående meny");
            String choice = input();
            switch (choice) {
                case "1":
                    System.out.println("Vilken karaktär vill du starta med? (Skriv in namnet)");
                    String userA = input();
            for (Hero hero : characterList) {
                if (userA.equalsIgnoreCase(hero.getName())) {
                    Collections.swap(characterList, characterList.indexOf(hero), 0);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("\n"+red+"Spelaren '"+userA+"' hitades inte,"+white+" vänligen välj ett namn från listan eller skapa en ny karaktär.\n");
            }
                    break;
                case "0":
                    ChooseCharacterType();
                        break;
                default:
                    errorMessage();
            }
            
            
        } while (!found);
    }
    
    // Här startas spelet? var ska man börja?
    public static void adventureSize() {
        while (true) {
            System.out.println("\n                                      .-----------------------------------------.      ");
            System.out.println("                                      |             Välj ett äventyr            |        ");
            System.out.println("                                      |              1) Litet                   |        ");
            System.out.println("                                      |              2) Lagom                   |        ");
            System.out.println("                                      |              3) Stort                   |        ");
            System.out.println("                                      |              0) Huvudmeny               |        ");
            System.out.println("                                      '-----------------------------------------'        ");
            System.out.println("");

            System.out.print("Välj ditt äventyr: ");
            String choice = input();

            switch (choice) {
                case "1":
                    Map.createMap(4);
                    break;
                case "2":
                    Map.createMap(6);
                    break;
                case "3":
                    Map.createMap(8);
                    break;
                case "0":
                    startMenu();
                    break;
                case "-":
                    System.out.println(green +"Musiken är off"+white);                   
                    break;
                case "+":
                    System.out.println(green+"Musiken är på"+white);
                    break;
                default:
                    errorMessage();
                    break;
            }
        }
    }

    // Denna meny ska ligga i "Menu classen"
    @SuppressWarnings("empty-statement")
    public static void directionMenu(int r) {
        //boolean loop = true;
        while (true) {
            Map.printMap(r, true, i, j);
            System.out.println("");

            Map.map[i][j].setVisited(true);

            System.out.print("Gör ditt val: ");
            String direction = Menues.input();

            System.out.println("");

            switch (direction) {
                case "w":
                    if (i == 0) {
                        Actions.chooseAnotherRoom();
                        directionMenu(r);
                    } else {
                        System.out.println("        ↑");
                        i--;
                        Actions.newRoom(r);
                    }
                    break;
                case "s":
                    if (i == r - 1) {
                        Actions.chooseAnotherRoom();
                        directionMenu(r);
                    } else {
                        i++;
                        System.out.println("        ↓");
                        Actions.newRoom(r);
                    }
                    break;
                case "d":
                    if (j == r - 1) {
                        Actions.chooseAnotherRoom();
                        directionMenu(r);
                    } else {
                        System.out.println("        →");
                        j++;
                        Actions.newRoom(r);
                    }
                    break;
                case "a":
                    if (j == 0) {
                        Actions.chooseAnotherRoom();
                        directionMenu(r);
                    } else {
                        System.out.println("        ←");
                        j--;
                        Actions.newRoom(r);
                    }
                    break;
                case "-":
                    System.out.println(green +"Musiken är off"+white);                   
                    break;
                case "+":
                    System.out.println(green+"Musiken är på"+white);
                    break; 
                default:
                    clean();
                    System.out.println("      _   .:+:*:+:.   _            *********************************************           ");
                    System.out.println("     ( `-._\\...../_.-' )              " + Menues.characterList.get(0).getName() + ", mår du bra?                                    ");
                    System.out.println("      \\   ((('_')))   /               För att röra dig genom kartan                                                    ");
                    System.out.println("       )   ))) (((   (                måste du använda:                                                   ");
                    System.out.println("      (   ((( v )))   )               W , A  , S , D knapparna                                                ");
                    System.out.println("       )`--') X (`-._(                Skärp dig!                                                  ");
                    System.out.println("      /   _/     \\_   \\                                                                      ");
                    System.out.println("     /  .'/       \\`.  \\           *********************************************               ");
                    System.out.println("    (__/ /         \\ \\__)                                                                    ");
                    System.out.println("        /           \\                                                                  ");
                    System.out.println("       /             \\                                                               ");
                    System.out.println("      /~s~s~s~s~s~s~s~\\                     ");
                    Actions.waiting(2);

            }
        }

    }

    public static void errorMessage() {
        System.out.println(red + "***Fel inmatning***" + white);
    }

    public static String input() {
        String input;
        input = sc.nextLine();
        if (input.equalsIgnoreCase("exit")) {
            goodBye();
        }
        else if (input.equalsIgnoreCase("-")) {
            stopPlaying();
        }
        else if (input.equalsIgnoreCase("+")) {
            musicPlay();
        }

        return input;
        
    }
        public static String inputName() {
        String input;
        boolean alreadyTaken;
        do {
            alreadyTaken = false;
            input = sc.nextLine();
            for (Hero heroName : characterList) {
                if (input.equalsIgnoreCase(heroName.getName())) {
                    alreadyTaken = true;
                }
            }
            if (alreadyTaken) {
                System.out.println(red+"Fel, namnet finns redan. Vänligen välj ett annat."+white);
            }
            
        } while (alreadyTaken);
        
        
        return input;
    }

    public static void goodBye() {
        System.out.println("\n      _   .:+:*:+:.   _            ******************************************           ");
        System.out.println("     ( `-._\\...../_.-' )                                                               ");
        System.out.println("      \\   ((('_')))   /               Bra spelat!                                       ");
        System.out.println("       )   ))) (((   (                Kom tillbaka för att samla nya skatter!           ");
        System.out.println("      (   ((( v )))   )                                                                 ");
        System.out.println("       )`--') X (`-._(                Hej då!                                           ");
        System.out.println("      /   _/     \\_   \\                                                               ");
        System.out.println("     /  .'/       \\`.  \\                          Folket tackar dig :)                ");
        System.out.println("    (__/ /         \\ \\__)                                                             ");
        System.out.println("        /           \\                                                                   ");
        System.out.println("       /             \\                   *** created by Mios bottar ***                 ");
        System.out.println("      /~s~s~s~s~s~s~s~\\            ******************************************           \n");

        System.exit(0);
    }

    static void welcomeMessage() {
        clean();
        SaveToFile.saveToFile();
        System.out.println("      _   .:+:*:+:.   _            *************************************************           ");
        System.out.println("     ( `-._\\...../_.-' )                                                               ");
        System.out.println("      \\   ((('_')))   /              Hej, " + characterList.get(0).getName() + "!");
        System.out.println("       )   ))) (((   (               Välkommen till sagovärldens mörka sida!    ");
        System.out.println("      (   ((( v )))   )              Jag är Atina den goda, och jag ska guida                                   ");
        System.out.println("       )`--') X (`-._(               genom spelet.                                                ");
        System.out.println("      /   _/     \\_   \\              Din uppgift är att samla så många skatter som     ");
        System.out.println("     /  .'/       \\`.  \\             möjligt, men se upp! Det kan dyka upp monster     ");
        System.out.println("    (__/ /         \\ \\__)            från alla olika hörn, var då redo för strid.      ");
        System.out.println("        /           \\                                                                   ");
        System.out.println("       /             \\                 Låt oss spela Dungeon Run!                        ");
        System.out.println("      /~s~s~s~s~s~s~s~\\                                                                  ");
        System.out.println("                                   *************************************************           ");

    }

    public static void attack() {
        System.out.println("                        __________                                                  ");
        System.out.println("              Exit  -> |  __  __  |    Med smidighet som få, lyckas du fly          ");
        System.out.println("                       | |  ||  | |    tillbaka in i föregående rum.                ");
        System.out.println("               _       | |  ||  | |                                                 ");
        System.out.println("             _( }      | |__||__| |                                                 ");
        System.out.println("    -=   _  <<  \\      |  __  __()|                                                ");
        System.out.println("        `.\\__/`/\\\\     | |  ||  | |                                              ");
        System.out.println(" -=      '--'\\\\  `     | |  ||  | |                                               ");
        System.out.println("     -=     //         | |__||__| |                                                 ");
        System.out.println("            \\)         |__________|                                                ");

    }

    // Detta är bara en mall som jag använde för att testa utskrifter
    public static void block() {
        System.out.println("                                   O                                     O  ");
        System.out.println("                             {o)xxx|===============-  *  -===============|xxx(o}        ");
        System.out.println("                                   O                                     O              ");
        System.out.println("                                                    BLOCK!                              ");
        System.out.println("                                   O                                     O              ");
        System.out.println("                             {o)xxx|===============-  *  -===============|xxx(o}        ");
        System.out.println("                                   O                                     O              ");
    }

    public static void clean() {
        for (int i = 0; i < 40; i++) {
            System.out.println("");
        }
    }
}

//                     O                 O
//     -===============|xxx(o}  *  {o)xxx|===============-
//                     O                 O      
//
//
//
//System.out.println(" _________   ___  ___ __  ___   _____  _______  __/\__  __  ___ ");
//System.out.println(" \  |   \ \  | |  | | | \ | |  / /  \| | |  \| / /  \ \ | \ | | ");
//System.out.println("  | |    \ \ | |  | | | |\| | | |  ___ | |==  | <(())> || |\| | ");
//System.out.println("  | |     | | \_\_!_| |_| \_|  \_\_/_| |_!__/| \_\  /_/ |_| \_| ");
//System.out.println("  | |     ! | __________  ___  ___ __  ___        \/            ");
//System.out.println("  | |    / /  \  |    \ \ | |  | | | \ | |  ||  ¡    ¡  ||  |!  ");
//System.out.println(" /__!___/_/    | |     ! || |  | | | |\| |  !|  ||  ||  ||  !   ");
//System.out.println("           ¡   | |____/ /  \_\_!_| |_| \_|   !  !!  ||  |!      ");
//System.out.println("   !  !|  ||   | |   \ \                   O        !|  !       ");
//System.out.println("       !  !|   | |    \ \  -===============|xxx(o}   !          ");
//System.out.println("           !  /__|     \_\_                O                    ");
//
//
//
//System.out.println("    /\                                                        /\          ");
//System.out.println("   /--\                                                      /--\         ");
//System.out.println("  /....\                                                    /....\        ");
//System.out.println(" /______\                                                  /______\       ");
//System.out.println("  |:   |                                                    |:   |        ");
//System.out.println("  |[]  |       ::_:::_::                    ::_:::_::       | :[]|        ");
//System.out.println("  |:   |       |_______|.:.:.:.:.:.:.:.:.:.:|_______|       |:   |        ");
//System.out.println("  |    !:.:.:.:.|:    |  ,----------------,  |:    |.:.:.:.:!    |        ");
//System.out.println("  |:            | :   |/'    ____..____    '\| :   |             |        ");
//System.out.println("   \  []        |:    |    /'    ||    '\    |:    |        []  /         ");
//System.out.println("    |:     []   | :   |   |o     ||     o|   | :   |  []       |          ");
//System.out.println("    |:          |: _  |   |     _||_     |   |: _  |           |          ");
//System.out.println("    |:  []      | (_) |   |    (_||_)    |   | (_) |       []  |          ");
//System.out.println("    |:          |:    |   |     (||)     |   |:    |           |          ");
//System.out.println("    |;          | :   |   |      ||      |   | :   |           |          ");
//System.out.println("  /''           |:    |   |o     ||     o|   |:    |           ''\        ");
//System.out.println(" [_____________[_______]--'------''------'--[_______]_____________]       ");
//
//
//
//
//
//
//
