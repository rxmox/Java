public class JavaStrings {

    public static void main(String[] args){

        String animalFact1 = "Horses are mammals.";
        String animalFact2 = new String("Elephants are mammals.");
        String animalFact3 = new String(animalFact1);
        String animalFact4 = new String();
        String animalFact5 = new String(animalFact1.toCharArray(), 0, 6);

        System.out.println(animalFact1);
        System.out.println(animalFact2);
        System.out.println(animalFact3);
        System.out.println(animalFact4);
        System.out.println(animalFact5);

        int sum = animalFact1.length() + animalFact2.length() + animalFact3.length()
                +animalFact4.length() + animalFact5.length();

        System.out.println(sum);
    }
}
