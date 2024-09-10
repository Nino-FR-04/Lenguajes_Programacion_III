package Lab2_1;
import java.util.Scanner;

public class AppBanco {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cuenta[] cuentas = new Cuenta[2];
		
		cuentas[0] = new CuentaAhorro(1000,0.1);
		cuentas[1] = new CuentaCorriente(1500);
		
		while (true) {
			System.out.println("Seleccione una opción: D)epositar, R)etirar, C)onsultar, S)alir");
			String op = sc.next();
			
			if(op.equals("D") || op.equals("R")) {
				System.out.print("Ingrese un numero de cuenta y un monto: ");
				int num = sc.nextInt();
				double monto = sc.nextDouble();
				
				if(op.equals("D")) {
					cuentas[num].depositar(monto);
				}else {
					cuentas[num].retirar(monto);
				}
				System.out.println("Saldo: " + cuentas[num].getSaldo());
			
			}else if(op.equals("C")) {
				for(int i=0;i<cuentas.length;i++) {
					cuentas[i].consultar();
					System.out.println(i + " " + cuentas[i].getSaldo());
				}
			
			}else {
				break;
			}
			
		}
	}
}
