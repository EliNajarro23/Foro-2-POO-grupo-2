import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

class Equipo {
    String fabricacion;
    String modelo;
    String microprocesador;

    public Equipo(String fabricacion, String modelo, String microprocesador) {
        this.fabricacion = fabricacion;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
    }
}

class Desktop extends Equipo {
    String ram;
    String tarjetaGrafica;
    String capacidadDiscoDuro;
    String tamanoTorre;
    String tamanoPantalla;
    String resolucion; // Nuevo atributo
    String tipoPantalla;
    String sistemaOperativo;

    public Desktop(String fabricacion, String modelo, String microprocesador, String ram, String tarjetaGrafica, String capacidadDiscoDuro, String tamanoTorre, String tamanoPantalla, String resolucion, String tipoPantalla, String sistemaOperativo) {
        super(fabricacion, modelo, microprocesador);
        this.ram = ram;
        this.tarjetaGrafica = tarjetaGrafica;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
        this.tamanoTorre = tamanoTorre;
        this.tamanoPantalla = tamanoPantalla;
        this.resolucion = resolucion; // Nuevo atributo
        this.tipoPantalla = tipoPantalla;
        this.sistemaOperativo = sistemaOperativo;
    }
}

class Laptop extends Equipo {
    String ram;
    String tarjetaGrafica;
    String tamanoPantalla;
    String resolucion; // Nuevo atributo
    String capacidadDiscoDuro;
    String tipoPantalla;
    String sistemaOperativo;

    public Laptop(String fabricacion, String modelo, String microprocesador, String ram, String tarjetaGrafica, String tamanoPantalla, String resolucion, String capacidadDiscoDuro, String tipoPantalla, String sistemaOperativo) {
        super(fabricacion, modelo, microprocesador);
        this.ram = ram;
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoPantalla = tamanoPantalla;
        this.resolucion = resolucion; // Nuevo atributo
        this.capacidadDiscoDuro = capacidadDiscoDuro;
        this.tipoPantalla = tipoPantalla;
        this.sistemaOperativo = sistemaOperativo;
    }
}

class Tablet extends Equipo {
    String ram;
    String resolucion; // Cambiado de tamanoDiagonal a resolucion
    String tipoPantalla;
    String tamanoMemoriaNAND;
    String sistemaOperativo;
    String tamanoPantalla;

    public Tablet(String fabricacion, String modelo, String microprocesador, String ram, String resolucion, String tipoPantalla, String tamanoMemoriaNAND, String sistemaOperativo, String tamanoPantalla) {
        super(fabricacion, modelo, microprocesador);
        this.ram = ram;
        this.resolucion = resolucion; // Cambiado de tamanoDiagonal a resolucion
        this.tipoPantalla = tipoPantalla;
        this.tamanoMemoriaNAND = tamanoMemoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
        this.tamanoPantalla = tamanoPantalla;
    }
}

