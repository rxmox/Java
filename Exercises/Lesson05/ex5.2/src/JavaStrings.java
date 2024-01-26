public class JavaStrings {

    public int addTogether(String string1, String string2){
        // Trim the strings
        String trimmedString1 = string1.trim();
        String trimmedString2 = string2.trim();
        // Concatenate the trimmed strings
        String concatenatedString = trimmedString1 + trimmedString2;
        // Return the length of the concatenated string
        return concatenatedString.length();
    }

    public String idProcessing(String firstName, String lastName, String petName,
                                                                    int year){
        // Extract the initials
        String initials = firstName.substring(0, 1) + lastName.substring(0, 1) + petName.substring(0, 1);
        return initials.toUpperCase()+year;
    }

    public String secretCode(String ingredient){
        // Replace vowels with 'z' and use only the first three letters
        String vowels = "aeiouAEIOU";
        String secretCode = "";

        for (int i = 0; secretCode.length() < 3; i++) {
            char currentChar = ingredient.charAt(i);
            //indexOf returns a value greater than or equal to 0 if currentChar is a vowel
            if (vowels.indexOf(currentChar) >= 0) {
                secretCode += 'z';
            } else {
                secretCode += currentChar;
            }
        }
        // Return the secret code in uppercase
        return secretCode;
    }

    public static void main(String args[]) {
        JavaStrings myObject = new JavaStrings();

        // Print out examples from addTogether.
        String oneExample = "12 4 6789";
        String twoExample = "abcdef gh";
        int theLength = myObject.addTogether(oneExample,twoExample);
        System.out.println(theLength);

        // Length is unchanged by adding whitespace to front and back
        oneExample = "   " + oneExample + "\n";
        twoExample = "\t" + twoExample;
        theLength = myObject.addTogether(oneExample,twoExample);
        System.out.println(theLength);

        // Print out example of idProcessing
        String personFirst = "Dorothy";
        String personLast = "Gale";
        String petName = "Toto";
        int petBirth = 1899;
        String theID = myObject.idProcessing(personFirst,personLast,
                petName,petBirth);
        System.out.println(theID);

        // Print out examples from secretCode
        String ingredientOne = "tomato";
        String ingredientTwo = "WATER";
        String theCode = myObject.secretCode(ingredientOne);
        System.out.println(theCode);
        theCode = myObject.secretCode(ingredientTwo);
        System.out.println(theCode);
    }
}