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

        for(int i = 0; i < other.points.length; i++) {
            this.points[i] = new Point(other.points[i]);
        }
    }

    @Override
    public String toString() {

        String text = "";

        for (Point p : points) {
            text += p + "\n";
        }

        return text;
    }

    public String toSvg() {

        String svg = "<polygon points=\"";

        for (Point p : points) {
            svg += p.getX() + "," + p.getY() + " ";
        }

        svg += "\" fill=\"none\" stroke=\"black\" />\n";

        return svg;
    }
    public BoundingBox boundingBox() {

        double minX = points[0].getX();
        double maxX = points[0].getX();
        double minY = points[0].getY();
        double maxY = points[0].getY();

        for (Point p : points) {

            if (p.getX() < minX)
                minX = p.getX();

            if (p.getX() > maxX)
                maxX = p.getX();

            if (p.getY() < minY)
                minY = p.getY();

            if (p.getY() > maxY)
                maxY = p.getY();
        }

        return new BoundingBox(
                minX,
                minY,
                maxX - minX,
                maxY - minY
        );
    }
}
