import java.util.regex.*;

public class Sensor implements FormattedOutput, Cloneable {
    private String sensor;
    private static final String REGEX = "\\(([a-z]+)\\)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public Sensor(String sensor) throws IllegalArgumentException {
        Matcher matcher = PATTERN.matcher(sensor);
        if (matcher.find()) {
            this.sensor = matcher.group(1);
        }
        else { throw new IllegalArgumentException("Sensor invalid"); }
    }

    public String getSensor() {
        return this.sensor;
    }

    // implement the method from the FormattedOutput interface
    @Override
    public String getFormatted() {
        String output = "Sensor: " + this.sensor;
        return output;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Sensor copy = (Sensor) super.clone();
        copy.sensor = this.sensor;
        return copy;
    }
}