import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class AnimPNG {
  public static void main(String[] args) {
    try {
      int width = 2560, height = 1440;
      int numeroFrames=600;

      // TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
      // into integer pixels
      int despx=0;
      int num=0;
      for (int i = 0; i < numeroFrames; i++) {
        BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g=imagen.createGraphics();
        Font font = new Font("Georgia", Font.PLAIN, 48);

        String message = "Prueba de Imagen";
        g.setBackground(Color.BLACK);

        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
          RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
          RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics();
        int stringWidth = fontMetrics.stringWidth(message);
        int stringHeight = fontMetrics.getAscent();
        g.setPaint(Color.white);
        g.drawString(message, (width - stringWidth) / 2+despx++, height / 2 + stringHeight / 4);
        ImageIO.write(imagen, "PNG", new File("im"+String.format("%04d",num++)+".PNG"));

      }

      String filePath = "output";
      File fileP = new File(filePath);
      String commands = "C:\\ffmpeg-4.1.3-win64-static\\bin\\ffmpeg -f image2 -i "
        + "im00*.png " +  "video.mp4";
      System.out.println(commands);
      Runtime.getRuntime().exec(commands);
      System.out.println(fileP.getAbsolutePath());

    } catch (IOException ie) {
      ie.printStackTrace();
    }
  }
}
