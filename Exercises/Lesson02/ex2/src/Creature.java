/**
 @author Omar Ahmed  <a href="mailto:omar.ahmed@ucalgary.ca">omar.ahmed@ucalgary.ca</a>
 @version  1.3
 @since 1.0
 */

//Slide 6
//public class Creature{
//    /**
//     * @param args Handles command-line argument
//     */
//    public static void main(String[] args){
//        System.out.println("This is a placeholder for Creature " + args[0]);
//    }
//}

//Slide 10
//public class Creature {
//    /**
//     * @param args Handles an optional command-line argument
//     */
//    public static void main(String[] args){
//        System.out.print("This is a placeholder for ");
//        for (int i = 0; i < args.length; i++)
//            System.out.print(args[i] + " ");
//        System.out.println();
//    }
//}


//Slide 11
//public class Creature {
//    /**
//     * @param args Handles a single command-line argument
//     */
//    public static void main(String[] args){
//        if (args.length == 0){
//            throw new IllegalArgumentException("You must supply a command line argument");
//        } else{
//            System.out.println("This is a placeholder for Creature " + args[0]);
//        }
//    }
//}

//slide 12
//public class Creature {
//    public static void main(String[] args){
//        String myAnimalType = animal();
//        System.out.println("This is a placeholder for Creature " + myAnimalType);
//    }
//
//    static String animal(){
//        String animalType = "dog";
//        return animalType;
//    }
//}

//slide 16 and exercise 2.2
//public class Creature {
//    public static void main(String[] args){
//        Animal myAnimal = new Animal();
//        String myType = myAnimal.animalType(); //accesses the animalType of myAnimal
//        System.out.println("This is a placeholder for Creature " + myType);
//    }
//
//}
//
//class Animal{
//    private String animalType = "dog";
//
//    public String animalType(){  //creates a method called animalType
//        return animalType;
//    }
//}

//Slide 21
//public class Creature {
//    public static void main(String[] args){
//        Animal myPet = new Animal();
//        myPet.setAnimalType("mouse");
//        Animal myWildlife = new Animal();
//        myWildlife.setAnimalType("deer");
//
//        System.out.println("I have a pet " + myPet.getAnimalType());
//        System.out.println("I see a " + myWildlife.getAnimalType() + " outside");
//    }
//
//}
//
//class Animal{
//    private String animalType;
//
//    public void setAnimalType(String arg){
//        animalType = arg;
//    }
//
//    public String getAnimalType(){
//        return animalType;
//    }
//}

//slide 34
//public class Creature {
//    public static void main(String[] args){
//        Animal myPet = new Animal ("mouse");
//        Animal myWildlife = new Animal ("deer");
//
//        System.out.println("I have a pet " + myPet.getAnimalType());
//        System.out.println("I see a " + myWildlife.getAnimalType() + " outside");
//    }
//
//}
//
//class Animal{
//    private String animalType;
//
//    public Animal(String givenType){
//        animalType = givenType;
//    }
//    public void setAnimalType(String arg){
//        animalType = arg;
//    }
//
//    public String getAnimalType(){
//        return animalType;
//    }
//}

//slide 35, Multiple Arguments
//public class Creature {
//    /**
//     @param args Ignored command-line argument
//     */
//    public static void main(String[] args) {
//        Animal myPet = new Animal("mouse");
//        myPet.setAnimalTypeKingdom("deer", "animalia");
//
//        System.out.println(myPet.getAnimalType() + " is an " + myPet.getAnimalKingdom());
//    }
//}
//
//class Animal {
//    private String animalType;
//    private String animalKingdom;
//
//    public Animal(String givenType)
//    {
//        animalType = givenType;
//    }
//
//    public String getAnimalType() {
//        return animalType;
//    }
//
//    public String getAnimalKingdom() {
//        return animalKingdom;
//    }
//
//    public void setAnimalTypeKingdom(String type, String kingdom)
//    {
//        animalType = type;
//        animalKingdom = kingdom;
//    }
//}

//Slide 36, Overloading and 'This'
//public class Creature {
//    /**
//     @param args Ignored command-line argument
//     */
//    public static void main(String[] args) {
//        Animal myPet = new Animal();
//        myPet.setAnimalKingdom("animalia");
//        System.out.println(myPet.getAnimalType() + " is an " + myPet.getAnimalKingdom());
//
//        myPet.setAnimalTypeKingdom("deer", "animalia");
//        System.out.println(myPet.getAnimalType() + " is an " + myPet.getAnimalKingdom());
//    }
//}

//class Animal {
//    private String animalType;
//    private String animalKingdom;
//
//    public Animal(String animalType)
//    {
//        this.animalType = animalType;
//    }
//
//    public Animal()
//    {
//        this("mouse");
//    }
//
//    public void setAnimalTypeKingdom(String type, String kingdom)
//    {
//        this.setAnimalType(type);
//        this.setAnimalKingdom(kingdom);
//    }
//
//    public void setAnimalKingdom(String kingdom)
//    {
//        this.animalKingdom = kingdom;
//    }
//
//    public void setAnimalType(String animalType)
//    {
//        this.animalType = animalType;
//    }
//
//    public String getAnimalType() {
//        return animalType;
//    }
//
//    public String getAnimalKingdom() {
//        return animalKingdom;
//    }
//}

