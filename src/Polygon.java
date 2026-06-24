import java.util.Arrays;

public class Polygon {

    private Point[] points;

    public Polygon(Point[] points) {
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point(points[i]);
        }
    }

    public Polygon(Polygon other) {
        this.points = new Point[other.points.length];

        for(int i = 0; i < points.length; i++) {
            this.points[i] = new Point(other.points[i]);
        }
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    public String toSvg() {
        String result = "<polygon points=\"";

        for (Point p : points) {
            result += p.getX() + "," + p.getY() + " ";
        }

        result += "\" fill=\"none\" stroke=\"black\" />";

        return result;
    }
    public BoundingBox boundingBox() {
        Point pointXY = new Point();
        double x = points[0].getX();
        double y = points[0].getY();
        double xMax = x;
        double yMin = y;
        for(Point point : points) {
            if(point.getX() < x) {
                x = point.getX();
            }
            if(point.getY() > y) {
                y = point.getY();
            }
        }
        pointXY.translate(x, y);
        for(Point point : points) {
            if(point.getX() > x) {
                xMax = point.getX();
            }
            if(point.getY() < y) {
                yMin = point.getY();
            }
        }
        return new BoundingBox(x, y, xMax - x, y - yMin);
    }
}
