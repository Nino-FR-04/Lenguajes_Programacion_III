package actividades;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class SwingDemo {
    public SwingDemo() {
        createMainFrame(); 
    }

    public void createMainFrame() {
        JFrame frame = new JFrame("demostracion de la actividad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2));
        JButton btnBinding = new JButton("BINDING DE DATOS");
        btnBinding.addActionListener(e -> ventana1());
        frame.add(btnBinding);
        JButton btnSimpleGraph = new JButton("GRAFICO SIMPLE");
        btnSimpleGraph.addActionListener(e -> ventana2());
        frame.add(btnSimpleGraph);
        JButton btnAdvancedGraph = new JButton("GRAFICO AVANZADO");
        btnAdvancedGraph.addActionListener(e -> ventana3());
        frame.add(btnAdvancedGraph);
        JButton btnMultimedia = new JButton("ELEMENTOS MULTIMEDIA");
        btnMultimedia.addActionListener(e -> ventana4());
        frame.add(btnMultimedia);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
    private void ventana1() {
        JFrame frame = new JFrame("Binding de Datos");
        frame.setLayout(new FlowLayout());
        JTextField textField = new JTextField(20);
        JLabel label = new JLabel("Texto: ");
        JLabel displayLabel = new JLabel("Texto Reflejado");

        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                displayLabel.setText(textField.getText());
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(new JLabel("Salida: "));
        frame.add(displayLabel);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void ventana2() {
        JFrame frame = new JFrame("Meses mas calurosos");
        frame.setSize(400, 400);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
             
                g.setColor(Color.BLACK);
                g.drawString("Orden de los 3 meses con mas calor en el peru", 40, 20);
                g.setColor(Color.YELLOW); 
                g.fillRect(50, 200, 50, 100); 
                g.setColor(Color.ORANGE); 
                g.fillRect(150, 150, 50, 150); 
                g.setColor(Color.RED); 
                g.fillRect(250, 100, 50, 200); 

                g.setColor(Color.BLACK);
                g.drawString("Diciembre", 50, 320);
                g.drawString("Enero", 150, 320);
                g.drawString("Febrero", 250, 320);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
    private void ventana3() {
        JFrame frame = new JFrame("distribucion de mi dia en la universidad");
        frame.setSize(400, 400);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.BLACK);
                g.drawString("Distribucion de un estudiante de ingenieria de sistemas", 100, 20);
                int[] values = {60, 35, 5};
                Color[] colors = {Color.RED, Color.BLUE, Color.GREEN};
                String[] labels = {"programar", "comer", "dormir"};
                int startAngle = 0;
                for (int i = 0; i < values.length; i++) {
                    g.setColor(colors[i]);
                    int arcAngle = (int) (values[i] * 360 / 100.0);
                    g.fillArc(100, 100, 200, 200, startAngle, arcAngle);
                    startAngle += arcAngle;
                }
                g.setColor(Color.BLACK);
                for (int i = 0; i < labels.length; i++) {
                    g.drawString(labels[i], 320, 120 + i * 20);
                }
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
    private void ventana4() {
        JFrame frame = new JFrame("Elementos Multimedia");
        frame.setLayout(new FlowLayout());
        JButton btnLoadImage = new JButton("SUBIR IMAGEN");
        JLabel imageLabel = new JLabel();
        btnLoadImage.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
                imageLabel.setIcon(icon);
            }
        });
     
        JButton playButton = new JButton("SONIDO");
        playButton.addActionListener(e -> playAudio("Audios\\cancionintro.wav"));
        frame.add(btnLoadImage);
        frame.add(imageLabel);
        frame.add(playButton);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    public static void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            if (!audioFile.exists()) {
                System.out.println("El archivo de audio no existe: " + filePath);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
           } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        new SwingDemo(); 
    }
}
