package com.example.agshapki.mosmos;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.util.Log;

interface SoundMakerInterface {
    void setVolume(int volume);
    int getVolume();
    void setMute(boolean mute);
    boolean getMute();
}

class SoundMaker implements SoundMakerInterface {

    private static final String TAG = "SoundMaker";
    
    MediaPlayer mediaPlayer;

    private static int catGood = R.raw.cat_good;
    private static int catBad = R.raw.cat_bad;

    static int maxVolume = 10;

    private static String keyVolume = "VOLUME_LEVEL";
    private static String keyMute = "VOLUME_MUTE";
    private SharedPreferences getSharedPreferences() {return MainActivity.sharedPreferences;}
    private SharedPreferences.Editor getSharedPreferencesEditor() {return MainActivity.sharedPreferencesEditor;}

    public void playGood() {play(catGood);}
    public void playBad() {play(catBad);}

    public void play(int id) {
        if (getMute()) {
            Log.d(TAG, "play: muted");
            return;
        }
        Log.d(TAG, "play: playing track");
        if (mediaPlayer!=null && mediaPlayer.isPlaying()) {
            Log.d(TAG, "play: player is still playing");
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(MainActivity.context, id);
        updateVolume(getVolume());
        mediaPlayer.start();
    }

    private void updateVolume(int volumeLevel) {
        Log.d(TAG, "updateVolume: volumeLevel=" + String.valueOf(volumeLevel));
        volumeLevel = Math.min(maxVolume, volumeLevel);
        float volume = (float) (1 - (Math.log(maxVolume - volumeLevel) / Math.log(maxVolume)));
        //float volume=(float)(Math.log(maxVolume-volumeLevel)/Math.log(maxVolume));
        Log.d(TAG, "updateVolume: " + String.valueOf(volume));
        mediaPlayer.setVolume(volume, volume);
    }

    @Override
    public int getVolume() {
        int currentVolume = getSharedPreferences().getInt(keyVolume,50);
        Log.d(TAG, "getVolume: current volume is " + String.valueOf(currentVolume));
        return currentVolume;
    }

    @Override
    public void setVolume(int volume) {
        Log.d(TAG, "setVolume: " + String.valueOf(volume));
        getSharedPreferencesEditor().putInt(keyVolume, volume);
        getSharedPreferencesEditor().commit();

        playGood();
    }

    @Override
    public void setMute(boolean mute) {
        Log.d(TAG, "setMute: " + String.valueOf(mute));
        getSharedPreferencesEditor().putBoolean(keyMute,mute);
        getSharedPreferencesEditor().commit();

        playGood();
    }

    @Override
    public boolean getMute() {
        boolean muted = getSharedPreferences().getBoolean(keyMute, false);
        Log.d(TAG, "getMute: " + String.valueOf(muted));
        return muted;
    }


}
