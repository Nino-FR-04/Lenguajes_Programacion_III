package ejerciciosII;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
 
public class AppAudio {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Reproducción de efectos de sonidos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new java.awt.GridLayout(6, 1)); 	

        JButton playButton = new JButton("sonido de la campana ");
        playButton.addActionListener(e -> playAudio("Audios\\Sonido de campana.wav"));
                     
        JButton playButton2 = new JButton("sonido del perro ");
        playButton2.addActionListener(e -> playAudio("Audios\\sonido de perro.wav"));
        
        JButton playButton3= new JButton("sonido de explosion"); 
        playButton3.addActionListener(e -> playAudio("Audios\\sonido de explosion.wav")); 
        
        JButton playButton4= new JButton("sonido de risa"); 
        playButton4.addActionListener(e -> playAudio("Audios\\sonido de risa.wav")); 
        
        JButton playButton5= new JButton("sonido de gato"); 
        playButton5.addActionListener(e -> playAudio("Audios\\sonido de gato.wav")); 
        
        JButton playButton6= new JButton("sonido de bostezo "); 
        playButton6.addActionListener(e -> playAudio("Audios\\sonido de bostezo.wav"));
        
        //Se agregan al contenedor principal
        frame.add(playButton);
        frame.add(playButton2);
        frame.add(playButton3);
        frame.add(playButton4);
        frame.add(playButton5);
        frame.add(playButton6);
        frame.setVisible(true);
        
    }

	public static void playAudio(String filePath) {
		try {
			File audioFile = new File(filePath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}

