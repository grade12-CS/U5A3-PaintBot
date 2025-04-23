import becker.robots.*;
import java.util.HashSet;

/**
 * A painting bot using 'flood fill algorithm' that is recursive in nature. 
 * The bot has a filling method using both DFS and BFS.
 * TODO: explain the difference in using BFS and DFS for this algorithm.
 */
public class PainterBot extends DaveSoftware {

    public PainterBot(City city, int y, int x) {
        super(city, y, x);
    }
}
