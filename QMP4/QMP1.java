
public enum Categoria{
    PARTE_SUPERIOR, PARTE_INFERIOR, CALZADO, ACCESORIO
}

public class Atuendo{
    private List<Prenda> prendasValidas;
    private Temperatura temperaturaAdecuada;

    public Temperatura getTemperaturaAdecuada() {
        return temperaturaAdecuada;
    }
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
}


public class Prenda{
    private TipoPrenda tipo;
    private Material material;
    private Color color;
    private Color colorSecundario; 
    private Trama trama;

   public Prenda(String material, Color color, TipoPrenda tipo, Color colorSecundario, Trama trama){
        this.tipo = tipo;
        this.material = material;
        this.color = color;
        this.trama = trama;
        this.colorSecundario = colorSecundario;
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

/*
public class Usuario{
    List<Prenda> prendas;

    public void cargarPrenda(Prenda prenda){
        if (validar(prenda)) {
            prendas.add(prenda);
        } else {
            throw new Error("La prenda no cumple con los requerimientos");
        }
    }

    public boolean validar(Prenda prenda) {
        //validaciones
    }

    public void generarAtuendo(List<Prenda> listaPrendas) {
        return new Atuendo(listaPrendas);
    }
}
*/