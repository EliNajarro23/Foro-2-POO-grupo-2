import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class RegistroDeEquipos {
    private static final ArrayList<Equipo> equipos = new ArrayList<>();

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Gestión de Equipos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Crear un panel para el mensaje de bienvenida
        JPanel panelBienvenida = new JPanel();
        JLabel lblBienvenida = new JLabel("Bienvenido a TodoPC");
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
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
        btnRegistrar.addActionListener((ActionEvent e) -> registrarEquipo());

        // Acción para el botón "Ver Equipos"
        btnVerEquipos.addActionListener((ActionEvent e) -> verEquipos());
       
         // Acción para el botón "Salir"
        btnSalir.addActionListener((ActionEvent e) -> {
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que quieres salir del programa?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        });
    
        // Mostrar la ventana
        frame.setVisible(true);
        
    }

    private static void registrarEquipo() {
        String[] tiposEquipo = {"Desktop", "Laptop", "Tablet"};
        int tipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de equipo", "Registrar Equipo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tiposEquipo, tiposEquipo[0]);

        if (tipo == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String fabricacion = JOptionPane.showInputDialog("Ingrese la fabricación:");
        if (fabricacion == null || fabricacion.trim().isEmpty()) return;

        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
        if (modelo == null || modelo.trim().isEmpty()) return;

        String microprocesador = JOptionPane.showInputDialog("Ingrese el microprocesador:");
        if (microprocesador == null || microprocesador.trim().isEmpty()) return;

        switch (tipo) {
            case 0: // Desktop
                String ram = JOptionPane.showInputDialog("Ingrese la RAM:");
                String tarjetaGrafica = JOptionPane.showInputDialog("Ingrese la tarjeta gráfica:");
                String capacidadDiscoDuro = JOptionPane.showInputDialog("Ingrese la capacidad del disco duro:");
                String tamanoTorre = JOptionPane.showInputDialog("Ingrese el tamaño de la torre:");
                String tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
                String resolucion = JOptionPane.showInputDialog("Ingrese la resolución de la pantalla:");
                String tipoPantalla = JOptionPane.showInputDialog("Ingrese el tipo de pantalla:");
                String sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                equipos.add(new Desktop(fabricacion, modelo, microprocesador, ram, tarjetaGrafica, capacidadDiscoDuro, tamanoTorre, tamanoPantalla, resolucion, tipoPantalla, sistemaOperativo));
                break;
            case 1: // Laptop
                ram = JOptionPane.showInputDialog("Ingrese la RAM:");
                tarjetaGrafica = JOptionPane.showInputDialog("Ingrese la tarjeta gráfica:");
                tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
                resolucion = JOptionPane.showInputDialog("Ingrese la resolución de la pantalla:");
                capacidadDiscoDuro = JOptionPane.showInputDialog("Ingrese la capacidad del disco duro:");
                tipoPantalla = JOptionPane.showInputDialog("Ingrese el tipo de pantalla:");
                sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                equipos.add(new Laptop(fabricacion, modelo, microprocesador, ram, tarjetaGrafica, tamanoPantalla, resolucion, capacidadDiscoDuro, tipoPantalla, sistemaOperativo));
                break;
            case 2: // Tablet
                ram = JOptionPane.showInputDialog("Ingrese la RAM:");
                resolucion = JOptionPane.showInputDialog("Ingrese la resolución de la pantalla:");
                tipoPantalla = JOptionPane.showInputDialog("Ingrese el tipo de pantalla (Capacitiva/Resistiva):");
                String tamanoMemoriaNAND = JOptionPane.showInputDialog("Ingrese el tamaño de la memoria NAND:");
                sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
                equipos.add(new Tablet(fabricacion, modelo, microprocesador, ram, resolucion, tipoPantalla, tamanoMemoriaNAND, sistemaOperativo, tamanoPantalla));
                break;
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

        String[] columnNames = {"Tipo", "Fabricación", "Modelo", "Microprocesador", "RAM", "Tarjeta Gráfica", "Tamaño Pantalla", "Resolución", "Tipo Pantalla", "Memoria NAND", "Sistema Operativo", "Capacidad Disco Duro", "Tamaño Torre"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        equipos.forEach((equipo) -> {
        if (equipo instanceof Desktop) {
            Desktop desktop = (Desktop) equipo;
            model.addRow(new Object[]{"Desktop", desktop.getFabricacion(), desktop.getModelo(), desktop.getMicroprocesador(), desktop.getRam(), desktop.getTarjetaGrafica(), desktop.getTamanoPantalla(), desktop.getResolucion(), desktop.getTipoPantalla(), "N/A", desktop.getSistemaOperativo(), desktop.getCapacidadDiscoDuro(), desktop.getTamanoTorre()});
        } else if (equipo instanceof Laptop) {
            Laptop laptop = (Laptop) equipo;
            model.addRow(new Object[]{"Laptop", laptop.getFabricacion(), laptop.getModelo(), laptop.getMicroprocesador(), laptop.getRam(), laptop.getTarjetaGrafica(), laptop.getTamanoPantalla(), laptop.getResolucion(), laptop.getTipoPantalla(), "N/A", laptop.getSistemaOperativo(), laptop.getCapacidadDiscoDuro(), "N/A"});
        } else if (equipo instanceof Tablet) {
            Tablet tablet = (Tablet) equipo;
            model.addRow(new Object[]{"Tablet", tablet.getFabricacion(), tablet.getModelo(), tablet.getMicroprocesador(), tablet.getRam(),"N/A", tablet.getTamanoPantalla(), tablet.getResolucion(), tablet.getTipoPantalla(), tablet.getTamanoMemoriaNAND(), tablet.getSistemaOperativo(), "N/A", "N/A"});
        }
    });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frameTabla = new JFrame("Lista de Equipos");
        frameTabla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTabla.add(scrollPane);
        frameTabla.pack();
        frameTabla.setVisible(true);
    }

    
}

    