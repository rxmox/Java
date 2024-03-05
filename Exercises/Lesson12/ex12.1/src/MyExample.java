
class Animal {
//  private int age;
    protected int age;

    public Animal(int age) {
        this.setAge(age);
    }

    public Animal() {
    }

    public int getYears() {
        return this.age;
    }

//    public int getAge() {
//        return this.age;
//    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("Nom nom nom");
    }
}

class Reptile extends Animal {
    private String scales;

    public Reptile(int age) {
        super(age);
    }

    public Reptile(int age, String scales) {
        super(age);
        setScales(scales);
    }


    public String getScales() {
        return this.scales;
    }

    public void setScales(String scales) {
        this.scales = scales;
    }
}

public class MyExample {
    public static void  main(String[] args) {
        Reptile chameleon = new Reptile(2, "multi-hued");
        Reptile gecko = new Reptile(1);

        System.out.println("Chameleons are " +
                chameleon.getScales() + " and " +
                "this one is " + chameleon.getYears() +
                " years old.");

        System.out.println("This gecko is " +
                gecko.getYears() + " years old and is" +
                " enjoying a meal.");
        gecko.eat();

        // We can also still use the Animal class without
        // using the Reptile class.
        Animal horse = new Animal(7);
        System.out.println("Our horse is " +
                horse.getYears() + " years old.");
    }
}