import becker.robots.*;
import java.util.HashSet;

/**
 * A painting bot using 'flood fill algorithm' that is recursive in nature. 
 * The bot has a filling method using both DFS and BFS.
 * TODO: explain the difference in using BFS and DFS for this algorithm.
 */
public class PainterBot extends DaveSoftware {
    //dimension of the current city
    private final int avenues, streets;
    private final City city;

    public PainterBot(City city, int avenues, int streets) {
        super(city, 2, 6);
        this.city = city;
        this.avenues = avenues;
        this.streets = streets;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x <= avenues && y >= 0 && y <= streets;
    }

    private boolean isValid(Point p) {
        return isValid(p.x, p.y);
    }
   
    public void fill_DFS() {
        if (!isValid(getCurrent()) || canPickThing()) {
            return;
        }
        HashSet<Point> visited = new HashSet<>();
        Point start = getCurrent();
        dfs(start.x, start.y, visited);
    } 

    private void dfs(int x, int y, HashSet<Point> visited) {
        Point p = new Point(x, y);
        if (!isValid(p) || visited.contains(p)) {
            return;
        }
        goTo(p);
        visited.add(new Point(x, y));
        if (canPickThing()) return;
        new Thing(city, y, x); 
        //check adjacent points
        dfs(x-1, y, visited);
        dfs(x, y-1, visited);
        dfs(x+1, y, visited);
        dfs(x, y+1, visited);
    }
}
