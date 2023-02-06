

package app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import static app.Constants.HEIGHT_Y;
import static app.Constants.WIDTH_X;
import static app.MainThread.canvas;
import static java.lang.StrictMath.abs;

import com.example.myapplication.R;


/**
 * Created by Radek on 2017-11-11.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;

    protected ArrayList<Screen> images;
    protected ArrayList<Screen> imgToRemove;
    protected ArrayList<Screen> imgToAdd;
    protected ArrayList<Screen> imgToPaintBackground;

    protected int gameBoardState [] [] = new int [3000][2250];

    protected double averageFPS;

    protected MediaPlayer mp = new MediaPlayer();

    protected MediaPlayer sound1 = mp.create(getContext(), R.raw.eat);

    protected int score = 0;

    int factorXY1;
    int factorXY2;

    protected int gameStart = 0;
    protected int gameOver = 0;

    boolean isLandscape;
    protected int[] pixels;
    protected int[][] pixels2D;
    protected int[] tempPixels;



    protected int shiftX = 0;
    protected int shiftY = 0;
    protected int prevX = 0;
    protected int prevY = 0;
    protected int diffX = 0;
    protected int diffY = 0;

    protected int movingDist = 0;

    protected int pressedX = 0;
    protected int pressedY = 0;

    int holdingtime = 0;

    long currentCounterTime = 0;
    long startCounterTime = 0;

    protected int wind = 1; // 1 - from north, 2 - from east...

    boolean firstRun = true;


//    MediaPlayer soundMetronome = mp.create(getContext(), R.raw.metronom1);

//    SoundPool soundMetronome = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
//    int soundId = soundMetronome.load(getContext(), R.raw.metronom1, 1);
//
//    SoundPool soundMetronome2 = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
//    int soundId2 = soundMetronome2.load(getContext(), R.raw.metronom1, 2);
//
//    SoundPool soundMetronome3 = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
//    int soundId3 = soundMetronome3.load(getContext(), R.raw.metronom1, 2);
//
//    SoundPool soundMetronome4 = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
//    int soundId4 = soundMetronome4.load(getContext(), R.raw.metronom1, 2);


    boolean fingerMenu = false;
    boolean screenPressed = false;

    protected boolean startedGame = false;

    protected Screen tempBitmap;

    boolean moveScreenOn = false;

    BitmapFactory.Options options = new BitmapFactory.Options();

    public GamePanel(Context context) {
        super(context);

        images = new ArrayList<>();
        imgToRemove = new ArrayList<>();
        imgToAdd = new ArrayList<>();
        imgToPaintBackground = new ArrayList<>();

        for (int i = 0; i < 3000; i++)
            for (int j = 0; j < 2250; j++)
                gameBoardState [i] [j] = -1;        // -1 - unchanged pixel / map element

        float xy1 = WIDTH_X/HEIGHT_Y;
        float xy2 = 16/9;

        if (xy1 <= xy2)
            isLandscape = false;
        else
            isLandscape = true;

        if (isLandscape == true) {
            factorXY1 = HEIGHT_Y;
            factorXY2 = 1080;
        }
        else {
            factorXY1 = WIDTH_X;
            factorXY2 = 1920;
        }

        System.out.println("factorXY1: " + factorXY1);
        System.out.println("factorXY2: " + factorXY2);


        getHolder().addCallback(this);
        obstacleManager();
        setFocusable(true);
    }

    public void obstacleManager (){
        ObstacleManager.obstacleManager(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int widht, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //thread = new MainThread(getHolder(), this);
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);

        if (thread.getState() == Thread.State.NEW)
            thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        int counter = 0;

        while (retry && counter<1000) {
            counter ++;
            try {
                thread.setRunning(false);
                thread.join();
                retry = false;
                thread = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return OnTouchEvent.onTouchEvent(event,this, factorXY1, factorXY2);
    }

    public void update() {
        Update.update(this);
    }

    @Override
    public void draw(Canvas canvas)
    {
        if (firstRun) {
            if (isLandscape == false)
                canvas.setDensity(160 * factorXY1 / factorXY2);
            else
                canvas.setDensity(160 * factorXY1 / factorXY2);

            firstRun = false;
        }

        if (canvas != null){
            super.draw(canvas);
//            canvas.drawColor(Color.rgb(16,16,16));
        }

        Draw.draw (this, canvas);
    }
}