import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagenAPNG {
  public static void main(String[] args) {
    try {
      int width = 640, height = 480;

      // TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
      // into integer pixels
      BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

      Graphics2D ig2 = bi.createGraphics();

      ig2.setBackground(Color.BLACK);

      Font font = new Font("TimesRoman", Font.BOLD, 20);
      ig2.setFont(font);
      String message = "Prueba de Imagen";
      FontMetrics fontMetrics = ig2.getFontMetrics();
      int stringWidth = fontMetrics.stringWidth(message);
      int stringHeight = fontMetrics.getAscent();
      ig2.setPaint(Color.white);
      ig2.drawString(message, (width - stringWidth) / 2, height / 2 + stringHeight / 4);

      ImageIO.write(bi, "PNG", new File("yourImageName.PNG"));
    } catch (IOException ie) {
      ie.printStackTrace();
    }
  }
}
