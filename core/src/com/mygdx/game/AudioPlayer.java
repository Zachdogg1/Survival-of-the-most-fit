package com.mygdx.game;

/**
 * Created by 256233 on 5/8/2017.
 */
import javazoom.jlme.util.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
public class AudioPlayer implements Runnable{


    /**
     * Created by Taylor on 2/12/2017.
     * Short ReadMe the library file contains a jar file that has the necessary library for .mp3 files
     */

        private Player player;
        private static String input;
        public static boolean isRunning;
        public static boolean song;
        private static int rando;
        public static String currentsong;
        public AudioPlayer(String fileName){
            isRunning = true;
            song = false;
            setInput(fileName);
            init();
        }
        /**
         Uses String input to setup an audioplayer.
         */
        private void init(){
            try{
                File file = new File(input);
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);

                player = new Player(bis);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        public void playOnce(){
            try {
                song = true;
                player.play();
                init();

                song = false;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        public static void setInput(String fileName){
            input = fileName;
        }

        @Override
        public void run() {

            while (isRunning==true)try {
                playOnce();
                player.stop();
                rando = randomgeneration.music();
                if (0 == rando) {
                    this.setInput("data/music/Far Away.mp3");
                }
                if (1 == rando) {
                    this.setInput("data/music/Staystrong.mp3");

                }
                if (2 == rando) {

                    this.setInput("data/music/Codered.mp3");
                }
                if(3 == rando)
                {

                    this.setInput("data/music/Rimraid.mp3");
                }
                init();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        }