public class RegistroDeEquipos {
    private static final ArrayList<Equipo> equipos = new ArrayList<>();

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Gestión de Equipos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200); // Ajustamos el tamaño para acomodar el mensaje de bienvenida
        frame.setLayout(new BorderLayout());

        // Crear un panel para el mensaje de bienvenida
        JPanel panelBienvenida = new JPanel();
        JLabel lblBienvenida = new JLabel("Bienvenido/a :D");
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16)); // Ajustamos la fuente del mensaje
        panelBienvenida.add(lblBienvenida);

        // Crear un panel para los botones
        JPanel panelBotones = new JPanel();
        JButton btnRegistrar = new JButton("Registrar Equipo");
        JButton btnVerEquipos = new JButton("Ver Equipos");
        JButton btnSalir = new JButton("Salir");

        // Agregar los botones al panel
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnVerEquipos);
        panelBotones.add(btnSalir);

        // Agregar el panel de bienvenida y el panel de botones a la ventana
        frame.add(panelBienvenida, BorderLayout.NORTH);
        frame.add(panelBotones, BorderLayout.CENTER);

        // Acción para el botón "Registrar Equipo"
        btnRegistrar.addActionListener((ActionEvent e) -> {
            registrarEquipo();
        });

        // Acción para el botón "Ver Equipos"
        btnVerEquipos.addActionListener((ActionEvent e) -> {
            verEquipos();
        });

        // Acción para el botón "Salir"
        btnSalir.addActionListener((ActionEvent e) -> {
            // Mostrar un cuadro de diálogo de confirmación
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que quieres salir del programa?",
                    "Confirmar salida", 
                    JOptionPane.YES_NO_OPTION
            );
            
            // Si el usuario selecciona "Sí", cerrar la ventana
            if (respuesta == JOptionPane.YES_OPTION) {
                frame.dispose(); // Cierra la ventana
            }
            // Si selecciona "No", no hacer nada
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }

    private static void registrarEquipo() {
        String[] tiposEquipo = {"Desktop", "Laptop", "Tablet"};
        int tipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de equipo", "Registrar Equipo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tiposEquipo, tiposEquipo[0]);

        // Si el usuario cancela la selección del tipo de equipo, salimos del método
        if (tipo == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos correspondientes", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String fabricacion = JOptionPane.showInputDialog("Ingrese la fabricación:");
        if (fabricacion == null || fabricacion.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
        if (modelo == null || modelo.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String microprocesador = JOptionPane.showInputDialog("Ingrese el microprocesador:");
        if (microprocesador == null || microprocesador.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        switch (tipo) {
            case 0:
                {
                    // Desktop
                    String ram = JOptionPane.showInputDialog("Ingrese la RAM:");
                    if (ram == null || ram.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tarjetaGrafica = JOptionPane.showInputDialog("Ingrese la tarjeta gráfica:");
                    if (tarjetaGrafica == null || tarjetaGrafica.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String capacidadDiscoDuro = JOptionPane.showInputDialog("Ingrese la capacidad del disco duro:");
                    if (capacidadDiscoDuro == null || capacidadDiscoDuro.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tamanoTorre = JOptionPane.showInputDialog("Ingrese el tamaño de la torre:");
                    if (tamanoTorre == null || tamanoTorre.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
                    if (tamanoPantalla == null || tamanoPantalla.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String resolucion = JOptionPane.showInputDialog("Ingrese la resolución de la pantalla:"); // Nuevo campo
                    if (resolucion == null || resolucion.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tipoPantalla = JOptionPane.showInputDialog("Ingrese el tipo de pantalla:");
                    if (tipoPantalla == null || tipoPantalla.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                    if (sistemaOperativo == null || sistemaOperativo.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       equipos.add(new Desktop(fabricacion, modelo, microprocesador, ram, tarjetaGrafica, capacidadDiscoDuro, tamanoTorre, tamanoPantalla, resolucion, tipoPantalla, sistemaOperativo));
                    break;
                }
            case 1:
                {
                    // Laptop
                    String ram = JOptionPane.showInputDialog("Ingrese la RAM:");
                    if (ram == null || ram.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tarjetaGrafica = JOptionPane.showInputDialog("Ingrese la tarjeta gráfica:");
                    if (tarjetaGrafica == null || tarjetaGrafica.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
                    if (tamanoPantalla == null || tamanoPantalla.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String resolucion = JOptionPane.showInputDialog("Ingrese la resolución de la pantalla:"); // Nuevo campo
                    if (resolucion == null || resolucion.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String capacidadDiscoDuro = JOptionPane.showInputDialog("Ingrese la capacidad del disco duro:");
                    if (capacidadDiscoDuro == null || capacidadDiscoDuro.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tipoPantalla = JOptionPane.showInputDialog("Ingrese el tipo de pantalla:");
                    if (tipoPantalla == null || tipoPantalla.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                    if (sistemaOperativo == null || sistemaOperativo.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       equipos.add(new Laptop(fabricacion, modelo, microprocesador, ram, tarjetaGrafica, tamanoPantalla, resolucion, capacidadDiscoDuro, tipoPantalla, sistemaOperativo));
                    break;
                }
            case 2:
                {
                    // Tablet
                    String ram = JOptionPane.showInputDialog("Ingrese la RAM:");
                    if (ram == null || ram.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String resolucion = JOptionPane.showInputDialog("Ingrese la resolución de la pantalla:"); // Cambiado de tamaño diagonal a resolución
                    if (resolucion == null || resolucion.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tipoPantalla = JOptionPane.showInputDialog("Ingrese el tipo de pantalla (Capacitiva/Resistiva):");
                    if (tipoPantalla == null || tipoPantalla.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tamanoMemoriaNAND = JOptionPane.showInputDialog("Ingrese el tamaño de la memoria NAND:");
                    if (tamanoMemoriaNAND == null || tamanoMemoriaNAND.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                    if (sistemaOperativo == null || sistemaOperativo.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       String tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
                    if (tamanoPantalla == null || tamanoPantalla.trim().isEmpty()) { // Si el usuario cancela o deja el campo vacío
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }       equipos.add(new Tablet(fabricacion, modelo, microprocesador, ram, resolucion, tipoPantalla, tamanoMemoriaNAND, sistemaOperativo, tamanoPantalla));
                    break;
                }
            default:
                break;
        }

        JOptionPane.showMessageDialog(null, "Equipo registrado exitosamente!");
    }

    private static void verEquipos() {
        if (equipos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay equipos registrados.", "Lista de Equipos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Crear un modelo de tabla con columnas para Desktops, Laptops y Tablets
        String[] columnNames = {"Tipo", "Fabricación", "Modelo", "Microprocesador", "RAM", "Tarjeta Gráfica", "Tamaño Pantalla", "Resolución", "Tipo Pantalla", "Memoria NAND", "Sistema Operativo", "Capacidad Disco Duro", "Tamaño Torre"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Llenar la tabla con los datos de los equipos
        equipos.forEach((equipo) -> {
            if (equipo instanceof Desktop) {
                Desktop desktop = (Desktop) equipo;
                model.addRow(new Object[]{"Desktop", desktop.fabricacion, desktop.modelo, desktop.microprocesador, desktop.ram, desktop.tarjetaGrafica, desktop.tamanoPantalla, desktop.resolucion, desktop.tipoPantalla, "", desktop.sistemaOperativo, desktop.capacidadDiscoDuro, desktop.tamanoTorre});
            } else if (equipo instanceof Laptop) {
                Laptop laptop = (Laptop) equipo;
                model.addRow(new Object[]{"Laptop", laptop.fabricacion, laptop.modelo, laptop.microprocesador, laptop.ram, laptop.tarjetaGrafica, laptop.tamanoPantalla, laptop.resolucion, laptop.tipoPantalla, "", laptop.sistemaOperativo, laptop.capacidadDiscoDuro, ""});
            } else if (equipo instanceof Tablet) {
                Tablet tablet = (Tablet) equipo;
                model.addRow(new Object[]{"Tablet", tablet.fabricacion, tablet.modelo, tablet.microprocesador, tablet.ram, "", tablet.tamanoPantalla, tablet.resolucion, tablet.tipoPantalla, tablet.tamanoMemoriaNAND, tablet.sistemaOperativo, "", ""});
            }
        });

        // Crear la tabla con el modelo de datos
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Crear una ventana para mostrar la tabla
        JFrame frameTabla = new JFrame("Lista de Equipos");
        frameTabla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTabla.add(scrollPane);
        frameTabla.pack();
        frameTabla.setVisible(true);
    }
}