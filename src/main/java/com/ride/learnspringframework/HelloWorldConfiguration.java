package com.ride.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age) {};

record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "MyName";
    }
    @Bean
    public int age() {
        return 20;
    }

    @Bean
    public Person person() {
        var person = new Person("A", 21);
        return person;
    }

    @Bean
    public Address address() {
        var address = new Address("street", "city");
        return address;
    }
}
