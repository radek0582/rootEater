package app;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceView;

import com.example.myapplication.R;

public  class Sound {
    public Sound() {

    }

    public void audioPlayer(GamePanel gamePanel){
        //set up MediaPlayer
        MediaPlayer mp = new MediaPlayer();
        MediaPlayer sound1 = mp.create(gamePanel.getContext(), R.raw.eat);
        sound1.start();
    }
}
