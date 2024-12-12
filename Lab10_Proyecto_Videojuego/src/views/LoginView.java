package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Colores.InterfazColores;
import Fuente.FuentePersonalizada;
import componentes.Audio;
import controllers.LoginController;

public class LoginView extends JFrame {

    private static final long serialVersionUID = 1L;
    
    // Atributos
    private JTextField campoUsername;
    private JPasswordField campoPassword;
    private LoginController controlador;
    
    // Constructor
    public LoginView() {
        super("LOGIN");
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
    
    //Metodo encargado de la creacion del titulo
    private JLabel crearTitulo() {
        JLabel titulo = new JLabel("BIENVENIDO");
        titulo.setFont(FuentePersonalizada.cargarFuente(30));
        titulo.setForeground(InterfazColores.FONT_LIGHT);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        return titulo;
    }
    
    //Creacion del panel principal
    private JPanel crearPanelGrid() {
        JPanel panelGrid = new JPanel(new GridLayout(3, 1));
        panelGrid.setBackground(InterfazColores.BACKGROUND_SECONDARY);
        panelGrid.setBorder(new EmptyBorder(10, 10, 10, 10));

        panelGrid.add(crearImagen());
        panelGrid.add(crearCampos());
        panelGrid.add(crearBotones());

        return panelGrid;
    }

    //Crea una imagen insertada en un Jlabel
    private JLabel crearImagen() {
    	ImageIcon imagen = new ImageIcon(new ImageIcon("Recursos\\User\\user.png")
                .getImage().getScaledInstance(155,155, Image.SCALE_SMOOTH));
  
		return new JLabel(imagen);
    }
    
    //Crea los campos de texto con su respectivo JLabel
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
    
    //Crea los botones de acceso y registro
    private JPanel crearBotones() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 20, 0));
        panel.setBackground(null);
        panel.setBorder(new EmptyBorder(50, 10, 50, 10));

        JButton botonLogin = crearBoton("Acceder");
        
        botonLogin.addActionListener(e -> {
            // Llamar al método del controlador para validar los datos
            this.controlador.validarDatos();
        });
        
        JButton botonRegister = crearBoton("Registrarse");
        
        botonRegister.addActionListener(e -> {
            this.controlador.getMainController().mostrarRegistroDesdeLogin();
            Audio.playAudioBoton1();
        });


        panel.add(botonLogin);
        panel.add(botonRegister);

        return panel;
    }
    
    //Encargado de crear el JLabel de la ventana
    private JLabel crearLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(FuentePersonalizada.cargarFuente(15));
        label.setForeground(InterfazColores.FONT_LIGHT);
        return label;
    }
    
    //Encargado de crear el JTextField de la ventana
    private JTextField crearTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(FuentePersonalizada.cargarFuente(15));
        textField.setForeground(InterfazColores.FONT_LIGHT);
        textField.setBorder(null);
        textField.setBackground(InterfazColores.BACKGROUND_COMPONENTES_COLOR);
        return textField;
    }

    //Encargado de crear el JPasswordField de la ventana
    private JPasswordField crearPasswordField() {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(FuentePersonalizada.cargarFuente(15));
        passwordField.setForeground(InterfazColores.FONT_LIGHT);
        passwordField.setBorder(null);
        passwordField.setBackground(InterfazColores.BACKGROUND_COMPONENTES_COLOR);
        return passwordField;
    }
    
    //Encargado de crear los JButton de la ventana
    private JButton crearBoton(String text) {
        JButton button = new JButton(text);
        button.setFont(FuentePersonalizada.cargarFuente(15));
        button.setForeground(InterfazColores.FONT_LIGHT);
        button.setBackground(InterfazColores.BACKGROUND_COMPONENTES_COLOR);
        button.setBorder(null);
        button.setFocusPainted(false);
        return button;
    }
    
    //Encargado de mostrar una ventana emergente con algun tipo de mensaje
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
    
    //Setter
    public void setControlador(LoginController controlador) {
        this.controlador = controlador;
    }
}
