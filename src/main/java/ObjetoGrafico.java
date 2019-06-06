import java.awt.*;
import java.util.List;

public abstract class ObjetoGrafico {
  private int frameInicial=0;
  private int frameFinal=-1;
  Animacion animacion;
  protected int xInicial=0;
  protected int yInicial=0;
  protected int xActual=0;
  protected int yActual=0;

  public void setFrameInicial(int frameInicial) {
    this.frameInicial = frameInicial;
  }
  public void setDuracionFrames(int frames) {
    this.frameFinal = frameInicial+frames;
  }

  public void setPosicionInicial(int xInicial,int yInicial) {
    this.xInicial = xInicial;
    this.yInicial=yInicial;
    this.xActual=xInicial;
    this.yActual=yInicial;
  }

  public ObjetoGrafico() {
    this.animacion=Animacion.getInstance();
    System.out.println(animacion);
    System.out.println(animacion.getGraficos());

  }

  public abstract void pinta( int frame);



  public void compruebaYElimina(int frame){
    if(animacion!=null){
      if(frame>frameFinal){
        animacion.remove(this);
      }
    }
  }


  public ObjetoGrafico centra(){
    if(animacion!=null) {
      this.xInicial = animacion.getAncho() / 2;
      this.xActual=xInicial;
      this.yInicial = animacion.getAlto() / 2;
      this.yActual=yInicial;
    }
    return this;
  }

  public boolean sigueActivo(int frameActual) {
    return frameActual<this.frameFinal;
  }
}
