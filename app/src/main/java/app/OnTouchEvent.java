package app;


import android.graphics.BitmapFactory;
import android.view.MotionEvent;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class OnTouchEvent {

    public static boolean onTouchEvent(MotionEvent event, GamePanel gamePanel, int factorXY1, int factorXY2){
        int xTouch = (int)event.getX();
        int yTouch = (int)event.getY();

        switch (event.getAction()){
//            case MotionEvent.ACTION_MOVE:
//                gamePanel.moveScreenOn = true;
//                gamePanel.diffX = gamePanel.prevX - xTouch;
//                gamePanel.diffY = gamePanel.prevY - yTouch;
//                gamePanel.shiftX -= gamePanel.diffX;
//                gamePanel.shiftY -= gamePanel.diffY;
//                gamePanel.prevX = xTouch;
//                gamePanel.prevY = yTouch;
//                gamePanel.movingDist = gamePanel.diffX * gamePanel.diffX + gamePanel.diffY * gamePanel.diffY;
//                break;
            case MotionEvent.ACTION_DOWN:
                gamePanel.prevX = xTouch;
                gamePanel.prevY = yTouch;
                gamePanel.pressedX = xTouch;
                gamePanel.pressedY = yTouch;
                gamePanel.movingDist = 0;
                break;
            case MotionEvent.ACTION_UP:
                gamePanel.screenPressed = false;

                if (gamePanel.gameStart == 0){
                    gamePanel.gameStart = 1;
                    gamePanel.score = 0;
                }
                else if (gamePanel.gameOver == 1){
                    gamePanel.gameStart = 0;
                    gamePanel.gameOver = 0;
                }
                else if (gamePanel.moveScreenOn == false || xTouch < gamePanel.pressedX + 10 && xTouch > gamePanel.pressedX - 10
                        && yTouch > gamePanel.pressedY - 10 && yTouch < gamePanel.pressedY + 10 && gamePanel.moveScreenOn)
                    for (Screen img : gamePanel.images)
                        if (img.getDesc().equals("ant")){
                            System.out.println("posX posY xTouch yTouch " + img.getPositionX() + " " + img.getPositionY() +  " " + xTouch + " " + yTouch);

                            if (xTouch * factorXY2 / factorXY1 > (img.getPositionX() - 100 + gamePanel.shiftX * factorXY2 / factorXY1)
                                    && xTouch * factorXY2 / factorXY1< (img.getPositionX() + 100 + gamePanel.shiftX * factorXY2 / factorXY1)
                                    && yTouch * factorXY2 / factorXY1> (img.getPositionY() - 100 + gamePanel.shiftY * factorXY2 / factorXY1)
                                    && yTouch * factorXY2 / factorXY1< (img.getPositionY() + 100 + gamePanel.shiftY * factorXY2 / factorXY1) ){

    //                        toAdd.add(new Screen("blood", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.blood, gamePanel.options), -1, 1, img.getDrawing_pos_X(), img.getDrawing_pos_Y(), 200, 200, -1, 1, 150));
    //                        gamePanel.imgToAdd.add(new Screen("blood", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.blood, gamePanel.options), -1, 1, img.getDrawing_pos_X(), img.getDrawing_pos_Y(), -1, -1, 200, 200, -1, 1, 150));
                                gamePanel.imgToPaintBackground.add(new Screen("blood", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.blood, gamePanel.options), -1, 1, img.getPositionX(), img.getPositionY(),  200, 200, -1, 1, 150, 1, 160));
                                gamePanel.imgToRemove.add(img);
                            break;
                            }
                        }
                else if (img.getDesc().equals("cloud") || img.getDesc().equals("caterpillar")){
                    img.setTargetX((xTouch * factorXY2 / factorXY1 - gamePanel.shiftX * factorXY2 / factorXY1) );
                    img.setTargetY((yTouch * factorXY2 / factorXY1 - gamePanel.shiftY * factorXY2 / factorXY1) );
                    img.setTarget(1);

                            System.out.println(" shiftX " + gamePanel.shiftX + " shiftY "  + gamePanel.shiftY  + " imgPosX " + img.getPositionX() + " imgTarX " + img.getTargetX() + " imgPosY " + img.getPositionY() + " imgTarY " + img.getTargetY());
                        }

                gamePanel.moveScreenOn = false;

                for (Screen scr : gamePanel.images){
                    if (scr.getDesc().equals("caterpillar"))
                        System.out.println("xP " + scr.getPositionX() + " xT " + scr.getTargetX());
                }
                System.out.println("touch: " + (xTouch - gamePanel.shiftX) * factorXY2/factorXY1);

                break;
        }
        return true;
    }
}
