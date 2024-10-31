package Actividad6;

import java.io.Serializable;

public class Fecha implements Serializable{

	private static final long serialVersionUID = 1L;

	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int dia,int mes,int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	public Fecha() {}
	
	public int getAño() {return this.anio;}
	public void setAño(int anio) {this.anio = anio;}
	
	public int getDia() {return this.dia;}
	public void setDia(int dia) {this.dia = dia;}
	
	public int getMes() {return this.mes;}
	public void setMes(int mes) {this.mes = mes;}
		
}
