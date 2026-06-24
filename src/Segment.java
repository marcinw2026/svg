public class Segment {
    private Point p1;
    private Point p2;

    public double length() {
        return Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2) + Math.pow(p2.getY()-p1.getY(), 2));
    }

    public static Segment longestSegment(Segment[] segments) {
        if(segments == null || segments.length == 0) {
            return null;
        }

        Segment longest = segments[0];

        for(int i = 1; i < segments.length; i++) {
            if (segments[i].length() > longest.length()) {
                longest = segments[i];
            }
        }
        return longest;
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

    public Point getP1() {
        return new Point(p1);
    }

    public Point getP2() {
        return new Point(p2);
    }

    public static class SvgScene {

    }
}
