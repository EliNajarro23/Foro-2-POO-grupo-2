//Clase Laptop que hereda de la clase equipo con la palabra reservada extends
public class Laptop extends Equipo{
    
    //Declaración de variables de la clase Laptop, poniendo sus atributos private con el fin de proteger los datos
     private String ram;
    private String tarjetaGrafica;
    private String tamanoPantalla;
    private String resolucion;
    private String capacidadDiscoDuro;
    private String tipoPantalla;
    private String sistemaOperativo;

    //Constructor
    public Laptop(String fabricacion, String modelo, String microprocesador, String ram, String tarjetaGrafica, String tamanoPantalla, String resolucion, String capacidadDiscoDuro, String tipoPantalla, String sistemaOperativo) {
        super(fabricacion, modelo, microprocesador);  //Constructor de la clase padre
        this.ram = ram;
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoPantalla = tamanoPantalla;
        this.resolucion = resolucion;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
        this.tipoPantalla = tipoPantalla;
        this.sistemaOperativo = sistemaOperativo;
    }

    // Metodos get nos permiten acceder a los atributos de la clase Laptop de una manera controlada
    public String getRam() {
        return ram;
    }

    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public String getTamanoPantalla() {
        return tamanoPantalla;
    }

    public String getResolucion() {
        return resolucion;
    }

    public String getCapacidadDiscoDuro() {
        return capacidadDiscoDuro;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
}
