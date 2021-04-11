package dungeonrun;

import java.util.ArrayList;
import java.util.Scanner;

public class Combat {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Character> combatOrder = new ArrayList<>();

    public Combat(ArrayList<Character> combatOrder) {

    }

    public static ArrayList<Character> initiative(int x, int y) {
        int singleInitiative;
        int totalInitiative = 0;

        for (Monster monster : Map.map[x][y].monsters) {
            combatOrder.add(monster); // loopar igenom alla monster i rummet och addar dem till listan combatOrder.
        }
        combatOrder.add(Menues.characterList.get(0)); //addar spelkaraktär till listan combatOrder så länge denna är på index plats 0.
        for (Character character : combatOrder) {
            for (int i = 1; i <= character.getInitiative(); i++) {
                singleInitiative = dice(); //loop som slumpar fram iniativ för varje medlem i combatOrder

                totalInitiative += singleInitiative;
            }
            character.setTotalInitiative(totalInitiative);

            if (character instanceof Hero) {
                System.out.println("Din snabbhet: " + character.getTotalInitiative());    
            } else {
                System.out.println(character.theType() + "s snabbhet: " + character.getTotalInitiative());
            }
            

            totalInitiative = 0; // dumpar värdet så att det inte finns kvar tills nästa varv i loopen.
        }
        CharacterSorter characterSorter = new CharacterSorter(combatOrder);
        ArrayList<Character> sortedCombatOrder = characterSorter.getSortedCharacterByTotalInitiative();
        return sortedCombatOrder;
    }

    public static int dice() {

        int random = (int) (Math.random() * 6 + 1);

        return random;
    }

