import java.util.ArrayList;

public class RobotDataRecord implements Cloneable {
    private ArrayList<RobotDataLine> log = new ArrayList<RobotDataLine>();

    public RobotDataRecord(String[] array) {
        for (int i = 0; i < array.length; i++) {
            RobotDataLine newEntry;
            try{
                newEntry = new RobotDataLine(array[i]);
            } catch (IllegalArgumentException exceptions){
                continue;
            }
            this.log.add(newEntry);
        }
    }

    public RobotDataLine getLine(int index) {
        return this.log.get(index);
    }

    public ArrayList<RobotDataLine> getDataRecord() {
        return this.log;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        RobotDataRecord copy = (RobotDataRecord) super.clone();
        copy.log = new ArrayList<RobotDataLine>();
        for (RobotDataLine line : this.log) {
            copy.log.add((RobotDataLine) line.clone());
        }
        return copy;
    }
}
