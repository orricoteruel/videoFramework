import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Animacion {
  private static Animacion animacion=null;
  private int alto;
  private int ancho;
  private List<ObjetoGrafico> objetos=new ArrayList<>();
  private Graphics2D graficos;
  private int frameActual;

  public Graphics2D getGraficos() {
    return graficos;
  }





  public int getAlto() {
    return alto;
  }

  public void setAlto(int alto) {
    this.alto = alto;
  }

  public int getAncho() {
    return ancho;
  }

  public void setAncho(int ancho) {
    this.ancho = ancho;
  }

  public List<ObjetoGrafico> getObjetos() {
    return objetos;
  }

  public void setObjetos(List<ObjetoGrafico> objetos) {
    this.objetos = objetos;
  }

  public BufferedImage getImagen() {
    return imagen;
  }


  private BufferedImage imagen;

  public static Animacion getInstance(){
    if(animacion==null){
      System.out.println("Nueva Animacion");
      animacion=new Animacion();
      return animacion;
    } else {
      return animacion;
    }
  }

  private Animacion(){};
  public Animacion configuraAnimacion(AnimacionBuilder animacionBuilder) {
    if (animacionBuilder == null) {
      throw new IllegalArgumentException("ERROR: Builder nulo");
    }
    this.alto=animacionBuilder.getAlto();
    this.ancho=animacionBuilder.getAncho();

    imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
    System.out.println(this.info());
    return this;
  }

  public Animacion add(ObjetoGrafico o){
    objetos.add(o);
    return this;
  }

  public void generaImagenes(){
    int despx=0;
    int num=0;
    BarraDialogo miBarra=new BarraDialogo(objetos.size());

    frameActual=0;
    while(!objetos.isEmpty()){
      miBarra.actualiza(frameActual);
      graficos=imagen.createGraphics();
      graficos.clearRect(0,0,imagen.getWidth(),imagen.getHeight());

      for (ObjetoGrafico o :
        objetos) {
        o.pinta(frameActual);
      }
      List<ObjetoGrafico> nuevaLista=new ArrayList<>();
      for (ObjetoGrafico o:
           objetos) {
        if(o.sigueActivo(frameActual)){
          nuevaLista.add(o);
        }
      }
      objetos=nuevaLista;
      try {
        ImageIO.write(imagen, "PNG", new File("out\\im"+String.format("%04d",num++)+".PNG"));
      } catch (IOException e) {
        e.printStackTrace();
      }
      frameActual++;
    }
    miBarra.termina();
  }


  private String info() {
    return "ANIMACION:" +
      "\n  ANCHO: "+this.ancho+
      "\n  ALTO:  "+this.alto+
      "\n  OBJETOS:"+this.objetos.size();
  }

  public void generaVideo() {
    String filePath = "output";
    File fileP = new File(filePath);
    String commands = "C:\\ffmpeg-4.1.3-win64-static\\bin\\ffmpeg -f image2 -i "
      + "out\\im%4d.png " +  "video.mp4 -y";
    System.out.println(commands);
    try {

      Runtime runtime = Runtime.getRuntime();
      Process process = runtime.exec(commands);
      File f=new File(".");
      System.out.println(f.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void remove(ObjetoGrafico objetoGrafico) {
    objetos.remove(objetoGrafico);
  }
}
