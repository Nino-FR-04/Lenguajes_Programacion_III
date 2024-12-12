package ejercicios;

public class Main {
	public static void main(String[] args) {
		ProductoModelo modelo = new ProductoModelo();
		new ProductoVista(modelo).setVisible(true);
		
	}
}
