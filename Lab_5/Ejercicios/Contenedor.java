package Ejercicios;

import java.util.ArrayList;

public class Contenedor <F,S> {
	//Atributos
	private ArrayList<Par<F,S>> listaPar;
	
	//-----------Constructor
	public Contenedor() {
		this.listaPar = new ArrayList<>();
	}
	
	//Methods
	
	//---------------------------------------------------
	public void agregarPar(F first,S second) {
		this.listaPar.add(new Par<>(first,second));
	}
	//---------------------------------------------------
	public Par<F,S> obtenerPar(int index){
		try {
			if(index < 0 || index > (this.listaPar.size() - 1)) {
				//-------------throw the exception if "index" is out of range
				throw new IndexOutOfBoundsException("Indice no valido - " + "[" + index + "]");
			}else {
				return this.listaPar.get(index);
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	//---------------------------------------------------
	public ArrayList<Par<F,S>> obtenerTodosLosPares(){
		return this.listaPar;
	}
	//---------------------------------------------------
	public void mostrarPares() {
		for(Par<F,S> elemento : this.listaPar) {
			System.out.println(elemento);
		}
	}
}
