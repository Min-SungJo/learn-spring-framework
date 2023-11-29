package com.ride.learnspringframework2;

import com.ride.learnspringframework2.game.GameRunner;
import com.ride.learnspringframework2.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ride.learnspringframework2.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {
        try (
                var context =
                        new AnnotationConfigApplicationContext
                                (GamingAppLauncherApplication.class);
        ) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
