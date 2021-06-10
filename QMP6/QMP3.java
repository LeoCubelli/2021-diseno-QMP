
public class Guardarropas{
    List<Prenda> prendasSuperiores;
    List<Prenda> prendasInferiores;
    List<Prenda> calzados;
    List<Prenda> accesorios;


    public void cargarPrenda(Prenda prenda){
        if (prenda.getTipoPrenda().getCategoria() == Categoria.PARTE_SUPERIOR) {
            prendasSuperiores.add(prenda);
        }
        if (prenda.getTipoPrenda().getCategoria() == Categoria.PARTE_INFERIOR) {
            prendasInferiores.add(prenda);
        }
        if (prenda.getTipoPrenda().getCategoria() == Categoria.CALZADO) {
            calzados.add(prenda);
        }
        if (prenda.getTipoPrenda().getCategoria() == Categoria.ACCESORIO) {
            accesorios.add(prenda);
        }
    }


    public void sacarPrenda(Prenda prenda) {
        if (prenda.getTipoPrenda().getCategoria() == Categoria.PARTE_SUPERIOR) {
            prendasSuperiores.remove(prenda);
        }
        if (prenda.getTipoPrenda().getCategoria() == Categoria.PARTE_INFERIOR) {
            prendasInferiores.remove(prenda);
        }
        if (prenda.getTipoPrenda().getCategoria() == Categoria.CALZADO) {
            calzados.remove(prenda);
        }
        if (prenda.getTipoPrenda().getCategoria() == Categoria.ACCESORIO) {
            accesorios.remove(prenda);
        }
    }

}


class AsesorDeImagen() {

    public Atuendo sugerirAtuendo() {
      Double temperatura = servicioClimatico.consultarTemperaturaPara("Buenos Aires");

      return this.atuendoParaTemperaturaAdecuada(temperatura);
    }

    public Atuendo generarSugerencia() {
        return new Atuendo (prendasSuperiores.atRandom(),prendasInferiores.atRandom(), calzados.atRandom());
    }

    public Atuendo generarSugerenciaSegunClima() {
        Integer temperatura = servicioCliamtico.temperaturaEnBsAs();
        return atuendoPorTemperatura(temperatura);
    }

    public atuendoPorTemperatura(Integer temperatura) {
        Prenda prendaSuperior = prendasSuperiores.stream().filter(prendaSuperior -> prendaSuperior.getTemperatura().esValida(temperatura)).atRandom();
        Prenda prendasInferior = prendasInferiores.stream().filter(prendaInferior -> prendaInferior.getTemperatura().esValida(temperatura)).atRandom();
        Prenda calzado = calzados.stream().filter(calzado -> calzado.getTemperatura().esValida(temperatura)).atRandom();
        return new Atuendo (prendaSuperior, prendaInferior, calzado);
    }
}