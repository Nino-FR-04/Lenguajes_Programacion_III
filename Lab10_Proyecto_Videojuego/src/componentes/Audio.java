package componentes;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {

    private static Clip audioClip;
    private static Clip audioClipFondo;

    public static void playAudioBoton1() {
    	//Hilos
        new Thread(() -> {
            try {
                if (audioClip != null && audioClip.isRunning()) {
                    audioClip.stop();
                    audioClip.close();
                }

                File audioFile = new File("Recursos\\Sonidos\\Boton1.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);

                FloatControl control = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);

                float Volumen = -20.0f; 
                control.setValue(Volumen);

                audioClip.start();

                // Esperar a que termine el sonido
                audioClip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        audioClip.close(); // Cerrar el clip después de que termine
                    }
                });

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
                System.err.println("Error al reproducir el archivo"); //Test
            }
        }).start(); 
    }
    
    //Sonido N°2
    public static void playAudioBoton2() {
        new Thread(() -> {
            try {
                if (audioClip != null && audioClip.isRunning()) {
                    audioClip.stop();
                    audioClip.close();
                }

                // Cargar el archivo de audio
                File audioFile = new File("Recursos\\Sonidos\\Boton2.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                // Crear y abrir el Clip
                audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);

                // Obtener el control de volumen 
                FloatControl control = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);

                float Volumen = -5.0f; 
                control.setValue(Volumen);

                // Reproducir el audio
                audioClip.start();

                // Esperar a que termine el sonido
                audioClip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        audioClip.close(); 
                    }
                });

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
                System.err.println("Error al reproducir el archivo"); //Test
            }
        }).start();
    }
    
    public static void playAudioBoton3() {
    	//Manejo de hilos
        new Thread(() -> {
            try {
                if (audioClip != null && audioClip.isRunning()) {
                    audioClip.stop();
                    audioClip.close();
                }

                File audioFile = new File("Recursos\\Sonidos\\Boton3.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);

                FloatControl control = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);

                float Volumen = -5.0f;
                control.setValue(Volumen);

                audioClip.start();

                //Cierra el clip despues de terminar
                audioClip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        audioClip.close();
                    }
                });

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
                //Test
                System.err.println("Error al reproducir el archivo");
            }
        }).start(); 
    }

    public static void playAudioEnBucle() {
        new Thread(() -> {
            try {
                // Si ya hay un clip reproduciéndose, detenerlo
                if (audioClipFondo != null) {
                	audioClipFondo.stop();
                	audioClipFondo.close();
                }

                // Cargar el archivo de audio
                File audioFile = new File("Recursos\\Sonidos\\SonidoFondo.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                audioClipFondo = AudioSystem.getClip();
                audioClipFondo.open(audioStream);
                
                FloatControl control = (FloatControl) audioClipFondo.getControl(FloatControl.Type.MASTER_GAIN);

                float Volumen = -18.0f;
                control.setValue(Volumen);

                // Configurar el audio para que se reproduzca en bucle
                audioClipFondo.loop(Clip.LOOP_CONTINUOUSLY); // Loop infinito
                audioClipFondo.start();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
                System.err.println("Error al reproducir el archivo");
            }
        }).start();
    }


    public static void stopAudio() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            audioClip.close();
        }
    }
    
    public static void stopAudioFondo() {
        if (audioClipFondo != null && audioClipFondo.isRunning()) {
        	audioClipFondo.stop();
        	audioClipFondo.close();
        }
    }
}
