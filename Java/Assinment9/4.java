package assignment9;

public interface Animal {
    public void eat();
    public void sleep();
    public void makeSound();
}

package assignment9;

public class Bird implements  Animal{
    @Override
    public void eat() {
        System.out.println("bird is eathing");
    }

    @Override
    public void sleep() {
        System.out.println("bird is sleeping");
    }

    @Override
    public void makeSound() {
        System.out.println("bird is making sound");
    }
}

package assignment9;

public class Cat implements Animal{

    public void eat() {
        System.out.println("cat is eathing");
    }

    @Override
    public void sleep() {
        System.out.println("cat is sleeping");
    }

    @Override
    public void makeSound() {
        System.out.println("cat is purring");
    }
}

package assignment9;

public class Dog implements Animal{

    @Override
    public void eat() {
        System.out.println("dog is eathing");
    }

    @Override
    public void sleep() {
        System.out.println("dog is sleeping");
    }

    @Override
    public void makeSound() {
        System.out.println("dog is barking");
    }
}
