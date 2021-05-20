public final class AccuWeatherAPI {

    public final List<Map<String, Object>> getWeather(String ciudad) {
		return Arrays.asList(new HashMap<String, Object>(){{
			put("DateTime", "2019-05-03T01:00:00-03:00");
			put("EpochDateTime", 1556856000);
			put("WeatherIcon", 33);
			put("IconPhrase", "Clear");
			put("IsDaylight", false);
			put("PrecipitationProbability", 0);
			put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
			put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
			put("Temperature", new HashMap<String, Object>(){{
				put("Value", 57);
				put("Unit", "F");
				put("UnitType", 18);
			}});
		}});
	}
}


public class Temperatura {
  Integer temperaturaMaxima;
  Integer temperaturaMinima;

  public boolean esValida(Integer temperatura) {
    return temperatura <= temperaturaMaxima && temperatura >= temperaturaMinima;
  }

}

public class servicioClimatico {

	private static final AccuWeatherAPI apiClima = new AccuWeatherAPI();

	public static AccuWeatherAPI getApiClima() {
    	return apiClima;
	}

	List<Map<String, Object>> condicionesClimaticasBsAs() {
    	return apiClima.getWeather("Buenos Aires, Argentina");
	}
}