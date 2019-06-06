public class AnimacionBuilder {
  private int ancho=640;
  private int alto=480;

  public AnimacionBuilder() {
  }

//  public Animacion build(){
//    return Animacion.getInstance().configuraAnimacion(this);
//  }

  public AnimacionBuilder preview(){
    this.ancho=640;
    this.alto=480;
    return this;
  }

  public AnimacionBuilder youtube(){
    this.ancho=2560;
    this.alto= 1440;
    return this;
  }

  public int getAlto(){
    return ancho;
  }

  public int getAncho(){
    return alto;
  }

}
