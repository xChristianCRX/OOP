package org.example.exercicioZoo;

public class Lion extends Animal implements RunnableAnimal{
    @Override
    public void makeSound() {
        System.out.println("Rrrrrwaarrr!");
    }
    @Override
    public void run(){
        System.out.println("Lion is running!");
    }
}
