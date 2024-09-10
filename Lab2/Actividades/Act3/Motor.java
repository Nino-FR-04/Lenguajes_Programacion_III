package Lab2;

public class Motor {
	
	//Atributos
	private int numMotor;
	private int revPorMin;
	
	//Contructor
	public Motor(int numMotor,int revPorMin) {
		this.numMotor = numMotor;
		this.revPorMin = revPorMin;
	}
	
	//Setters y Getters
	public void setNumMotor(int numMotor) {
		this.numMotor = numMotor;
	}
	
	public void setRevPorMin(int revPorMin) {
		this.revPorMin = revPorMin;
	}
	
	public int getNumMotor() {
		return this.numMotor;
	}
	
	public int getRevPorMin() {
		return this.revPorMin;
	}
	
	//Metodos
	public String toString() {
		return "Motor{" +
                "numMotor=" + numMotor +
                ", revPorMin=" + revPorMin +
                '}';
	}
	
}
