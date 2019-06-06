import java.awt.*;

public class CuadradoGrafico extends ObjetoGrafico{
  int lado;

  public CuadradoGrafico() {
    super();
    this.lado = 20;
    this.xInicial=0;
    this.yInicial=0;
  }

  @Override
  public void pinta(int frame) {
    Graphics2D g=this.animacion.getGraficos();
    g.drawRect(xInicial,yInicial,lado,lado);
  }


}
