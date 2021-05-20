
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

    public Atuendo generarSugerencia {
        return new Atuendo (prendasSuperiores.atRandom(),prendasInferiores.atRandom(), calzados.atRandom());
    }

     public Atuendo generarSugerenciaSegunClima() {
      ServicioClimatico servicioClimatico = ServicioClimatico.getApiClima();
      List<Map<String, Object>> climaBsAs = servicioClimatico.condicionesClimaticasBsAs();
      Integer temperatura = climaBsAs.get(0).get("Temperature");
      return atuendoPorTemperatura(temperatura);
    }

    public atuendoPorTemperatura(Temperatura temperatura) {
        Prenda prendaSuperior = prendasSuperiores.stream().filter(prendaSuperior -> prendaSuperior.getTemperatura().esValida(temperatura)).atRandom();
        Prenda prendasInferior = prendasInferiores.stream().filter(prendaInferior -> prendaInferior.getTemperatura().esValida(temperatura)).atRandom();
        Prenda calzado = calzados.stream().filter(calzado -> calzado.getTemperatura().esValida(temperatura)).atRandom();
        return new Atuendo (prendaSuperior, prendaInferior, calzado);
    }
}


