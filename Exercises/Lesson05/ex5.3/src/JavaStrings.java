import java.util.regex.*;

public class JavaStrings {
    public static void main(String[] args) {
        String myString = "ENSF Principles of Software Development";

        //using reg ex count how many instances of E are in String
        Pattern myPattern = Pattern.compile("E", Pattern.CASE_INSENSITIVE);
        Matcher myMatcher = myPattern.matcher(myString);
        int matchCount = 0;
        while (myMatcher.find())
            matchCount++;
        System.out.println(matchCount);

        System.out.println();

        //using split() to count and print each token in the string when delimited by whitespace
        String[] tokenizedArray = myString.split(" ", 0);
        System.out.println("Number of tokens: " + tokenizedArray.length);
        for (String value: tokenizedArray)
            System.out.println(value);

        System.out.println();

        //using StringBuilder to insert a colon after "ENSF" and printing updated statement
        StringBuilder updatedString = new StringBuilder(myString);
        updatedString.insert(4,":");
        System.out.println(updatedString);
    }
}