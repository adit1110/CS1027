import java.io.IOException;


    /**
     * 150 word explanation:
     * The PathFinder class is designed to compute a path through the Pyramid Falls National Park.
     * This class utilizes a stack to keep track of the path, implementing a kind of depth-first search strategy.
     * My main approach was to prioritize unmarked treasure chambers, which was then followed by unmarked lighted chambers,
     * and then to finally, work on unmarked dim chambers. I faced major challenges in designing an efficient mechanism to select the
     * next chamber to visit based on the given priority criteria. However though, I was able to overcome this by examining
     * the neighbors of the current chamber and applying the conditions sequentially. The 'bestChamber' function is
     * instrumental in achieving this. For testing, I utilized several maps with varying configurations of chambers, alongside the given test cases.
     * I also had manually traced the expected output path for these maps and compared them with the program's output to ensure correctness, and I used the debugger to maximize this
     * effort. Hence, as a whole, this program demonstrates a clear understanding of stack data structure, object-oriented programming, and control structures.
     */


    /**
    * This public PathFinder class uses a depth-first search algorithm to navigate a map of a pyramid and find treasures.
    * @author Adit Bhimani
    */
public class PathFinder {
    private Map pyramidMap;
    private int treasuresFound;

    /**
     * This public Pathfinder method initializes a new PathFinder with a given map file.
     *
     * @param fileName the name of the map file
     * @throws IOException if an error occurs when reading the file
     */
    public PathFinder(String fileName) throws IOException {
        Map map = new Map(fileName);
        pyramidMap = map;
        this.treasuresFound = 0;
    }

    /**
     * This public DLStack method finds the path in the pyramid to collect all treasures using a depth-first search.
     *
     * @return returns a stack representing the path to collect all treasures
     */
    public DLStack<Chamber> path() {
        DLStack<Chamber> pathStack = new DLStack<>();
        Chamber entrance = pyramidMap.getEntrance();
        entrance.markPushed();
        pathStack.push(entrance);

        while(!pathStack.isEmpty()) {
            Chamber current = pathStack.peek();
            if(current.isTreasure() && pyramidMap.getNumTreasures() == treasuresFound) {
                break;
            }
            Chamber next = bestChamber(current);
            if(next != null) {
                pathStack.push(next);
                next.markPushed();
                if(next.isTreasure())
                    treasuresFound++;
            } else {
                current = pathStack.pop();
                current.markPopped();
            }
        }

        return pathStack;
    }

    /**
     * This public getMap method returns the map being used by the PathFinder.
     *
     * @return returns the pyramid map
     */
    public Map getMap() {
        return this.pyramidMap;
    }

    /**
     * This public boolean isDim method checks whether a given chamber is dim.
     *
     * @param currentChamber the chamber to check
     * @return returns true if the chamber is dim; false otherwise
     */
    public boolean isDim(Chamber currentChamber) {
        if(currentChamber == null || currentChamber.isSealed() || currentChamber.isLighted()) {
            return false;
        }

        for(int i = 0; i < 6; i++) {
            int index = 0;
            Chamber neighbor = currentChamber.getNeighbour(index);
            if(neighbor.isLighted()) {
                return true;
            }
        }

        return false;
    }

    /**
     * This public bestChamber method finds the best chamber to go to from the current chamber.
     *
     * @param currentChamber the current chamber
     * @return returns the best neighboring chamber to go to
     */
    public Chamber bestChamber(Chamber currentChamber) {
        Chamber unmarkedTreasureChamber = null;
        Chamber unmarkedLightedChamber = null;
        Chamber unmarkedDimChamber = null;

        for(int i = 0; i < 6; i++) {
            int index = 0;
            Chamber neighbor = currentChamber.getNeighbour(index);

            if(neighbor.isMarked()) {
                continue;
            }

            if(neighbor.isTreasure() && unmarkedTreasureChamber == null) {
                unmarkedTreasureChamber = neighbor;
                continue;
            }

            if(neighbor.isLighted() && unmarkedLightedChamber == null) {
                unmarkedLightedChamber = neighbor;
                continue;
            }

            if(isDim(neighbor) && unmarkedDimChamber == null) {
                unmarkedDimChamber = neighbor;
            }
        }

        if(unmarkedTreasureChamber != null) {
            return unmarkedTreasureChamber;
        } else if(unmarkedLightedChamber != null) {
            return unmarkedLightedChamber;
        } else {
            return unmarkedDimChamber;
        }
    }

}
