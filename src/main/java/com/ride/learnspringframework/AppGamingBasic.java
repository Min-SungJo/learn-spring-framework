package com.ride.learnspringframework;

import com.ride.learnspringframework.game.GameRunner;
import com.ride.learnspringframework.game.MarioGame;
import com.ride.learnspringframework.game.SuperContraGame;

public class AppGamingBasic {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var superContraGame = new SuperContraGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}
