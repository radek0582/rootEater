package app;

import static app.MainThread.canvas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Draw {
    public static void draw (GamePanel gamePanel, Canvas canvas){

        Paint paint = new Paint();
        paint.setTextSize(80 * gamePanel.factorXY1 / gamePanel.factorXY2);
        paint.setColor(Color.rgb(150, 150, 150));

        for (Screen img : gamePanel.imgToRemove)
            gamePanel.images.remove(img);

        gamePanel.imgToRemove.clear();

        for (Screen img : gamePanel.imgToAdd)
            gamePanel.images.add(img);

        gamePanel.imgToAdd.clear();

        Screen board = null;

//        for (Screen imgBoard : gamePanel.images)
//            if (imgBoard.getDesc().equals("background"))
//                board = imgBoard;

//        for (Screen img : gamePanel.imgToPaintBackground)
//        {
//            int a = img.getPositionX();
//            int b = img.getPositionY();
//
////            System.out.println("image wid: " + img.getAnimation().getImage().getWidth() + " hei" + img.getAnimation().getImage().getHeight() + "pix : " + img.getAnimation().getImage().getPixel(1,1));
//
//            for (int i = 0; i < img.getAnimation().getImage().getWidth(); i++)
//                for (int j = 0; j < img.getAnimation().getImage().getHeight(); j++)
//                    {
//                        int colorCode = img.getAnimation().getImage().getPixel(i, j);
//
//                        if (Color.alpha(colorCode) != 0) {
//                            gamePanel.gameBoardState [i + a][j + b] = -2;
//                            board.getAnimation().getImage().setPixel(i + a - 125, j + b, Color.argb(Color.alpha(colorCode), Color.red(colorCode), Color.green(colorCode), Color.blue(colorCode)));
//                        }
//                    }
//        }

        gamePanel.imgToPaintBackground.clear();

//        for (Screen img : gamePanel.images){
//            if (img.getDesc().equals("background")) {
//                drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
//                break;
//            }
//        }


        if (gamePanel.gameStart == 0){
            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("bcgstart"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("startworm"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("start"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }
        }

        if (gamePanel.gameStart == 1) {
            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("sky"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("cloud1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("forest1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("bush1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("bush2"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }


            for (Screen img : gamePanel.images) {


                if (img.getDesc().equals("earth1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);

                if (img.getDesc().equals("earth2"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("rock1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }
            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("rock2"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("rock3"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("carrot1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("eatencarrot1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("beetroot1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("eatenbeetroot1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("parsley1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("eatenparsley1"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("mole"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("caterpillar"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("cloud"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }




//        canvas.drawText(" FPS: " + gamePanel.averageFPS, 100 * gamePanel.factorXY1 / gamePanel.factorXY2, 100 * gamePanel.factorXY1 / gamePanel.factorXY2, paint);
            canvas.drawText(" Score: " + gamePanel.score, 100 * gamePanel.factorXY1 / gamePanel.factorXY2, 100 * gamePanel.factorXY1 / gamePanel.factorXY2, paint);
        }

        if (gamePanel.gameOver == 1){
//                for (Screen img : gamePanel.images) {
//                    if (img.getDesc().equals("gameOver"))
//                        drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
//                }
            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("bcgstart"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("finish"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }

            for (Screen img : gamePanel.images) {
                if (img.getDesc().equals("score"))
                    drawObj(img, gamePanel, gamePanel.factorXY1, gamePanel.factorXY2, canvas);
            }
            canvas.drawText("" + gamePanel.score, 1000 * gamePanel.factorXY1 / gamePanel.factorXY2, 810 * gamePanel.factorXY1 / gamePanel.factorXY2, paint);

        }
    }

    public static void drawObj (Screen obj, GamePanel gamePanel, int factorXY1, int factorXY2, Canvas canvas){
        obj.setX((obj.getPositionX() + gamePanel.shiftX * factorXY2 / factorXY1 - obj.getAnimation().getImage().getWidth() / 2 ) * factorXY1 / factorXY2);
        obj.setY((obj.getPositionY() + gamePanel.shiftY * factorXY2 / factorXY1 - obj.getAnimation().getImage().getHeight() / 2 ) * factorXY1 / factorXY2);
        obj.update();
        obj.draw(canvas);
    }
}
