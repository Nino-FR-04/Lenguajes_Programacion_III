package EjercicioParteII;

import java.awt.*;
import javax.swing.*;

public class Vista extends JFrame {

    private static final long serialVersionUID = 1L;

    // Campos globales para que sean accesibles desde diferentes métodos
    private JTextField text1, text2, text3;
    private JCheckBox opc1, opc2, opc3;
    private JRadioButton opcion1, opcion2;
    private JComboBox<String> comboBox, comboBox2;

    public Vista() {
        setTitle("Pasajes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 400);

        JPanel panel_main = new JPanel();
        panel_main.setLayout(new BoxLayout(panel_main, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel_main);
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(15);
        add(scrollPane);

        panel_main.add(panelSuperior());
        panel_main.add(panel1());
        panel_main.add(panel2("SERVICIOS ADICIONALES"));
        panel_main.add(checkBox());
        panel_main.add(panel2("OPCIONES DE VIAJE"));
        panel_main.add(botonesOpcion());
        panel_main.add(panel2("LUGAR ORIGEN - DESTINO"));
        panel_main.add(cuadrosCB());
        panel_main.add(panel2("CALIDADES DE SERVICIO"));
        panel_main.add(calidadServicios());

        // Añadir los botones de acción al panel principal
        panel_main.add(botonesAccion());
    }

    private JPanel panelSuperior() {
        JPanel panelSup = new JPanel();
        panelSup.setLayout(new FlowLayout());
        JLabel titulo = new JLabel("INFORMACIÓN-PASAJERO");
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
        panelSup.add(titulo);
        return panelSup;
    }

    private JPanel panel1() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 2, 3, 3));

        JLabel nombre = new JLabel("Nombre");
        nombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
        text1 = new JTextField(20);

        JLabel dni = new JLabel("Documento Nacional de Identidad (DNI)");
        dni.setFont(new Font("Times New Roman", Font.BOLD, 20));
        text2 = new JTextField(20);

        JLabel FechaViaje = new JLabel("Fecha de Viaje");
        FechaViaje.setFont(new Font("Times New Roman", Font.BOLD, 20));
        text3 = new JTextField(20);

        panel1.add(nombre);
        panel1.add(text1);
        panel1.add(dni);
        panel1.add(text2);
        panel1.add(FechaViaje);
        panel1.add(text3);

        return panel1;
    }

    private JPanel panel2(String titulo) {
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 10));
        JLabel subtitulo = new JLabel(titulo);
        subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        panel2.add(subtitulo);
        return panel2;
    }

    private JPanel checkBox() {
        JPanel checkBox = new JPanel();
        checkBox.setLayout(new GridLayout(1, 3, 10, 0));

        opc1 = new JCheckBox("Audífonos");
        opc1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(opc1);

        opc2 = new JCheckBox("Mantas");
        opc2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(opc2);

        opc3 = new JCheckBox("Revistas");
        opc3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(opc3);

        checkBox.add(panel1);
        checkBox.add(panel2);
        checkBox.add(panel3);

        return checkBox;
    }

    private JPanel botonesOpcion() {
        JPanel botonesPanel = new JPanel(new FlowLayout());

        opcion1 = new JRadioButton("1er Piso");
        opcion2 = new JRadioButton("2do Piso");

        opcion1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        opcion2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcion1);
        grupo.add(opcion2);

        botonesPanel.add(opcion1);
        botonesPanel.add(opcion2);

        return botonesPanel;
    }

    private JPanel cuadrosCB() {
        JPanel panelCuadros = new JPanel();
        panelCuadros.setLayout(new BoxLayout(panelCuadros, BoxLayout.X_AXIS));

        JPanel origen = new JPanel(new BorderLayout());
        JPanel destino = new JPanel(new BorderLayout());

        String[] opciones = {"Lima", "Moquegua", "Tacna"};
        comboBox = new JComboBox<>(opciones);
        comboBox2 = new JComboBox<>(opciones);

        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        comboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        origen.add(comboBox, BorderLayout.CENTER);
        destino.add(comboBox2, BorderLayout.CENTER);

        origen.add(new JLabel("ORIGEN"), BorderLayout.PAGE_START);
        destino.add(new JLabel("DESTINO"), BorderLayout.PAGE_START);

        panelCuadros.add(origen);
        panelCuadros.add(Box.createHorizontalStrut(20));
        panelCuadros.add(destino);

        return panelCuadros;
    }

    private JPanel calidadServicios() {
        JPanel calidades = new JPanel(new BorderLayout());

        String[] opciones = {"Economico", "Standard", "VIP"};
        JList<String> lista = new JList<>(opciones);
        lista.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JScrollPane scrollPane = new JScrollPane(lista);
        calidades.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));

        calidades.add(scrollPane, BorderLayout.CENTER);

        return calidades;
    }

    // Método para crear los botones de acción
    private JPanel botonesAccion() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton btnResumen = new JButton("Mostrar Resumen");
        btnResumen.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        // Acción de reiniciar - Lambda
        btnReiniciar.addActionListener(e -> reiniciarCampos());

        panel.add(btnReiniciar);
        panel.add(btnResumen);

        return panel;
    }

    // Método para reiniciar todos los campos
    private void reiniciarCampos() {
        text1.setText("");
        text2.setText("");
        text3.setText("");
        opc1.setSelected(false);
        opc2.setSelected(false);
        opc3.setSelected(false);
        opcion1.setSelected(false);
        opcion2.setSelected(false);
        comboBox.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);
    }

}

