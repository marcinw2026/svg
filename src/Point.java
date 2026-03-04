public class Point {
    private double x=5;
    private double y=10;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(Point oldPoint) {
        this.x = oldPoint.getX();
        this.y = oldPoint.getY();
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        String napis = "x=" + x + " y=" + y;
        return napis;
    }

    public String toSvg() {
        String napis = "<circle r=\"45\" cx=\"" + x +  "\" cy=\"" + y + "\" fill=\"red\" />";
        return napis;
    }

    public void translate(double dx, double dy) {
        x = x + dx;
        y = y + dy;
    }

    public Point translated(double dx, double dy) {
        Point point = new Point();
        point.x = x + dx;
        point.y = y + dy;
        return point;
    }
}
