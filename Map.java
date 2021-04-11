package dungeonrun;

import static dungeonrun.Menues.green;
import static dungeonrun.Menues.white;
import java.util.Scanner;

public class Map {

    static Scanner sc = new Scanner(System.in);
    static Room[][] map;
    

    public static void createMap(int r) {

        map = new Room[r][r];

        int i = 0;
        int j = 0;

        for (i = 0; i < r; i++) {
            for (j = 0; j < r; j++) {
                map[i][j] = new Room();
                //System.out.println("["+i+"]"+"["+j+"]");

                if (map[i][j] == map[0][0] || map[i][j] == map[0][r-1] || map[i][j] == map[r-1][0] || map[i][j] == map[r-1][r-1]) {
                    map[i][j].setExit(true);
                } 
                else {
                    map[i][j].addMonsters();
                    map[i][j].addTreasures();
                    
                }
                map[i][j].addAmbience();
                //map[i][j].displayMonsters();
                //map[i][j].displayTreasures();
            }
        }

        presentMap(r);

        printMap(r, false, 0, 0);

        chooseRoom(r, map);
    }

    public static void chooseRoom(int r, Room[][] map) {
        while (true) {       
            System.out.print("Gör ditt val: ");
            String choice = Menues.input();
            //Menues.clean();
            
            
            switch (choice) {
                case "1":
                    beCareful();
                    Actions.startGame(r, 0, 0);
                    break;
                case "2":
                    beCareful();
                    Actions.startGame(r, 0, r - 1);
                    break;
                case "3":
                    beCareful();
                    Actions.startGame(r, r - 1, 0);
                    break;
                case "4":
                    beCareful();
                    Actions.startGame(r, r - 1, r - 1);
                    break;
                case "0":
                    Menues.adventureSize();
                    break;
                case "-":
                    System.out.println(green +"Musiken är av"+white);
                    break;
                case "+":
                    System.out.println(green+"Musiken är på"+white);
                    break;
                default:
                    Menues.errorMessage();
                    printMap(r, false, 0, 0);
                    
            }
        }
    }
    
    public static void beCareful() {
        System.out.println("\n");
        System.out.println("      _   .:+:*:+:.   _            *********************************************        ");
        System.out.println("     ( `-._\\...../_.-' )                 Var försiktigt, " + Menues.characterList.get(0).getName());
        System.out.println("      \\   ((('_')))   /                               &                                ");
        System.out.println("       )   ))) (((   (                            Lycka till!                           ");
        System.out.println("      (   ((( v )))   )                                                                 ");
        System.out.println("       )`--') X (`-._(             *********************************************        ");
        System.out.println("      /   _/     \\_   \\                                                               ");
        System.out.println("     /  .'/       \\`.  \\                                                              ");
        System.out.println("    (__/ /         \\ \\__)                                                             ");
        System.out.println("        /           \\                                                                  ");
        System.out.println("       /             \\                                                                 ");
        System.out.println("      /~s~s~s~s~s~s~s~\\                                                                ");
        Actions.waiting(1.5);
    }

static void presentMap(int r) {

        switch (r) {
            case 4:
                Menues.clean();
                System.out.println("      _   .:+:*:+:.   _            *********************************************                        ");
                System.out.println("     ( `-._\\...../_.-' )                  - Fantastiskt, "+Menues.characterList.get(0).getName()       );
                System.out.println("      \\   ((('_')))   /                                                                                ");
                System.out.println("       )   ))) (((   (                                Du har valt                                     ");
                System.out.println("      (   ((( v )))   )                                  det                                          ");
                System.out.println("       )`--') X (`-._(                              lilla äventyret!                                  ");
                System.out.println("      /   _/     \\_   \\                                                                               ");
                System.out.println("     /  .'/       \\`.  \\                Detta är din karta, håll i den hårt.                        ");
                System.out.println("    (__/ /         \\ \\__)                                                                             ");
                System.out.println("        /           \\             *********************************************                        ");
                System.out.println("       /             \\                                                                                 ");
                System.out.println("      /~s~s~s~s~s~s~s~\\                                                                                ");
                break;
            case 6:
                Menues.clean();
                System.out.println("      _   .:+:*:+:.   _            *********************************************                        ");
                System.out.println("     ( `-._\\...../_.-' )                  - Fantastiskt, "+Menues.characterList.get(0).getName()       );
                System.out.println("      \\   ((('_')))   /                                                                                ");
                System.out.println("       )   ))) (((   (                                Du har valt                                     ");
                System.out.println("      (   ((( v )))   )                                  det                                          ");
                System.out.println("       )`--') X (`-._(                           mellanstora äventyret!                               ");
                System.out.println("      /   _/     \\_   \\                                                                               ");
                System.out.println("     /  .'/       \\`.  \\                Detta är din karta, håll i den hårt.                        ");
                System.out.println("    (__/ /         \\ \\__)                                                                             ");
                System.out.println("        /           \\             *********************************************                        ");
                System.out.println("       /             \\                                                                                 ");
                System.out.println("      /~s~s~s~s~s~s~s~\\                                                                                 ");
                break;
            case 8:
                Menues.clean();
                System.out.println("      _   .:+:*:+:.   _            *********************************************                        ");
                System.out.println("     ( `-._\\...../_.-' )                  - Fantastiskt, "+Menues.characterList.get(0).getName()       );
                System.out.println("      \\   ((('_')))   /                                                                                ");
                System.out.println("       )   ))) (((   (                                Du har valt                                     ");
                System.out.println("      (   ((( v )))   )                                  det                                          ");
                System.out.println("       )`--') X (`-._(                             det stora äventyret!                               ");
                System.out.println("      /   _/     \\_   \\                                                                               ");
                System.out.println("     /  .'/       \\`.  \\                Detta är din karta, håll i den hårt.                        ");
                System.out.println("    (__/ /         \\ \\__)                                                                             ");
                System.out.println("        /           \\             *********************************************                        ");
                System.out.println("       /             \\                                                                                 ");
                System.out.println("      /~s~s~s~s~s~s~s~\\                                                                                 ");
                break;
            default:
                break;
        }
        
    }

