//package edu.ucalgary.oop;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.*;

public class RobotDataLine implements Cloneable {
    private String dataLine;
    private String robotID;
    private Sensor sensor;
    private Movement movement;
    private LocalDate date;
    private static final String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
    private static final String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
    private static final Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

    public RobotDataLine(String line) throws IllegalArgumentException{
        this.dataLine = line;
        this.sensor = new Sensor(this.dataLine);
        this.movement = new Movement(this.dataLine);

        Matcher dateMatcher = DATE_PATTERN.matcher(this.dataLine);
        Matcher robotMatcher = ROBOT_PATTERN.matcher(this.dataLine);
        
        if(robotMatcher.find()) {
        	this.robotID = robotMatcher.group(1);
        }
        else { throw new IllegalArgumentException("Robot invalid"); }
    



        if (dateMatcher.find()) {
            String unformatted = dateMatcher.group().substring(1, dateMatcher.group().length() - 1).replace("/", "-");
            String formatted = unformatted.substring(6, 10) + unformatted.substring(2, 6) + unformatted.substring(0, 2);
            try{
            this.date = LocalDate.parse(formatted);
            } catch (DateTimeParseException e){
                throw new IllegalArgumentException("Date is Invalid!");
            }
        } else {
            throw new IllegalArgumentException("Date is Invalid!");
        }


    }

    public String getRobotID() {
        return this.robotID;
    }

    public String getDataLine() {
        return this.dataLine;
    }

    public Sensor getSensor() {
        return this.sensor;
    }

    public Movement getMovement() {
        return this.movement;
    }

    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        RobotDataLine copy = (RobotDataLine) super.clone();
        copy.dataLine = this.dataLine;
        copy.robotID = this.robotID;
        copy.sensor = (Sensor) this.sensor.clone();
        copy.movement = (Movement) this.movement.clone();
        copy.date = this.date;
        return copy;
    }
}
