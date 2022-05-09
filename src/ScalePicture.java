import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScalePicture {
    static String pathStart = "D:/AUD/Bilder/";
    static String pathEnd;
    static String pathFull;
    static String pathFullR;

    public static void main(String[] args) throws IOException {
        File jpgOriginal = new File(downloadPicture());
        pathFullR = pathStart + "R" + pathEnd;
        System.out.println("R:" + pathFullR);
        File jpgResized = new File(pathFullR);
        resizedImage(jpgOriginal, jpgResized, 500, 500, "jpg");
    }

    public static void resizedImage(File originalImage, File resizedImage, int width, int height, String format) throws IOException {
        BufferedImage original = ImageIO.read(originalImage);
        BufferedImage resized = new BufferedImage(width, height, original.getType());
        Graphics2D g2 = resized.createGraphics();
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();
        ImageIO.write(resized, format, resizedImage);
    }

    public static String downloadPicture() {
        String link = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/123_280E_0477110307_%2814wik%29.JPG/1200px-123_280E_0477110307_%2814wik%29.JPG";
        String linkLastTen = link.substring(link.length()-10);
        pathEnd = linkLastTen;
        pathFull = pathStart + linkLastTen;
        System.out.println("pathFull" + pathFull);
        String savePath = pathFull;
        try(InputStream in = new URL(link).openStream()){
            Files.copy(in, Paths.get(savePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savePath;
    }
}

