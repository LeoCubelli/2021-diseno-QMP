
public enum Categoria{
    PARTE_SUPERIOR, PARTE_INFERIOR, CALZADO, ACCESORIO
}

public class Atuendo{
    private Prenda parteSuperior;
    private Prenda parteInferior;
    private Prenda calzado;
}

public enum Material {
    ALGODON, LANA, CUERO, PIQUE, ACETATO
}

public class TipoPrenda {
    public static TipoPrenda ZAPATILLAS = new TipoPrenda(CALZADO);
    public static TipoPrenda ZAPATOS = new TipoPrenda(CALZADO);
    public static TipoPrenda REMERA = new TipoPrenda(PARTE_SUPERIOR);
    public static TipoPrenda CAMISA = new TipoPrenda(PARTE_SUPERIOR);
    public static TipoPrenda PANTALON = new TipoPrenda(PARTE_INFERIOR);

    Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }
}


public class Prenda{
    private TipoPrenda tipoPrenda;
    private Material material;
    private Color color;
    private Color colorSecundario; 
    private Trama trama;
    private Temperatura temperatura;

   public Prenda(String material, Color color, TipoPrenda tipoPrenda, Color colorSecundario, Trama trama, Temperatura temperatura){
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.color = color;
        this.trama = trama;
        this.colorSecundario = colorSecundario;
        this.temperatura = temperatura;

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }
}

public class Color {
    public static Color VERDE = new Color(0,0,255);
    public static Color BLANCO = new Color(255,255,255);
    public static Color NEGRO = new Color(0,0,0);
    public static Color GRIS = new Color(130,130,130);

    Integer nivelAzul;
    Integer nivelRojo;
    Integer nivelVerde;

    public Color(Integer nivelAzul, Integer nivelRojo, Integer nivelVerde) {
        this.nivelAzul = nivelAzul;
        this.nivelRojo = nivelRojo;   
        this.nivelVerde = nivelVerde;
    }
}