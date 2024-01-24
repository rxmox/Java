import java.util.Arrays;

public class SimpleArrays {
    String[] stringArray = new String[4]; //4 element array of Strings

    //Constructor with one argument
    public SimpleArrays(String str){
        Arrays.fill(stringArray, str); //populates all elements of instance variable array with the string
    }

    //Zero argument constructor
    public SimpleArrays(){
        Arrays.fill(stringArray, "Hello, World!"); //array populated with default string
    }

    public String arrayConcat(int index){
        if (index < 0 || index >= stringArray.length){
            throw new IndexOutOfBoundsException("Index supplied is outside of bounds");
        }
        String result = new String();
        for (int i = index; i < stringArray.length; i++){
            result += stringArray[i];
            if (i < stringArray.length - 1){
                result += "#";
            }
        }
        return result;
    }

    //if no array index is supplied use 0, overloading
    //calls original method with default index of 0
    public String arrayConcat(){
        return arrayConcat(0);
    }

    public String arrayCrop(int start, int end){
        if (start < 0 || end < 0 || start >= stringArray.length || end >= stringArray.length)
            return ("Fail");
        if (start == end)
            return ("Match");
        if (start > end){
            int temp = start;
            start = end;
            end = temp;
        }
        String result = new String();
        for (int i = start; i <= end; i++){
            result += stringArray[i];
            if (i < stringArray.length - 1)
                result += "#";
        }
        return result;
    }

    public static void main(String[] args){
        SimpleArrays myArray1 = new SimpleArrays();
        String foundResult1 = myArray1.arrayConcat();
        System.out.println(foundResult1);

        SimpleArrays myArray2 = new SimpleArrays();
        String foundResult2 = myArray2.arrayConcat(2);
        System.out.println(foundResult2);

        SimpleArrays myArray3 = new SimpleArrays("Hi you");
        String foundResult3 = myArray3.arrayConcat();
        System.out.println(foundResult3);

        SimpleArrays myArray4 = new SimpleArrays("Hi you");
        String foundResult4 = myArray4.arrayConcat(2);
        System.out.println(foundResult4);

        SimpleArrays myArray5 = new SimpleArrays("Hi you");
        String foundResult5 = myArray5.arrayCrop(0, 2);
        System.out.println(foundResult5);

        SimpleArrays myArray6 = new SimpleArrays("Hi you");
        String foundResult6 = myArray6.arrayCrop(3, 2);
        System.out.println(foundResult6);

        SimpleArrays myArray7 = new SimpleArrays("Hi you");
        String foundResult7 = myArray7.arrayCrop(0, 6);
        System.out.println(foundResult7);

        SimpleArrays myArray8 = new SimpleArrays("Hi you");
        String foundResult8 = myArray8.arrayCrop(3, 3);
        System.out.println(foundResult8);
    }

}



