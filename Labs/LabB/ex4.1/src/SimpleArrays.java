// The class has an instance variable (a 4-element array of Strings)
// • Has a constructor which can be called with one argument: a String
// – Uses the java.util.Arrays method fill to populate all elements of the instance variable
// array with the String
// • Overloads the constructor with a zero argument version
// – The array is populated with the default String "Hello, world"

// • Provides a method arrayConcat
// – Accepts an array index; if no array index is supplied, 0 is used by default
// – If the index which is supplied is outside the bounds of the array, an IndexOutOfBoundsEx-
// ception should be thrown (any message may be provided). We have not yet studied catching
// errors, so do not catch the error even if you know how to do it.
// – Returns a String consisting of all the elements of the array, from the provided index to the
// end, concatenated, separated by the # character (no whitespace should be introduced)


// • Provides a method arrayCrop
// – Accepts two integers as arguments, corresponding to starting and ending array indices. The
// starting and ending indices are inclusive.
// – Returns a String consisting of all the elements between the two indices specified, concate-
// nated, separated by the # character (no whitespace should be introduced)
// – If the ending integer is smaller than the starting integer, switch the two (use the start as the
// end, and the end as the start)
// – If either integer is not a valid index, return "Fail"
// – If the two integers are the same, return "Match


import java.util.Arrays;

public class SimpleArrays {
  private String[] stringArray = new String[4]; // Instance variable

  // Constructor with one argument
  public SimpleArrays(String str) {
      Arrays.fill(stringArray, str); //method fill to populate all elements of the instance variable
  }

  // Zero argument constructor
  public SimpleArrays() { // Overloaded constructor
      this("Hello, world"); // The array is populated with the default String "Hello, world"
  }


  // Overloaded arrayConcat with default index 0
public String arrayConcat() {
  return arrayConcat(0);
}

  // arrayConcat method
  public String arrayConcat(int index) { // Accepts an array index; if no array index is supplied, 0 is used by default
    if (index < 0 || index >= stringArray.length) { // If the index which is supplied is outside the bounds of the array, an IndexOutOfBoundsException should be thrown
        throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
    }
    StringBuilder result = new StringBuilder(); //result will have all elements concatenated, separated by the # character
    for (int i = index; i < stringArray.length; i++) {
        result.append(stringArray[i]);
        if (i < stringArray.length - 1) {
            result.append("#");
        }
    }
    return result.toString(); //toString() method returns the string representation of the object
}


// arrayCrop method
public String arrayCrop(int start, int end) {
    if (start == end) {  // If the two integers are the same, return "Match
        return "Match";
    }
    if (start < 0 || end < 0 || start >= stringArray.length || end >= stringArray.length) {
        return "Fail";  // If either integer is not a valid index, return "Fail"
    }
    if (end < start) {  //end integer is smaller than the starting integer, switch the two
        int temp = start;
        start = end;
        end = temp;
    }
    StringBuilder result = new StringBuilder();
    for (int i = start; i <= end; i++) {
        result.append(stringArray[i]);
        if (i < end) {
            result.append("#");
        }
    }
    return result.toString();
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
