import java.util.ArrayList;

public class Elevator {
    private int currentFloor;
    private int totalTravelTime = 0;
    private final ArrayList<Integer> floorsVisited = new ArrayList<>();
    private final ArrayList<Integer> floorsToVisit;

    // Constructor
    Elevator(int currentFloor, ArrayList<Integer> floorsToVisit) {
        this.floorsToVisit = floorsToVisit;
        this.currentFloor = currentFloor;
    }

    void go() {

        // ensure input is valid i.e. no negative values for floors
        if (!inputIsValid()) {
            System.out.println("input invalid");
            return;
        }

        // maintain list of floors remaining to visit, so that visited floors can be removed from list
        ArrayList<Integer> floorsLeftToVisit = floorsToVisit;

        while (!floorsToVisit.isEmpty()) {
            if (floorsLeftToVisit.contains(currentFloor)) {
                floorsVisited.add(currentFloor);
                floorsLeftToVisit.remove(Integer.valueOf(currentFloor));
            }
            // if floorsToVisit contains a floor above us, go up
            if (higherFloorLeftToVisit(floorsToVisit, currentFloor)) {
                goUp();
            }
            else { // there are no more floors above us that need to be visited
                goDown();
            }
        }
        // once we have visited all requested floors, go to bottom
        goToBottom(currentFloor);
    }

    void goUp() {
        totalTravelTime += 10;
        currentFloor++;
    }

    void goDown() {
        totalTravelTime += 10;
        currentFloor--;
    }

    void goToBottom(int currentFloor) {
        totalTravelTime += (currentFloor - 1) * 10;
        this.currentFloor = 1;
    }

    boolean higherFloorLeftToVisit(ArrayList<Integer> floorsToVisit, int currentFloor) {
        for (Integer integer : floorsToVisit) {
            if (integer > currentFloor) {
                return true;
            }
        }
        return false;
    }

    boolean inputIsValid() {
        if (currentFloor < 0) {
            return false;
        }
        for (Integer floor : floorsToVisit) {
            if (floor<=0) {
                return false;
            }
        }
        return true;
    }

    public int getTotalTravelTime() {
        return totalTravelTime;
    }

    public ArrayList<Integer> getFloorsVisited() {
        return floorsVisited;
    }
}
