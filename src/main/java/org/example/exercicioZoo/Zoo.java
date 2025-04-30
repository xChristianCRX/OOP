package org.example.exercicioZoo;

public class Zoo {
    public static void main(String[] args) {
        Animal[] animals = {
                new Lion(),
                new Wolf(),
                new Owl(),
                new Lion(),
                new Owl(),
                new Wolf(),
                new Lion(),
                new Wolf(),
                new Owl(),
                new Lion()
        };

        for(Animal animal : animals) {
            animal.makeSound();
            if(animal instanceof RunnableAnimal) {
                ((RunnableAnimal) animal).run();
            }
        }
    }
}
