
public class Equipo {
    
    //Declaración de variables de la clase Equipo, poniendo sus atributos Protected con el fin de proteger los datos
     protected String fabricacion;
    protected String modelo;
    protected String microprocesador;

    //Constructor
    public Equipo(String fabricacion, String modelo, String microprocesador) {
        this.fabricacion = fabricacion;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
    }

    // Metodos get nos permiten acceder a los atributos de la clase Equipo de una manera controlada
    public String getFabricacion() {
        return fabricacion;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMicroprocesador() {
        return microprocesador;
    }
}
