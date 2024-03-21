import java.util.regex.*;

public class Movement implements FormattedOutput, Cloneable {
    private String action;
    private String direction;
    private static final String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Movement(String movement) throws IllegalArgumentException {
        Matcher matcher = PATTERN.matcher(movement);

        if (matcher.find()) {
            String temp = matcher.group().replace("\"", "");
            String[] tempArr = temp.split(" - ");
            action = Actions.valueOf(tempArr[0].toUpperCase()).toString();
            if(Directions.valueOf(tempArr[1]).name() == null){
                throw new IllegalArgumentException("Direct invalid");
            } else{
                direction = tempArr[1];
            }
        } else {
            throw new IllegalArgumentException("Movement invalid");
        }
    }

    public String getAction() {
        return this.action;
    }

    public String getDirection() {
        return this.direction;
    }

    // implement the method from the FormattedOutput interface
    // return a string in the format "Action: <action>, Direction: <direction>"
    @Override
    public String getFormatted() {
        // Directions enum is used to convert the direction abbreviation to the full spelling
        Directions directionOutput = Directions.E;
        if (this.direction.equals("E")) {
            directionOutput = Directions.E;
        } else if (this.direction.equals("N")) {
            directionOutput = Directions.N;
        } else if (this.direction.equals("NE")) {
            directionOutput = Directions.NE;
        } else if (this.direction.equals("NW")) {
            directionOutput = Directions.NW;
        } else if (this.direction.equals("S")) {
            directionOutput = Directions.S;
        } else if (this.direction.equals("SE")) {
            directionOutput = Directions.SE;
        } else if (this.direction.equals("SW")) {
            directionOutput = Directions.SW;
        } else if (this.direction.equals("W")) {
            directionOutput = Directions.W;
        }
        String output = "Action: " + this.action + ", " + "Direction: " + directionOutput.toString();
        return output;


    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Movement copy = (Movement) super.clone();
        copy.action = this.action;
        copy.direction = this.direction;
        return copy;
    }
}
