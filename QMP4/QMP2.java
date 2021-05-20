public enum Trama {
	LISO, RAYADO, ESTAMPADO
}

public class Borrador {
  private TipoDePrenda tipoPrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario = null; //Es null por default 
  private Trama trama;
  private Temperatura temperatura;

  public void especificarTipoDePrenda(TipoDePrenda tipoPrenda) {
    this.tipoPrenda = requireNonNull(tipoPrenda, "Tipo de prenda no puede ser nulo");
  }

  public void especificarMaterial(Material material) {
    this.material = requireNonNull(material, "El material no puede ser nulo");
  }

  public void especificarColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = requireNonNull(color, "El color principal no puede ser nulo");
  }

  public void especificarColorSecundario(Color colorSecundario) {
  	//Al ser null por default, si se especifica un color secundario debe ser válido
    this.colorSecundario = requireNonNull(colorSecundario, "Debe especificar un color válido");
  }

  public void especificarTrama(Trama trama) {
  	if (trama == null) {
  		this.trama = Trama.LISO;
  	} else {
  		this.trama = trama;
  	}
  }

  public void especificarTemperatura(Temperatura temperatura) {
    this.temperatura = requireNonNull(temperatura, "Tipo de prenda no puede ser nulo");
  }

  public Prenda crearPrenda() {
    return new Prenda(tipoPrenda, material, colorPrincipal, colorSecundario, trama, temperatura);
  }

}

public class Uniforme {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;
}

public abstract class Sastre {
   public Uniforme crearUniforme() {
   	return new Uniforme(this.fabricarParteSuperior(),this.fabricarParteInferior(), this.fabricarCalzado());
   }

  protected abstract Prenda fabricarParteSuperior();
  protected abstract Prenda fabricarParteInferior();
  protected abstract Prenda fabricarCalzado();
}

class SastreSanJuan extends Sastre {

  protected Prenda fabricarParteSuperior() {
    Borrador chombaPiqueVerde = new Borrador();
    chombaPiqueVerde.especificarTipoDePrenda(TipoDePrenda.REMERA);
    chombaPiqueVerde.especificarMaterial(Material.PIQUE);
    chombaPiqueVerde.especificarTrama(null);
    chombaPiqueVerde.especificarColorPrincipal(Color.VERDE);
    return chombaPiqueVerde.crearPrenda();
  }

  protected Prenda fabricarParteInferior() {
    Borrador pantalonGris = new Borrador();
    pantalonGris.especificarTipoDePrenda(TipoDePrenda.PANTALON);
    pantalonGris.especificarMaterial(Material.ACETATO);
    pantalonGris.especificarTrama(null);
    pantalonGris.especificarColorPrincipal(Color.GRIS);
    return pantalonGris.construirPrenda();
  }

  protected Prenda fabricarCalzado() {
    Borrador zapatillasBlancas = new Borrador();
    zapatillasBlancas.especificarTipoDePrenda(TipoDePrenda.ZAPATILLAS);
    zapatillasBlancas.especificarMaterial(Material.CUERO);
   	zapatillasBlancas.especificarTrama(null);
    zapatillasBlancas.especificarColorPrincipal(Color.BLANCO);
    return zapatillasBlancas.construirPrenda();
  }
}

class SastreJohnson extends Sastre {

  protected Prenda fabricarParteSuperior() {
    Borrador camisaBlanca = new Borrador();
    camisaBlanca.especificarTipoDePrenda(TipoDePrenda.CAMISA);
    camisaBlanca.especificarMaterial(Material.ALGODON);
   	camisaBlanca.especificarTrama(null);    
    camisaBlanca.especificarColorPrincipal(Color.BLANCO);
    return camisaBlanca.construirPrenda();
  }

  protected Prenda fabricarParteInferior() {
    Borrador pantalonNegro = new Borrador();
    pantalonNegro.especificarTipoDePrenda(TipoDePrenda.PANTALON);
    pantalonNegro.especificarMaterial(Material.ACETATO);
    pantalonNegro.especificarTrama(null);
    pantalonNegro.especificarColorPrincipal(Color.NEGRO);
    return pantalonNegro.construirPrenda();
  }

  protected Prenda fabricarCalzado() {
    Borrador zapatosNegros = new Borrador();
    zapatosNegros.especificarTipoDePrenda(TipoDePrenda.ZAPATOS);
    zapatosNegros.especificarMaterial(Material.CUERO);
   	zapatosNegros.especificarTrama(null);
    zapatosNegros.especificarColorPrincipal(Color.NEGRO);
    return zapatosNegros.construirPrenda();
  }
}