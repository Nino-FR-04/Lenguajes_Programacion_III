package models;

//Clase general
public abstract class Entidad {
	
	//--------
	private int id_entidad;
	private String nombre;
	private int vida;
	private	int resistencia; //En porcentaje
	private int danio;
	private String movRuta;
	private String iconoRuta;
	private int vidaMaxima;
	
	//Constructor
	public Entidad(int id,String nombre,int vida,int resistencia,
			int danio,String movRuta,String iconoRuta) {
		this.id_entidad = id;
		this.nombre = nombre;
		this.vida = vida;
		this.resistencia = resistencia;
		this.danio = danio;
		this.movRuta = movRuta;
		this.iconoRuta = iconoRuta;
		this.vidaMaxima = vida;
	}
	
	//Getters
	public String getIconoRuta() {return this.iconoRuta;}
	public String getMovRuta() {return this.movRuta;}
	
	public int getId() {return this.id_entidad;}
	public String getNombre() {return this.nombre;}
	public int getVida() {return this.vida;}
	public int getDanio() {return this.danio;}
	public int getResistencia() {return this.resistencia;}
	
	//Setters
	public void setVida(int vida) {this.vida = vida;}
	
	//Metodos
	public abstract void modificarVida(int cantidad);
	public int getVidaMaxima() {return this.vidaMaxima;}
	
}
