package com.ride.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
        return new Person(name, age, address);
    }
    @Bean(name = "address2")
    @Primary
    public Address address() {
        var address = new Address("street", "city");
        return address;
    }
    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        var address = new Address("street3", "city3");
        return address;
    }
}
