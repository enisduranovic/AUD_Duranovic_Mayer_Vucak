import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScalePicture {
    public void resize(String link, String saveToFilePath) throws IOException {
        File jpgPicture = new File(link);
        File jpgResized = new File(saveToFilePath);
        resizedImage(jpgPicture, jpgResized, 500, 500, "jpg");
    }

    public void resizedImage(File originalImage, File resizedImage, int width, int height, String format) throws IOException {
        BufferedImage original = ImageIO.read(originalImage);
        BufferedImage resized = new BufferedImage(width, height, original.getType());
        Graphics2D g2 = resized.createGraphics();
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();
        ImageIO.write(resized, format, resizedImage);
    }
}

