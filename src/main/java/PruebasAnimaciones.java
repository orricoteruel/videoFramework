public class PruebasAnimaciones {
  public static void main(String[] args) {
    Animacion animacion=Animacion.getInstance();
    animacion.configuraAnimacion(new AnimacionBuilder().preview());
    ObjetoGrafico cuadrado=new CuadradoGrafico();
    cuadrado.setFrameInicial(0);
    cuadrado.setDuracionFrames(40);
    animacion.add(cuadrado);
    TextoGrafico texto=new TextoGrafico("HUGO");
    TextoGrafico texto3=new TextoGrafico("ALEX");
    TextoGrafico texto2=new TextoGrafico("ROSANA");
    texto.centra();
    texto.setDuracionFrames(80);
    texto2.setFrameInicial(30);
    texto2.centra();
    texto2.setPosicionInicial(100,100);
    texto2.setDuracionFrames(40);
    texto3.setPosicionInicial(150,200);
    texto3.setDuracionFrames(130);

    animacion.add(texto);
    animacion.add(texto2);
    animacion.add(texto3);

    animacion.generaImagenes();
    animacion.generaVideo();
  }
}