    static void printMap(int r, boolean inGameMap, int x, int y) {
        int corner = 1;

        System.out.println("");

        for (int i = 0; i <= r*2; i++) {
            //for (int j = 0; j < 39-r*3; j++) { // centrerar kartan, sänk från 59 till...?
            //    System.out.print(" ");
            //}
            for (int j = 0; j <= r*6; j++) {
                if (i == 0 /*|| i == r*2*/) { // första raden
                    if (j == 0 || j == r*6) { // hörnen
                        System.out.print(".");
                    } else {
                        System.out.print("-");
                    }
                } else if (i == r*2) { // sista raden
                    if (j == 0 || j == r*6) { // hörnen
                        System.out.print("·");
                    } else {
                        System.out.print("-");
                    }
                } else if (i%2 == 0){ // de streckade raderna
                    if (j%6 == 0) {
                        if (j == 0 || j == r*6) {
                            System.out.print("|");
                        } else {
                            System.out.print("+");
                        }
                    } else {
                        if (j == 1 || j == r*6-1) {
                            System.out.print(" ");
                        } else {
                            System.out.print("-");
                        }
                    }
                } else { // if (i%2 == 1)
                    if (j%6 == 0) {
                        System.out.print("|");
                    } else {
                        if (inGameMap) {
                            positionOnMap(i, j, x, y);
                        } else {
                            if (j%6 == 3) {
                                if ((j == 3 || j == r*6-3) && (i == 1 || i == r*2-1)) {
                                    System.out.print(corner); // siffran som betecknar hörnen
                                    corner++;
                                } else {
                                    System.out.print(" ");
                                }
                            } else {
                                System.out.print(" ");
                            }
                        }
                           
                    }
                }
            }

            if (!inGameMap) {
                     if (i == 1+r-4) {System.out.print("     Varje hörn har en port - var vill du börja?");}
                else if (i == 3+r-4) {System.out.print("     1) Nordvästra porten");}
                else if (i == 4+r-4) {System.out.print("     2) Nordöstra porten");}
                else if (i == 5+r-4) {System.out.print("     3) Sydvästra porten");}
                else if (i == 6+r-4) {System.out.print("     4) Sydöstra porten");}
                else if (i == 7+r-4) {System.out.print("     0) Välj ett annat äventyr");}
            } else {
                     if (i == 1+r-4) {System.out.print("     Vart vill du gå nu?     ");}
                else if (i == 3+r-4) {System.out.print("              ↑              ");}
                else if (i == 4+r-4) {System.out.print("              W              ");}
                else if (i == 5+r-4) {System.out.print("         ← A     D →         ");}
                else if (i == 6+r-4) {System.out.print("              S              ");}
                else if (i == 7+r-4) {System.out.print("              ↓              ");}
            }

            System.out.print("\n");    
        }
        System.out.println("");
        
        
        
        
    }

    public static void positionOnMap(int i, int j, int x, int y) {

        if (j%6 == 3) {
            if ((i-1)/2 == x && (j-3)/6 == y) { // rummet du står i
                System.out.print(Menues.green+"O"+Menues.white);
            } else {
                System.out.print(map[(i-1)/2][(j-3)/6].status());
            }
        } else {
            System.out.print(" ");
        }
        
    }

    
}


     
// ¡ ·
