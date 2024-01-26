import java.util.regex.*;

public class DateNormalizer {

    // Regex pattern to match date-like numbers separated by dash or period
    private static final Pattern DATE_PATTERN = Pattern.compile(
            "(\\d{1,4})[-.](\\d{1,2})[-.](\\d{1,4})"
    );//year could be at the start or at the end

    public String normalizeDate(String dateString) {
        Matcher matcher = DATE_PATTERN.matcher(dateString);

        // Check if the input is a date-like number
        if (!matcher.matches()) {
            return ""; // Return an empty string if not a date-like number
        }

        // Extract year, month, and day components from the match
        String year = matcher.group(1);
        String month = matcher.group(2);
        String day = matcher.group(3);

        // Determine if the year is in the first or last position based on length
        if (year.length() == 2) {
            // If year is 2 digits, assume it's at the end (dd-mm-yy)
            year = day;
            day = matcher.group(1);
        }

        // Normalize to yyyy-mm-dd format, padding with zeros if necessary
        year = year.length() == 2 ? "20" + year : year; // Assuming 21st century for 2 digit years
        month = month.length() == 1 ? "0" + month : month;
        day = day.length() == 1 ? "0" + day : day;

        return year + "-" + month + "-" + day;
    }

    public static void main(String[] args) {
        DateNormalizer normalizer = new DateNormalizer();

        // Example inputs
        String[] dates = {"2021-12-16", "2022.01.15", "15-01-2022", "16.12.2021", "14.32.2021", "3 Jan 2022"};

        // Normalize each date and print the result
        for (String date : dates) {
            System.out.println(normalizer.normalizeDate(date));
        }
    }
}
