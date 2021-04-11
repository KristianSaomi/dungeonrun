package dungeonrun;

import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class DungeonBMusic {
    static Clip clip;
    
    public static void bgMusic() {
        String filepath = "music.wav";
        DungeonBMusic musicObject = new DungeonBMusic();
        musicObject.playMusic(filepath);
    }

    void playMusic(String musicLocation) {
        Scanner sc = new Scanner(System.in);
        
        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                

//                System.out.println("hit 1 to pause");
//                int x = sc.nextInt();
//              JOptionPane.showMessageDialog(null, "Hit ok to pause");
//                long Themsong = clip.getMicrosecondPosition();
//                clip.stop();
//                System.out.println("hit 1 to resume");
//                int y = sc.nextInt();
//              JOptionPane.showMessageDialog(null, "Hit ok to resume");
//                clip.setMicrosecondPosition(Themsong);
//                clip.start();
//                System.out.println("hit 1 to stop playing");
//                int z = sc.nextInt();
//              JOptionPane.showMessageDialog(null, "press OK to stop playing");
            } else {
                System.out.println("Cant find file");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }
    
    public static void stopPlaying() {
        clip.stop();
    }
    public static void musicPlay() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    
}
           //Behöver Läggas in i Main 
//    String filepath = "archero.wav";
//        SoundEffects musicObject = new SoundEffects();
//        musicObject.playMusic(filepath);
//
//        String filepath1 = "welcome.wav";
//        WelcomeMessage welcome = new WelcomeMessage();
//        welcome.playSounds(filepath1);