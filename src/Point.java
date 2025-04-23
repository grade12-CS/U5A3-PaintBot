
/**
 * A Point class to pick out location easily on the map 
 */
public class Point {
    /**
     * x and y coordinates of a point
     */
    public final int x, y; 

    /**
     * creates a point
     * @param x x-coordinate of a point
     * @param y y-coordinate of a point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * creates a zero point. 
     * both x and y coordinates are 0.
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * checks if current point is equal to other object or point
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    /**
     * it is essential to override hashCode() to use Point as a key in java sets
     */
    @Override
    public int hashCode() {
        return 31 * (31 + x) + y;
    }

    /**
     * converts current point in string formatted
     */
    @Override
    public String toString() {
        return "x: " + this.x + " y: "+ this.y;
    }
}
