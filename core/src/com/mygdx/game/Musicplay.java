package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by 256233 on 5/8/2017.
 */
public class Musicplay {


        public Musicplay(SoundName sn)
        {
            currentSound = sn;
        }

        public Musicplay(SongName s) {
            currentSong = s;
        }
        public static enum SongName {
            BATTLE, Norm1, Norm3, Norm5;
        }

        public static enum SoundName {
            PLAYERHIT
        }

        static Music battle = Gdx.audio.newMusic(Gdx.files.internal("data/music/Rimraid.mp3"));
        static Music standard = Gdx.audio.newMusic(Gdx.files.internal("data/music/Far Away.mp3"));
        static Music other = Gdx.audio.newMusic(Gdx.files.internal("data/music/Staystrong.mp3"));
        static Music another = Gdx.audio.newMusic(Gdx.files.internal("data/music/Codered.mp3"));
        SongName currentSong;
        Music nowPlaying;
        SoundName currentSound;
        Sound soundPlaying;

        public void setNowPlaying(SongName s)
        {
            currentSong = s;
        }

        private void setSoundNowPlaying(SoundName sn)
        {
            currentSound = sn;
        }

        public void playSound(SoundName sn)
        {

            this.setSoundNowPlaying(sn);


            soundPlaying.play();
        }

        public void play()
        {
            switch (currentSong)
            {
                case BATTLE:
                    nowPlaying = battle;
                    break;
                case Norm1:
                    nowPlaying = standard;
                    break;
                case Norm3:
                    nowPlaying = other;
                    break;
                case Norm5:
                    nowPlaying = another;
                    break;
            }
            nowPlaying.play();
            nowPlaying.setLooping(true);
        }

        public void stop()
        {
            nowPlaying.stop();
        }

        public void switchSong(SongName s)
        {
            this.setNowPlaying(s);
            if(this.nowPlaying.isPlaying()) {
                this.stop();
            }
            this.play();
        }


    }

