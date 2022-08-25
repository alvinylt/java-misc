package RoutePlanner;

import java.util.ArrayList;
import java.util.List;

public class RoutePlanner {

    List<Location> locations;

    static class Location {
        double xCoord;
        double yCoord;

        Location(double xCoord,double yCoord) {
            this.xCoord = xCoord;
            this.yCoord = yCoord;
        }

        double getX() { return this.xCoord; }

        double getY() { return this.yCoord; }

        @Override
        public String toString() {
            return "(" + this.xCoord + "," + this.yCoord + ")";
        }
    }

    /**
     * Constructor for this class which initiates a new ArrayList,
     * which contains the list of Locations to be visited.
     */
    RoutePlanner() { this.locations = new ArrayList<>(); }

    /**
     * Add a new Location to be visited into the ArrayList of Locations.
     * @param loc a new Location to be visited
     */
    void addLocation(Location loc) { this.locations.add(loc); }

    /**
     * Distance formula helper method.
     * Given two Locations, find the Euclidean distance between them.
     *
     * @param x0 x-coordinate of the starting point
     * @param y0 y-coordinate of the starting point
     * @param x1 x-coordinate of the destination
     * @param y1 y-coordinate of the destination
     * @return the Euclidean distance between the two Locations
     */
    public double calculateDistance(double x0,double y0,double x1,double y1) {
        return Math.sqrt(Math.pow(x1 - x0,2) + Math.pow(y1 - y0,2));
    }

    /**
     * Nearest Neighbour Algorithm.
     * @param startX x-coordinate of the starting Location
     * @param startY y-coordinate of the starting location
     * @return a List of Locations, in the order of visiting
     */
    public List<Location> calculateRoute(double startX,double startY) {
        ArrayList<Location> locToVisit = new ArrayList<>(locations);
        return calcRouteHelper(startX,startY,locToVisit,new ArrayList<>());
    }

    /**
     * Helper method for calculateRoute.
     * Performs recursion to find the route using Nearest Neighbour Algorithm.
     *
     * @param startX x-coordinate of the starting Location
     * @param startY y-coordinate of the starting Location
     * @param locToVisit a List of Locations to be visited
     * @param locVisited a List of Locations already visited
     * @return a List of Locations, in the order of visiting
     */
    public List<Location> calcRouteHelper(double startX,double startY,
                                          ArrayList<Location> locToVisit,
                                          ArrayList<Location> locVisited) {
        if (locToVisit.size() == 0) {
            return locVisited;
        } else {
            Location nextLoc = findNearestLocation(startX,startY,locToVisit);
            locVisited.add(nextLoc);
            locToVisit.remove(nextLoc);
            double newX = nextLoc.getX();
            double newY = nextLoc.getY();
            return calcRouteHelper(newX,newY,locToVisit,locVisited);
        }
    }

    /**
     * Given a Location, find the nearest neighbour.
     * Helper method for calcRouteHelper.
     *
     * @param startX x-coordinate of the starting Location
     * @param startY y-coordinate of the starting Location
     * @param locationsToVisit a List of Locations to be visited
     * @return the nearest neighbour to the starting Location
     */
    Location findNearestLocation(double startX,double startY,
                                 ArrayList<Location> locationsToVisit) {
        Location nextLocation = locationsToVisit.get(0);

        for (Location loc : locationsToVisit) {
            double d1 = calculateDistance(startX,startY,
                    loc.getX(),loc.getY());
            double d2 = calculateDistance(startX,startY,
                    nextLocation.getX(), nextLocation.getY());

            if (d1 < d2) {
                nextLocation = loc;
            }
        }

        return nextLocation;
    }

}
