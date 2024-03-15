
// Superclass that provides basic properties and behaviors that all animals have
class Animal {
//  private int age;
    protected int age;

    //constructor that accepts age and sets it using setAge method
    public Animal(int age) {
        this.setAge(age);
    }

    //no argument constructor that allows for creating an Animal instance
    // without specifying age
    public Animal() {
    }

    //getter for years field
    public int getYears() {
        return this.age;
    }

    //getter for age field
//    public int getAge() {
//        return this.age;
//    }

    //setter for age field
    public void setAge(int age) {
        this.age = age;
    }

    // method that simulates the eating action with a print statement
    public void eat() {
        System.out.println("Nom nom nom");
    }
}
// Inherits from the Animal class using the extends keyword.
class Reptile extends Animal {
    //new field that describes reptiles scales
    private String scales;

    //constructor that accepts age and passes it to Animal's constructor using super
    public Reptile(int age) {
        super(age);
    }

    //constructor that accepts both age and scales
    public Reptile(int age, String scales) {
        super(age);
        setScales(scales);
    }


    // getter method for scales
    public String getScales() {
        return this.scales;
    }

    //setter method for scales
    public void setScales(String scales) {
        this.scales = scales;
    }
}

public class MyExample {
    public static void  main(String[] args) {
        //passes 2 fields, so uses 1st constructor of reptile
        Reptile chameleon = new Reptile(2, "multi-hued");
        //passes 1 field, so uses 2nd constructor of reptile
        Reptile gecko = new Reptile(1);

        //getScales is a method in reptile class
        //getYears is a method in animal class
        //notice how a reptile can access animal methods due to inheritance
        System.out.println("Chameleons are " +
                chameleon.getScales() + " and " +
                "this one is " + chameleon.age +
                " years old.");

        System.out.println("This gecko is " +
                gecko.age + " years old and is" +
                " enjoying a meal.");
        gecko.eat();

        // We can also still use the Animal class without
        // using the Reptile class.
        Animal horse = new Animal(7);
        System.out.println("Our horse is " +
                horse.age + " years old.");
    }
}