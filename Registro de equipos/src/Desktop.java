//Clase Desktop que hereda de la clase equipo con la palabra reservada extends
public class Desktop extends Equipo{
    
    //Declaración de variables de la clase Desltop, poniendo sus atributos private con el fin de proteger los datos
     private String ram;
    private String tarjetaGrafica;
    private String capacidadDiscoDuro;
    private String tamanoTorre;
    private String tamanoPantalla;
    private String resolucion;
    private String tipoPantalla;
    private String sistemaOperativo;

    // Constructor
    public Desktop(String fabricacion, String modelo, String microprocesador, String ram, String tarjetaGrafica, String capacidadDiscoDuro, String tamanoTorre, String tamanoPantalla, String resolucion, String tipoPantalla, String sistemaOperativo) {
        super(fabricacion, modelo, microprocesador);  //Constructor de la clase padre (Equipo)
        this.ram = ram;
        this.tarjetaGrafica = tarjetaGrafica;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
        this.tamanoTorre = tamanoTorre;
        this.tamanoPantalla = tamanoPantalla;
        this.resolucion = resolucion;
        this.tipoPantalla = tipoPantalla;
        this.sistemaOperativo = sistemaOperativo;
    }

    // Metodos get nos permiten acceder a los atributos de la clase Desktop de una manera controlada
    public String getRam() {
        return ram;
    }

    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public String getCapacidadDiscoDuro() {
        return capacidadDiscoDuro;
    }

    public String getTamanoTorre() {
        return tamanoTorre;
    }

    public String getTamanoPantalla() {
        return tamanoPantalla;
    }

    public String getResolucion() {
        return resolucion;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
}
