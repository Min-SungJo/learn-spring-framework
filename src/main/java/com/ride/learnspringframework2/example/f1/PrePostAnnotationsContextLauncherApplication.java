package com.ride.learnspringframework2.example.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    // 의존성을 연결하는 대로 초기화하는 것을 가정
    private SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("SomeClass All dependencies are ready!");
    }

    /**
     * 초기화 과정의 일부,
     * 초기화를 수행하기 위해 의존성 주입이 완료된 후 실행해야 하는 메서드에서 사용,
     * 클래스를 사용하기 전에 호출되어야 함
     * (다른 Bean이 이 Bean을 사용할 수 있게 되기 전에 이 메서드가 호출)
     * dovmv
     */
    @PostConstruct
    public void initialize() {
        System.out.println("@PostConstruct Initialize");
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("@PreDestroy Cleanup");
    }
}

@Component
class SomeDependency{

    public void getReady() {
        System.out.println("[getReady] Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {
        try (
                var context =
                        new AnnotationConfigApplicationContext
                                (PrePostAnnotationsContextLauncherApplication.class);
        ) {
                Arrays.stream(context.getBeanDefinitionNames())
                        .forEach(System.out::println);
        }
    }
}
