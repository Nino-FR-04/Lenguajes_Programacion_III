package Lab2;

public class Automovil {
	//Atributos
	private String placa;
	private int numPuertas;
	private String marca;
	private String modelo;
	private Motor motor;
	
	//Constructor
	public Automovil(String placa,int nPuertas,
			String marca,String modelo) {
		
		this.placa = placa;
		this.numPuertas = nPuertas;
		this.marca = marca;
		this.modelo = modelo;
		
	}
	
	//setters y getters
	
	public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
	//Metodos
	public String toString() {
		return "Automovil{" +
                "placa='" + placa + '\'' +
                ", numPuertas=" + numPuertas +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", motor=" + (motor != null ? motor.toString() : "sin motor") +
                '}';
	}
	
}
