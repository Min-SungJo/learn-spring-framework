package com.ride.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address) {};

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
        return new Person("A", 21, new Address("main street", "city2"));
    }
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }
    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }
    @Bean(name = "address2")
    public Address address() {
        var address = new Address("street", "city");
        return address;
    }
    @Bean(name = "address3")
    public Address address3() {
        var address = new Address("street3", "city3");
        return address;
    }
}