    public static void Fight(int x, int y, int prevX, int prevY) {
        double damage; // hur mycket skada en karaktär gör per tärning
        double totalDamage = 0; // ^ totalt
        double defence; // hur starkt ens försvar är per tärning
        double totalDefence = 0; // ^ totalt
        double escapeChance; // chans att lyckas fly 0-100
        double escapeDiff; // risk att inte lyckas fly 0-100
        boolean goOn = true; // denna ska brytat på rätt ställen
        int crit; // chans för kritisk träff
        int monsterAttack = 0; // har koll på första attacken av monster så att riddaren kan använda sköldblock
        boolean escape = false;
        
        String filepath5 = "fight.wav";
        fightSound fight = new fightSound();
        fight.playSounds(filepath5);

        System.out.println("\n\n                         O                           O                    ");
        System.out.println("         -===============|xxx(o}   S·T·R·I·D   {o)xxx|===============-    ");
        System.out.println("                         O                           O                    \n\n\n");

        Actions.waiting(1);

        combatOrder = initiative(x, y);
        System.out.println("");

        System.out.print("Din hälsa: "+Menues.red);
        for (int i = 0; i < Menues.characterList.get(0).getEndurance(); i++) {
            System.out.print("♥ ");
        }
        System.out.print(Menues.white+"\n");

        for (Monster monster : Map.map[x][y].monsters) {
            System.out.print(monster.theType() + "s hälsa: ");
            for (int i = 0; i < monster.getEndurance(); i++) {
                System.out.print(Menues.red+"♥ "+Menues.white);
            }
            System.out.print("\n");
        }
        System.out.println("");

        if (combatOrder.get(0) instanceof Hero) {
            System.out.println("Du är snabbast, så du börjar!");
        } else {
            System.out.println(combatOrder.get(0).theType() + " är snabbast, så den börjar!");
        }
        System.out.println("");

        Actions.waiting(3);

        do {
            for (Character characters : combatOrder) {
                damage = 0;
                totalDamage = 0;
                defence = 0;
                totalDefence = 0;

                if (characters instanceof Monster && characters.getEndurance() > 0) { // MONSTERS TUR (om det är vid liv)
                    monsterAttack += 1; // räknare?

                    System.out.println("");

                    for (int i = 1; i <= characters.getAttack(); i++) { // slår tärningar för hur hårt slaget är
                        damage = dice();
                        totalDamage += damage;
                    }
                    System.out.println(characters.theType() + "s attack: " + (int)totalDamage);
                    for (int j = 1; j <= Menues.characterList.get(0).getAgility(); j++) { // slår tärningar för sannolikhet att undvika ett slag, och att fly?
                        defence = dice();
                        totalDefence += defence;

                    }
                    if (Menues.characterList.get(0) instanceof Knight && monsterAttack == 1) { // ger riddaren 1000 i defense i ett monsters första slag
                        totalDefence = 1000;
                    }
                    System.out.println("Ditt försvar: " + (int)totalDefence);

                    System.out.println("");

                    Actions.waiting(1);

                    if (totalDefence < totalDamage) { // Om mostret träffar dig
                        String filepath7 = "hit.wav";
                        bodyHitSound hit = new bodyHitSound();
                        hit.playSounds(filepath7);

                        Menues.characterList.get(0).setEndurance(Menues.characterList.get(0).getEndurance() - 1); // hjältens tålighet minskar med 1 (riddare 9, magiker 4, tjuv 5)

                        printSwords(); //                                              mitten * mitten
                        System.out.println("                                               "+Menues.red+"ATTACK!"+Menues.white+"                               ");
                        System.out.println("                                      "+characters.theType() + " går till attack!                      ");
                        System.out.println("                                           Du blev skadad.                            ");
                        System.out.println("                                      Du har nu: "+Menues.purple+Menues.characterList.get(0).getEndurance()+Menues.white+" i hälsa kvar.");
                        printSwords();

                        Actions.waiting(2);

                        if (Menues.characterList.get(0).getEndurance() <= 0) { // OM DU DÖR - flytta ut?

                            System.out.println("\n            _.--\"\"--._         ***************************************        _.--\"\"--._                  ");
                            System.out.println("           /  _    _  \\                                                      /  _    _  \\                   ");
                            System.out.println("        _  ( (_\\  /_) )  _               Du kämpade tappert               _  ( (_\\  /_) )  _                ");
                            System.out.println("       { \\._\\   /\\   /_./ }         Men det var inte tillräckligt        { \\._\\   /\\   /_./ }           ");
                            System.out.println("       /_\"=-.}______{.-=\"_\\                                              /_\"=-.}______{.-=\"_\\           ");
                            System.out.println("        _  _.=(\"\"\"\")=._  _                    DU ÄR DÖD                   _  _.=(\"\"\"\")=._  _          ");
                            System.out.println("       (_'\"_.-\"`~~`\"-._\"'_)                                              (_'\"_.-\"`~~`\"-._\"'_)         ");
                            System.out.println("        {_\"            \"_}     ***************************************    {_\"            \"_}              ");
                            goOn = false;
                            Menues.characterList.get(0).setAlive(false);
                            Menues.pressEnter();
                            Menues.startMenu(); // placera i slutet av Fight och gå dit om hjälten är död?
                            // cleara alla insamlade skatter för denna omgång?
                        }
                    } else { // if (totalDefence >= totalDamage) om ditt försvar är högre än monstrets attack

                        if (totalDefence >= 1000) {

                            String filepath10 = "block.wav";
                            blockSound block = new blockSound();
                            block.playMusic(filepath10);

                            printSwords();
                            System.out.println("                                             "+Menues.green+"SKÖLDBLOCK!"+Menues.white+"                              ");
                            System.out.println("                                      " + characters.theType() + " svingade mot dig                     ");
                            System.out.println("                                         men du skrek högt                          ");
                            System.out.println("                                     och gömde dig bakom skölden!                   ");
                            printSwords();

                        } else { // Skriva ut vilket monster som du missade att blocka
                            String filepath9 = "miss.wav";
                            missSound miss = new missSound();
                            miss.playSounds(filepath9);

                            printSwords(); //                                              mitten * mitten
                            System.out.println("                                                "+Menues.green+"BLOCK!"+Menues.white+"                              ");
                            System.out.println("                                 Du lyckades blocka " + characters.theType() + "s attack     ");
                            System.out.println("                                             Bra jobbat!                              ");
                            printSwords();

                        }
                        Actions.waiting(2);
                    }
                } else if (characters instanceof Hero) { // HJÄLTENS TUR
                    System.out.println("");
                    System.out.println("      _   .:+:*:+:.   _            ******************************************           ");
                    System.out.println("     ( `-._\\...../_.-' )                                                               ");
                    System.out.println("      \\   ((('_')))   /                      - Vad ska vi göra nu?                     ");
                    System.out.println("       )   ))) (((   (                                                                  ");
                    System.out.println("      (   ((( v )))   )                            1) Attackera                       ");
                    System.out.println("       )`--') X ( `-._(                            2) Försök Fly                       ");
                    System.out.println("      /   _/     \\_   \\                                                               ");
                    System.out.println("     /  .'/       \\`.  \\           ******************************************         ");
                    System.out.println("    (__/ /         \\ \\__)                                                             ");
                    System.out.println("        /           \\                                                                   ");
                    System.out.println("       /             \\                                                                  ");
                    System.out.println("      /~s~s~s~s~s~s~s~\\                                                                 ");
                    
                    int choice1 = chooseBetweenNumbers(1, 2);

                    if (choice1 == 1) { // Om du väljer Attackera
                        System.out.println("\nVilket monster vill du attackera?"); // vill vi att denna meny bara ska dyka upp om det finns mer än ett monster?
                        for (int i = 0; i < Map.map[x][y].monsters.size(); i++) {
                            System.out.println((i + 1) + ") " + Map.map[x][y].monsters.get(i).theType());
                        }

                        int choice2 = chooseBetweenNumbers(1, Map.map[x][y].monsters.size());

                        // Kan vara characters
                        for (int f = 0; f <= Menues.characterList.get(0).getAttack(); f++) { // slår tärningar * hjältens Attack
                            damage = dice();
                            totalDamage += damage;
                        }
                        if (Menues.characterList.get(0) instanceof Thief) {
                            crit = (int) (Math.random() * 4 + 1);
                            if (crit == 1) { // 25 % chans att göra dubbel skada
                                totalDamage = totalDamage * 2;
                            }
                        }
                        System.out.println("\nDin attack: " + (int)totalDamage);

                        for (int k = 0; k <= Map.map[x][y].monsters.get(choice2 - 1).getAgility(); k++) {
                            defence = dice();
                            totalDefence = totalDefence + defence;
                        }
                        System.out.println(Map.map[x][y].monsters.get(choice2 - 1).theType() + "s försvar: " + (int)totalDefence);
                        System.out.println("");

                        if (totalDefence < totalDamage) { // Om hjältens attack är starkare än monstrets försvar
                            String filepath6 = "hit.wav";
                            bodyHitSound hit = new bodyHitSound();
                            hit.playSounds(filepath6);

                            Map.map[x][y].monsters.get(choice2 - 1).setEndurance(Map.map[x][y].monsters.get(choice2 - 1).getEndurance() - 1);

                            printSwords();
                            System.out.println("                                                "+Menues.green+"ATTACK!"+Menues.white+"                               ");
                            System.out.println("                              Du lyckades träffa " + Map.map[x][y].monsters.get(choice2 - 1).theType() + " med din attack!           ");
                            System.out.println("                                             Det tog skada.                           ");
                            System.out.println("                                   " + Map.map[x][y].monsters.get(choice2 - 1).theType() + " har nu: "+Menues.purple+Map.map[x][y].monsters.get(choice2 - 1).getEndurance()+Menues.white+" i hälsa kvar.");
                            printSwords();

                        } else {

                            String filepath8 = "miss.wav";
                            missSound miss = new missSound();
                            miss.playSounds(filepath8);
                    
                            printSwords();
                            System.out.println("                                                "+Menues.yellow+"MISS!"+Menues.white+"                               ");
                            System.out.println("                                         Din attack missade!                        ");
                            System.out.println("                                    Du måste börja sikta bättre!                    ");
                            printSwords();
                        }
                        Actions.waiting(2);
                        if (Map.map[x][y].monsters.get(choice2 - 1).getEndurance() <= 0) {
                            System.out.println("");
                            printSwords(); //                                                     *
                            System.out.println("                                         "+Menues.green+"MONSTRET BESEGRAT!"+Menues.white+"                              ");
                            System.out.println("                                 " + Map.map[x][y].monsters.get(choice2 - 1).theType() + " faller till marken och dör.");
                            System.out.println("                                             Väl kämpat!                    ");
                            printSwords();
                            Menues.characterList.get(0).killedMonsters.add(Map.map[x][y].monsters.get(choice2-1));
                            int killedMonsters = 0;
                            killedMonsters++;
                            int totalKills =killedMonsters+Menues.characterList.get(0).getKillCount();
                            Menues.characterList.get(0).setKillCount(totalKills);
                            // Lägga till i lista över besegrade monster innan det tas bort?
                            Map.map[x][y].monsters.remove(choice2 - 1);
                            Actions.waiting(2);
                        }
                        
                        if (Map.map[x][y].monsters.size() == 0) {
                            goOn = false;
                        }
                    } else { // Om du väljer fly
                        escapeChance = Menues.characterList.get(0).getAgility() * 10; // Riddaren 40 %, Magikern 80 %, Thief 
                        escapeDiff = (int) (Math.random() * 101); // slumpar fram 0-100
                        if (Menues.characterList.get(0) instanceof Magician) {
                            escapeChance = 80;
                        }
                        System.out.println("escapeChance = " + escapeChance);
                        System.out.println("escapeDiff = " + escapeDiff);
                        if (escapeChance > escapeDiff) {
                            String filepath8 = "miss.wav";
                            missSound miss = new missSound();
                            miss.playSounds(filepath8);
                            System.out.println("                        __________                                                  ");
                            System.out.println("              Exit  -> |  __  __  |    FLYKT!            ");
                            System.out.println("                       | |  ||  | |    Med smidighet som trotsar gudarna         ");
                            System.out.println("               _       | |  ||  | |    lyckas du fly tillbaka in i         ");
                            System.out.println("             _( }      | |__||__| |    föregående rum.                          ");
                            System.out.println("    -=   _  <<  \\      |  __  __()|                        ");
                            System.out.println("        `.\\__/`/\\\\     | |  ||  | |                                              ");
                            System.out.println(" -=      '--'\\\\  `     | |  ||  | |                                               ");
                            System.out.println("     -=     //         | |__||__| |    *Monstren skrattar högt*                                        ");
                            System.out.println("            \\)         |__________|                                                ");
                            goOn = false;
                            escape = true;
                            break; // Kanske?
                        } else {
                            System.out.println("\n\nDu gör ett försök att fly men misslyckas! Hjäälp någon?\n");
                        }
                    }

                } // else - Om det är ett DÖTT monsters tur händer inget

            }
            //System.out.println("Spelomgång slut, alla har kört varsin gång");

        } while (goOn && !escape); // lägga if !escape någon annanstans?


        combatOrder.clear();

        if (Map.map[x][y].monsters.size() == 0) {
            Actions.waiting(1);
            Menues.clean();
            System.out.println("\n                        ..." + Menues.characterList.get(0).getName() + ", är du där?\n\n                            ...jag tror vi klarade det!!\n\n\n\n\n\n");
            Menues.pressEnter();
            Menues.clean();
        }
        if (escape) {
            x = prevX;
            y = prevY;
            Actions.escapeFromCombat(prevX, prevY);
        }

    }

    public static int chooseBetweenNumbers(int from, int to) {
        int choice;

        while (true) {

            choice = inputInt();
            if (choice < from || choice > to) {
                System.out.println("Välj ett av alternativen, kom igen nu, vi har bråttom!!");
            } else {
                break;
            }
        }

        return choice;
    }

    public static int inputInt() {
        String choiceString;
        int choice;

        while (true) {
            try {
                choiceString = sc.nextLine();
                choice = Integer.parseInt(choiceString);

                break;
            } catch (Exception e) {
                System.out.println("Du måste ange en siffra, kom igen nu, vi har bråttom!!");
            }
        }

        return choice;
    }

    public static void printSwords() {

        System.out.println("                               O                                     O              ");
        System.out.println("                         {o)xxx|===============-  *  -===============|xxx(o}        ");
        System.out.println("                               O                                     O              ");
    }

}
