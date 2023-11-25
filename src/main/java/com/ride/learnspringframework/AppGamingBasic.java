package com.ride.learnspringframework;

import com.ride.learnspringframework.game.GameRunner;
import com.ride.learnspringframework.game.MarioGame;
import com.ride.learnspringframework.game.PacmanGame;
import com.ride.learnspringframework.game.SuperContraGame;

public class AppGamingBasic {
    public static void main(String[] args) {
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
