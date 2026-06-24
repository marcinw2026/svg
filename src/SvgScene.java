import java.io.FileWriter;
import java.io.IOException;

public class SvgScene {
    private Polygon[] polygons;
    private int nextIndex;
    public SvgScene() {
        polygons = new Polygon[3];
        nextIndex = 0;
    }

    public void addPolygon(Polygon polygon) {
       polygons[nextIndex] = polygon;
       nextIndex++;
       if(nextIndex == polygons.length) {
           nextIndex = 0;
       }
    }

    public String toSvg() {

        String result = "";

        for (Polygon polygon : polygons) {

            if (polygon != null) {
                result += polygon.toSvg() + "\n";
            }
        }

        return result;
    }

    public void save(String path) {

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;

        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for (Polygon polygon : polygons) {

            if (polygon == null)
                continue;

            BoundingBox box = polygon.boundingBox();

            minX = Math.min(minX, box.x());
            minY = Math.min(minY, box.y());

            maxX = Math.max(maxX, box.x() + box.width());
            maxY = Math.max(maxY, box.y() + box.height());
        }

        double width = maxX - minX;
        double height = maxY - minY;

        String svg =
                "<svg xmlns=\"http://www.w3.org/2000/svg\" " +
                        "width=\"" + width + "\" " +
                        "height=\"" + height + "\" " +
                        "viewBox=\"" +
                        minX + " " +
                        minY + " " +
                        width + " " +
                        height +
                        "\">\n" +

                        toSvg() +

                        "</svg>";

        try (FileWriter writer = new FileWriter(path)) {
            writer.write(svg);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
