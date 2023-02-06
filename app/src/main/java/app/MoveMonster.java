package app;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.SurfaceView;

import com.example.myapplication.R;

import java.util.Random;

public class MoveMonster {






    public static int randomNumber (int start, int range){
        int number = -1;

        Random r = new Random();

        number = r.nextInt(range) + start;

        return number;
    }



    public static void moveMonster (GamePanel gamePanel){
        Random r = new Random();
        Screen board = null;
        int worldSpeed = 0;

        Sound eat = new Sound();

        gamePanel.currentCounterTime = System.currentTimeMillis() - gamePanel.startCounterTime;

        for (Screen imgBoard : gamePanel.images)
            if (imgBoard.getDesc().equals("background")) {
                board = imgBoard;
                break;
            }

        for (Screen imgBoard : gamePanel.images) {
            String name = imgBoard.getDesc();

            if (name.equals("eatencarrot1") || name.equals("eatenbeetroot1") || name.equals("eatenparsley1")) {
                if (imgBoard.getPositionX() >= 2500)
                    gamePanel.images.remove(imgBoard);
            }
        }

        for (Screen catImg : gamePanel.images)
            if (catImg.getDesc().equals(("caterpillar"))) {
                Animation caterpilar = catImg.getAnimation();

                if (gamePanel.gameOver == 0) {
                    worldSpeed = 7;

                    if (caterpilar.getCurrentFrame() % 16 < 8)
                        worldSpeed = 2;

                    if (gamePanel.score > 100)
                        worldSpeed *= 2;
                    else if (gamePanel.score > 200)
                        worldSpeed *= 4;
                    else if (gamePanel.score > 300)
                        worldSpeed *= 8;
                    else if (gamePanel.score > 400)
                        worldSpeed *= 16;
                }
                else
                    worldSpeed = 1;
            }

        for (Screen img : gamePanel.images){
            if (gamePanel.currentCounterTime >= 40){
                gamePanel.startCounterTime = System.currentTimeMillis();
                int posX;
                int posY;

                if (img.getDesc().equals("earth1")){
                    img.setPositionX(img.getPositionX() + worldSpeed);
                }
                if (img.getDesc().equals("earth2")){
                    img.setPositionX(img.getPositionX() + worldSpeed);
                }

                if (img.getDesc().equals("carrot1")){
                    img.setPositionX(img.getPositionX() + worldSpeed);

                }

                if (img.getDesc().equals("rock1")){
                    img.setPositionX(img.getPositionX() + worldSpeed);

                }

                if (img.getDesc().equals("rock2")){
                    img.setPositionX(img.getPositionX() + worldSpeed);

                }

                if (img.getDesc().equals("rock3")){
                    img.setPositionX(img.getPositionX() + worldSpeed);

                }

                if (img.getDesc().equals("cloud1"))
                    img.setPositionX(img.getPositionX() + worldSpeed / 4);

                if (img.getDesc().equals("forest1"))
                    img.setPositionX(img.getPositionX() + worldSpeed / 2);

                if (img.getDesc().equals("bush1") || img.getDesc().equals("bush2"))
                    img.setPositionX(img.getPositionX() + worldSpeed);

                if (img.getDesc().equals("beetroot1"))
                    img.setPositionX(img.getPositionX() + worldSpeed);

                if (img.getDesc().equals("parsley1")){
                    img.setPositionX(img.getPositionX() + worldSpeed);
                }

                if (img.getDesc().equals("eatencarrot1")){
                    img.setPositionX(img.getPositionX() + worldSpeed);
                }

                if (img.getDesc().equals("eatenbeetroot1")){
                    img.setPositionX(img.getPositionX() + worldSpeed);

                }

                if (img.getDesc().equals("eatenparsley1")){
                    img.setPositionX(img.getPositionX() + worldSpeed);
                }

                if (img.getDesc().equals("mole")){
                    img.setPositionX(img.getPositionX() + worldSpeed + randomNumber(5,5));
                    int pos1Y = img.getPositionY();
                    int targetY = img.getVariableValue("targetY");

                    if (img.getPositionY() < targetY)
                        img.setPositionY(pos1Y + 5);
                    else
                        img.setPositionY(pos1Y - 5);

                    if (img.getPositionY() < targetY + 15 && img.getPositionY() > targetY - 15)
                        img.setVariableValue("targetY", randomNumber(400, 400));


                }

                if (img.getDesc().equals("earth1") && img.getPositionX() >= 4500)
                {
                   img.setPositionX(-3400);
                }

                if (img.getDesc().equals("earth2") && img.getPositionX() >= 4500)
                {

                    img.setPositionX(-3400);
                }

                if (img.getDesc().equals("mole") && img.getPositionX() >= 2500)
                    img.setPositionX(randomNumber(-2000, 1000));

                if (img.getDesc().equals("forest1") && img.getPositionX() >= 2500)
                    img.setPositionX(randomNumber(-5000, 1000));



                if (img.getDesc().equals("bush1") && img.getPositionX() >= 2500)
                    img.setPositionX(randomNumber(-4000, 1000));

                if (img.getDesc().equals("bush2") && img.getPositionX() >= 2500)
                    img.setPositionX(randomNumber(-3000, 1000));

                if (img.getDesc().equals("carrot1") && img.getPositionX() >= 2500)
                    img.setPositionX(randomNumber(-1500, 1000));

                if (img.getDesc().equals("beetroot1") && img.getPositionX() >= 2500)
                    img.setPositionX(randomNumber(-1500, 1000));

                if (img.getDesc().equals("parsley1") && img.getPositionX() >= 2500)
                    img.setPositionX(randomNumber(-3000, 1000));

                if (img.getDesc().equals("caterpillar")){
                    Animation monster = img.getAnimation();

                    float a = img.getPositionX(); // x1
                    float b = img.getPositionY(); // y1
                    float c = img.getTargetX();   // x2
                    float d = img.getTargetY();   // y2

                    int caterX = img.getPositionX();
                    int caterY = img.getPositionY();

                    float newX = a;
                    float newY = b;

                    for (Screen image : gamePanel.images) {
                        String name = image.getDesc();

                        if (name.equals("carrot1")) {
                            if (caterX >= image.getPositionX() - 100 && caterX <= image.getPositionX() + 100 && caterY >= image.getPositionY() - 100 && caterY <= image.getPositionY() + 100) {
                                gamePanel.images.add(new Screen("eatencarrot1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.eatencarrot, gamePanel.options), -1, 1, image.getPositionX(), image.getPositionY(), 100, 100, -1, 1, 100, 1, 80));
                                image.setPositionX(randomNumber(-1500, 1000));
                                gamePanel.score += 10;
                                eat.audioPlayer(gamePanel);
                            }
                        }
                        else if (name.equals("beetroot1")) {
                            if (caterX >= image.getPositionX() - 100 && caterX <= image.getPositionX() + 100 && caterY >= image.getPositionY() - 100 && caterY <= image.getPositionY() + 100) {
                                gamePanel.images.add(new Screen("eatenbeetroot1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.eatenbeetroot3, gamePanel.options), -1, 1, image.getPositionX(), image.getPositionY(), 100, 100, -1, 1, 100, 1, 80));
                                image.setPositionX(randomNumber(-1500, 1000));
                                gamePanel.score += 20;
                                eat.audioPlayer(gamePanel);
                            }
                        }
                        else if (name.equals("parsley1")) {
                            if (caterX >= image.getPositionX() - 100 && caterX <= image.getPositionX() + 100 && caterY >= image.getPositionY() - 100 && caterY <= image.getPositionY() + 100) {
                                gamePanel.images.add(new Screen("eatenparsley1", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.eatenparsley, gamePanel.options), -1, 1, image.getPositionX(), image.getPositionY(), 100, 100, -1, 1, 100, 1, 80));
                                image.setPositionX(randomNumber(-1500, 1000));
                                gamePanel.score += 50;
                                eat.audioPlayer(gamePanel);
                            }
                        }
                        else if (name.equals("rock1") || name.equals("rock2") || name.equals("rock3")) {
                            int height = image.getAnimation().getImage().getHeight();
                            int width = image.getAnimation().getImage().getWidth();

                            if (caterX >= image.getPositionX() - width/2 && caterX <= image.getPositionX() + width/2 && caterY >= image.getPositionY() - height/2 && caterY <= image.getPositionY() + height/2) {
                                System.out.println("--- >  skucha CaterX: " + caterX + " rockX " + image.getPositionX()  + "caterY: " + caterY + " rockY " + image.getPositionY());
                                gamePanel.score = 0;

                            }
                        }
                        else if (name.equals("mole")) {
                            int height = image.getAnimation().getImage().getHeight();
                            int width = image.getAnimation().getImage().getWidth();

                            if (caterX >= image.getPositionX() - width/2 && caterX <= image.getPositionX() + width/2 && caterY >= image.getPositionY() - height/2 && caterY <= image.getPositionY() + height/2) {
                                System.out.println("--- >  skucha CaterX: " + caterX + " rockX " + image.getPositionX()  + "caterY: " + caterY + " rockY " + image.getPositionY());
                                gamePanel.gameOver = 1;
                            }
                        }
                    }

                    float v = 0;
                    int speed = img.getVariableValue("speed");

                    if (monster.getCurrentFrame()%16 < 8)
                        speed *= 0.2;

                    long curDelay = monster.getDelay();

                    if (monster.getCurrentFrame() >= 7 && img.getAnimation().getCurrentFrame() <= 10){
                        if (gamePanel.score < 100)
                            curDelay = 64;
                        else if (gamePanel.score < 200)
                            curDelay = 32;
                        else if (gamePanel.score < 300)
                            curDelay = 16;
                        else if (gamePanel.score < 400)
                            curDelay = 8;
                        else
                            curDelay = 4;
                    }
                    else {
                        if (gamePanel.score < 100)
                            curDelay = 32;
                        else if (gamePanel.score < 200)
                            curDelay = 16;
                        else if (gamePanel.score < 300)
                            curDelay = 8;
                        else if (gamePanel.score < 400)
                            curDelay = 4;
                        else
                            curDelay = 2;
                    }

                    monster.setDelay(curDelay);

                    if (c - a != 0) {
                        v = (d - b) / (c - a);
//                        System.out.println("v: " + v);
                    }
                    else {
                        if (img.getPositionY() < img.getTargetY())
                            newY += speed;
                        else if (img.getPositionY() > img.getTargetY())
                            newY -= speed;
                    }

                    if (v != 0 && c - a != 0) {
                        if (v <= 1 && v >= -1) {

                            if (img.getPositionX() < img.getTargetX())
                                newX += speed;
                            else if (img.getPositionX() > img.getTargetX())
                                newX -= speed;

                            newY = (d - b) * (newX - a) / (c - a) + b;
                        } else if (v > 1 || v < -1) {

                            if (img.getPositionY() < img.getTargetY())
                                newY += speed;
                            else if (img.getPositionY() > img.getTargetY())
                                newY -= speed;

                            newX = (newY * c - newY * a - b * c + b * a) / (d - b) + a;
                        }
                    }
                    else{
                        if (img.getPositionX() < img.getTargetX())
                            newX += speed;
                        else if (img.getPositionX() > img.getTargetX())
                            newX -= speed;

//                        System.out.println("poziom" + v);
                    }

                    if (img.getTarget() != -1) {
//                        img.setPositionX((int) newX);
                        if (newY > 450 )
                            img.setPositionY((int) newY);
                    }

                    if (img.getPositionX() < img.getTargetX() + 10 && img.getPositionX() > img.getTargetX() - 10
                        && img.getPositionY() < img.getTargetY() + 10 && img.getPositionY() > img.getTargetY() - 10) {
                        img.setTarget(-1);
                    }

                    float angle = 0;

                    if (img.getTarget() != -1) {
                        if (v >= 1 || v <= -1) {
                            if (img.getPositionX() < img.getTargetX()) {
                                if (img.getPositionY() < img.getTargetY()) {      // 1
                                    angle = 90 - 45 / v;
                                } else {                                    // 2
                                    angle = -90 - 45 / v;
                                }

//                                img.getAnimation().setFrameShift(16);
//                                img.rotateFrames(16, 31, (int) angle);
//                            img.rotateFramesDelayed(16, 31, (int) angle);


                                if (img.getAnimation().getCurrentState() != 1)
                                    img.getAnimation().setNewState(1);
                            } else {
                                if (img.getPositionY() < img.getTargetY()) {      // 3
                                    angle = -90 - 45 / v;
//                                System.out.println("poz 3");
                                } else {                                    // 4
                                    angle = 90 - 45 / v;
//                                System.out.println("poz 4");
                                }

//                                img.rotateFrames(0, 15, (int) angle);
//                            img.rotateFramesDelayed(0, 15, (int) angle);
                                img.getAnimation().setFrameShift(0);

                                if (img.getAnimation().getCurrentState() != 2)
                                    img.getAnimation().setNewState(2);
                            }
                        } else if (v > -1 && v < 1 && v != 0) {
                            if (img.getPositionX() < img.getTargetX()) {
                                if (img.getPositionY() > img.getTargetY()) {      // 5
                                    angle = 45 * v;
//                                System.out.println("poz 5");
//                                System.out.println("frame: " + img.getAnimation().getCurrentFrame() + " shift: " + img.getAnimation().getFrameShift());
                                } else {                                    // 6
                                    angle = 45 * v;
//                                System.out.println("poz 6");
//                                System.out.println("frame: " + img.getAnimation().getCurrentFrame() + " shift: " + img.getAnimation().getFrameShift());
                                }

//                                img.getAnimation().setFrameShift(16);
//                                img.rotateFrames(16, 31, (int) angle);
//                            img.rotateFramesDelayed(16, 31, (int) angle);

                                if (img.getAnimation().getCurrentState() != 1)
                                    img.getAnimation().setNewState(1);
                            } else {
                                if (img.getPositionY() < img.getTargetY()) {      // 7
                                    angle = 45 * v;
//                                System.out.println("poz 7");
//                                System.out.println("frame: " + img.getAnimation().getCurrentFrame() + " shift: " + img.getAnimation().getFrameShift());
                                } else {                                    // 8
                                    angle = 45 * v;
//                                System.out.println("poz 8");
//                                System.out.println("frame: " + img.getAnimation().getCurrentFrame() + " shift: " + img.getAnimation().getFrameShift());
                                }

//                                img.rotateFrames(0, 15, (int) angle);
//                            img.rotateFramesDelayed(0, 15, (int) angle);
                                img.getAnimation().setFrameShift(0);

                                if (img.getAnimation().getCurrentState() != 2)
                                    img.getAnimation().setNewState(2);
                            }
                        } else if (v == 0) {

                        }
                    }

                    int x = img.getPositionX();
                    int y = img.getPositionY();
                }
            }
        }
    }
}
