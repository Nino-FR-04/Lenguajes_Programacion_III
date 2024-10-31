package ejercicio3;
import java.util.ArrayList;
import java.io.*;

public class EmpleadoModelo {
	private ArrayList<Empleado> empleados;
	
	//-----------Constructor
	public EmpleadoModelo() throws IOException {
		this.empleados = leerEmpleados();
	}
	
	//Metodos
	public ArrayList<Empleado> getEmpleados(){
		return this.empleados;
	}
	
	public boolean contains(int numero) {
		for(Empleado e : this.empleados) {
			if(e.getNumero() == numero) {
				return true;
			}
		}
		return false;
	}
	
	//-----------------------------------------------
	public void AgregarEmpleado(Empleado empleado) throws IOException {
		this.empleados.add(empleado);
		actualizarArchivo(empleado);
	}
	//-----------------------------------------------
	public Empleado BuscarEmpleado(int numero) {
		for(Empleado e : this.empleados) {
			if(e.getNumero() == numero) {
				return e;
			}
		}
		return null;
	}
	//-----------------------------------------------
	public String EliminarEmpleado(int numero) throws IOException {
		String nombre;
		
		for(Empleado e : this.empleados) {
			if(e.getNumero() == numero) {
				nombre = e.getNombre();
				this.empleados.remove(e);
				sobreescribirArchivo();
				return nombre;
			}
		}
		return null;
	}
	//-----------------------------------------------
	private ArrayList<Empleado> leerEmpleados() throws IOException {
		
		File archivo = new File("Empleados.bin");
	    // Crear el archivo si no existe
	    if (!archivo.exists()) {
	        archivo.createNewFile(); 
	        return new ArrayList<>();
	    }
		
		
		ArrayList<Empleado> AuxEmpleados = new ArrayList<>();
		try (DataInputStream DiS = new DataInputStream(new FileInputStream(archivo))) {
			while(DiS.available()>0) {
				int numero = DiS.readInt();
				String nombre = DiS.readUTF();
				double saldo = DiS.readDouble();
				
				AuxEmpleados.add(new Empleado(numero,nombre,saldo));
			}
		}
		
		return AuxEmpleados;
	}
	//-----------------------------------------------
	private void sobreescribirArchivo() throws IOException {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Empleados.bin"))) {
			for(Empleado e : this.empleados) {
				dos.writeInt(e.getNumero());
				dos.writeUTF(e.getNombre());
				dos.writeDouble(e.getSaldo());
			}
		}
	}
	//-----------------------------------------------
	private void actualizarArchivo(Empleado empleado) throws IOException {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Empleados.bin",true))) {
			dos.writeInt(empleado.getNumero());
			dos.writeUTF(empleado.getNombre());
			dos.writeDouble(empleado.getSaldo());
		}
	}
}
