import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    // assumptions:
    // - valid floor numbers are > 0
    // - the 1st argument provided (via command line) will be assumed to be current floor
    // - the remaining arguments provided will be assumed to be the floors to visit
    // - if no arguments are provided, sample values will be used

    public static void main(String[] args) {

        int currentFloor;
        ArrayList<Integer> floorsToVisit = new ArrayList<>();

        if (args.length > 0) {
            currentFloor = Integer.parseInt(args[0]);
            for (String arg : args) {
                floorsToVisit.add(Integer.parseInt(arg));
            }
        } else {
            // set starting floor if none was provided
            currentFloor = 13;
            // set floors to visit if none was provided
            floorsToVisit = new ArrayList<>(Arrays.asList(5, 16, 2, 8, 12));
        }

        Elevator elevator = new Elevator(currentFloor, floorsToVisit);
        elevator.go();

        System.out.println("floors visited: " + elevator.getFloorsVisited());
        System.out.println("total time taken (seconds): " + elevator.getTotalTravelTime());
    }
}