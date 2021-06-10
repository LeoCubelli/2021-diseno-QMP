Interface ObserverDeAlertas {
  public void alertasRecibidas(List<String> alertas, List<Usuarios> usuarios);
}

Class SugerenciaDiaria implements ObserverDeAlertas {
 ServicioClimatico servicioClimatico;
 List<Sugerencia> sugerencias;
 
  public void alertasRecibidas(List<String> alertas, List<Usuarios> usuarios){
    Integer temperatura = servicioMeteorologico.temperaturaEnBsAs();
    List<Sugerencia> sugerenciasAdecuadas = sugerencias.filter(sugerencia -> sugerencia.esAdecuadaPara(temperatura));
    SistemaPrincipal.getInstance().enviarSugerencia(sugerenciasAdecuadas.get().random);
  }
}

Class NotificadorDeGranizo implements ObserverDeAlertas
{
 
  ServicioNotificador notificador;
 
  public void alertasRecibidas(List<String> alertas, List<Usuarios> usuarios){
    if(alertas.contains("HAIL") {
      usuarios.forEach(usuario -> notificador.notificar("Alerta de granizo", usuario);
    }
  }
}

Class NotificadorDeTormenta implements ObserverDeAlertas
{
 
  ServicioNotificador notificador;
 
  public void alertasRecibidas(List<String> alertas, List<Usuarios> usuarios){
    if(alertas.contains("STORM") {
      usuarios.forEach(usuario -> notificador.notificar("Alerta de tormenta",usuario);
    }
  }
}

Class Mail implements ObserverDeAlertas
{
  MailSender mailSender;
    
  public void alertasRecibidas(List<String> alertas, List<Usuarios> usuarios){
    if(alertas.size() > 0) {
      usuarios.forEach(usuario -> mailSender.send(usuario.getEmail(),"Se registraron las alertas meteorologicas" ++ alertas));
    }
  }
}

Class SistemaPrincipal
{
  List<ObserverDeAlertas> observersAlertas; 
  List<Usuario> usuarios;
      
   private static final SistemaPrincipal INSTANCE = new SistemaPrincipal();
   
   public static SistemaPrincipal getInstance() { return INSTANCE; }
    
    public void enviarSugerencia(Sugerencia sugerencia){
      usuarios.forEach(usuario -> usuario.recibirSugerenciaDiaria(sugerencia);
    }
    
}