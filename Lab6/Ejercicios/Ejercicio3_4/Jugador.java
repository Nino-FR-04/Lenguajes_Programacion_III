package Ejercicio3;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item objetoEquipado;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new InventarioModel();
    }

    public void atacar(Enemigo enemigo) {
        if (objetoEquipado != null) {
        	//-------Calculo basado en el nivel
            int danio = 10 * nivel; 
            enemigo.recibirDanio(danio);
        }
    }

    public void usarObjeto(String nombreObjeto) {
        Item item = inventario.BuscarItem(nombreObjeto);
        if (item != null) {
            item.usarItem();
        }
    }

    public void recibirDanio(int danio) {salud -= danio;}
    public void equiparObjeto(Item item) {objetoEquipado = item;}
    
    public String getNombre() {return nombre;}
    public int getSalud() {return salud;}
    public int getNivel() {return nivel;}

    public InventarioModel getInventario() {return inventario;}
}

