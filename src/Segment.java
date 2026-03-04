public class Segment {
    public Point p1;
    public Point p2;

    public double length() {
        return Math.sqrt(Math.pow(p2.x-p1.x) + Math.pow(p2.y-p1.y));
    }

    public static Segment longestSegment(Segment[] segments) {
        if (segments == null || segments.length == 0) {
            return null;
        }
        Segment longest = segments[0];

        for (int i = 1; i < segments.length; i++) {
            if (segments[i].length() > longest.legth()) {
                longest = segments[i];
            }
        }
        return longest;
    }
}
