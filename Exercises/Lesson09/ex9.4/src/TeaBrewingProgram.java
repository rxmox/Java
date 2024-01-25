public class TeaBrewingProgram {

    public static void main(String[] args) {
        Teapot teapot = new Teapot();
        teapot.addWater();
        teapot.insertTeabag("Green tea");
        teapot.brewTea();
        teapot.removeTeabag();
    }
}

class Teapot {
    private boolean hasWater = false;
    private boolean hasTeabag = false;
    private String teaType = "";

    public void addWater() {
        hasWater = true;
        System.out.println("Water has been added to the teapot.");
    }

    public void insertTeabag(String teaType) {
        if (hasWater) {
            this.teaType = teaType;
            hasTeabag = true;
            System.out.println("A teabag of " + teaType + " has been inserted into the teapot.");
        } else {
            System.out.println("Please add water before inserting the teabag.");
        }
    }

    public void brewTea() {
        if (hasWater && hasTeabag) {
            System.out.println("Brewing the " + teaType + "...");
            // Brewing process (time simulation could be added here)
            System.out.println("The " + teaType + " is ready to be served.");
        } else {
            System.out.println("Cannot brew tea. Make sure there is water and a teabag in the teapot.");
        }
    }

    public void removeTeabag() {
        if (hasTeabag) {
            hasTeabag = false;
            System.out.println("Teabag has been removed from the teapot.");
        } else {
            System.out.println("No teabag in the teapot to remove.");
        }
    }
}
