package app;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

public class Update {

    public static void update(GamePanel gamePanel) {
        MoveMonster.moveMonster(gamePanel);

//        if (gamePanel.moveScreenOn == true) {
//            gamePanel.moveScreen(gamePanel, gamePanel.xMove, gamePanel.yMove);
//            gamePanel.moveScreenOn = false;
//        }

//        if (gamePanel.currentXtouch != -1 || gamePanel.currentYtouch != -1) {
//
//        }
//        else
        //          prevXTouch = -1;

        if (gamePanel.screenPressed) {
            gamePanel.holdingtime++;
        }
        else
            gamePanel.holdingtime = 0;

        if (gamePanel.holdingtime > 30) {
            gamePanel.fingerMenu = true;
            System.out.println("fingerMenu");
        }
        else
            gamePanel.fingerMenu = false;

//        if (gamePanel.player_target_X != -100){
//            if (gamePanel.moveTime == -1) {
//                gamePanel.moveTime ++;
//                gamePanel.startMoveTime = System.currentTimeMillis();
//            }
//
//            gamePanel.moveTime = System.currentTimeMillis() - gamePanel.startMoveTime;
//
//            if (gamePanel.player_target_X > gamePanel.player_pos_X && gamePanel.moveTime > 30) {
//                gamePanel.player_pos_X += 5;
//                gamePanel.moveTime = -1;
//
//                if (gamePanel.player_target_X - gamePanel.player_pos_X < 0)
//                    gamePanel.player_target_X = -100;
//            }
//
//            if (gamePanel.player_target_X < gamePanel.player_pos_X && gamePanel.moveTime > 30) {
//                gamePanel.player_pos_X -= 5;
//                gamePanel.moveTime = -1;
//
//                if (gamePanel.player_pos_X - gamePanel.player_target_X < 0)
//                    gamePanel.player_target_X = -100;
//            }
//        }


        //          prevXTouch = -1;
//        if (gamePanel.movingDotState == 0){
//
//        }
//
//        gamePanel.currentCounterTime = System.currentTimeMillis() - gamePanel.startCounterTime;
//
//        long switchTime = 60000 / gamePanel.setTime;
//
//        if (gamePanel.currentCounterTime >= switchTime){
//            System.out.println("time: " + gamePanel.currentCounterTime);
//
//            gamePanel.startCounterTime = System.currentTimeMillis();
//
//            //SoundPool soundMetronome = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
//
//            if (gamePanel.playedSound == 1) {
//                gamePanel.soundMetronome.play(gamePanel.soundId, 1, 1, 0, 0, 1);
//                gamePanel.playedSound = 2;
//                System.out.println("dzwiek 1");
//            }
//            else if (gamePanel.playedSound == 2) {
//                gamePanel.soundMetronome2.play(gamePanel.soundId2, 1, 1, 0, 0, 1);
//                gamePanel.playedSound = 3;
//                System.out.println("dzwiek 2");
//            }
//            else if (gamePanel.playedSound == 3) {
//                gamePanel.soundMetronome3.play(gamePanel.soundId3, 1, 1, 0, 0, 1);
//                gamePanel.playedSound = 4;
//                System.out.println("dzwiek 3");
//            }
//            else if (gamePanel.playedSound == 4) {
//                gamePanel.soundMetronome4.play(gamePanel.soundId4, 1, 1, 0, 0, 1);
//                gamePanel.playedSound = 1;
//                System.out.println("dzwiek 4");
//            }
//
//        }



    }


}
