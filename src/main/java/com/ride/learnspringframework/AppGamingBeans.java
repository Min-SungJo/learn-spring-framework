package com.ride.learnspringframework;

import com.ride.learnspringframework.game.GameRunner;
import com.ride.learnspringframework.game.GamingConsole;
import com.ride.learnspringframework.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppGamingBeans {
    public static void main(String[] args) {
        try (
                var context =
                        new AnnotationConfigApplicationContext
                                (GamingConfiguration.class);
        ) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
