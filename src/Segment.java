public class Segment {
    private Point p1;
    private Point p2;

    public double length() {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Segment longestSegment(Segment[] segments) {

        if (segments.length == 0)
            return null;

        Segment longest = segments[0];

        for (int i = 1; i < segments.length; i++) {
            if (segments[i].length() > longest.length()) {
                longest = segments[i];
            }
        }

        return longest;
    }
}

    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    @Override
    public String toString() {
        return "Segment{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

}
