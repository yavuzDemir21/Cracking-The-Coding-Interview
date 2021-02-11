package stacksandqueues;
/*
An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out"basis. People must
adopt either the"oldest"(based on arrival time) of all animals at the shelter, or they can select whether they would
prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal
they  would like. Create the data structures to maintain this system and implement operations such as enqueue,
dequeueAny, dequeueDog, and dequeueCat. You may use the built-in Linkedlist data structure.
*/

import java.util.LinkedList;
import java.util.Queue;

class Animal{
    static int time = 0;
    int arrivalTime;
    String name;
    public Animal(String name){
        this.name = name;
        arrivalTime = ++time;
    }

    public String info(){
        return name + " " + arrivalTime;
    }

}

class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
}

class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}

class AnimalShelter{
    Queue<Dog> dogQueue;
    Queue<Cat> catQueue;
    public AnimalShelter(){
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void enqueue(Animal a){
        if(a instanceof Dog) dogQueue.add((Dog)a);
        if(a instanceof Cat) catQueue.add((Cat)a);
    }

    public Animal dequeueAny(){
        if(catQueue.isEmpty() && dogQueue.isEmpty()) return null;

        if(catQueue.isEmpty()) return dogQueue.remove();
        if(dogQueue.isEmpty()) return catQueue.remove();

        if(catQueue.peek().arrivalTime < dogQueue.peek().arrivalTime){
            return catQueue.remove();
        }else{
            return dogQueue.remove();
        }
    }

    public Dog dequeueDog(){
        if(dogQueue.isEmpty()) return null;
        return dogQueue.remove();
    }

    public Cat dequeueCat(){
        if(catQueue.isEmpty()) return null;
        return catQueue.remove();
    }

}

public class Question6 {
    public static void main(String[] args) {
        AnimalShelter as = new AnimalShelter();

        as.enqueue(new Dog("d1"));
        as.enqueue(new Dog("d2"));
        as.enqueue(new Cat("c1"));
        as.enqueue(new Dog("d3"));
        as.enqueue(new Cat("c2"));
        as.enqueue(new Dog("d4"));

        System.out.println(as.dequeueDog().info());
        System.out.println(as.dequeueAny().info());
        System.out.println(as.dequeueAny().info());
        System.out.println(as.dequeueDog().info());


    }
}
