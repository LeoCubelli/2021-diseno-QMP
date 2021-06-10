public abstract class Propuesta {
  private Prenda prenda;
  private Guardarropas guardarropa;

}

public class PropuestaPrendaAAgregar extends Propuesta {
  public void aplicarPropuesta() {
    guardarropa.cargarPrenda(prenda);
  }
}

public class PropuestaPrendaAQuitar extends Propuesta {
  public void aplicarPropuesta() {
    guardarropa.sacarPrenda(prenda);
  }
}


public class Usuario {
  List<Guardarropas> guardarropas;
  List<Propuesta> propuestas;
  List<Propuesta> propuestasAceptadas;
  Sugerencia sugerenciaDiaria;
  String email;

  public void recibirSugerenciaDiaria(Sugerencia sugerencia){
    sugerenciaDiaria = sugerencia;
  }

  public String getEmail() {
    return email;
  }

  public void compartirGuardarropas(Usuario usuario, Guardarropas guardarropa) {
    usuario.agregarGuardarropas(guardarropa);
  }

  public void agregarGuardarropas(Guardarropas guardarropa) {
    guardarropas.add(guardarropa)
  }

  public void agregarPropuesta(Propuesta propuesta) {
    propuestas.add(propuesta)
  }

  public void rechazarPropuesta(Propuesta propuesta) {
    if (propuestas.contains(propuesta)) {
      propuestas.remove(propuesta);
    }
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    propuesta.aplicarPropuesta();
    propuestasAceptadas.add(propuesta);
    propuestas.remove(propuesta);
  }
}
