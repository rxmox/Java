//Exercise 2.3
class Animal {
    //instance variables
    private int legs = 4;  //default value for legs
    private String color;  //color of the animal

    //constructor with color and number of legs
    public Animal(String color, int legs){
        this.color = color;
        this.legs = legs;
    }

    //constructor with color only
    public Animal(String color)
    {
        this.color = color;
    }

    public void setLegs(int legs)
    {
        this.legs = legs;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public int getLegs() {
        return legs;
    }

    public String getColor(){
        return color;
    }

    // The main method to test the Animal class functionality
    public static void main(String[] args) {
        Animal myPet = new Animal("brown", 4);
        System.out.println("My pet has " + myPet.getLegs() + " legs and is " + myPet.getColor());

        Animal myWildlife = new Animal("gray");
        //myWildlife.setColor("gray");
        myWildlife.setLegs(4);
        System.out.println("The wild animal has " + myWildlife.getLegs() + " legs and is " + myWildlife.getColor());
    }

}