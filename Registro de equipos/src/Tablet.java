//Clase Tablet que hereda de la clase equipo con la palabra reservada extends
public class Tablet extends Equipo{
    
    //Declaración de variables de la clase Tablet, poniendo sus atributos private con el fin de proteger los datos
    private String ram;
    private String resolucion;
    private String tipoPantalla;
    private String tamanoMemoriaNAND;
    private String sistemaOperativo;
    private String tamanoPantalla;
    
    // Constructor
    public Tablet(String fabricacion, String modelo, String microprocesador, String ram, String resolucion, String tipoPantalla, String tamanoMemoriaNAND, String sistemaOperativo, String tamanoPantalla) {
        super(fabricacion, modelo, microprocesador); //Constructor de la clase padre (Equipo)
        this.ram = ram;
        this.resolucion = resolucion;
        this.tipoPantalla = tipoPantalla;
        this.tamanoMemoriaNAND = tamanoMemoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
        this.tamanoPantalla = tamanoPantalla;
    }

    // Metodos get nos permiten acceder a los atributos de la clase Tablet de una manera controlada
    public String getRam() {
        return ram;
    }

    public String getResolucion() {
        return resolucion;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public String getTamanoMemoriaNAND() {
        return tamanoMemoriaNAND;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public String getTamanoPantalla() {
        return tamanoPantalla;
    }
}
