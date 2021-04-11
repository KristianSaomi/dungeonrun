package dungeonrun;

import java.util.ArrayList;
import java.util.Collections;

public class CharacterSorter {

    ArrayList<Character> character = new ArrayList<>();

    public CharacterSorter(ArrayList<Character> character) {
        this.character = character;
    }

    

    public ArrayList<Character> getSortedCharacterByTotalInitiative() {
        Collections.sort(character);
        return character;
    }
}