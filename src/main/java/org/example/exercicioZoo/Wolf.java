package org.example.exercicioZoo;

public class Wolf extends Animal implements RunnableAnimal{
    @Override
    public void makeSound() {
        System.out.println("Auuuuuu!");
    }

    @Override
    public void run(){
        System.out.println("Wolf is running!");
    }
}