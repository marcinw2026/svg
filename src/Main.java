public class Main {
    public static void main(String[] args) {
        Polygon p1 = new Polygon(new Point[]{
                new Point(10, 10),
                new Point(100, 10),
                new Point(50, 80)
        });

        Polygon p2 = new Polygon(new Point[]{
                new Point(150, 100),
                new Point(250, 100),
                new Point(250, 200),
                new Point(150, 200)
        });

        SvgScene scene = new SvgScene();

        scene.addPolygon(p1);
        scene.addPolygon(p2);

        scene.save("scene.svg");
    }

}