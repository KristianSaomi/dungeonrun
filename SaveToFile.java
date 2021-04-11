
package dungeonrun;

import static dungeonrun.Menues.characterList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaveToFile {
       public static void saveToFile() {
                try {
            try (FileOutputStream fileOut = new FileOutputStream("savedHeroes.ser")) {
                try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    for (Hero h : characterList) {
                        out.writeObject(h);
                    }
                out.close();
                fileOut.close();
                }

            }
             } catch (IOException e) {
                    System.out.println(e);
        }
    }
    
 public static void readFromFile() {
characterList.removeAll(characterList); // Så det ej blir dubletter när man kallar på denna metod. 

  Hero h = null;
      try {
        try (FileInputStream fileIn = new FileInputStream("savedHeroes.ser"); ObjectInput in = new ObjectInputStream(fileIn)) {          
            while (true) {                
                h=(Hero) in.readObject();
                 characterList.add(h);  
                }
        }
    } catch (IOException i) {
 } catch (ClassNotFoundException ex) {
    Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
   }


}
}
