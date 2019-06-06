import java.awt.*;

public class Fuentes {
  public static void main(String[] args) {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font[] fonts = ge.getAllFonts();

    for (Font font : fonts) {
      System.out.print(font.getFontName() + " : ");
      System.out.println(font.getFamily());
    }
  }
}
