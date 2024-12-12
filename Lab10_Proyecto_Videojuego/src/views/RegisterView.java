package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Colores.InterfazColores;
import Fuente.FuentePersonalizada;
import componentes.Audio;
import controllers.RegisterController;

public class RegisterView extends JFrame {

    private static final long serialVersionUID = 1L;
    
    // Atributos
    private JTextField campoUsername;
    private JPasswordField campoPassword;
    private RegisterController controlador;

    // Constructor
    public RegisterView() {
        super("REGISTRO");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        
        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(new EmptyBorder(50, 50, 50, 50));
        panelPrincipal.setBackground(InterfazColores.BACKGROUND_PRIMARY);

        panelPrincipal.add(crearTitulo(), BorderLayout.NORTH);
        panelPrincipal.add(crearPanelGrid(), BorderLayout.CENTER);
        
        add(panelPrincipal);
    }

    private JLabel crearTitulo() {
        JLabel titulo = new JLabel("BIENVENIDO");
        titulo.setFont(FuentePersonalizada.cargarFuente(30));
        titulo.setForeground(InterfazColores.FONT_LIGHT);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        return titulo;
    }

    private JPanel crearPanelGrid() {
        JPanel panelGrid = new JPanel(new GridLayout(3, 1));
        panelGrid.setBackground(InterfazColores.BACKGROUND_SECONDARY);
        panelGrid.setBorder(new EmptyBorder(10, 10, 10, 10));

        panelGrid.add(crearImagen());
        panelGrid.add(crearCampos());
        panelGrid.add(crearPanelBotones());

        return panelGrid;
    }

    private JLabel crearImagen() {
    	ImageIcon imagen = new ImageIcon(new ImageIcon("Recursos\\User\\user.png")
                .getImage().getScaledInstance(155,155, Image.SCALE_SMOOTH));
  
		return new JLabel(imagen);
    }

    private JPanel crearCampos() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBackground(null);
        panel.setBorder(new EmptyBorder(0, 10, 0, 10));

        panel.add(crearLabel("Usuario"));
        campoUsername = crearTextField();
        panel.add(campoUsername);

        panel.add(crearLabel("Contraseña"));
        campoPassword = crearPasswordField();
        panel.add(campoPassword);

        return panel;
    }

    private JLabel crearLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(FuentePersonalizada.cargarFuente(15));
        label.setForeground(InterfazColores.FONT_LIGHT);
        return label;
    }

    private JTextField crearTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(FuentePersonalizada.cargarFuente(15));
        textField.setForeground(InterfazColores.FONT_LIGHT);
        textField.setBorder(null);
        textField.setBackground(InterfazColores.BACKGROUND_COMPONENTES_COLOR);
        return textField;
    }

    private JPasswordField crearPasswordField() {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(FuentePersonalizada.cargarFuente(15));
        passwordField.setForeground(InterfazColores.FONT_LIGHT);
        passwordField.setBorder(null);
        passwordField.setBackground(InterfazColores.BACKGROUND_COMPONENTES_COLOR);
        return passwordField;
    }

    private JPanel crearPanelBotones() {
    	//Configuracion del panel
    	JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 0));
    	panelBotones.setBorder(new EmptyBorder(50, 10, 50, 10));
    	panelBotones.setBackground(null);
    	
    	JButton botonAtras = crearBoton("VOLVER");
    	botonAtras.addActionListener(e -> {
            // Llamar al método del controlador para Ingresar los datos
            controlador.getMainController().mostrarLoginDesdeRegistro();
            Audio.playAudioBoton1();
        });
    	
    	JButton botonRegistro = crearBoton("REGISTRARSE");
    	
    	botonRegistro.addActionListener(e -> {
            // Llamar al método del controlador para Ingresar los datos
            controlador.IngresarDatos();
        });
    	
    	//Añadir los botones
    	panelBotones.add(botonRegistro);
    	panelBotones.add(botonAtras);
    	
    	//Retorna los botones
    	return panelBotones;
    }
    
    private JButton crearBoton(String text) {
    	
        JButton boton = new JButton(text);
        boton.setFont(FuentePersonalizada.cargarFuente(15));
        boton.setForeground(InterfazColores.FONT_LIGHT);
        boton.setBackground(InterfazColores.BACKGROUND_COMPONENTES_COLOR);
        boton.setBorder(new EmptyBorder(10,10,10,10));
        boton.setFocusPainted(false);
        
        return boton;
    }

    public void mensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);
    }
    
    //Getters
    public String getUsernameValue() {
    	return this.campoUsername.getText();
    }
    
    public String getPasswordValue() {
    	return new String(this.campoPassword.getPassword());
    }
    
    public void setControlador(RegisterController controlador) {
        this.controlador = controlador;
    }

}