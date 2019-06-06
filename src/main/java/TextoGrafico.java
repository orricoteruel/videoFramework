import java.awt.*;

public class TextoGrafico extends ObjetoGrafico{

  String texto;

  public TextoGrafico(String texto) {
    super();
    this.texto=texto;
  }

  @Override
  public void pinta(int frame) {
    Graphics2D g=animacion.getGraficos();
    g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
      RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
      RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
    Font font = new Font("Georgia", Font.PLAIN, 48);
    g.setFont(font);
    FontMetrics fontMetrics = g.getFontMetrics();
    int stringWidth = fontMetrics.stringWidth(this.texto);
    int stringHeight = fontMetrics.getAscent();
    g.setPaint(Color.white);
    g.drawString(this.texto, xActual+frame, yActual);
  }
}
