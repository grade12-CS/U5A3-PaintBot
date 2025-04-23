import becker.robots.*;
import java.util.HashSet;

/**
 * A robot fills area using 'flood fill algorithm'.
 * The algorithm was implemented with Depth First Search (DFS) algorithm that is recursive in nature. 
 * There are different ways to achieve flood filling, which normally uses Breadth First Search (BFS) and DFS algorithms. 
 * DFS searches as deeply as possible, where as BFS searches level by level.
 * Generally, BFS is more efficeint and preferred algorithm for flood filling, as it fills area from starting point across all directions simultaneously.
 * But in this project, we have only one robot and I don't want to create bunch of dummy robots to achieve this.
 * Hence, I used DFS, which fills area lien by line.
 */
public class PaintBot extends DaveSoftware {
    //dimension of the current city
    private final int avenues, streets;
    //stores the city in which a robot was created.
    private final City city;

    /**
     * 
     * @param city the city of canvas to spawn a robot
     * @param avenues the width of city where points created less or equal to this width value and greater than zero will be valid.
     * @param streets the height of city where points created less or equal to this height value and greater than zero will be valid.
     */
    public PaintBot(City city, int avenues, int streets) {
        super(city, 2, 6);
        this.city = city;
        this.avenues = avenues;
        this.streets = streets;
    }

    /**
     * checks if a point is in a valid range.
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     * @return true if valid, false if not
     */
    private boolean isValid(int x, int y) {
        return x >= 0 && x <= avenues && y >= 0 && y <= streets;
    }

    /**
     * checks if a point is in a valid range.
     * @param p point to check its validity
     * @return true if valid, false if not
     */
    private boolean isValid(Point p) {
        return isValid(p.x, p.y);
    }
   
    /**
     * paint a polygon by recursively creating thing. 
     */
    public void paint() {
        if (!isValid(getCurrent()) || canPickThing()) {
            return;
        }
        HashSet<Point> visited = new HashSet<>();
        Point start = getCurrent();
        dfs(start.x, start.y, visited);
    } 

    /**
     * a recursive flood filling method using DFS algorithm.
     * @param x x-coordinate of point to check or paint
     * @param y y-coordinate of point to check or paint
     * @param visited A hash set shared by points and storing visited points. This is used to check if a point is visited or not.
     */
    private void dfs(int x, int y, HashSet<Point> visited) {
        Point p = new Point(x, y);
        if (!isValid(p) || visited.contains(p)) {
            return;
        }
        goTo(p);
        visited.add(new Point(x, y));
        //if already painted or reached an edge, don't paint that point
        if (canPickThing()) return;
        //paint by creating a thing
        new Thing(city, y, x); 

        //check or paint adjacent points
        dfs(x-1, y, visited);
        dfs(x, y-1, visited);
        dfs(x+1, y, visited);
        dfs(x, y+1, visited);
    }
}
