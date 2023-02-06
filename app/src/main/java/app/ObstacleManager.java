package app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Button;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleManager {

    public static int randomNumber (int start, int range){
        int number = -1;

        Random r = new Random();

        number = r.nextInt(range) + start;

        return number;
    }


    public static void obstacleManager(GamePanel gamePanel){
        gamePanel.startedGame = false;

        Button button;

        gamePanel.options.inScaled = false;

        gamePanel.tempBitmap = new Screen(BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.leaf3, gamePanel.options), -100, 1, 3000, 2250, -1, 1, 150);
        gamePanel.tempPixels = new int[3000*2250];
        gamePanel.tempBitmap.getSpritesheet().getPixels(gamePanel.tempPixels,0,3000,0,0,3000,2250);

        Bitmap compare = Bitmap.createBitmap(3000, 2250, Bitmap.Config.ARGB_8888);

        compare.setPixels(gamePanel.tempPixels,0,3000,0,0,3000,2250);
        compare.setDensity(160);// * factorXY1/factorXY2);

        Screen backgroundImage = new Screen("background", compare, 1, 1, 1500, 1000, 3000, 2250, -1, 1, 150, 1, 160);

        gamePanel.images.add(backgroundImage);


        gamePanel.images.add(new Screen("earth1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.earth, gamePanel.options), -1, 1, 500, 700, 4000, 700, -1, 1, 100, 1, 160));
        gamePanel.images.add(new Screen("earth2", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.earth, gamePanel.options), -1, 1, -3500, 700, 4000, 700, -1, 1, 100, 1, 160));
        gamePanel.images.add(new Screen("sky", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.sky, gamePanel.options), -1, 1, 500, 200, 4000, 700, -1, 1, 100, 1, 160));

        gamePanel.images.add(new Screen("carrot1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.carrot, gamePanel.options), -1, 1, randomNumber(-1000, 300), 400, 100, 100, -1, 1, 100, 1, 80));
        gamePanel.images.add(new Screen("beetroot1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.beetroot3, gamePanel.options), -1, 1, randomNumber(-2000, 500), 380, 120, 120, -1, 1, 100, 1, 80));
        gamePanel.images.add(new Screen("parsley1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.parsley, gamePanel.options), -1, 1, randomNumber(-3000, 700), 400, 100, 100, -1, 1, 100, 1, 80));

        gamePanel.images.add(new Screen("rock1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.rock4, gamePanel.options), -1, 1, randomNumber(-1000, 700), randomNumber(450,400), 577, 352, -1, 1, 100, 1, 220));
        gamePanel.images.add(new Screen("rock2", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.rock5, gamePanel.options), -1, 1, randomNumber(-1500, 700), randomNumber(450,400), 361, 268, -1, 1, 100, 1, 220));
        gamePanel.images.add(new Screen("rock3", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.rock6, gamePanel.options), -1, 1, randomNumber(-2000, 700), randomNumber(450,400), 346, 207, -1, 1, 100, 1, 220));
        gamePanel.images.add(new Screen("rock4", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.rock7, gamePanel.options), -1, 1, randomNumber(-2000, 700), randomNumber(450,400), 313, 154, -1, 1, 100, 1, 220));

        gamePanel.images.add(new Screen("cloud1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.cloud1, gamePanel.options), -1, 1, randomNumber(500, 1000), 100, 400, 200, -1, 1, 100, 1, 160));
        gamePanel.images.add(new Screen("forest1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.forest, gamePanel.options), -1, 1, randomNumber(-1000, 700), 300, 629, 373, -1, 1, 100, 1, 160));

        gamePanel.images.add(new Screen("bush1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.bush1, gamePanel.options), -1, 1, randomNumber(-500, 700), 350, 500, 392, -1, 1, 100, 1, 160));
        gamePanel.images.add(new Screen("bush2", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.bush2, gamePanel.options), -1, 1, randomNumber(-500, 700), 400, 334, 262, -1, 1, 100, 1, 160));

        gamePanel.images.add(new Screen("mole", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.kret3, gamePanel.options), -1, 1, randomNumber(-1000, 500), 800, 329, 150, -1, 2, 200, 1, 160));
        gamePanel.images.get(gamePanel.images.size() - 1).addVariable("targetY", 400);

        gamePanel.images.add(new Screen("startworm", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.wormstart, gamePanel.options), -1, 1, 800, 600, 897, 629, -1, 1, 100, 1, 160));
        gamePanel.images.add(new Screen("bcgstart", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.bcgstart, gamePanel.options), -1, 1, 800, 700, 2500, 1500, -1, 1, 100, 1, 160));

        gamePanel.images.add(new Screen("start", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.start, gamePanel.options), -1, 1, 1200, 500, 616, 300, -1, 1, 100, 1, 160));
        gamePanel.images.add(new Screen("gameOver", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.gameover, gamePanel.options), -1, 1, 1000, 500, 371, 300, -1, 1, 100, 1, 160));
        gamePanel.images.add(new Screen("finish", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.finish, gamePanel.options), -1, 1, 1000, 500, 1140, 620, -1, 1, 100, 1, 160));
        gamePanel.images.add(new Screen("score", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.score, gamePanel.options), -1, 1, 1000, 800, 618, 200, -1, 1, 100, 1, 160));



        Random x = new Random();

        for (int z = 0; z < 1; z++) {
            int a = x.nextInt(1500) - 750;
            int b = x.nextInt(1000) - 500;

            gamePanel.images.add(new Screen("caterpillar", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.caterpillar2, gamePanel.options), -1, 1, 1600, 700, 150, 150, -1, 64, 100, 15, 160));
            gamePanel.images.get(gamePanel.images.size() - 1).addVariable("speed", 5);
            gamePanel.images.get(gamePanel.images.size() - 1).addVariable("currentAngle", 0);

//            images.add(new Screen("ghost", BitmapFactory.decodeResource(getResources(), R.drawable.ghost, options), -1, 1, 1800 + a, 800 + b, 1800 + a, 800 + b, 400, 400, -1, 2, 150));
        }

//        gamePanel.images.add(new Screen("cloud", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.cloud, gamePanel.options), -1, 1, 1500, 700, 1000, 500, -1, 1, 100, 1, 160));
//        gamePanel.images.get(gamePanel.images.size() - 1).addVariable("rain", 100);
//        gamePanel.images.get(gamePanel.images.size() - 1).addVariable("thunders", 3);
//        gamePanel.images.get(gamePanel.images.size() - 1).setTargetX(1000);
//        gamePanel.images.get(gamePanel.images.size() - 1).setTargetY(1000);

//         images.get(1).getAnimation().setAnimationLength(1);
//        images.add(new Screen("kwadrat", BitmapFactory.decodeResource(getResources(), R.drawable.kwadrat100, options), -1, 1, 1400, 1000, 1400, 1000, 100, 100, -1, 1, 150));
//        images.add(new Screen("kwadrat", BitmapFactory.decodeResource(getResources(), R.drawable.kwadrat200, options), -1, 1, 1800, 1000, 1800, 1000, 200, 200, -1, 1, 150));
//        images.add(new Screen("kwadrat", BitmapFactory.decodeResource(getResources(), R.drawable.kwadrat400, options), -1, 1, 2200, 1000, 2200, 1000, 400, 400, -1, 1, 150));

    }
}
