package Actividad4;

import java.io.*;
import javax.swing.JFrame;

public class TestFilePrueba {
	public static void main(String[] args) {
		
		FileInputStream file;
		
		byte b[] = new byte[1024];
		
		try {
			
			file = new FileInputStream("C:/Users/USER/Desktop/FSI_Asssets/TestFile.java");
			file.read(b);
			String s = new String(b);
			ViewFile view = new ViewFile(s);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setSize(400,150);
			view.setVisible(true);
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
