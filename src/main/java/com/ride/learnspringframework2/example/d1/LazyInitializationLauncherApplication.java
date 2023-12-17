package com.ride.learnspringframework2.example.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Lazy // 지연초기화, 사용될 때 초기화하도록 설정
@Component
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        //Logic
        System.out.println("Some Initialization");
        this.classA = classA;
    }
    public void doSomething() {
        System.out.println("[doSomething] Do Something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        try (
                var context =
                        new AnnotationConfigApplicationContext
                                (LazyInitializationLauncherApplication.class)
        ) {
            System.out.println("Initialization of context is completed");
            //ClassB에 @Lazy를 적용했기 때문에, 사용 직전 로드됨
            context.getBean(ClassB.class).doSomething();
        }
    }
}
